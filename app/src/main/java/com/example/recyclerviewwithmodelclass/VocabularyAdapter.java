package com.example.recyclerviewwithmodelclass;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VocabularyAdapter extends RecyclerView.Adapter<VocabularyAdapter.VocabularyViewHolder> {

    Context context;
    ArrayList<Vocabulary> vocabularyArrayList;

    public VocabularyAdapter(Context context, ArrayList<Vocabulary> vocabularyArrayList) {
        this.context = context;
        this.vocabularyArrayList = vocabularyArrayList;
    }

    @NonNull
    @Override
    public VocabularyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.vocabulary_layout,parent,false);
        return new VocabularyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VocabularyViewHolder holder, int position) {
        holder.textView.setText(vocabularyArrayList.get(position).getEngwords());
        holder.textView2.setText(vocabularyArrayList.get(position).getUzbwords());
    }

    @Override
    public int getItemCount() {
        return vocabularyArrayList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void filterList(ArrayList<Vocabulary> filteredList) {
        vocabularyArrayList=filteredList;
        notifyDataSetChanged();
    }


    static class  VocabularyViewHolder extends RecyclerView.ViewHolder {

        TextView textView,textView2;
        public VocabularyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textview1);
            textView2=itemView.findViewById(R.id.textview2);
        }
    }
}
