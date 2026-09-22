package com.togetherweserve.app.utils

import com.google.common.truth.Truth.assertThat
import com.togetherweserve.app.data.local.EventEntity
import org.junit.Test

class EventFilterTest {

    private fun event(id: String, title: String, cause: String) = EventEntity(
        eventId = id, title = title, cause = cause, description = "",
        dateTime = 0L, location = "Cape Town", slotsAvailable = 10,
        volunteersGoing = 2, organiserId = "org1", organiserName = "OceanCare NPO"
    )

    private val sample = listOf(
        event("1", "Beach Clean-up", "Environment"),
        event("2", "School Reading Day", "Education"),
        event("3", "Soup Kitchen Shift", "Health")
    )

    @Test
    fun `empty query and no causes returns all events`() {
        val result = EventFilter.filter(sample, "", emptyList())
        assertThat(result).hasSize(3)
    }

    @Test
    fun `query matches title case-insensitively`() {
        val result = EventFilter.filter(sample, "beach", emptyList())
        assertThat(result).hasSize(1)
        assertThat(result.first().eventId).isEqualTo("1")
    }

    @Test
    fun `query matches cause`() {
        val result = EventFilter.filter(sample, "health", emptyList())
        assertThat(result.map { it.eventId }).containsExactly("3")
    }

    @Test
    fun `selected causes filter narrows results`() {
        val result = EventFilter.filter(sample, "", listOf("Education"))
        assertThat(result.map { it.eventId }).containsExactly("2")
    }

    @Test
    fun `query and cause combine with AND logic`() {
        val result = EventFilter.filter(sample, "soup", listOf("Health"))
        assertThat(result.map { it.eventId }).containsExactly("3")
    }

    @Test
    fun `no matches returns empty list`() {
        val result = EventFilter.filter(sample, "no-such-event", emptyList())
        assertThat(result).isEmpty()
    }
}
