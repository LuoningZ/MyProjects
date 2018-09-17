package com.gy.limguide.manager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.gy.limguide.Module.DirectionFinder;
import com.gy.limguide.Module.DirectionFinderListener;
import com.gy.limguide.Module.Route;
import com.gy.limguide.R;
import com.gy.limguide.activities.RecentActivity;
import com.gy.limguide.fragment.BaseTitleFragment;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeTab1Fragment extends BaseTitleFragment implements OnMapReadyCallback , DirectionFinderListener {

    @BindView(R.id.btn_activity)
    Button btn_activity;
    @BindView(R.id.chcufadi)
    EditText chcufadi;
    @BindView(R.id.mudidi)
    EditText mudidi;


    private GoogleMap mMap;

    private List<Marker> originMarkers = new ArrayList<>();
    private List<Marker> destinationMarkers = new ArrayList<>();
    private List<Polyline> polylinePaths = new ArrayList<>();

    @Override
    protected int onSetContentView() {
        return R.layout.fragment_home_tab1;
    }

    @Override
    protected void onInitData() {

        setTitle(0,"行在利莫LimGuide",R.drawable.search);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.mapview);

        mapFragment.getMapAsync(this);


    }
    @OnClick({
            R.id.btn_activity,
            R.id.iv_right
    })
    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.btn_activity:
                Intent intent=new Intent(getActivity(), RecentActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_right:
                sendRequest();
                break;
        }
    }

    @Override
    public void onInitdata(Bundle savedInstanceState) {
        super.onInitdata(savedInstanceState);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMinZoomPreference(12);

        // Add a marker in Sydney and move the camera
        LatLng limerick = new LatLng(52.667960, -8.631500);
        mMap.addMarker(new MarkerOptions().position(limerick).title("Marker in Limerick"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(limerick));
    }

    private void sendRequest() {
        Log.i("cccccccccc","sendRequest");
        String origin = chcufadi.getText().toString();
        String destination = mudidi.getText().toString();
        if (origin.isEmpty()) {
            Toast.makeText(getContext(), "Please enter origin address!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (destination.isEmpty()) {
            Toast.makeText(getContext(), "Please enter destination address!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            new DirectionFinder(this, origin, destination).execute();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDirectionFinderStart() {
        if (originMarkers != null) {
            for (Marker marker : originMarkers) {
                marker.remove();
            }
        }

        if (destinationMarkers != null) {
            for (Marker marker : destinationMarkers) {
                marker.remove();
            }
        }

        if (polylinePaths != null) {
            for (Polyline polyline:polylinePaths ) {
                polyline.remove();
            }
        }
    }

    @Override
    public void onDirectionFinderSuccess(List<Route> routes) {


        polylinePaths = new ArrayList<>();
        originMarkers = new ArrayList<>();
        destinationMarkers = new ArrayList<>();

        for (Route route : routes) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(route.startLocation, 16));
//            ((TextView) findViewById(R.id.tvDuration)).setText(route.duration.text);
//            ((TextView) findViewById(R.id.tvDistance)).setText(route.distance.text);

            originMarkers.add(mMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.start_blue))
                    .title(route.startAddress)
                    .position(route.startLocation)));
            destinationMarkers.add(mMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.end_green))
                    .title(route.endAddress)
                    .position(route.endLocation)));

            PolylineOptions polylineOptions = new PolylineOptions().
                    geodesic(true).
                    color(Color.BLUE).
                    width(10);

            for (int i = 0; i < route.points.size(); i++)
                polylineOptions.add(route.points.get(i));

            polylinePaths.add(mMap.addPolyline(polylineOptions));
        }

    }
}
