package com.by5388.xw.android.kotlindemo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.by5388.xw.android.kotlindemo.R
import com.by5388.xw.android.kotlindemo.bean.Person

/**
 * @author  by5388  on 2018/10/27.
 */
class PersonAdapter(var context: Context, var people: MutableList<Person>) :
    RecyclerView.Adapter<PersonAdapter.PersonHolder>() {

    init {

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, positin: Int) =
        PersonHolder(View.inflate(context, R.layout.item_person, null))

    override fun getItemCount() = people.size

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        if (position >= people.size) {
            return
        }
        val person = people[position]
        holder.age.text = person.age.toString()
        holder.name.text = person.name
    }

    class PersonHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var age: TextView = itemView.findViewById(R.id.person_age)
        var name: TextView = itemView.findViewById(R.id.person_name)
    }
}