package com.iii.pos.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.iii.pos.R;
import com.iii.pos.item.Items_Detail;

public class Adapter_List_Dishes extends ArrayAdapter<Items_Detail> {

	Context context;
	ArrayList<Items_Detail> itemlist;
	List<String> li;

	public Adapter_List_Dishes(Context context, int textViewResourceId,
			ArrayList<Items_Detail> objects) {
		super(context, textViewResourceId, objects);
		this.itemlist = objects;
		this.context = context;
	}

	ArrayAdapter<String> arradapter;
	
	int arrim[] = {R.drawable.soupga, R.drawable.cakho, R.drawable.canhraumuong, R.drawable.laumam};

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View item = convertView;
		try {

			if (item == null) {
				LayoutInflater inflate = (LayoutInflater) this.context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				item = inflate.inflate(R.layout.listitem_temp, null);
			}
			final Items_Detail itemdetail = itemlist.get(position);
			if (itemdetail != null) {
				TextView tv1 = (TextView) item.findViewById(R.id.textview1);
				TextView tv2 = (TextView) item.findViewById(R.id.textview2);
				TextView tv3 = (TextView) item.findViewById(R.id.textview3);

				int status = itemdetail.getStatus();

				tv2.setText(String.valueOf(itemdetail.get_id()));
				tv1.setText(String.valueOf(itemdetail.getName()));
				tv3.setText(String.valueOf(status+" $"));

				li = new ArrayList<String>();
				for (int i = 1; i <= status; i++) {

					li.add(String.valueOf(i));
				}
				
				final EditText edit = (EditText) item.findViewById(R.id.editText1);

				final CheckBox check = (CheckBox) item
						.findViewById(R.id.checkbox);
//				if (check.isChecked() == false) {
//						edit.setVisibility(EditText.GONE);
//				}
//				check.setOnCheckedChangeListener(new OnCheckedChangeListener() {
//
//					@Override
//					public void onCheckedChanged(CompoundButton buttonView,
//							boolean isChecked) {
//						if (check.isChecked() == false) {
//							edit.setVisibility(EditText.GONE);
//						} else {
//							edit.setVisibility(EditText.VISIBLE);
//						}
//					}
//				});
				
				ImageView im = (ImageView) item.findViewById(R.id.image_view);
				im.setBackgroundResource(arrim[position]);
			}

		} catch (Exception e) {
			Log.i("Log : ", "Exception : " + e.getMessage());
		}
		return item;
	}



}
