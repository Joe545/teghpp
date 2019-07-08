package com.teghpp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Patientdata extends AppCompatActivity {
    EditText txtName, txtAge, txtTime, txtWt, txtWeek, txtPaEnt, txtPaSal, txtFcEnt, txtFcSal, txtTalla, txtPeso, txtGestas;
    TextView a;
    Button btnsave, btntest;
    DatabaseReference reff, reff1;
    Member member;
    String name;
    int age, agea, weight, week, paent, pasal, fcent, fcsal, talla, peso, gestas;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseUser user = firebaseAuth.getCurrentUser();
    String uId = firebaseAuth.getCurrentUser().getUid();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientdata);

        //a = (TextView) findViewById(R.id.txtGro);
        txtName = (EditText) findViewById(R.id.txtName);
        txtAge = (EditText) findViewById(R.id.txtAge);
        txtWt = (EditText) findViewById(R.id.txtWt);
        txtFcEnt = (EditText) findViewById(R.id.txtFcEnt);
        txtFcSal = (EditText) findViewById(R.id.txtFcSal);
        txtPaEnt = (EditText) findViewById(R.id.txtPaEnt);
        txtPaSal = (EditText) findViewById(R.id.txtPaSal);
        txtPeso = (EditText) findViewById(R.id.txtPeso);
        txtTalla = (EditText) findViewById(R.id.txtTalla);
        txtGestas = (EditText) findViewById(R.id.txtGestas);
        txtWeek = (EditText) findViewById(R.id.txtWeek);
        btnsave = (Button) findViewById(R.id.btnsave);
        // btntest = (Button) findViewById(R.id.btntest);
        member = new Member();
        reff = FirebaseDatabase.getInstance().getReference().child("Member");

        /** btntest.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
        showToast("Button");
        reff1 = FirebaseDatabase.getInstance().getReference().child("Member");
        reff1.addValueEventListener(new ValueEventListener() {
        @Override public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        String group = dataSnapshot.child("group").getValue().toString();
        a.setText(group);
        }

        @Override public void onCancelled(@NonNull DatabaseError databaseError) {
        System.out.println("Fallo en la lectura");

        }
        });


        }
        });*/

        btnsave.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                if (txtName.getText().toString().trim().isEmpty()) {
                    txtName.setError("Ingrese Iniciales del paciente");
                    txtName.requestFocus();
                    return;
                }

                if (txtAge.getText().toString().trim().isEmpty()) {
                    txtAge.setError("Ingrese edad de la paciente");
                    txtAge.requestFocus();
                    return;
                }
                if (txtWt.getText().toString().trim().isEmpty()) {
                    txtWt.setError("Ingrese peso");
                    txtWt.requestFocus();
                    return;
                }
                if (txtFcEnt.getText().toString().trim().isEmpty()) {
                    txtFcEnt.setError("Ingrese FC entrada");
                    txtFcEnt.requestFocus();
                    return;
                }
                if (txtFcSal.getText().toString().trim().isEmpty()) {
                    txtFcSal.setError("Ingrese FC salida");
                    txtFcSal.requestFocus();
                    return;
                }

                if (txtPaEnt.getText().toString().trim().isEmpty()) {
                    txtPaEnt.setError("Ingrese PA entrada");
                    txtPaEnt.requestFocus();
                    return;
                }
                if (txtPaSal.getText().toString().trim().isEmpty()) {
                    txtPaSal.setError("Ingrese PA salida");
                    txtPaSal.requestFocus();
                    return;
                }

                if (txtPeso.getText().toString().trim().isEmpty()) {
                    txtPeso.setError("Ingrese peso del bebe");
                    txtPeso.requestFocus();
                    return;
                }
                if (txtTalla.getText().toString().trim().isEmpty()) {
                    txtTalla.setError("Ingrese talla del bebe");
                    txtTalla.requestFocus();
                    return;
                }

                if (txtGestas.getText().toString().trim().isEmpty()) {
                    txtGestas.setError("Ingrese PA salida");
                    txtGestas.requestFocus();
                    return;
                }
                if (txtWeek.getText().toString().trim().isEmpty()) {
                    txtWeek.setError("Ingrese semanas de embarazo");
                    txtWeek.requestFocus();
                    return;

                }

                weight = Integer.parseInt(txtWt.getText().toString().trim());
                agea = Integer.parseInt(txtAge.getText().toString().trim());
                week = Integer.parseInt(txtWeek.getText().toString().trim());
                name = txtName.getText().toString();
                age = Integer.parseInt(txtAge.getText().toString());
                paent = Integer.parseInt(txtPaEnt.getText().toString().trim());
                pasal = Integer.parseInt(txtPaSal.getText().toString().trim());
                fcent = Integer.parseInt(txtFcEnt.getText().toString().trim());
                fcsal = Integer.parseInt(txtFcSal.getText().toString().trim());
                talla = Integer.parseInt(txtTalla.getText().toString().trim());
                peso = Integer.parseInt(txtPeso.getText().toString().trim());
                gestas = Integer.parseInt(txtGestas.getText().toString().trim());


                member.setEdad(agea);
                member.setPesoMama(weight);
                member.setSemanas(week);
                member.setFcEnt(fcent);
                member.setFcSal(fcsal);
                member.setPaEnt(paent);
                member.setPaSal(pasal);
                member.setPesoBebe(peso);
                member.setTalla(talla);
                member.setGestas(gestas);
                member.setIniciales(txtName.getText().toString().trim());
                reff.push().setValue(member);

                txtName.setText("");
                txtAge.setText("");
                txtWt.setText("");
                txtWeek.setText("");
                txtFcEnt.setText("");
                txtFcSal.setText("");
                txtPaEnt.setText("");
                txtPaSal.setText("");
                txtFcSal.setText("");
                txtPeso.setText("");
                txtTalla.setText("");
                txtGestas.setText("");

                Toast.makeText(Patientdata.this, "información insertada correctamente", Toast.LENGTH_LONG).show();
            }


        });
    }

    private void showToast(String text) {
        Toast.makeText(Patientdata.this, text, Toast.LENGTH_SHORT).show();
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
                startActivity(new Intent(this, Login.class));

                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {

    }


    public void AlertInicio(final View view) {
        AlertDialog.Builder myAlertBuilder = new
                AlertDialog.Builder(Patientdata.this);
        // Set the dialog title.
        myAlertBuilder.setTitle("ALERTA");
        // Set the dialog message.
        myAlertBuilder.setMessage(R.string.alerta_final);

        // Add the buttons.
        myAlertBuilder.setPositiveButton(R.string.si, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // User clicked OK button.

                goToInicio(view);
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
    public void goToInicio(View view) {

        Toast.makeText(this, "Pantalla principal", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}