package in.sumeetkumar.apps.android.demos;

import in.sumeetkumar.android.control.RangeSeekBar;
import in.sumeetkumar.android.control.RangeSeekBar.OnRangeSeekBarChangeListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.TextView;

public class RangeSeekerWithMap extends Activity {

	protected static final String TAG = "RANGE_SEEKER_WITH_MAP";
	static final LatLng HAMBURG = new LatLng(53.558, 9.927);
	static final LatLng KIEL = new LatLng(53.551, 9.993);
	private GoogleMap map;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_range_seeker_with_map);
		addRangeSeekerBar();
		addGoogleMaps();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.range_seeker_with_map, menu);
		return true;
	}

	 private void addRangeSeekerBar(){
	    	// create RangeSeekBar as Date range between 1950-12-01 and now
			try {
				ViewGroup layout = (ViewGroup) findViewById(R.id.time_range_selector);
//				ViewGroup timeLayout = (ViewGroup) findViewById(R.id.time_show);
				final TextView fromView = (TextView) layout.findViewById(R.id.txtFrom);
	        	final TextView toView = (TextView) layout.findViewById(R.id.txtTo);
				
				Date minDate = new SimpleDateFormat("yyyy-MM-dd").parse("2013-05-01");
				Date maxDate = new Date();
		    	RangeSeekBar<Long> seekBar = new RangeSeekBar<Long>(minDate.getTime(), maxDate.getTime(), this);
		    	seekBar.setOnRangeSeekBarChangeListener(new OnRangeSeekBarChangeListener<Long>() {
		    	        @Override
		    	        public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Long minValue, Long maxValue) {
		    	                // handle changed range values
//		    	        	fromView.setText("From:" + new Date(minValue).getMinutes());
//		    	        	toView.setText("To:" + new Date(maxValue).getMinutes());
		    	            Log.i(TAG, "User selected new date range: MIN=" + new Date(minValue) + ", MAX=" + new Date(maxValue));
		    	        }
		    	});

		    	// add RangeSeekBar to pre-defined layout
		    	
		    	layout.addView(seekBar);
		    	
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				Log.i(TAG, e.getMessage());
				e.printStackTrace();
			}
	    }
	 
	 private void addGoogleMaps(){
		 map = ((MapFragment) getFragmentManager().findFragmentById(R.id.google_map))
			        .getMap();
			    
			    if (map!=null){
			      Marker hamburg = map.addMarker(new MarkerOptions().position(HAMBURG)
			          .title("Hamburg"));
			      Marker kiel = map.addMarker(new MarkerOptions()
			          .position(KIEL)
			          .title("Kiel")
			          .snippet("Kiel is cool")
			          .icon(BitmapDescriptorFactory
			              .fromResource(R.drawable.ic_launcher)));
			    }
	 }
}
