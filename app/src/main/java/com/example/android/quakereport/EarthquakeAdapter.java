package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.android.quakereport.R.id.magnitude;

/**
 * Created by Mudit on 01-09-2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes){
        super(context,0,earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item,parent,false);
        }
        Earthquake currentEarthquake = getItem(position);

        TextView magnitudeView = (TextView)listItemView.findViewById(magnitude);
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = ContextCompat.getColor(getContext(), getMagnitudeColor(currentEarthquake.getMagnitude()));

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        DecimalFormat formatter = new DecimalFormat("#0.0");
        String mag = formatter.format(currentEarthquake.getMagnitude());
        magnitudeView.setText(mag);

        String location = currentEarthquake.getLocation();
        String offsetLocation,primaryLocation;
        if(location.contains("of")){
            int index = location.indexOf("of");
            offsetLocation = location.substring(0,index+2);
            primaryLocation = location.substring(index+3);
        }
        else{
            offsetLocation = "Near the";
            primaryLocation = location;
        }
        TextView primaryLocationView = (TextView)listItemView.findViewById(R.id.primary_location);
        primaryLocationView.setText(primaryLocation);

        TextView offsetLocationView = (TextView)listItemView.findViewById(R.id.location_offset);
        offsetLocationView.setText(offsetLocation);

        long timeInMilliseconds = currentEarthquake.getTimeInMilliseconds();
        Date dateObject = new Date(timeInMilliseconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM DD,yyyy");
        String dateToDisplay = dateFormat.format(dateObject);
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        String timeToDisplay = timeFormat.format(dateObject);

        TextView dateView = (TextView)listItemView.findViewById(R.id.date);
        dateView.setText(dateToDisplay);

        TextView timeView = (TextView)listItemView.findViewById(R.id.time);
        timeView.setText(timeToDisplay);

        return listItemView;
    }

    private int getMagnitudeColor(double mag){
        if(mag<2){
            return R.color.magnitude1;
        }
        else if(mag<3){
            return R.color.magnitude2;
        }
        else if(mag<4){
            return R.color.magnitude3;
        }
        else if(mag<5){
            return R.color.magnitude4;
        }
        else if(mag<6){
            return R.color.magnitude5;
        }
        else if(mag<7){
            return R.color.magnitude6;
        }
        else if(mag<8){
            return R.color.magnitude7;
        }
        else if(mag<9){
            return R.color.magnitude8;
        }
        else if(mag<10){
            return R.color.magnitude9;
        }
        else{
            return R.color.magnitude10plus;
        }
    }
}
