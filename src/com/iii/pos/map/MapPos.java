package com.iii.pos.map;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.iii.pos.R;

public class MapPos extends Fragment {
	private WebView webView;
	private String URLWebview = "";

	@SuppressWarnings("deprecation")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View headerLayout = inflater.inflate(R.layout.map_pos, container,
				false);
		return null;
	}

}