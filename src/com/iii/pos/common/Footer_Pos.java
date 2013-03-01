package com.iii.pos.common;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iii.pos.R;

public class Footer_Pos extends Fragment {
	final static String ARG_POSITION = "position";
	int mCurrentPosition = -1;
	OnHeadderSelectedListener mCallback;

	// The container Activity must implement this interface so the frag can
	// deliver messages
	public interface OnHeadderSelectedListener {
		/** Called by HeadlinesFragment when a list item is selected */
		public void onMenuButtonClick(int position);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// If activity recreated (such as from screen rotate), restore
		// the previous article selection set by onSaveInstanceState().
		// This is primarily necessary when in the two-pane layout.
		if (savedInstanceState != null) {
			mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
		}

		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.footer_pos, container, false);
	}

}