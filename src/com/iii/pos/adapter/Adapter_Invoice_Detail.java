package com.iii.pos.adapter;

import java.text.BreakIterator;
import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.iii.pos.R;
import com.iii.pos.invoice.Invoice_Detail_1;

public class Adapter_Invoice_Detail extends ArrayAdapter<Invoice_Detail_1> {

	private Context context;
	private ArrayList<Invoice_Detail_1> invoicelist;
	private int count = 0;

	public Adapter_Invoice_Detail(Context context, int textViewResourceId,
			ArrayList<Invoice_Detail_1> invoicelist) {
		super(context, textViewResourceId, invoicelist);
		this.context = context;
		this.invoicelist = invoicelist;
	}

	float total = 0f;

	// int countCost = 0;

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View item = convertView;
		try {

			if (item == null) {
				LayoutInflater inflate = (LayoutInflater) this.context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				item = inflate.inflate(R.layout.temp_listinvoice, null);
			}
			final Invoice_Detail_1 invoicedetail = invoicelist.get(position);

			// count++;
			// countCost++;
			ImageButton imbtnDelete = (ImageButton) item
					.findViewById(R.id.imbuttondelete);
			imbtnDelete.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					removeitem(position);
				}
			});

			TextView index = (TextView) item.findViewById(R.id.tvindex);
			TextView name = (TextView) item.findViewById(R.id.tvnameitem);
			TextView unit = (TextView) item.findViewById(R.id.tvunit_item);
			TextView amount = (TextView) item.findViewById(R.id.tvamount_item);
			TextView cost = (TextView) item.findViewById(R.id.tvcost_item);

			// TextView description = (TextView) item
			// .findViewById(R.id.tvdescription_item);


			// if (invoicelist.size() <= count) {
			// Log.i("Log  :", "OK : ");
			//
			//
			//
			// } else {
			if (invoicedetail != null) {

				if (count == 0) {
					index.setText(String.valueOf("TT"));
					name.setText(String.valueOf("Tên món ăn"));
					unit.setText(String.valueOf("Đơn giá"));
					amount.setText(String.valueOf("sl"));

					cost.setText(String.valueOf("Thành tiền"));
					imbtnDelete.setVisibility(ImageButton.GONE);
					Log.i("Log : ", "OK 1 : "+count);
				} else {
					if ((count+1) == invoicelist.size()) {
						Log.i("Log : ", "OK 3 : "+count);
//						gach.setVisibility(TextView.GONE);
						index.setText(String.valueOf(invoicedetail
								.getName_item()));
						cost.setText(String.valueOf(invoicedetail.getVat()
								+ " $\n"
								+ invoicedetail.getCommision()
								+ " $\n"
								+ (total + invoicedetail.getVat() + invoicedetail
										.getCommision()) + " $"));
						imbtnDelete.setVisibility(ImageButton.GONE);
						unit.setVisibility(TextView.GONE);
						name.setVisibility(TextView.GONE);
						amount.setVisibility(TextView.GONE);
						// index.setVisibility(TextView.GONE);
					} else {
						Log.i("Log : ", "OK 2 : "+count);
//						gach.setVisibility(TextView.VISIBLE);
						imbtnDelete.setVisibility(ImageButton.VISIBLE);
						index.setText(String.valueOf(count));
						name.setText(String.valueOf(invoicedetail
								.getName_item()));
						unit.setText(String.valueOf(invoicedetail
								.getAmount_item()));
						amount.setText(String.valueOf(invoicedetail
								.getUnit_item()));
						float thanhtoan = (invoicedetail.getUnit_item() * invoicedetail
								.getAmount_item());

						cost.setText(String.valueOf(thanhtoan + " $"));
						// description.setText(String.valueOf(invoicedetail
						// .getDescription()));

						total = total += thanhtoan;
					}
				}

				count++;
				// }else {

				// Log.i("Log : ", "Ok---------------");

				// name.setText(String.valueOf("Total : "));
				// cost.setText(String.valueOf(total+ " $"));
				//
				// if(countCost ==3){
				// return item;
				// }
			}
		} catch (Exception e) {
			Log.i("Log : ", "Exception : " + e.getMessage());
		}
		return item;
	}

	private void removeitem(int position) {
		remove(invoicelist.get(position));
		count = 0;
		total = 0f;
		// countCost = 0;
	}

}
