package com.example.newproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MyUadapter extends FirebaseRecyclerAdapter<model, MyUadapter.myviewholder> {
    public MyUadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull MyUadapter.myviewholder holder, int position, model model) {
        holder.filename.setText(model.getFilename());
        holder.codersname.setText(model.getCodersname());
        holder.code.setText(model.getCode());
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.uploads_list, parent, false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder {
        TextView filename, codersname, code;

        public myviewholder(@NonNull View itemview) {
            super(itemview);
            filename = (TextView) itemview.findViewById(R.id.filename);
            codersname = (TextView) itemview.findViewById(R.id.codersname);
            code = (TextView) itemview.findViewById(R.id.code);

        }
    }
}
