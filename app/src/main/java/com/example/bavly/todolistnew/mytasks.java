package com.example.bavly.todolistnew;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

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
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.mytasks, container, false);
        Add = (Button)  rootView.findViewById(R.id.buttonAdd);
         tasks = (EditText) rootView.findViewById(R.id.TasksLayout) ;
        date = (EditText) rootView.findViewById(R.id.editdate);
        title = (EditText) rootView.findViewById(R.id.edittitle) ;
        firebaseAuth = FirebaseAuth.getInstance();
     /*   if (firebaseAuth.getCurrentUser() == null){
        }*/
        databaseReference = FirebaseDatabase .getInstance().getReference();
        Add.setOnClickListener(this);


        return rootView;

    }

    public  void  getuserinfo(){

        String  Date = date.getText().toString().trim();
        String  Title = title.getText().toString().trim();
        String  Tasks = tasks.getText().toString().trim();
        userinfo info = new userinfo(Date,Title,Tasks);
        FirebaseUser user = firebaseAuth.getCurrentUser();
        databaseReference.child(user.getUid()).setValue(info);

    }

    @Override
    public void onClick(View view) {
        getuserinfo();
    }
}

