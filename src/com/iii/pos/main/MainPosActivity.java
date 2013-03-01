package com.iii.pos.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.iii.pos.R;
import com.iii.pos.common.Body_Pos;
import com.iii.pos.common.Header_Pos;
import com.iii.pos.invoice.InvoicePos;
import com.iii.pos.item.Category_Item_PosActivity;
import com.iii.pos.map.MapPos;

public class MainPosActivity extends FragmentActivity implements
		Header_Pos.OnHeadderSelectedListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_pos);
		// Create new transaction
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.popBackStack();

		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();
		MapPos mapPos = new MapPos();
		fragmentTransaction.replace(R.id.body_Pos_Container, mapPos);
		Category_Item_PosActivity category_item = new Category_Item_PosActivity();
		fragmentTransaction.replace(R.id.category_container, category_item);

		fragmentTransaction.addToBackStack(null);
		// Commit the transaction
		fragmentTransaction.commit();
	}

	@Override
	public void onMenuButtonClick(int btnKey) {
		// TODO Auto-generated method stub
		Fragment myBodyFragemnt = null;
		switch (btnKey) {
		case 1:
			// doing in the Map
			myBodyFragemnt = new MapPos();
			break;
		case 2:
			// doing in the Invoice
			myBodyFragemnt = new InvoicePos();
			break;
		case 3:
			// doing in the Settings
			break;
		case 4:
			// doing in the Login_out
			break;

		default:
			break;

		}
		// Create new transaction
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.popBackStack();

		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();
		// Replace whatever is in the fragment_container view with this
		// fragment,
		// and add the transaction to the back stack

		if (myBodyFragemnt != null) {
			fragmentTransaction
					.replace(R.id.body_Pos_Container, myBodyFragemnt);
		}
		if(btnKey==2){
			//insert invoice detail to right
			
		}
		fragmentTransaction
				.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		fragmentTransaction.addToBackStack(null);
		// Commit the transaction
		fragmentTransaction.commit();
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.popBackStack();
		super.onBackPressed();
	}
}
