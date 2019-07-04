package com.teghpp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class MenuActivity extends AppCompatActivity {

    private static final String LOG_TAG = MenuActivity.class.getSimpleName() ;
    private ViewPager viewPager;
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


    /**
     * public void launchPerdidaActivity(View view) {
     * switch (view.getId()) {
     * case R.id.sensorio:
     * viewPager.setCurrentItem(getItem(+0), true);
     * <p>
     * startActivity(new Intent(this, PerdidaActivity.class));
     * break;
     * <p>
     * case R.id.perfusion:
     * viewPager.setCurrentItem(getItem(+1), true);
     * <p>
     * startActivity(new Intent(this, PerdidaActivity.class));
     * <p>
     * break;
     * <p>
     * case R.id.pulso:
     * viewPager.setCurrentItem(getItem(+2), true);
     * <p>
     * startActivity(new Intent(this, PerdidaActivity.class));
     * break;
     * <p>
     * case R.id.presion:
     * viewPager.setCurrentItem(getItem(+3), true);
     * <p>
     * startActivity(new Intent(this, PerdidaActivity.class));
     * break;
     * }
     * }
     */


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

    private static final int INTERVALO = 2000; //2 segundos para salir
    private long tiempoPrimerClick;

    @Override
    public void onBackPressed() {
        if (tiempoPrimerClick + INTERVALO > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(this, "Vuelve a presionar para salir", Toast.LENGTH_SHORT).show();
        }
        tiempoPrimerClick = System.currentTimeMillis();
    }
}
