package com.example.mycanvasapp.TeacherView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mycanvasapp.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<String> data;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        Button delete;
        private Adapter adapter;

        public ViewHolder(View view) {
            super(view);

            title = view.findViewById(R.id.card_title);
            delete = view.findViewById(R.id.deleteButton);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapter.data.remove(getAdapterPosition());
                    adapter.notifyItemRemoved(getAdapterPosition());
                }
            });
        }

        public ViewHolder linkAdapter(Adapter adapter) {
            this.adapter = adapter;
            return this;
        }

        public TextView getTitle() {
            return title;
        }
    }

    public Adapter(ArrayList<String> dataSet) {
        data = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_teacher, viewGroup, false);
        return new ViewHolder(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getTitle().setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

