package com.iii.pos.map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.google.android.maps.MapView;
import com.iii.pos.R;

//--------------this class use to display the map for restaurant---------//
public class Floor1 extends Fragment {
	
	//--------------------Fields ---------------------------------//
	private WebView webView;
	private MapView mapview;
	private String URLWebview = "";

	// Context context=MyFragment.this;
	
	//---------------------initialize method---------------------------//
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View mapFloorLayout = inflater.inflate(R.layout.floor1, container,
				false);
		if (mapFloorLayout != null) {
			// URLWebview = getResources().getString(R.string.poswebview);
			webView = (WebView) mapFloorLayout.findViewById(R.id.webView1);
			webView.loadUrl("http://192.168.1.68/pos/map/main/floor1.php?android_id=1");
			//webView.loadUrl("http://192.168.1.228/FlipboardPageLayout/index.html");
			//webView.loadUrl("http://localhost/dom.php");
			webView.getSettings().setJavaScriptEnabled(true);
		}

		return mapFloorLayout;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
//		ViewGroup parentViewGroup = (ViewGroup) this.getR.getParent();
//		if (null != parentViewGroup) {
//			parentViewGroup.removeView(mRoutesSearchViewContainer);
//		}
	}

	// private String getAndroid_Id() {
	// TelephonyManager tManager = (TelephonyManager) getView().getContext()
	// .getSystemService(Context.TELEPHONY_SERVICE);
	// String uid = tManager.getDeviceId();
	// return uid;
	// }

}