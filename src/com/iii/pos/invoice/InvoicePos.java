package com.iii.pos.invoice;

import java.util.ArrayList;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.iii.pos.R;
import com.iii.pos.adapter.AdapterListInvoice;
import com.iii.pos.model.Invoice;

public class InvoicePos extends Fragment {
	private ListView invoiceList;
	private ArrayList<Invoice> arr;
	private AdapterListInvoice adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View invoiceLayout = inflater.inflate(R.layout.invoice_pos,
				container, false);
		invoiceList = (ListView) invoiceLayout.findViewById(R.id.listView);
		Invoice item1 = new Invoice();
		item1.setInv_id(1);
		item1.setName_item("Súp canh gà");
		item1.setUnit_item("Bát");
		item1.setAmount_item(2);
		item1.setCost_item(15);
		item1.setNotes("Giảm giá");

		Invoice item2 = new Invoice();
		item2.setInv_id(2);
		item2.setName_item("Súp canh Bò");
		item2.setUnit_item("Bát");
		item2.setAmount_item(2);
		item2.setCost_item(15);
		item2.setNotes("Miễn phí");

		Invoice item3 = new Invoice();
		item3.setInv_id(3);
		item3.setName_item("Súp canh châu");
		item3.setUnit_item("Bát");
		item3.setAmount_item(2);
		item3.setCost_item(15);
		item3.setNotes("Miễn phí");
		Invoice item4 = new Invoice();
		item4.setInv_id(0);
		item4.setName_item("TỔNG TIỀN PHẢI THANH TOÁN");
		item4.setUnit_item("Bát");
		item4.setAmount_item(6);
		item4.setCost_item(45);
		item4.setNotes("");

		Invoice item5 = new Invoice();
		item5.setInv_id(0);
		item5.setName_item("VAS");
		item5.setUnit_item("");
		item5.setAmount_item(0);
		item5.setCost_item(0.45f);
		item5.setNotes("");

		Invoice item6 = new Invoice();
		item6.setInv_id(0);
		item6.setName_item("TOTAL");
		item6.setUnit_item("");
		item6.setAmount_item(0);
		item6.setCost_item(49.5f);
		item6.setNotes("");
		arr = new ArrayList<Invoice>();
		arr.add(item1);
		arr.add(item2);
		arr.add(item3);
		arr.add(item4);
		arr.add(item5);
		arr.add(item6);

		adapter = new AdapterListInvoice(invoiceLayout.getContext(),
				R.layout.invoice_custom_listview, arr);
		invoiceList.setAdapter(adapter);

		// -----------------------get Button to excute--------------//

		Button btnAddInvoice = (Button) invoiceLayout
				.findViewById(R.id.addNewInvoice);
		btnAddInvoice.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				addNewInvoice(invoiceLayout.getContext());
			}
		});
		return invoiceLayout;
	}

	// dialgo here
	private void addNewInvoice(Context context) {
		final Dialog dialog = new Dialog(context);
		dialog.setTitle("Creating The Invoice");
		dialog.setContentView(R.layout.invoice_add);
		dialog.setCancelable(true);
		/*Button btnStart = (Button) dialog.findViewById(R.id.btnStart);
		btnStart.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				
				 * UpdataUserInit up = new UpdataUserInit(); up.execute();
				 
				new playSound(getApplicationContext()).playButton();
				// show right layout

				// icon_me.setImageResource(R.drawable.temp_thumbnail_mimirin);
				ShowMap_Activity.sex = 0;

				updateSex();
				dialog.dismiss();
				Message msg = handler.obtainMessage();
				handler.sendMessage(msg);

			}
		});

		ImageView btnThoat = (ImageView) dialog.findViewById(R.id.btnThoat);
		btnThoat.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				new playSound(getApplicationContext()).playButton();
				// show right layout

				ShowMap_Activity.sex = 1;

				updateSex();
				dialog.dismiss();
				// Message msg = handler.obtainMessage();
				// handler.sendMessage(msg);
			}
		});*/
		try {
			dialog.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
