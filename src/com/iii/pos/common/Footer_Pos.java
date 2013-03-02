package com.iii.pos.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iii.pos.R;

public class Footer_Pos extends Fragment {
	final static String ARG_POSITION = "position";
	int mCurrentPosition = -1;
	private TextView _tvTime;

	// The container Activity must implement this interface so the frag can
	// deliver messages
	public interface OnHeadderSelectedListener {
		/** Called by HeadlinesFragment when a list item is selected */
		public void onMenuButtonClick(int position);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		final View footerLayout = inflater.inflate(R.layout.footer_pos,
				container, false);
		// If activity recreated (such as from screen rotate), restore
		// the previous article selection set by onSaveInstanceState().
		// This is primarily necessary when in the two-pane layout.
		if (savedInstanceState != null) {
			mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
		}

		// //-----------animation
		// Animation animationToLeft = new TranslateAnimation(1150, -1150, 0,
		// 0);
		// animationToLeft.setDuration(22000);
		// animationToLeft.setRepeatMode(Animation.RESTART);
		// animationToLeft.setRepeatCount(Animation.INFINITE);
		//
		// Animation animationToRight = new TranslateAnimation(-1150,1150, 0,
		// 0);
		// animationToRight.setDuration(22000);
		// animationToRight.setRepeatMode(Animation.RESTART);
		// animationToRight.setRepeatCount(Animation.INFINITE);
		//
		_tvTime = (TextView) footerLayout.findViewById(R.id.usernameanim);
		//
		// textViewMarqToLeft.setAnimation(animationToLeft);
		// textViewMarqToRight.setAnimation(animationToRight);

		String currentDateTimeString = DateFormat.getDateTimeInstance().format(
				new Date());

		// textView is the TextView view that should display it
		_tvTime.setText("USER: PHAN DUY DUONG --- LOGIN TIME: "+currentDateTimeString.toUpperCase());
		// Inflate the layout for this fragment
		return footerLayout;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

}