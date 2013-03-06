package com.iii.pos.model;

import java.util.List;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.iii.pos.R;
import com.iii.pos.item.Detail_Items;

public class AdapterThuan extends ArrayAdapter<Detail_Items> implements TextWatcher {

	private final List<Detail_Items> list;
	private final Activity context;
	int listPosititon;

	public AdapterThuan(Activity context, List<Detail_Items> list) {
		super(context, R.layout.temp_listitem, list);
		this.context = context;
		this.list = list;
	}

	static class ViewHolder {
		protected TextView text;
		protected CheckBox checkbox;
		protected EditText address;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		listPosititon = position;
		ViewHolder viewHolder = null;
		if (convertView == null) {
			LayoutInflater inflator = context.getLayoutInflater();
			convertView = inflator.inflate(R.layout.temp_listitem, null);
			viewHolder = new ViewHolder();
			viewHolder.text = (TextView) convertView.findViewById(R.id.tv_title);
			viewHolder.checkbox = (CheckBox) convertView
					.findViewById(R.id.checkSelect);
			viewHolder.address = (EditText) convertView
					.findViewById(R.id.textQuantity);
			viewHolder.checkbox
					.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

						@Override
						public void onCheckedChanged(CompoundButton buttonView,
								boolean isChecked) {
//							int getPosition = (Integer) buttonView.getTag();
//							// Here we get the position that we have set for the
//							// checkbox using setTag.
//							list.get(getPosition).setSelected(
//									buttonView.isChecked());
							// Set the value of checkbox to maintain its state.
						}
					});
			viewHolder.address.addTextChangedListener(this);

			convertView.setTag(viewHolder);
			convertView.setTag(R.id.tv_title, viewHolder.text);
			convertView.setTag(R.id.checkSelect, viewHolder.checkbox);
			convertView.setTag(R.id.textQuantity, viewHolder.address);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
//		viewHolder.checkbox.setTag(position); // This line is important.
//
//		viewHolder.text.setText(list.get(position).getName());
//		viewHolder.checkbox.setChecked(list.get(position).isSelected());
//		if (list.get(position).getName() != null) {
//			viewHolder.address.setText(list.get(position).getName() + "");
//		} else {
//			viewHolder.address.setText("");
//		}

		return convertView;
	}

	@Override
	public void afterTextChanged(Editable s) {
		list.get(listPosititon).setName(s.toString());
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
