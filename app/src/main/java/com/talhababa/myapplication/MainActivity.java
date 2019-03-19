package com.talhababa.myapplication;

        import android.Manifest;
        import android.app.Dialog;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.content.pm.PackageManager;
        import android.graphics.Color;
        import android.net.Uri;
        import android.os.Build;
        import android.preference.PreferenceManager;
        import android.support.annotation.RequiresApi;
        import android.support.v4.app.ActivityCompat;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.view.ActionMode;
        import android.text.TextUtils;
        import android.view.ContextMenu;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Adapter;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.AutoCompleteTextView;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.DatePicker;
        import android.widget.EditText;
        import android.widget.ImageButton;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.ListView;
        import android.widget.MultiAutoCompleteTextView;
        import android.widget.RelativeLayout;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.List;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {


    Button btn, btn2, btn3, btn4;
    RelativeLayout arkaplan;
    LinearLayout ly;
    EditText edt1,edt2,edt3;
    ImageView imw;
    ListView lv;
    TextView tv;
    private ActionMode actionMode;
    int sayi=0;
    SharedPreferences preferences,ayarlar ;

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("anahtar",sayi);
        editor.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar ac = getSupportActionBar();

        ac.setTitle("Baslik");
        ac.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar));

        arkaplan= (RelativeLayout) findViewById(R.id.rl);

        //edt1= (EditText) findViewById(R.id.editText2);
        //btn= (Button) findViewById(R.id.button2);
        //String email = edt1.getText().toString();
        // Intent intent=new Intent(Intent.ACTION_SEND);

        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        ayarlar = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        ayarlariyukle();

        sayi = preferences.getInt("anahter",0);

        btn= (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayi++;
                btn.setText(""+sayi);
            }
        });




    }

    private void ayarlariyukle() {
        String pos = ayarlar.getString("arkaplan","1");
        switch (Integer.valueOf(pos)){
            case 0:
                arkaplan.setBackgroundColor(Color.RED);
                break;
            case 1:
                arkaplan.setBackgroundColor(Color.BLUE);
                break;
            case 2:
                arkaplan.setBackgroundColor(Color.BLACK);
                break;
            case 3:
                arkaplan.setBackgroundColor(Color.GREEN);
                break;
        }
        ayarlar.registerOnSharedPreferenceChangeListener(MainActivity.this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    //    return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.act1)
        {
            Intent intent = new Intent(getApplicationContext(),Ayarlar.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"Ayarlar",Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.act2)
        {
            Toast.makeText(getApplicationContext(),"Paylas",Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.act3)
        {
            Toast.makeText(getApplicationContext(),"Sil",Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        ayarlariyukle();
    }
}



/*public void dokunuldu(View v) {

        switch (v.getId())
        {
            case R.id.button2:
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Uyari !!");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setMessage("silmek istedigine emin misin ? ");
                builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Hayir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }) ;
                builder.setCancelable(false);
                builder.create().show();

        }

    }
*/