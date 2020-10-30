package com.mapbox.navigation.ui.route

import com.mapbox.navigation.base.trip.model.RouteLegProgress
import com.mapbox.navigation.base.trip.model.RouteProgress
import com.mapbox.navigation.core.arrival.ArrivalObserver

internal class MapArrivalObserver(
    private val vanishingPointStateManager: VanishingPointStateManager
) : ArrivalObserver {
    override fun onNextRouteLegStart(routeLegProgress: RouteLegProgress) {
        // not implemented
    }

    override fun onFinalDestinationArrival(routeProgress: RouteProgress) {
        vanishingPointStateManager.onFinalDestinationReached()
    }
}
