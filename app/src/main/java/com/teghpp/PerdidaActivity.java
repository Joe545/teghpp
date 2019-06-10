package com.teghpp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class PerdidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perdida);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
// Set the text for each tab.
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label5));

        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label3));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label4));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label6));
// Colocar scroll horinzontal en el tablayout para que se vean todas las opciones
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
// Set the tabs to fill the entire layout.
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
// Use PagerAdapter to manage page views in fragments.

// Each page is represented by its own fragment.
// This is another example of the adapter pattern.
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
// Setting a listener for clicks.

        // Setting a listener for clicks.
        viewPager.addOnPageChangeListener(new
                TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    public class PagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FragmentGrado();
                case 1:
                    return new FragmentPerdida();
                case 2:
                    return new FragmentSensorio();
                case 3:
                    return new FragmentPerfusion();
                case 4:
                    return new FragmentPulso();
                case 5:
                    return new FragmentPresion();
                default:
                    return null;
            }
        }


        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }

    public void launchCasoRojo(View view) {
        Toast.makeText(this, "Entro en Codigo Rojo", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Hora.class);
        startActivity(intent);
    }
//muestra alerta para entrar en codigo rojo
    public void onClickShowAlert(final View view) {
        AlertDialog.Builder myAlertBuilder = new
                AlertDialog.Builder(PerdidaActivity.this);
        // Set the dialog title.
        myAlertBuilder.setTitle("ALERTA");
// Set the dialog message.
        myAlertBuilder.setMessage("Esta por entrar en CODIGO ROJO. Los datos suministrados son validos:");

        // Add the buttons.
        myAlertBuilder.setPositiveButton(R.string.si, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // User clicked OK button.
                Toast.makeText(getApplicationContext(), R.string.pressed_ok,
                        Toast.LENGTH_SHORT).show();
                launchCasoRojo(view);

            }
        });

        myAlertBuilder.setNegativeButton(R.string.Cancel, new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User cancelled the dialog.
                        Toast.makeText(getApplicationContext(), R.string.pressed_cancel,
                                Toast.LENGTH_SHORT).show();
                    }
                });

        // Create and show the AlertDialog.
        myAlertBuilder.show();
    }
    //muestra alerta avisando el grado compensado
    public void onClickShowAviso(final View view) {
        AlertDialog.Builder myAlertBuilder = new
                AlertDialog.Builder(PerdidaActivity.this);
        // Set the dialog title.
        myAlertBuilder.setTitle(R.string.grado_compensado);
// Set the dialog message.
        myAlertBuilder.setMessage(R.string.recomendacion_compensado);



        // Add the buttons.
        myAlertBuilder.setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // User clicked OK button.
                Toast.makeText(getApplicationContext(), R.string.pressed_ok,
                        Toast.LENGTH_SHORT).show();

                }
        });

        myAlertBuilder.setNegativeButton(R.string.Cancel, new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User cancelled the dialog.
                        Toast.makeText(getApplicationContext(), R.string.pressed_cancel,
                                Toast.LENGTH_SHORT).show();
                    }
                });

        // Create and show the AlertDialog.
        myAlertBuilder.show();   }




    public void onClickShowAviso2(final View view) {
        AlertDialog.Builder myAlertBuilder = new
                AlertDialog.Builder(PerdidaActivity.this);
        // Set the dialog title.
        myAlertBuilder.setTitle(R.string.grado_moderado);
// Set the dialog message.
        myAlertBuilder.setMessage(R.string.recomendacion_compensado);



        // Add the buttons.
        myAlertBuilder.setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // User clicked OK button.
                Toast.makeText(getApplicationContext(), R.string.pressed_ok,
                        Toast.LENGTH_SHORT).show();

            }
        });

        myAlertBuilder.setNegativeButton(R.string.Cancel, new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User cancelled the dialog.
                        Toast.makeText(getApplicationContext(), R.string.pressed_cancel,
                                Toast.LENGTH_SHORT).show();
                    }
                });

        // Create and show the AlertDialog.
        myAlertBuilder.show();   }


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
