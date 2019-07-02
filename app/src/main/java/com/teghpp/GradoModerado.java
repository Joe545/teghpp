package com.teghpp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class GradoModerado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grado_moderado);
    }

    public void returnCaso1(View view) {
        Toast.makeText(this, "Entro en Código rojo", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, PerdidaActivity.class);
        startActivity(intent);
    }
}
