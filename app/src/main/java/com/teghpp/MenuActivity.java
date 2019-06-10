package com.teghpp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;



public class MenuActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private static final String LOG_TAG = MenuActivity.class.getSimpleName() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void launchPerdidaActivity(View view) {
        Toast.makeText(this, "entre en Perdida", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent (this, PerdidaActivity.class);
        startActivity (intent);


            }


}
