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
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class PerdidaActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    int count = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perdida);


        viewPager = (ViewPager) findViewById(R.id.pager);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
// Set the text for each tab.

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.brain));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.nail));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.pulse));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.pressure));



// Colocar scroll horinzontal en el tablayout para que se vean todas las opciones
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
// Set the tabs to fill the entire layout.
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //cambiar color en tablayout
        tabLayout.setTabIconTintResource(R.color.blanco);
        //cambiar el tamano de los iconos
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
                    return new FragmentSensorio();
                case 1:
                    return new FragmentPerfusion();
                case 2:
                    return new FragmentPulso();
                case 3:
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
        Toast.makeText(this, "Entro en Código rojo", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Hora.class);
        startActivity(intent);


        /**  String messageToSend = getString(R.string.primer_mensaje);
        String number = "4241678931";
         String number1 = "4241959187"; //Pirrone
         String number2 = "4123197467";//Djumovic
         String number3 = "4141070767";
        SmsManager.getDefault().sendTextMessage(number, null, messageToSend, null, null);
         Toast.makeText(this, "Se envio el mesaje", Toast.LENGTH_SHORT).show();

         SmsManager.getDefault().sendTextMessage(number1, null, messageToSend, null, null);
         Toast.makeText(this, "Se envio el mesaje", Toast.LENGTH_SHORT).show();

         SmsManager.getDefault().sendTextMessage(number2, null, messageToSend, null, null);
         Toast.makeText(this, "Se envio el mesaje", Toast.LENGTH_SHORT).show();

         SmsManager.getDefault().sendTextMessage(number3, null, messageToSend, null, null);
         Toast.makeText(this, "Se envio el mesaje", Toast.LENGTH_SHORT).show();*/
    }

    //muestra alerta para entrar en codigo rojo
    public void onClickShowAlert(final View view) {
        AlertDialog.Builder myAlertBuilder = new
                AlertDialog.Builder(PerdidaActivity.this);
        // Set the dialog title.
        myAlertBuilder.setTitle("ALERTA");
// Set the dialog message.
        myAlertBuilder.setMessage("Está por entrar en CÓDIGO ROJO. ¿Los datos suministrados son válidos?");

        // Add the buttons.
        myAlertBuilder.setPositiveButton(R.string.si, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // User clicked OK button.
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


    //menu de logout para la activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }



    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }


    //menu de logout para la activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuLogout:

                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(this, MainActivity.class));

                break;
        }
        return true;
    }


    public void nextFragment(View view) {
        switch (view.getId()) {
            case R.id.btAmarillo1:
                viewPager.setCurrentItem(getItem(+1), true);
                count = count + 100;
                count++;
                break;

            case R.id.btAmarillo2:
                viewPager.setCurrentItem(getItem(+1), true);
                count = count + 100;
                count++;
                break;

            case R.id.btAmarillo3:
                viewPager.setCurrentItem(getItem(+1), true);
                count = count + 100;
                count++;
                break;

            case R.id.btAmarillo4:
                count = count + 100;
                startActivity(new Intent(this, GradoModerado.class));


                //viewPager.setCurrentItem(getItem(-3), true);
                break;

            case R.id.btVerde1:
                viewPager.setCurrentItem(getItem(+1), true);
                count = count + 1;
                count++;
                break;

            case R.id.btVerde2:
                viewPager.setCurrentItem(getItem(+1), true);
                count = count++;
                break;

            case R.id.btVerde3:
                viewPager.setCurrentItem(getItem(+1), true);
                count = count + 1;
                count++;
                break;

            case R.id.btVerde4:
                count = count + 1;
                if (count < 100) {

                    startActivity(new Intent(this, GradoCompesado.class));
                } else {
                    startActivity(new Intent(this, GradoModerado.class));

                }
                //viewPager.setCurrentItem(getItem(-3), true);
                break;
        }
    }

    public void checkSMSStatePermission() {
        int permissionCheck = ContextCompat.checkSelfPermission(
                this, Manifest.permission.SEND_SMS);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.i("Mensaje", "No se tiene permiso para enviar SMS.");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 225);
        } else {
            Log.i("Mensaje", "Se tiene permiso para enviar SMS!");
        }
    }


}