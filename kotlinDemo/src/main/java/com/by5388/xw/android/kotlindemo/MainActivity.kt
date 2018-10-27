package com.by5388.xw.android.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.by5388.xw.android.kotlindemo.adapter.PersonAdapter
import com.by5388.xw.android.kotlindemo.bean.Person
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
    }

    private fun initData() {
        var people: MutableList<Person> = ArrayList()
        people.add(Person("a", 20))
        people.add(Person("b", 30))
        var adapter = PersonAdapter(this, people)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter
    }
}
