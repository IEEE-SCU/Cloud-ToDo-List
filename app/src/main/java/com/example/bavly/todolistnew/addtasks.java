package com.example.bavly.todolistnew;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bavly on 11/29/2016.
 */
public class addtasks  extends Fragment {
    public static TextView viewTasks ;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.addtasks, container, false);
        recyclerView =(RecyclerView) rootView.findViewById(R.id.drawerlist);
        adapter = new RecyclerViewAdapter(getActivity(),getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;

    }

    public static List<information> getData(){

        List<information>data =new ArrayList<>();
        String[] Titles = {"Do homeworks" , "Play" , "WatchTV" , "CODING" , "STUDY"};
        String[] Tasks = {"DoSCBSDHCBSHBDC" , "SDCBHSDKHUENKJCKNCK" , "SLHNCSDHBVFBVSKJD" , "SDJBSDSHBDHUSBDCHDSC" , "SJJDNSUDCHSUDCBSBCS"};
        String[] date = {"2016/11/2" , "2016/11/2" , "2016/11/2" , "2016/11/2" , "2016/11/2"};

        for (int i=0 ; i<Titles.length && i< Tasks.length && i<date.length;i++){

            information current = new information();
            current.Title =Titles[i];
            current.Task =Tasks[i];
            current.DATE =date[i];
            data.add(current);

        }
        return data;

    }
}

