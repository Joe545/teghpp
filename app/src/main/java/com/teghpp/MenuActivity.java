package com.teghpp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class MenuActivity extends AppCompatActivity {

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuLogout:

                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(this, MainActivity.class));

                break;
        }
        return true;
    }
}
