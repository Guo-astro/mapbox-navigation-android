package com.mapbox.navigation.core.replay.route

import com.mapbox.navigation.testing.BuilderTest
import kotlin.reflect.KClass

class ReplayRouteOptionsTest : BuilderTest<ReplayRouteOptions, ReplayRouteOptions.Builder>() {
    override fun getImplementationClass(): KClass<ReplayRouteOptions> = ReplayRouteOptions::class

    override fun getFilledUpBuilder(): ReplayRouteOptions.Builder {
        return ReplayRouteOptions.Builder()
            .maxAcceleration(12.0)
            .maxSpeedMps(34.0)
            .minAcceleration(56.0)
            .turnSpeedMps(78.0)
            .uTurnSpeedMps(910.0)
    }
}
