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


public class Caso2 extends Fragment {

    ExpListViewAdapterWithCheckbox listAdapter;
    ExpandableListView expListView;
    ArrayList<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_caso2, container, false);
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
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getActivity().getApplicationContext(), String.valueOf(groupPosition), Toast.LENGTH_SHORT).show();
                /** Toast.makeText(getApplicationContext(),
                 listDataHeader.get(groupPosition) + " Expanded",
                 Toast.LENGTH_SHORT).show();*/
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                /**Toast.makeText(getApplicationContext(),
                 listDataHeader.get(groupPosition) + " Collapsed",
                 Toast.LENGTH_SHORT).show();*/

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                /** Toast.makeText(
                 getApplicationContext(),
                 listDataHeader.get(groupPosition)
                 + " : "
                 + listDataChild.get(
                 listDataHeader.get(groupPosition)).get(
                 childPosition), Toast.LENGTH_SHORT)
                 .show();*/
                return false;
            }
        });


    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("TANN");
        listDataHeader.add("Taponamiento uterino:");
        listDataHeader.add("Sutura hemostatctica de B-Lynch");


        // Adding child data
        List<String> taponamiento = new ArrayList<String>();
        taponamiento.add("Balon de Bakri");
        taponamiento.add("Balon de artesanal ");

        List<String> tann = new ArrayList<String>();
        tann.add("texto de informacion para este caso");

        List<String> sutura = new ArrayList<String>();
        sutura.add("texto de informacion para este caso");


        listDataChild.put(listDataHeader.get(0), tann); // Header, Child data
        listDataChild.put(listDataHeader.get(1), taponamiento);
        listDataChild.put(listDataHeader.get(2), sutura);

    }
}


