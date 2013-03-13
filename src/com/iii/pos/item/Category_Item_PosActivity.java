package com.iii.pos.item;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.iii.pos.R;
import com.iii.pos.adapter.Adapter_List_Dishes;
import com.iii.pos.adapter.Adapter_list_Category;
import com.iii.pos.model.Category;
import com.iii.pos.model.Items;


//-----------add to right menu on main activity--------//
public class Category_Item_PosActivity extends Fragment {

	private ListView lv;
	private ArrayList<Category> arr;
	private Adapter_list_Category adb;

	private ArrayList<Items> arr1;
	private Adapter_List_Dishes adb1;
	private TextView tvtitle;
	private ImageButton imbuttom;
	private TextView tvgach;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View categoryLayout = inflater.inflate(R.layout.category_item,
				container, false);

		try {

			imbuttom = (ImageButton) categoryLayout.findViewById(R.id.btnback);
			tvgach = (TextView) categoryLayout.findViewById(R.id.tvgach);
			tvgach.setVisibility(TextView.GONE);
			imbuttom.setVisibility(ImageButton.GONE);

			tvtitle = (TextView) categoryLayout
					.findViewById(R.id.tvDisplayCateAndItem);
			lv = (ListView) categoryLayout.findViewById(R.id.listView1);
			loadCategoryInfo();

			lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> adapter, View v,
						int position, long arg3) {

					int cate_id = arr.get(position).getCtegory_id();
					Log.i("Log : ", "Cate ID : " + cate_id);
					tvtitle.setText(String.valueOf(arr.get(position).getName()));
					imbuttom.setVisibility(ImageButton.VISIBLE);
					tvgach.setVisibility(TextView.VISIBLE);

					loadItemInfo(cate_id);

				}
			});

			imbuttom.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					loadCategoryInfo();
					imbuttom.setVisibility(ImageButton.GONE);
					tvgach.setVisibility(TextView.GONE);
					tvtitle.setText("Category");
				}
			});

		} catch (Exception e) {
			Log.i("Log : ", "Exception : " + e.getMessage());
		}
		return categoryLayout;
	}

	private void loadCategoryInfo() {
		Category cate1 = new Category();
		cate1.setName("Các MónLẩu");
		cate1.setDescription("Miền Bắc, Miền Trung, Miền Nam");
		cate1.setCtegory_id(1);
		Category cate2 = new Category();
		cate2.setName("Các Món Nhậu");
		cate2.setDescription("Miền Bắc, Miền Trung, Miền Nam");
		cate2.setCtegory_id(2);
		Category cate3 = new Category();
		cate3.setName("Các Món Súp");
		cate3.setDescription("Miền Bắc, Miền Trung, Miền Nam");
		cate3.setCtegory_id(3);
		Category cate4 = new Category();
		cate4.setName("Các Món Vịt");
		cate4.setDescription("Miền Bắc, Miền Trung, Miền Nam");
		cate4.setCtegory_id(4);
		Category cate5 = new Category();
		cate5.setName("Các Món Thịt Chó");
		cate5.setDescription("Miền Bắc, Miền Trung, Miền Nam");
		cate5.setCtegory_id(5);
		Category cate6 = new Category();
		cate6.setName("Các Món Thịt Trâu");
		cate6.setDescription("Miền Bắc, Miền Trung, Miền Nam");
		cate6.setCtegory_id(6);

		arr = new ArrayList<Category>();
		arr.add(cate1);
		arr.add(cate2);
		arr.add(cate3);
		arr.add(cate4);
		arr.add(cate5);
		arr.add(cate6);

		adb = new Adapter_list_Category(getActivity().getApplicationContext(),
				R.layout.category_item, arr);
		lv.setAdapter(adb);

	}

	private void loadItemInfo(int cate_id) {

		Items item1 = new Items();
		item1.setName("Súp Gà");
		item1.setPrice(123);
		item1.setDescription("Súp gà là món ăn bổ dưỡng thơm ngon");
		Items item2 = new Items();
		item2.setName("Cá Kho");
		item2.setPrice(42);
		item2.setDescription("Cá kho ngon ngọt tự nhiên với hương vị cá đồng");
		Items item3 = new Items();
		item3.setName("Canh rau Muống");
		item3.setPrice(63);
		item3.setDescription("Rau Muống là món ăn dân tộc có hương vị của quê hương..");
		Items item4 = new Items();
		item4.setName("Lẩu Mắm");
		item4.setPrice(23);
		item4.setDescription("Lẩu mắm có hương vị đậm đà của miền sông nước");

		arr1 = new ArrayList<Items>();
		arr1.add(item1);
		arr1.add(item2);
		arr1.add(item3);
		arr1.add(item4);
		adb1 = new Adapter_List_Dishes(getActivity(), R.layout.category_item, arr1);
		lv.setAdapter(adb1);
	}

}