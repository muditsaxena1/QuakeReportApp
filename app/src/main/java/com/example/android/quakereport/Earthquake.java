package com.example.android.quakereport;

import android.location.Location;

/**
 * Created by Mudit on 01-09-2017.
 */

public class Earthquake {
    private Double mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;
    private String mURL;


    public Earthquake(Double Magnitude,String Location, long timeInMilliseconds,String URL){
        mMagnitude = Magnitude;
        mLocation=Location;
        mTimeInMilliseconds = timeInMilliseconds;
        mURL = URL;

    }
    public Double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation(){
        return mLocation;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public String getURL() {
        return mURL;
    }
}
