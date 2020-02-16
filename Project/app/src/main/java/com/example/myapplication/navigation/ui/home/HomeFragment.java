package com.example.myapplication.navigation.ui.home;

import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.content.Context.LOCATION_SERVICE;
import static android.location.LocationManager.GPS_PROVIDER;

/*
Yuping Tian
This activity is showing the recycling centre in Dublin on Google map and show
them as markers, while users click on the marker, the name of the centre will shows
up, and users can active a navigation by click the button on the bottom-right side.
This activity requires Google API, and the markers are add in the map manually.
 */

public class HomeFragment extends Fragment implements OnMapReadyCallback{


    GoogleMap mMap;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        LocationManager locationManager;


        View v = inflater.inflate(R.layout.activity_maps, null);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment == null) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            mapFragment = SupportMapFragment.newInstance();
            ft.replace(R.id.map, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) getContext().getSystemService(LOCATION_SERVICE);

        if (locationManager.isProviderEnabled(GPS_PROVIDER)) {

        } else {
            Intent intent = new Intent(Settings.ACTION_SECURITY_SETTINGS);
        }


        return v;

    }

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng home = new LatLng(53.306596, -6.221878);
        LatLng station1 = new LatLng(53.324432, -6.263263);
        LatLng station2 = new LatLng(53.288092, -6.126916);
        LatLng station3 = new LatLng(53.284203, -6.125841);
        LatLng station4 = new LatLng(53.324648, -6.308889);
        LatLng station5 = new LatLng(53.341616, -6.214291);
        LatLng station6 = new LatLng(53.340877, -6.203123);
        LatLng station7 = new LatLng(53.316429, -6.223720);
        LatLng station8 = new LatLng(53.334556, -6.225915);
        LatLng station9 = new LatLng(53.288062, -6.200787);
        LatLng station10 = new LatLng(53.278281, -6.208827);
        LatLng station11 = new LatLng(53.272244, -6.208709);
        LatLng station12 = new LatLng(53.298251, -6.296864);
        LatLng station13 = new LatLng(53.310387, -6.346852);
        LatLng station14 = new LatLng(53.324662, -6.308884);
        LatLng station15 = new LatLng(53.321018, -6.266519);
        LatLng station16 = new LatLng(53.322700, -6.220485);
        LatLng station17 = new LatLng(53.324248, -6.206645);
        LatLng station18 = new LatLng(53.288146, -6.154098);
        LatLng station19 = new LatLng(53.287983, -6.126803);
        LatLng station20 = new LatLng(53.267276, -6.136373);
        LatLng station21 = new LatLng(53.257212, -6.113294);
        LatLng station22 = new LatLng(53.255055, -6.189108);
        LatLng station23 = new LatLng(53.354907, -6.244353);



        mMap.addMarker(new MarkerOptions().position(home).title("Home").draggable(true));
        mMap.addMarker(new MarkerOptions().position(station1).title("Bring Centre").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(station2).title("Eden Park Recycling Centre").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(station3).title("Dún Laoghaire Waste").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(station4).title("Windmill Road Civic Amenity Centre").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(station5).title("Ringsend Recycling Centre").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(station6).title("All Away Waste").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(station7).title("RTE Recycling compound").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(station8).title("Recycling Bank").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(station9).title("Recycling Station").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(station10).title("Bottle Bank").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(station11).title("Greenking Composting Ltd").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(station12).title("Recycling Bay").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(station13).title("Ballymount Civic Amenity Site").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(station14).title("Windmill Road Civic Amenity Centre").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(station15).title("Recycling Bay").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(station16).title("Bottle Bank - Wanderers Rugby Club").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(station17).title("Bring Centre").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(station18).title("Bring Banks").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(station19).title("Eden Park Recycling Centre").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(station20).title("Bring Banks").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(station21).title("Cans and Bottles recycling").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(station22).title("Ballyogan Recycling Park").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(station23).title("North Strand Recycling Centre").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(home, 10.0f));


    }


}