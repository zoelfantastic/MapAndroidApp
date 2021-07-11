package com.example.myappandroidapp

import com.google.android.gms.maps.GoogleMap


class Utils {
    fun configActivityMaps(googleMap: GoogleMap): GoogleMap? {
        // set map type
        googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
        // Enable / Disable zooming controls
        googleMap.uiSettings.isZoomControlsEnabled = false

        // Enable / Disable Compass icon
        googleMap.uiSettings.isCompassEnabled = true
        // Enable / Disable Rotate gesture
        googleMap.uiSettings.isRotateGesturesEnabled = true
        // Enable / Disable zooming functionality
        googleMap.uiSettings.isZoomGesturesEnabled = true
        googleMap.uiSettings.isScrollGesturesEnabled = true
        googleMap.uiSettings.isMapToolbarEnabled = true
        return googleMap
    }
}