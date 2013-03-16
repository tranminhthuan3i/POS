package com.iii.pos.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.iii.pos.R;
import com.iii.pos.common.Constaints;
import com.iii.pos.model.Category;

public class Adapter_list_Category extends ArrayAdapter<Category> {

	private ArrayList<Category> categorylist;
	private Context context;
	private ArrayList<String> img_category;

	public ArrayList<String> getImg_category() {
		return img_category;
	}

	public void setImg_category(ArrayList<String> img_category) {
		this.img_category = img_category;
	}

	public Adapter_list_Category(Context context, int textViewResourceId,
			ArrayList<Category> category) {
		super(context, textViewResourceId, category);
		this.context = context;
		this.categorylist = category;
	}

	int arrim[] = { R.drawable.soupga, R.drawable.cakho,
			R.drawable.canhraumuong, R.drawable.laumam };

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View item = convertView;

		if (item == null) {
			LayoutInflater inflate = (LayoutInflater) this.context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			item = inflate.inflate(R.layout.temp_listcategory, null);
		}
		final Category itemdetail = categorylist.get(position);
		if (categorylist != null) {

			TextView tvName = (TextView) item.findViewById(R.id.tvNameCategory);
			TextView tvDetail = (TextView) item
					.findViewById(R.id.tvDescriptionCategory);

			tvName.setText(String.valueOf(itemdetail.getName()));
			tvDetail.setText(String.valueOf(itemdetail.getDescription()));

		}
		ImageView im = (ImageView) item.findViewById(R.id.img_category);
		try {
			String filepath = Environment.getExternalStorageDirectory()
					.getPath()+Constaints.URLImageCategory+img_category.get(position)+".png";
			System.out.println("TRAN MINH THUAN  "+filepath);
			Bitmap bm = BitmapFactory.decodeFile(filepath);
			im.setImageBitmap(bm);
			//bm.recycle();
		} catch (Exception e) {

		}
		return item;
	}

	

}
