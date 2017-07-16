package com.parvez_n_jabed_co.ccc_project;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by PARVEZ on 07-Feb-17.
 */

public class TransportAdepter  extends BaseAdapter {

    Context context;
    List<TransportItem> rowItems;

    TransportAdepter(Context context, List<TransportItem> rowItems) {
        this.context = context;
        this.rowItems = rowItems;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }
    @Override

    public int getViewTypeCount() {

        return getCount();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }


    /* private view holder class */
    private class ViewHolder {
        ImageView trans_pic;
        TextView trans_type;
        TextView trans_gtr;
        //	Button hospital_btn;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.transportiteam, null);
            holder = new ViewHolder();

            holder.trans_type = (TextView) convertView.findViewById(R.id.transport_type);
            holder.trans_pic = (ImageView) convertView.findViewById(R.id.trans_pic);
            holder.trans_gtr = (TextView) convertView.findViewById(R.id.trans_gert);
            //   holder.hospital_btn  = (Button) convertView.findViewById(R.id.button);
            TransportItem row_pos = rowItems.get(position);

            holder.trans_pic.setBackgroundResource(row_pos.getTrans_pic_id());
            holder.trans_type.setText(row_pos.getTrans_type());
            holder.trans_gtr.setText("");

            /*	holder.hospital_btn.setText("parvez");
			holder.hospital_btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Toast.makeText(context, "parvez btn" ,
							Toast.LENGTH_SHORT).show();

				}
			});*/

            convertView.setTag(holder);
        } else {

            holder = (ViewHolder) convertView.getTag();
        }


        return convertView;
    }

}
