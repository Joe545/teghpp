package com.teghpp;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;




/**
 * A simple {@link Fragment} subclass.
 */
public class Caso1 extends Fragment {
    ListView listView;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_caso1, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        listView = (ListView) getView().findViewById(R.id.listview);




            ArrayList<String> arrayList=new ArrayList<>();

            arrayList.add("1.   Mida el grado de choque");
            arrayList.add("2.   Establezca Grado de Choque");
            arrayList.add("3.   Asigne Roles de Trabajo");
            arrayList.add("4.   Verifique estado de conciencia");
            arrayList.add("5.   Administre Oxigeno");
            arrayList.add("6.   Masaje uterino permanente");
            arrayList.add("7.   Via endovenosa #1");
            arrayList.add("8.   Via endovenosa #2");
            arrayList.add("9.   TRATAMIENTO FARMACOLOGICO");
            arrayList.add("10.  VALORAR INDICE DE CHOQUE");
            arrayList.add("11.  EVALUE LAS 4 T");
            arrayList.add("12.  Cuantificar diuresis y temperatura");


            ArrayAdapter arrayAdapter;

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);



        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity().getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();

            }
        });
    }


}