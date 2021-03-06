package pl.waw.stojaki.android.stojakiwawpl;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class StojakiMapa extends FragmentActivity {
    public LatLng CURRENT_LOCATION = new LatLng(52.221856, 21.007040);
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    ArrayList<BikeRack> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InputStream in_s = null;
        FileXMLparse rup = null;
        try {
            Context context = getApplicationContext();
            in_s = context.getResources().openRawResource(R.raw.stojaki);
            rup = new FileXMLparse(in_s);

        } catch (IOException e) {
            e.printStackTrace();
        }
        this.lista = rup.list;
        setContentView(R.layout.activity_stojaki_mapa);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        // Getting LocationManager object



        //CURRENT_LOCATION = new LatLng(location.getLatitude(),location.getLongitude());
       // locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CURRENT_LOCATION,17));

        mMap.setMyLocationEnabled(true);
        int i;

        for(i=0;i<this.lista.size();i++){
            if(!this.lista.get(i).isLimit()) {
                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(this.lista.get(i).getLat(), this.lista.get(i).getLng()))
                        .title(this.lista.get(i).getName())
                        .snippet(this.lista.get(i).getFacilities().toString()));
            }else{
                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(this.lista.get(i).getLat(), this.lista.get(i).getLng())).title(this.lista.get(i).getName())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                        .snippet(this.lista.get(i).getFacilities().toString())
                );
            }
        }
    }
}
