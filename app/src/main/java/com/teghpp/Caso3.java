package com.teghpp;


import android.content.Context;
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
public class Caso3 extends Fragment {
    ListView listView;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_caso3, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        listView = (ListView) getView().findViewById(R.id.listview2);


        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("1. Histerectomia obstetica");
        arrayList.add("2.   Cirugia de control de daño");


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
