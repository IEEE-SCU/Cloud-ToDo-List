package com.example.bavly.todolistnew;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by bavly on 11/29/2016.
 */
public class mytasks extends Fragment {
View view;
    public Button Add ;
    public EditText Tasks ;
public static String TaskText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.mytasks, container, false);
Add = (Button)  rootView.findViewById(R.id.buttonAdd);
   Tasks = (EditText) rootView.findViewById(R.id.TasksLayout) ;
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TaskText = Tasks.getText().toString();

addtasks.viewTasks.setText(TaskText);
                Toast.makeText(getActivity(), "Button is Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;

    }
}

