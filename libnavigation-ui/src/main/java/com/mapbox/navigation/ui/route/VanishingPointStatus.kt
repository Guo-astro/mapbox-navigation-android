package com.mapbox.navigation.ui.route

import com.mapbox.navigation.base.trip.model.RouteProgress
import com.mapbox.navigation.base.trip.model.RouteProgressState

internal class VanishingPointStateManager {
    var state: VanishingPointState = VanishingPointState.DISABLED
        private set

    fun onNewRouteProgress(routeProgress: RouteProgress) {
        state = when (routeProgress.currentState) {
            RouteProgressState.LOCATION_TRACKING -> VanishingPointState.ENABLED
            RouteProgressState.ROUTE_COMPLETE -> VanishingPointState.NEAR_DESTINATION
            else -> VanishingPointState.DISABLED
        }
    }

    fun onFinalDestinationReached() {
        state = VanishingPointState.REACHED_DESTINATION
    }
}

internal enum class VanishingPointState {
    ENABLED,
    NEAR_DESTINATION,
    REACHED_DESTINATION,
    DISABLED
}
