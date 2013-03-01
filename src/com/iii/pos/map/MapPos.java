package com.iii.pos.map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.iii.pos.R;

public class MapPos extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View mapLayout = inflater.inflate(R.layout.map_pos, container,
				false);

		// show on btnSetting
		Button btnFloor1 = (Button) mapLayout.findViewById(R.id.btnFloor1);
		btnFloor1.setOnClickListener(btnFloorClickListener);
		// show on btnSetting
		Button btnFloor2 = (Button) mapLayout.findViewById(R.id.btnFloor2);
		btnFloor2.setOnClickListener(btnFloorClickListener);
		// show on btnSetting
		Button btnFloor3 = (Button) mapLayout.findViewById(R.id.btnFloor3);
		btnFloor3.setOnClickListener(btnFloorClickListener);
		// show on btnSetting
		Button btnFloor4 = (Button) mapLayout.findViewById(R.id.btnFloor4);
		btnFloor4.setOnClickListener(btnFloorClickListener);

		// get an instance of FragmentTransaction from your Activity
		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();

		// add a fragment
		Floor1 myFragment = new Floor1();
		fragmentTransaction.add(R.id.floor_Container, myFragment);
		fragmentTransaction.commit();
		return mapLayout;
	}

	Button.OnClickListener btnFloorClickListener = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Fragment mapFloorFragemnt = null;
			int key = v.getId();
			switch (key) {
			case R.id.btnFloor1:
				
				mapFloorFragemnt = new Floor1();
				break;
			case R.id.btnFloor2:
				mapFloorFragemnt = new Floor2();
				break;
			case R.id.btnFloor3:
				
				break;
			case R.id.btnFloor4:

				break;

			default:
				break;
			}
			// Create new transaction
			FragmentManager fragmentManager = getFragmentManager();
			if (fragmentManager.getBackStackEntryCount() > 1) {
				fragmentManager.popBackStack();
			}

			FragmentTransaction fragmentTransaction = fragmentManager
					.beginTransaction();
			// Replace whatever is in the fragment_container view with this
			// fragment,
			// and add the transaction to the back stack

			if (mapFloorFragemnt != null) {
				fragmentTransaction.replace(R.id.floor_Container,
						mapFloorFragemnt);
			}
			fragmentTransaction
					.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
			fragmentTransaction.addToBackStack(null);
			// Commit the transaction
			fragmentTransaction.commit();
		}
	};
	

}