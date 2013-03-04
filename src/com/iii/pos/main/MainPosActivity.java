package com.iii.pos.main;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.iii.pos.R;
import com.iii.pos.common.Header_Pos;
import com.iii.pos.invoice.InvoicePos;
import com.iii.pos.invoice.Invoice_Detail_PosActivity;
import com.iii.pos.item.Category_Item_PosActivity;
import com.iii.pos.map.Floor1;
import com.iii.pos.map.Floor2;
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
		login_out(getApplicationContext());
	}

	@Override
	public void onMenuButtonClick(int btnKey,View v) {
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
			login_out(v.getContext());
			break;

		default:
			break;

		}
		// Create new transaction

		if (myBodyFragemnt != null) {
			FragmentManager fragmentManager = getSupportFragmentManager();
			if (fragmentManager.getBackStackEntryCount() > 1) {
				fragmentManager.popBackStack();
			}

			FragmentTransaction fragmentTransaction = fragmentManager
					.beginTransaction();
			// Replace whatever is in the fragment_container view with this
			// fragment,
			// and add the transaction to the back stack
			fragmentTransaction
					.replace(R.id.body_Pos_Container, myBodyFragemnt);
			if (btnKey == 1) {
				Category_Item_PosActivity category_item = new Category_Item_PosActivity();
				fragmentTransaction.replace(R.id.category_container,
						category_item);
			}
			if (btnKey == 2) {
				// insert invoice detail to right
				Invoice_Detail_PosActivity invoice_detail = new Invoice_Detail_PosActivity();
				fragmentTransaction.replace(R.id.category_container,
						invoice_detail);
			}
			// .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
			fragmentTransaction.addToBackStack(null);
			// Commit the transaction
			fragmentTransaction.commit();

		}

		// fragmentTransaction
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.popBackStack();
		super.onBackPressed();
	}

	private void login_out(Context context) {
		final Dialog dialog = new Dialog(context);
		dialog.setTitle("User Login");
		dialog.setContentView(R.layout.login_pos);
		dialog.setCancelable(true);
		/*
		 * Button btnStart = (Button) dialog.findViewById(R.id.btnStart);
		 * btnStart.setOnClickListener(new View.OnClickListener() {
		 * 
		 * @Override public void onClick(View v) {
		 * 
		 * 
		 * UpdataUserInit up = new UpdataUserInit(); up.execute();
		 * 
		 * new playSound(getApplicationContext()).playButton(); // show right
		 * layout
		 * 
		 * // icon_me.setImageResource(R.drawable.temp_thumbnail_mimirin);
		 * ShowMap_Activity.sex = 0;
		 * 
		 * updateSex(); dialog.dismiss(); Message msg = handler.obtainMessage();
		 * handler.sendMessage(msg);
		 * 
		 * } });
		 * 
		 * ImageView btnThoat = (ImageView) dialog.findViewById(R.id.btnThoat);
		 * btnThoat.setOnClickListener(new View.OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { new
		 * playSound(getApplicationContext()).playButton(); // show right layout
		 * 
		 * ShowMap_Activity.sex = 1;
		 * 
		 * updateSex(); dialog.dismiss(); // Message msg =
		 * handler.obtainMessage(); // handler.sendMessage(msg); } });
		 */
		try {
			dialog.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
