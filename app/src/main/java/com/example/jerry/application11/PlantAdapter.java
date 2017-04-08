package com.example.jerry.application11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;

/**
 * Created by jerry on 16/4/7.
 */
public class PlantAdapter extends ArrayAdapter<Plant> {

    private int resourceId;
    public PlantAdapter(Context context , int textViewResourceId, List<Plant> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Plant plant = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.plantName = (TextView) view.findViewById(R.id.name);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.plantName.setText(plant.getName());
        return view;
    }

    class ViewHolder{
        TextView plantName;
    }
}
