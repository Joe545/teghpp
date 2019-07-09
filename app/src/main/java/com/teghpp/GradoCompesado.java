package com.teghpp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class GradoCompesado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grado_compesado);
    }

    public void returnCaso(View view) {

        Intent intent = new Intent(this, PerdidaActivity.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {

        Toast.makeText(this, "Use los botones de la Aplicacion", Toast.LENGTH_SHORT).show();

    }
}
