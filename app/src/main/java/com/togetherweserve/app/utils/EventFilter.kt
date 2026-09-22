package com.togetherweserve.app.utils

import com.togetherweserve.app.data.local.EventEntity

/**
 * Pure filtering logic used by HomeFragment, pulled out into its own
 * object so it can be unit tested without needing an Android Context.
 */
object EventFilter {

    fun filter(events: List<EventEntity>, query: String, selectedCauses: List<String>): List<EventEntity> {
        val q = query.trim().lowercase()
        return events.filter { event ->
            val matchesQuery = q.isEmpty() ||
                event.title.lowercase().contains(q) ||
                event.cause.lowercase().contains(q)
            val matchesCause = selectedCauses.isEmpty() ||
                selectedCauses.any { it.equals(event.cause, ignoreCase = true) }
            matchesQuery && matchesCause
        }
    }
}
