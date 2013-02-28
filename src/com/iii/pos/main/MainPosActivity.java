package com.iii.pos.main;

import java.util.ArrayList;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.iii.pos.R;
import com.iii.pos.adapter.Adapter_List_Dishes;
import com.iii.pos.invoice.InvoicePos;
import com.iii.pos.item.Items_Detail;
import com.iii.pos.map.Floor1;
import com.iii.pos.map.Floor2;
import com.iii.pos.map.MapPos;

@SuppressWarnings("deprecation")
public class MainPosActivity extends TabActivity {
	private ListView lv;
	private ArrayList<Items_Detail> arr;
	private Adapter_List_Dishes adb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_pos);

		TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);

		// Tab 1
		TabSpec tab1 = tabHost.newTabSpec("tab1");
		tab1.setIndicator("MAPPOS");
		tab1.setContent(new Intent(MainPosActivity.this, MapPos.class));
		tabHost.addTab(tab1);

		// Tab 2
		TabSpec tab2 = tabHost.newTabSpec("tab2");
		tab2.setIndicator("INVOICE");
		tab2.setContent(new Intent(MainPosActivity.this, InvoicePos.class));

		tabHost.addTab(tab2);

		// tab 3
		TabSpec tab3 = tabHost.newTabSpec("tab3");
		tab3.setIndicator("INFO");
		tab3.setContent(new Intent(MainPosActivity.this, Floor2.class));
		tabHost.addTab(tab3);
		// tab 3
		TabSpec tab4 = tabHost.newTabSpec("tab4");
		tab3.setIndicator("TEMP");
		tab3.setContent(new Intent(MainPosActivity.this, Floor2.class));
		tabHost.addTab(tab3);

		try {

			Items_Detail item1 = new Items_Detail();
			item1.setName("Súp Gà");
			item1.setStatus(47);
			item1.set_id("Súp gà là món ăn bổ dưỡng thơm ngon");
			Items_Detail item2 = new Items_Detail();
			item2.setName("Cá Kho");
			item2.setStatus(46);
			item2.set_id("Cá kho ngon ngọt tự nhiên với hương vị cá đồng");
			Items_Detail item3 = new Items_Detail();
			item3.setName("Canh rau Muống");
			item3.setStatus(44);
			item3.set_id("Rau Muống là món ăn dân tộc có hương vị của quê hương..");
			Items_Detail item4 = new Items_Detail();
			item4.setName("Lẩu Mắm");
			item4.setStatus(43);
			item4.set_id("Lẩu mắm có hương vị đậm đà của miền sông nước");

			lv = (ListView) this.findViewById(R.id.listView1);
			arr = new ArrayList<Items_Detail>();
			arr.add(item1);
			arr.add(item2);
			arr.add(item3);
			arr.add(item4);

			adb = new Adapter_List_Dishes(getApplicationContext(),
					R.layout.activity_main_pos, arr);
			lv.setAdapter(adb);

		} catch (Exception e) {
			Log.i("Log : ", "Exception : " + e.getMessage());
		}

	}
}
