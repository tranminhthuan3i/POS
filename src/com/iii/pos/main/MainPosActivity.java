package com.iii.pos.main;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import com.iii.pos.R;
import com.iii.pos.common.Header_Pos;
import com.iii.pos.config.ConfigurationWS;
import com.iii.pos.invoice.InvoicePos;
import com.iii.pos.invoice.Invoice_Detail_PosActivity;
import com.iii.pos.item.Category_Item_PosActivity;
import com.iii.pos.map.MapFragment;
import com.iii.pos.map.MapPos;

public class MainPosActivity extends FragmentActivity implements
		Header_Pos.OnHeaderSelectedListener {

	private boolean login = true;
	private ConfigurationWS mWS;
	String URL = "";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_pos);

		// ------------------creating the ws------------------------//
		mWS = new ConfigurationWS(this);
		URL = getResources().getString(R.string.loginWS);
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
		login_out(this);

	}

	private void putDataLogin() {

		// update croped image
		JSONObject json = new JSONObject();
		try {
			json.put("username", "tranminhthuan");

			json.put("pass", "123456");

			JSONArray jarr = mWS.connectWSPut_Get_Data(URL, json, "posts");

			for (int i = 0; i < jarr.length(); i++) {
				JSONObject element = jarr.getJSONObject(i);				
				String result = element.getString("result");				
			}

		} catch (JSONException e) { // TODO Auto-generated catch
									// block
			e.printStackTrace();
		}

	}

	@Override
	public void onMenuButtonClick(int btnKey, View v) {
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
		case 5:
			// doing in the Login_out
			myBodyFragemnt = new MapFragment();
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
		login = !login;
		final Dialog dialog = new Dialog(context);
		dialog.setTitle("User Login");
		dialog.setContentView(R.layout.login_pos);
		Button btnLogin = (Button) dialog.findViewById(R.id.btnLogin);
		btnLogin.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				putDataLogin();
			}
		});
		dialog.setCancelable(true);
		try {
			dialog.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateLanguage(String languageKey, View view) {
		// TODO Auto-generated method stub
		Intent t = new Intent(this, MainPosActivity.class);
		startActivity(t);
		this.finish();
	}
}
