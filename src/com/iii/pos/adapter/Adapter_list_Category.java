package com.iii.pos.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.iii.pos.R;
import com.iii.pos.model.Detail_Category;

public class Adapter_list_Category extends ArrayAdapter<Detail_Category> {

	private ArrayList<Detail_Category> categorylist;
	private Context context;

	public Adapter_list_Category(Context context, int textViewResourceId,
			ArrayList<Detail_Category> category) {
		super(context, textViewResourceId, category);
		this.context = context;
		this.categorylist = category;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View item = convertView;

		if (item == null) {
			LayoutInflater inflate = (LayoutInflater) this.context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			item = inflate.inflate(R.layout.temp_listcategory, null);
		}
		final Detail_Category itemdetail = categorylist.get(position);
		if (categorylist != null) {

			TextView tvName = (TextView) item.findViewById(R.id.tvNameCategory);
			TextView tvDetail = (TextView) item
					.findViewById(R.id.tvDescriptionCategory);

			tvName.setText(String.valueOf(itemdetail.getName()));
			tvDetail.setText(String.valueOf(itemdetail.getDescription()));
		}
		return item;
	}

}
