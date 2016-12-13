package com.example.bavly.todolistnew;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by bavly on 12/1/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.viewholder> {
    private LayoutInflater inflater;
    List<information> data = Collections.emptyList();


    public RecyclerViewAdapter(Context context , List<information> data ){

        inflater =LayoutInflater.from(context);
        this.data = data;


    }
    @Override
    public viewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.row_layout , parent ,false);
        viewholder holder = new viewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(viewholder holder, int position) {

        information current = data.get(position);

        holder.title.setText(current.Title);
        holder.task.setText(current.Task);
        holder.date.setText(current.DATE);



    }
    public void delete(int position){

        data.remove(position);
        notifyItemRemoved(position);
    }
    public void addItem(String country) {

    }

    @Override
    public int getItemCount() {


        return data.size();
    }


    class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView date;
        TextView title;
        TextView task;
        public viewholder(View itemView) {

            super(itemView);
            date = (TextView)itemView.findViewById(R.id.Tdate);
            title = (TextView)itemView.findViewById(R.id.Ttitle);
            task = (TextView)itemView.findViewById(R.id.Ttask);
            title.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
                delete(getPosition());
        }
    }
}
