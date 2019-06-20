package com.teghpp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        listDataHeader.add("PIDA AYUDA:");
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
        //0
        List<String> ayuda = new ArrayList<>();
        ayuda.add("Grado de choque SEVERO: se entro en codigo Rojo");
        ayuda.add("Asigne Roles");
        //1
        List<String> conciencia = new ArrayList<>();
        conciencia.add("texto de informacion para este caso");
        //2
        List<String> oxigeno = new ArrayList<>();
        oxigeno.add("texto de informacion para este caso");
        //3
        List<String> masaje = new ArrayList<>();
        masaje.add("Grado de choque SEVERO: se entro en codigo Rojo");
        masaje.add("Asigne Roles");

        //4
        List<String> via1 = new ArrayList<String>();
        via1.add("Administracion de soluciones. (500 cc sol 0.9% / Ringer Lactato - evaluar-)");
        //5
        List<String> via2 = new ArrayList<String>();
        via2.add("Transfundir dos Uds CG o (Rh-) o isogrupo");
        via2.add("Hemoglobina");
        via2.add("Hematocrito");
        via2.add("Tiempo de coagulacion");
        via2.add("Tipiaje");
        //6
        List<String> tratamiento = new ArrayList<String>();
        tratamiento.add("Oxitocina: 20 UI en 500 cc Sol 0.9% a 20 gts/min (Macrogotero)");
        tratamiento.add("Metilergonovina: 0.2% mg IM x 2 dosis (cada 20 min). Maximo cinco dosis en 24 horas");
        tratamiento.add("Misoprosol: 800 mcg VO / SL / VR");
        tratamiento.add("Acido Tranexamico: 1 gr VEV stat");
        //7
        List<String> indice = new ArrayList<String>();
        indice.add(" ( FC/PAS  > 1)");
        //8
        List<String> evalue = new ArrayList<String>();
        evalue.add("texto de informacion para este caso");
        evalue.add("TONO: 70%: Masaje uterino y farmacos.");
        evalue.add("TRAUMA: 20%: Sutura de desgarros.");
        evalue.add("TEJIDO: 9%: Remocion de restos.");
        evalue.add("TROMBINA: 1%: PFC y/o crioprecipitado");
        //9
        List<String> diuresis = new ArrayList<String>();
        diuresis.add("texto de informacion para este caso");


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


