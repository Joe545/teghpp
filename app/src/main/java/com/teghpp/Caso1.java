package com.teghpp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Caso1 extends Fragment {

    ExpListViewAdapterWithCheckbox listAdapter;
    ExpandableListView expListView;
    ArrayList<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    Chronometer crono;
    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_caso1, container, false);


    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        // get the listview
        expListView = (ExpandableListView) getView().findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpListViewAdapterWithCheckbox(getContext(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {

                return false;
            }
        });

        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {

                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getActivity().getApplicationContext(), String.valueOf(groupPosition), Toast.LENGTH_SHORT).show();

            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {


            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                return false;
            }
        });


    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Grado de choque SEVERO: se entro en codigo Rojo");
        listDataHeader.add("Verifique estado de conciencia");
        listDataHeader.add("Administre Oxigeno");
        listDataHeader.add("Masaje uterino permanente");
        listDataHeader.add("Via endovenonsa #1");
        listDataHeader.add("Via endovenonsa #2: LABORATORIO");
        listDataHeader.add("TRATAMIENTO FARMACOLOGICO");
        listDataHeader.add("VALORAR INDICE DE CHOQUE");
        listDataHeader.add("Evalue las 4T");
        listDataHeader.add("Cuantificar diuresis y temperatura corporal ");
        // Adding child data
        //0- Grado de Choque severo
        List<String> ayuda = new ArrayList<>();
        ayuda.add(getString(R.string.lista0_1));
        ayuda.add(getString(R.string.lista0_2));
        ayuda.add(getString(R.string.lista0_3));
        ayuda.add(getString(R.string.lista0_4));
        ayuda.add(getString(R.string.lista0_5));


        //1- Verifique estado de conciencia
        List<String> conciencia = new ArrayList<>();
        conciencia.add(getString(R.string.lista1_1));
        conciencia.add(getString(R.string.lista1_2));
        conciencia.add(getString(R.string.lista1_3));

        //2- Administre Oxigeno
        List<String> oxigeno = new ArrayList<>();
        oxigeno.add(getString(R.string.list2_1));
        oxigeno.add(getString(R.string.list2_2));
        oxigeno.add(getString(R.string.list2_3));

        //3- Masaje Utrino permanente
        List<String> masaje = new ArrayList<>();

        //4- Via endovenosa 1
        List<String> via1 = new ArrayList<String>();
        via1.add(getString(R.string.lista4_1));
        via1.add(getString(R.string.lista4_2));

        //5- Via endovenosa 2
        List<String> via2 = new ArrayList<String>();
        via2.add(getString(R.string.lista5_1));
        via2.add(getString(R.string.lista5_2));
        via2.add(getString(R.string.lista5_3));
        //via2.add("Hemoglobina");
        //via2.add("Hematocrito");
        //via2.add("Tiempo de coagulacion");
        //via2.add("Tipiaje");

        //6- tratamiento farmacologico
        List<String> tratamiento = new ArrayList<String>();
        tratamiento.add(getString(R.string.lista6_1));
        tratamiento.add(getString(R.string.lista6_2));
        tratamiento.add(getString(R.string.lista6_3));
        tratamiento.add(getString(R.string.lista6_4));

        //7- Valorar indice de choque
        List<String> indice = new ArrayList<String>();
        indice.add(" ( FC/PAS  > 1)");

        //8- evalue las 4 T
        List<String> evalue = new ArrayList<String>();
        evalue.add(getString(R.string.lista8_1));
        evalue.add(getString(R.string.lista8_2));
        evalue.add(getString(R.string.lista8_3));
        evalue.add(getString(R.string.lista8_4));


        //9- cuantificar diuresis
        List<String> diuresis = new ArrayList<String>();
        //diuresis.add("texto de informacion para este caso");


        listDataChild.put(listDataHeader.get(0), ayuda); // Header, Child data
        listDataChild.put(listDataHeader.get(1), conciencia);
        listDataChild.put(listDataHeader.get(2), oxigeno);
        listDataChild.put(listDataHeader.get(3), masaje); // Header, Child data
        listDataChild.put(listDataHeader.get(4), via1);
        listDataChild.put(listDataHeader.get(5), via2);
        listDataChild.put(listDataHeader.get(6), tratamiento); // Header, Child data
        listDataChild.put(listDataHeader.get(7), indice);
        listDataChild.put(listDataHeader.get(8), evalue);
        listDataChild.put(listDataHeader.get(9), diuresis); // Header, Child data


    }


}


