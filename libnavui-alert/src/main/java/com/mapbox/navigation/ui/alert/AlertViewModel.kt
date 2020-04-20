package com.mapbox.navigation.ui.alert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AlertViewModel : ViewModel() {
    companion object {
        val channel: Channel<AlertState> = Channel(1)
    }

    private val alertViewActionProcessor = AlertViewActionProcessor()

    fun showAlertView(alertText: String) {
        viewModelScope.launch {
            alertViewActionProcessor.showViewProcessor(alertText).collect {
                channel.send(it)
            }
        }
    }

    fun hideAlertView() {

    }
}