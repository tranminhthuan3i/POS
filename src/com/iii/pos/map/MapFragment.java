/**
 * 
 */
package com.iii.pos.map;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.iii.pos.R;

/**
 * @author tran minh thuan
 * 
 */

//--------------this class constaint google map -----------------//
public class MapFragment extends Fragment {
	
	//----------------Fields -----------------------------------//
	private MapView map = null;
	private MyLocationOverlay me = null;

	//---------------initialize method---------------------------//
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = null;
		if (map == null) {
			v = new FrameLayout(getActivity());
		}
		return v;
	}

	//---------------initialize method---------------------------//
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		if (map == null) {
			map = new MapView(getActivity(),
					"0Q4bWBX5SDRCYSNYYxxBSnQY2wgwRTx8XjHkbrw");
			map.setClickable(true);

			// map.getController().setCenter(
			// getPoint(40.76793169992044, -73.98180484771729));
			map.getController().setZoom(17);
			map.setBuiltInZoomControls(true);

			Drawable marker = getResources().getDrawable(R.drawable.cakho);

			marker.setBounds(0, 0, marker.getIntrinsicWidth(),
					marker.getIntrinsicHeight());

			// map.getOverlays().add(new SitesOverlay(marker));

			me = new MyLocationOverlay(getActivity(), map);
			map.getOverlays().add(me);

			((ViewGroup) getView()).addView(map);
		}
	}
}