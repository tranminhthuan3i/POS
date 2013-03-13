package com.iii.pos.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.iii.pos.model.Detail_Items;

public class Adapter_List_Dishes extends ArrayAdapter<Detail_Items> implements
		TextWatcher {

	Context context;
	List<Detail_Items> itemlist;

	int pos;

	public Adapter_List_Dishes(Context context, int textViewResourceId,
			List<Detail_Items> objects) {
		super(context, textViewResourceId, objects);
		this.itemlist = objects;
		this.context = context;
	}

	ArrayAdapter<String> arradapter;

	int arrim[] = { R.drawable.soupga, R.drawable.cakho,
			R.drawable.canhraumuong, R.drawable.laumam };

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View item = convertView;
		try {

			if (item == null) {
				LayoutInflater inflate = (LayoutInflater) this.context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				item = inflate.inflate(R.layout.temp_listitem, null);
			}
			final Detail_Items itemdetail = itemlist.get(position);
			if (itemdetail != null) {
				TextView tvName = (TextView) item.findViewById(R.id.tvNameItem);
				TextView tvDetail = (TextView) item
						.findViewById(R.id.tvDetailItem);
				TextView tvPrice = (TextView) item
						.findViewById(R.id.tvPriceItem);

				float Price = itemdetail.getPrice();

				tvName.setText(String.valueOf(itemdetail.getName()));
				tvDetail.setText(String.valueOf(itemdetail.getDescription()));
				tvPrice.setText(String.valueOf(Price + " VNĐ"));

				final EditText quantity = (EditText) item
						.findViewById(R.id.textQuantity);

				final CheckBox checkselect = (CheckBox) item
						.findViewById(R.id.checkSelect);
				if (checkselect.isChecked() == false) {
					quantity.setVisibility(EditText.GONE);
				}

				checkselect
						.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

							@Override
							public void onCheckedChanged(
									CompoundButton buttonView, boolean isChecked) {
								if (checkselect.isChecked() == false) {
									quantity.setVisibility(EditText.GONE);
								} else if (checkselect.isChecked() == true) {
									quantity.setVisibility(EditText.VISIBLE);
									quantity.requestFocus();
								}
							}
						});
				ImageView im = (ImageView) item.findViewById(R.id.image_view);
				im.setBackgroundResource(arrim[position]);

			}

		} catch (Exception e) {
			Log.i("Log : ", "Exception : " + e.getMessage());
		}
		return item;
	}

	@Override
	public void afterTextChanged(Editable arg0) {
		// TODO Auto-generated method stub
		// ((Object) itemlist.get(pos)).setAddress(arg0.toString());
	}

	@Override
	public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
			int arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}

}
