package edu.wit.mobileapp.wellness_app.ui.notifications;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.wit.mobileapp.wellness_app.R;

public class ListItemAdapter extends ArrayAdapter<time_schedule.ListItem>{
    private LayoutInflater mInflater;
    public ListItemAdapter(Context context, int resource, List<time_schedule.ListItem> list) {
        super(context, resource, list);
        mInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    public View getView(int resource, View contentView, ViewGroup parent){
        // Retrieve data
        time_schedule.ListItem item = (time_schedule.ListItem) getItem(resource);

        View view = mInflater.inflate(R.layout.activity_time_schedule,null);

        // Set counselor name
        TextView name;
        name =(TextView) view.findViewById(R.id.conselour_name);
        name.setText(item.counselor_name);

        return view;
    }
}
