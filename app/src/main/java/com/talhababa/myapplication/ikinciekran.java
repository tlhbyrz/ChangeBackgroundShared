package com.talhababa.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ikinciekran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikinciekran);

        TextView txt = (TextView) findViewById(R.id.textView);
        Bundle veri = getIntent().getExtras();
        CharSequence gelen = veri.getCharSequence("anahtar");


        txt.setText(gelen);
    }
}
