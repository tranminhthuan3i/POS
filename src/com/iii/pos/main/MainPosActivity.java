package com.iii.pos.main;

import java.text.DateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.iii.pos.R;
import com.iii.pos.category_item.Category_Item_PosActivity;
import com.iii.pos.common.Cache;
import com.iii.pos.common.Header_Pos;
import com.iii.pos.config.ConfigurationWS;
import com.iii.pos.invoice.InvoicePos;
import com.iii.pos.invoice.Invoice_Detail_PosActivity;
import com.iii.pos.map.MapFragment;
import com.iii.pos.map.MapPos;
import com.iii.pos.model.User;

public class MainPosActivity extends FragmentActivity implements
		Header_Pos.OnHeaderSelectedListener {

	private static final String UserNameKey = "_UserName";
	private static final String PassWordKey = "_PassWord";
	// --------------------Fields-----------------------------//
	private ConfigurationWS mWS;
	private String URL = "";
	private View footer = null;
	private int exit = 0;
	private Dialog dialog;
	private User user;
	private CheckBox cbShowPassword, cbSavePass;

	private String prefName = "SavePassWordCheck";
	protected static final String Save_Password_Key = "SavePass";
	private SharedPreferences shPref;

	// -----------------initialize--------------------------//
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_pos);

		// ------------------creating the ws------------------------//
		mWS = new ConfigurationWS(this);
		URL = getResources().getString(R.string.wslogin);
		user = new User();
		footer = (View) findViewById(R.id.footer_Pos_Fragment);

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

		// ------------------ get KEY for selected the language-----0//
		// -------------------Login out start first------------------//
		Bundle extras = getIntent().getExtras();
		if (extras == null) {
			login_out(this);
		}
		/*
		 * else { String language = extras.getString("KEY"); key =
		 * Integer.parseInt(language); System.out.println(key + "<--KEY"); }
		 */

		/*--------------------policy for connect to ws-------------*/
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);
	}

	// ----------------use to post and get data ------------------//
	private boolean putDataLogin(String username, String pass) {
		boolean ok = false;
		// update croped image
		JSONObject json = new JSONObject();
		try {
			json.put("username", username);

			json.put("pass", pass);

			JSONArray jarr = mWS.connectWSPut_Get_Data(URL, json, "posts");

			if (jarr != null) {
				for (int i = 0; i < jarr.length(); i++) {
					JSONObject element = jarr.getJSONObject(i);
					String result = element.getString("result1");
					if (result.equals("success")) {
						ok = true;
						return ok;
					}
				}
			}

		} catch (JSONException e) { // TODO Auto-generated catch
									// block
			e.printStackTrace();
		}
		return ok;

	}

	// ----------------Callback method from Header setting-------------//
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
			Button btnLogin_out = (Button) v.findViewById(R.id.btnLogin_Out);
			btnLogin_out.setText(R.string.login_out);
			btnLogin_out.setCompoundDrawablesWithIntrinsicBounds(
					R.drawable.menu_icon_login, 0, 0, 0);
			// --------------change img to login------//
			TextView footerText = (TextView) footer
					.findViewById(R.id.usernamestatus);
			footerText.setText("USER:                --- LOGIN TIME: 00:00:00");
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

	// -------------------processing before breack----------------//
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub

		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.popBackStack();
		super.onBackPressed();
	}

	// ---------Called when user pressed login--------------------//
	private void login_out(Context context) {
		dialog = new Dialog(context);
		dialog.setTitle("User Login");
		dialog.setContentView(R.layout.login_pos);
		dialog.setCancelable(false);
		final EditText epass = (EditText) dialog.findViewById(R.id.loginpass);
		final EditText ename = (EditText) dialog
				.findViewById(R.id.loginusername);
		// ------------save pass----------------------//
		final CheckBox cbSavePass = (CheckBox) dialog
				.findViewById(R.id.Check_SaveUserPass);

		cbShowPassword = (CheckBox) dialog.findViewById(R.id.ShowThePassWord);

		// ---------------show password--------------------------//
		cbShowPassword
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (!isChecked) {
							epass.setTransformationMethod(PasswordTransformationMethod
									.getInstance());
						} else {
							epass.setTransformationMethod(HideReturnsTransformationMethod
									.getInstance());
						}
					}
				});
		Button btnLogin = (Button) dialog.findViewById(R.id.btnLogin);
		btnLogin.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				final String username = ename.getText().toString();

				final String pass = epass.getText().toString();
				try {

					Log.d("ABC", "Bat dau");
					shPref = getSharedPreferences(prefName, MODE_PRIVATE);
					SharedPreferences.Editor editor = shPref.edit();
					editor.putString(UserNameKey,
							String.valueOf(ename.getText()).trim());
					editor.putString(PassWordKey,
							String.valueOf(epass.getText()).trim());
					Log.d("ABC", "Da vao");
					editor.putBoolean(Save_Password_Key, cbSavePass.isChecked());
					editor.commit();
					Cache.setCacheUserData(String.valueOf(ename.getText())
							.trim());
					Cache.setLoginState(true);
				} catch (Exception e) {
					Log.d("ABC", "loi roi");
					SharedPreferences shPre = getSharedPreferences(prefName,
							MODE_PRIVATE);
					cbSavePass.setChecked(shPre.getBoolean(Save_Password_Key,
							false));
				}
				if (putDataLogin(username, pass)) {
					Toast.makeText(MainPosActivity.this, "Login success",
							Toast.LENGTH_SHORT).show();
					// change img icon on button login to logout
					View header = (View) findViewById(R.id.headerMenuFragment);
					Button btnLogin_out = (Button) header
							.findViewById(R.id.btnLogin_Out);
					btnLogin_out.setText("Logout");
					btnLogin_out.setCompoundDrawablesWithIntrinsicBounds(
							R.drawable.menu_icon_logout, 0, 0, 0);
					// login to change status on the footer pos

					String currentDateTimeString = DateFormat
							.getDateTimeInstance().format(new Date());
					TextView footerText = (TextView) footer
							.findViewById(R.id.usernamestatus);
					// textView is the TextView view that should display it
					footerText.setText("USER: " + username.toUpperCase()
							+ "--- LOGIN TIME: "
							+ currentDateTimeString.toUpperCase());
					// set to User
					user.setUsername(username);
					user.setPassword(pass);

					dialog.dismiss();

				} else
					Toast.makeText(MainPosActivity.this,
							"Fault please try again", Toast.LENGTH_SHORT)
							.show();
			}
		});
		Button btnExit = (Button) dialog.findViewById(R.id.btnExit);
		btnExit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (dialog != null) {
					dialog.dismiss();
				}
				onBackPressed();
				onBackPressed();
			}
		});

		try {
			dialog.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// -------------update language----------------------------//
	@Override
	public void updateLanguage(String languageKey, View view) {
		// TODO Auto-generated method stub
		Bundle bl = new Bundle();
		bl.putString("KEY", languageKey);
		Intent t = new Intent(this, MainPosActivity.class);
		t.putExtras(bl);
		startActivity(t);
		this.finish();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		System.gc();
		finish();
	}
}
