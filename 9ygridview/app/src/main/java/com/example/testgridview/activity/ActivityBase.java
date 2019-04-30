package com.example.testgridview.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by jings on 2019/4/29.
 */

public class ActivityBase extends Activity {
    private static final String LOG_TAG = "ActivityBase";
    protected int spActionDistance = 10000;

    public void initTimeDistanceFromSP(Context pcontext, String spName){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(pcontext);
        String listpref = sp.getString(spName, "10000");
        Log.v(LOG_TAG,"BOSS_1_SP_TIME_DISTANCE ="+listpref);
        if(!TextUtils.isEmpty(listpref)){
            try {
                spActionDistance = Integer.valueOf(listpref);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
