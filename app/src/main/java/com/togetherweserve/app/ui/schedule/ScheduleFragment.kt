package com.togetherweserve.app.ui.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.firebase.auth.FirebaseAuth
import com.togetherweserve.app.data.repository.EventRepository
import com.togetherweserve.app.databinding.FragmentScheduleBinding
import com.togetherweserve.app.utils.ConnectivityObserver
import kotlinx.coroutines.launch

/**
 * FR8 - My Schedule: shows confirmed and pending-sync registrations from
 * RoomDB. Displays the "Offline — showing cached data" banner exactly as
 * in the wireframe when there is no connectivity, and triggers a sync of
 * any queued offline actions once the device is back online.
 */
class ScheduleFragment : Fragment() {

    private var _binding: FragmentScheduleBinding? = null
    private val binding get() = _binding!!
    private lateinit var repository: EventRepository
    private val adapter = ScheduleAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentScheduleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        repository = EventRepository(requireContext())
        binding.recyclerSchedule.adapter = adapter

        val online = ConnectivityObserver.isOnline(requireContext())
        binding.tvOfflineBanner.visibility = if (online) View.GONE else View.VISIBLE

        // Lifecycle-aware: collection auto-pauses/cancels with the view, so it
        // can never crash by touching `binding` after onDestroyView.
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                repository.observeSchedule().collect { list -> adapter.submitList(list) }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val userId = FirebaseAuth.getInstance().currentUser?.uid
                if (online && userId != null) {
                    repository.syncPendingActions()
                    repository.refreshSchedule(userId)
                }
            } catch (e: Exception) {
                // Network/API failure - fall back silently to cached schedule data.
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
