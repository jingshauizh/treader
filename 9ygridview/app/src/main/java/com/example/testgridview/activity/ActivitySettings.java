package com.example.testgridview.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.util.Log;
import com.example.testgridview.R;

/**
 * Created by jings on 2019/4/29.
 */

public class ActivitySettings extends PreferenceActivity {
    public static final String BOSS_1_SP_TIME_DISTANCE = "list_preference_boss1";
    public static final String BOSS_2_SP_TIME_DISTANCE = "list_preference_boss2";
    public static final String BOSS_3_SP_TIME_DISTANCE = "list_preference_boss3";
    public static final String BOSS_4_SP_TIME_DISTANCE = "list_preference_boss4";
    public static final String BOSS_5_SP_TIME_DISTANCE = "list_preference_boss5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);



    }



}
