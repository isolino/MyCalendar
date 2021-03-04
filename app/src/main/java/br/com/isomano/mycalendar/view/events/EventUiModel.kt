package br.com.isomano.mycalendar.view.events

import java.util.*

data class EventUiModel(
    val title: String,
    val date: Calendar,
    val description: String
)