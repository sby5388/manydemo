package com.by5388.xw.android.kotlindemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.by5388.xw.android.kotlindemo.adapter.PersonAdapter;
import com.by5388.xw.android.kotlindemo.bean.Person;

import java.util.ArrayList;
import java.util.List;

public class Temp2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp2);
        initView();
    }

    private void initView() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("a", 20));
        people.add(new Person("b", 30));
        PersonAdapter adapter = new PersonAdapter(this, people);
        RecyclerView recyclerView = findViewById(R.id.recycler_view333);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }
}
