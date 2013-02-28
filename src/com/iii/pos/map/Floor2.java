package com.iii.pos.map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.webkit.WebView;

import com.iii.pos.R;

public class Floor2 extends Activity{
	private WebView webView;
	private String URLWebview = "";
	private Context context = Floor2.this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.floor2);
		webView = (WebView) findViewById(R.id.webView3);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl("http://3i.com.vn/pos/map/main/floor2.php?android_id="
				+ getAndroid_Id());
		
	}
	private String getAndroid_Id() {
		TelephonyManager tManager = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		String uid = tManager.getDeviceId();
		return uid;
	}

}
