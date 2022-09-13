package com.example.recyclerviewwithmodelclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Vocabulary> vocabularyarraylist;
    RecyclerView recyclerView;
    VocabularyAdapter vocabularyAdapter;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview1);
        editText=findViewById(R.id.edittextsearch);
        vocabularyarraylist=new ArrayList<>();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });




        vocabularyarraylist.add(new Vocabulary("apple","olma"));
        vocabularyarraylist.add(new Vocabulary("bird","qush"));
        vocabularyarraylist.add(new Vocabulary("hen","tovuq"));
        vocabularyarraylist.add(new Vocabulary("cat","pshik"));

        vocabularyAdapter=new VocabularyAdapter(MainActivity.this,vocabularyarraylist);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(vocabularyAdapter);


    }

    private void filter(String text) {
        ArrayList<Vocabulary> filteredList = new ArrayList<>();

        for (Vocabulary item : vocabularyarraylist) {
            if (item.getEngwords ().toLowerCase().contains(text.toLowerCase()) || item.getUzbwords ().toLowerCase().contains(text.toLowerCase()) ) {
                filteredList.add(item);
            }
        }

        vocabularyAdapter.filterList(filteredList);
    }
}