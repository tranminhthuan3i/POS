package com.iii.pos.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.iii.pos.R;
import com.iii.pos.invoice.Invoice_Detail;

//-----------custom the listview-------------------//
public class AdapterListInvoice extends ArrayAdapter<Invoice_Detail> {

	// ----------------Fields ----------------------------------//
	private Context context;
	private ArrayList<Invoice_Detail> invoiceitemlist;
	private List<String> li;
	private ArrayAdapter<String> arradapter;

	// ---------------Constructor-------------------------------//
	public AdapterListInvoice(Context context, int textViewResourceId,
			List<Invoice_Detail> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		this.invoiceitemlist = (ArrayList<Invoice_Detail>) objects;
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View invoiceItem = convertView;
		try {

			if (invoiceItem == null) {
				LayoutInflater inflate = (LayoutInflater) this.context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				invoiceItem = inflate.inflate(R.layout.invoice_custom_listview,
						null);
			}
			final Invoice_Detail invoiceItemdetail = invoiceitemlist
					.get(position);
			if (invoiceItemdetail != null) {
				TextView index = (TextView) invoiceItem
						.findViewById(R.id.index);
				TextView name_item = (TextView) invoiceItem
						.findViewById(R.id.nameitem);
				TextView unit_item = (TextView) invoiceItem
						.findViewById(R.id.unit_item);
				TextView amount_item = (TextView) invoiceItem
						.findViewById(R.id.amount_item);
				TextView cost_item = (TextView) invoiceItem
						.findViewById(R.id.cost_item);
				TextView notes = (TextView) invoiceItem
						.findViewById(R.id.note_item);

				if (invoiceItemdetail.getInv_id() == 0) {
					index.setText("");
				} else {
					index.setText(String.valueOf(invoiceItemdetail.getInv_id()));
				}
				name_item.setText(String.valueOf(invoiceItemdetail
						.getName_item()));
				unit_item.setText(String.valueOf(invoiceItemdetail
						.getUnit_item()));
				if (invoiceItemdetail.getAmount_item() == 0) {
					amount_item.setText("");
				} else {
					amount_item.setText(String.valueOf(invoiceItemdetail
							.getAmount_item()));
				}
				
				cost_item.setText(String.valueOf(invoiceItemdetail
						.getCost_item())+"  $");
				notes.setText(String.valueOf(invoiceItemdetail.getNotes()));

				li = new ArrayList<String>();

				arradapter = new ArrayAdapter<String>(context,
						android.R.layout.simple_list_item_1, li);
			}

		} catch (Exception e) {
			Log.i("Log : ", "Exception : " + e.getMessage());
		}
		return invoiceItem;
	}

}
