package com.iii.pos.invoice;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.iii.pos.R;
import com.iii.pos.adapter.Adapter_Invoice_Detail;
import com.iii.pos.adapter.Adapter_List_Dishes;
import com.iii.pos.adapter.Adapter_list_Category;
import com.iii.pos.model.Category;
import com.iii.pos.model.Items;
import com.iii.pos.model.Invoice_Detail;

public class Invoice_Detail_PosActivity extends Fragment {



	private ListView lv;
	// private ArrayList<Items_Detail> arr;
	// private Adapter_List_Dishes adb;

	private ArrayList<Invoice_Detail> arr;
	private Adapter_Invoice_Detail adb;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View invoiceLayout = inflater.inflate(
				R.layout.invoice_detail_activiy, container, false);

		try {
			Invoice_Detail item = new Invoice_Detail();

			Invoice_Detail item1 = new Invoice_Detail();
			item1.setName_item("Canh Gà");
			item1.setUnit_item(3);
			item1.setAmount_item(23f);
			item1.setDescription("Miễn Phí");
			Invoice_Detail item2 = new Invoice_Detail();
			item2.setName_item("Lẩu");
			item2.setUnit_item(4);
			item2.setAmount_item(23f);
			item2.setDescription("Trả phí");
			Invoice_Detail item3 = new Invoice_Detail();
			item3.setName_item("Thịt chó");
			item3.setUnit_item(2);
			item3.setAmount_item(22f);
			item3.setDescription("Trả phí");
			Invoice_Detail item4 = new Invoice_Detail();
			item4.setName_item("Canh Rau Muống");
			item4.setUnit_item(5);
			item4.setAmount_item(264f);
			item4.setDescription("Miễn Phí");

			Invoice_Detail item5 = new Invoice_Detail();
			item5.setName_item("VAT : \nCommition : \nTotal : ");

			lv = (ListView) invoiceLayout.findViewById(R.id.listViewInvoiceDetail);
			arr = new ArrayList<Invoice_Detail>();
			arr.add(item);
			arr.add(item1);
			arr.add(item2);
			arr.add(item3);
			arr.add(item4);
			arr.add(item5);

			adb = new Adapter_Invoice_Detail(getActivity().getApplicationContext(),
					R.layout.invoice_detail_activiy, arr);
			lv.setAdapter(adb);

		} catch (Exception e) {
			Log.i("Log : ", "Exception : " + e.getMessage());
		}
		return invoiceLayout;
	}

}