package com.talhababa.myapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;

/**
 * Created by talha on 25.10.2017.
 */

public class Ayarlar extends PreferenceActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.ayarlar);

    }
}
