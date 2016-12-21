package com.example.bavly.todolistnew;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by bavly on 11/29/2016.
 */
public class mytasks extends Fragment implements View.OnClickListener {
View view;
    public Button Add ;
    public EditText tasks ,date,title;
   private DatabaseReference databaseReference;
   private FirebaseAuth firebaseAuth;
    int i =0;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.mytasks, container, false);
        Add = (Button)  rootView.findViewById(R.id.buttonAdd);
         tasks = (EditText) rootView.findViewById(R.id.TasksLayout) ;
        date = (EditText) rootView.findViewById(R.id.editdate);
        title = (EditText) rootView.findViewById(R.id.edittitle) ;
        firebaseAuth = FirebaseAuth.getInstance();


        databaseReference = FirebaseDatabase .getInstance().getReference();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        Add.setOnClickListener(this);


        return rootView;

    }

    private  void  getuserinfo(){

        String  Date = date.getText().toString().trim();
        String  Title = title.getText().toString().trim();
        String  Tasks = tasks.getText().toString().trim();
        userinfo info = new userinfo(Date,Title,Tasks);
        FirebaseUser user = firebaseAuth.getCurrentUser();
        databaseReference.child(user.getUid()).child("task"+i++).setValue(info);
        Toast.makeText(getContext(), "yor task is saved", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View view) {
        getuserinfo();
    }
}

