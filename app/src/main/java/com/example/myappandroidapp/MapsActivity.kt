package com.example.myappandroidapp

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*


class MapsActivity : AppCompatActivity(),
        GoogleMap.OnMarkerClickListener,
        OnMapReadyCallback  {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val pakuwon = LatLng(-7.275, 112.808)

        // add polylines to the map
        val polyline1 = googleMap.addPolyline(PolylineOptions()
                .clickable(true)
                .add(
                        LatLng(-7.275266, 112.808880),
                        LatLng(-7.275984, 112.808837),
                        LatLng(-7.276687, 112.807930),
                        LatLng(-7.275500, 112.806112),
                        LatLng(-7.273670, 112.806251),
                        LatLng(-7.274894, 112.807753))
                .color(Color.RED))

        mMap.addMarker(MarkerOptions().position(pakuwon).title(pakuwon.toString()).icon(BitmapFromVector(getApplicationContext(), R.drawable.ic_plane)))
        val zoomLevel = 16.0f
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pakuwon, zoomLevel))
        mMap.setOnMarkerClickListener(this)
    }

    override fun onMarkerClick(marker: Marker?): Boolean {
        val tag = marker?.tag as? String
        if (marker != null) {
            Toast.makeText(this, "${marker.title} isi tag", Toast.LENGTH_LONG).show()
        }
        return true
    }

    private fun BitmapFromVector(context: Context, vectorResId: Int): BitmapDescriptor? {
        // below line is use to generate a drawable.
        val vectorDrawable = ContextCompat.getDrawable(context, vectorResId)

        // below line is use to set bounds to our vector drawable.
        vectorDrawable!!.setBounds(0, 0, vectorDrawable.intrinsicWidth, vectorDrawable.intrinsicHeight)

        // below line is use to create a bitmap for our
        // drawable which we have added.
        val bitmap = Bitmap.createBitmap(vectorDrawable.intrinsicWidth, vectorDrawable.intrinsicHeight, Bitmap.Config.ARGB_8888)

        // below line is use to add bitmap in our canvas.
        val canvas = Canvas(bitmap)

        // below line is use to draw our
        // vector drawable in canvas.
        vectorDrawable.draw(canvas)

        // after generating our bitmap we are returning our bitmap.
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }
}