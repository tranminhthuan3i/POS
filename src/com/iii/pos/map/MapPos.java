package com.iii.pos.map;

import android.app.ActivityGroup;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.webkit.WebView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.iii.pos.R;



@SuppressWarnings("deprecation")
public class MapPos extends ActivityGroup {
	private WebView webView;
	private String URLWebview = "";
	private Context context = MapPos.this;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_pos);
		
		TabHost tapHost = (TabHost) findViewById(R.id.mappos);
		tapHost.setup(this.getLocalActivityManager());

		TabSpec spec1 = tapHost.newTabSpec("Tab 1");
		spec1.setContent(R.id.tab1);
		spec1.setContent(new Intent(this, Floor1.class));
		spec1.setIndicator("FLOOR 1");

		TabSpec spec2 = tapHost.newTabSpec("Tab 2");
		spec2.setContent(new Intent(this, Floor2.class));
		spec2.setIndicator("FLOOR 2"
				);

		TabSpec spec3 = tapHost.newTabSpec("Tab 3");
		spec3.setContent(new Intent(this, Floor2.class));
		spec3.setIndicator("FLOOR 3");

		tapHost.addTab(spec1);
		tapHost.addTab(spec2);
		tapHost.addTab(spec3);
	}

}