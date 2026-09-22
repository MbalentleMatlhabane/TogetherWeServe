package com.togetherweserve.app.ui.settings

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.togetherweserve.app.auth.LoginActivity
import com.togetherweserve.app.data.remote.RetrofitClient
import com.togetherweserve.app.data.remote.models.SettingsUpdateRequest
import com.togetherweserve.app.databinding.FragmentSettingsBinding
import com.togetherweserve.app.utils.ConnectivityObserver
import com.togetherweserve.app.utils.SessionManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

/**
 * FR3 - Settings management (profile, notification preferences, language,
 * offline data, security) and FR10 - multi-language support (English /
 * isiZulu), matching the "Settings" wireframe screen exactly.
 */
class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private lateinit var session: SessionManager
    private lateinit var appScope: CoroutineScope

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        session = SessionManager(requireContext())
        appScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

        binding.rowProfile.setOnClickListener {
            val user = FirebaseAuth.getInstance().currentUser
            AlertDialog.Builder(requireContext())
                .setTitle("Profile")
                .setMessage("Name: ${user?.displayName ?: "-"}\nEmail: ${user?.email ?: "-"}")
                .setPositiveButton("Close", null)
                .show()
        }

        binding.rowNotifications.setOnClickListener {
            val items = arrayOf("Event reminders", "Chat messages")
            val checked = booleanArrayOf(session.eventRemindersEnabled, session.chatMessagesEnabled)
            AlertDialog.Builder(requireContext())
                .setTitle("Notification preferences")
                .setMultiChoiceItems(items, checked) { _, which, isChecked ->
                    if (which == 0) session.eventRemindersEnabled = isChecked
                    else session.chatMessagesEnabled = isChecked
                }
                .setPositiveButton("Done") { _, _ -> pushSettingsToServer() }
                .show()
        }

        binding.rowLanguage.setOnClickListener {
            val languages = arrayOf("English", "isiZulu")
            val current = if (session.language == "zu") 1 else 0
            AlertDialog.Builder(requireContext())
                .setTitle("Choose language")
                .setSingleChoiceItems(languages, current) { dialog, which ->
                    session.language = if (which == 1) "zu" else "en"
                    pushSettingsToServer()
                    dialog.dismiss()
                    AlertDialog.Builder(requireContext())
                        .setMessage("Restart the app to apply the new language.")
                        .setPositiveButton("OK", null).show()
                }
                .show()
        }

        binding.rowOfflineData.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Offline data & sync")
                .setMessage("Event details and your upcoming registrations are cached on this " +
                        "device so you can view them without a connection. Any actions performed " +
                        "offline are queued and automatically synced once you're back online.")
                .setPositiveButton("Close", null)
                .show()
        }

        binding.rowPrivacy.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Privacy & security")
                .setMessage("Your password is never stored or transmitted in plain text - " +
                        "authentication is handled by Firebase Authentication.")
                .setPositiveButton("Close", null)
                .show()
        }

        binding.rowLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            session.clear()
            startActivity(Intent(requireContext(), LoginActivity::class.java))
            requireActivity().finish()
        }
    }

    private fun pushSettingsToServer() {
        val userId = FirebaseAuth.getInstance().currentUser?.uid ?: return
        if (!ConnectivityObserver.isOnline(requireContext())) return
        appScope.launch {
            try {
                RetrofitClient.api.updateSettings(
                    userId,
                    SettingsUpdateRequest(session.language, session.eventRemindersEnabled, session.chatMessagesEnabled)
                )
            } catch (e: Exception) { /* retried next time settings change while online */ }
        }
    }

    override fun onDestroyView() {
        appScope.cancel()
        super.onDestroyView()
        _binding = null
    }
}
