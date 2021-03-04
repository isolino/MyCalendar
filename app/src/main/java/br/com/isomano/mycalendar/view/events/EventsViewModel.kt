package br.com.isomano.mycalendar.view.events

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.util.*

class EventsViewModel : ViewModel() {

    private val eventsChannel = Channel<EventsEvent>()
    val events = eventsChannel.receiveAsFlow()

    private val eventList = mutableListOf(
        EventUiModel("First Event", Calendar.getInstance(), "Some Description"),
        EventUiModel("Second Event", Calendar.getInstance(), "Other Description"),
        EventUiModel("New Event", Calendar.getInstance(), "New Description"),
        EventUiModel("Last Event", Calendar.getInstance(), "Last Description")
    )

    private var eventIterator = eventList.iterator()

    private val _currentEvent = MutableLiveData<EventUiModel>(eventIterator.next())
    val currentEvent : LiveData<EventUiModel> = _currentEvent

    fun onCalendarEventClick(eventUiModel: EventUiModel) = viewModelScope.launch {
        eventsChannel.send(EventsEvent.OnCalendarEventClick(eventUiModel))
    }

    fun rollNextEvent() {
        if (!eventIterator.hasNext())
            eventIterator = eventList.iterator()
        _currentEvent.postValue(eventIterator.next())
    }

    sealed class EventsEvent {
        class OnCalendarEventClick(eventUiModel: EventUiModel) : EventsEvent()
    }
}