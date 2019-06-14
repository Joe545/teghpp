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
public class Caso2 extends Fragment {
    ListView listView;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_caso2, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        listView = (ListView) getView().findViewById(R.id.listview1);


        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("1.   TANN");
        arrayList.add("2.   Taponamiento uterino");
        arrayList.add("2.1.   Balon de Bakri");
        arrayList.add("2.2   Balon Artesanal");
        arrayList.add("3.   Sutura hemostatica de B-Lynch");


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
