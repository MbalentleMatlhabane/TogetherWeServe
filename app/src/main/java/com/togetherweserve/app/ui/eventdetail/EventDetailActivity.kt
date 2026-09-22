package com.togetherweserve.app.ui.eventdetail

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.togetherweserve.app.R
import com.togetherweserve.app.data.local.EventEntity
import com.togetherweserve.app.data.repository.EventRepository
import com.togetherweserve.app.databinding.ActivityEventDetailBinding
import com.togetherweserve.app.ui.group.GroupSignupActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale

/**
 * FR5 / FR6 / FR7 - shows full event info and lets the user register
 * individually or hand off to Group/Team Sign-up (the app's key
 * differentiator, per the Planning & Design document).
 */
class EventDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEventDetailBinding
    private lateinit var repository: EventRepository
    private var currentEvent: EventEntity? = null
    private var selectedMode: String = "individual"
    private var groupCode: String? = null
    private val appScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
    private val groupSignupLauncher = registerForActivityResult(
        androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val code = result.data?.getStringExtra(GroupSignupActivity.RESULT_GROUP_CODE)
        if (code != null) {
            selectedMode = "group"
            groupCode = code
            binding.tvInviteCode.visibility = View.VISIBLE
            binding.tvInviteCode.text = getString(R.string.invite_by_code_format, code)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        repository = EventRepository(this)

        val eventId = intent.getStringExtra(EXTRA_EVENT_ID) ?: run { finish(); return }

        appScope.launch {
            val event = repository.getEvent(eventId)
            currentEvent = event
            event?.let { bind(it) }
        }

        binding.btnJoinIndividual.setOnClickListener {
            selectedMode = "individual"
            groupCode = null
            binding.tvInviteCode.visibility = View.GONE
        }

        binding.btnJoinGroup.setOnClickListener {
            val intent = Intent(this, GroupSignupActivity::class.java)
            intent.putExtra(GroupSignupActivity.EXTRA_EVENT_ID, eventId)
            groupSignupLauncher.launch(intent)
        }

        binding.btnConfirmSignup.setOnClickListener {
            confirmSignup()
        }
    }

    private fun bind(event: EventEntity) {
        binding.tvTitle.text = event.title
        val df = SimpleDateFormat("EEE, dd MMM · HH:mm", Locale.getDefault())
        binding.tvDateTime.text = df.format(event.dateTime)
        binding.tvLocationOrganiser.text = "${event.location} · Hosted by ${event.organiserName}"
        binding.tvDescription.text = event.description
        binding.tvSpotsLeft.text = getString(
            R.string.spots_left_format, event.volunteersGoing, event.slotsAvailable
        )
    }

    private fun confirmSignup() {
        val event = currentEvent ?: return
        val userId = FirebaseAuth.getInstance().currentUser?.uid ?: return
        binding.progressBar.visibility = View.VISIBLE
        appScope.launch {
            val wentToServer = repository.joinEvent(event.eventId, event.title, event.dateTime, groupCode)
            binding.progressBar.visibility = View.GONE
            val message = if (wentToServer) getString(R.string.success_registered)
                          else getString(R.string.offline_banner)
            Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        appScope.cancel()
        super.onDestroy()
    }

    companion object {
        const val EXTRA_EVENT_ID = "extra_event_id"
    }
}
