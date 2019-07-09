package com.teghpp;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class Hora extends AppCompatActivity {
    FirebaseAuth mAuth;

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;

    /**
     * public abstract class CountDownTimer extends Object{
     * public CountDownTimer(long millisInFuture, long countDownInterval) {
     * }
     * <p>
     * public final CountDownTimer start() {
     * return android.os.CountDownTimer
     * }
     * }
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hora);

        final Chronometer chronometer = (Chronometer) findViewById(R.id.chronometerExample);
        chronometer.start();

        // Create an instance of the tab layout from the view.
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        // Set the text for each tab.
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label01));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label02));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label03));
        // Set the tabs to fill the entire layout.
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
// Use PagerAdapter to manage page views in fragments.


        // Using PagerAdapter to manage page views in fragments.
// Each page is represented by its own fragment.
// This is another example of the adapter pattern.
        final ViewPager viewPager = findViewById(R.id.viewpager);
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

    public void startChrono(View view) {


        String messageToSend = "Emergencia, entro en Codigo Rojo, acudir inmediatamente a la sala de urgencia.";
        String number = "4241678931";

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);
        } else {

            SmsManager.getDefault().sendTextMessage(number, null, messageToSend, null, null);
            Toast.makeText(this, "Se envio el mesaje", Toast.LENGTH_SHORT).show();

        }
    }
    //SmsManager.getDefault().sendTextMessage(number, null, messageToSend, null, null);
    // Toast.makeText(this, "Se envio el mesaje", Toast.LENGTH_SHORT).show();





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
                    return new Caso1();
                case 1:
                    return new Caso2();
                case 2:
                    return new Caso3();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }


    }


    public void finalAlert(final View view) {
        AlertDialog.Builder myAlertBuilder = new
                AlertDialog.Builder(Hora.this);
        // Set the dialog title.
        myAlertBuilder.setTitle("ALERTA");
        // Set the dialog message.
        myAlertBuilder.setMessage("Está por finalizar el caso y se procedera a llenar la Historia Perinatológica. ¿Esta seguro de finalizar?");

        // Add the buttons.
        myAlertBuilder.setPositiveButton(R.string.si, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // User clicked OK button.
                final Chronometer chronometer = (Chronometer) findViewById(R.id.chronometerExample);
                chronometer.stop();
                launchPatient(view);
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


    public void launchPatient(View view) {
        //final Chronometer chronometer = (Chronometer) findViewById(R.id.chronometerExample);
        // chronometer.setBase(SystemClock.elapsedRealtime());


        Toast.makeText(this, "Finalizo el caso", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, Patientdata.class));


    }


    @Override
    public void onBackPressed() {

    }


}