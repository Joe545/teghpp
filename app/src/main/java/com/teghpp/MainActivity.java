package com.teghpp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private EditText EditText3;
    private EditText EditText4;
    private Button button2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");
        // Initialize all the view variables.
        EditText3 = (EditText) findViewById(R.id.editText3);
        EditText4 = (EditText) findViewById(R.id.editText4);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);

        // Restore the saved state. See onSaveInstanceState() for what gets saved.
        if (savedInstanceState != null) {
            boolean isVisible =
                    savedInstanceState.getBoolean("reply_visible");
            // Show both the header and the message views. If isVisible is
            // false or missing from the bundle, use the default layout.
            if (isVisible) {

                EditText3.setVisibility(View.VISIBLE);

                EditText4.setText(savedInstanceState.getString("reply_text"));
                button.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
            }
        }
    }


    /**
     * Called when the user taps the Send button
     */


    public void launchRegistroActivity(View view) {
        Toast.makeText(this, "Registrar Usuario", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }

    public void launchMenuActivity(View view) {
        Toast.makeText(this, "Entro al Menu Principal", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }





}






