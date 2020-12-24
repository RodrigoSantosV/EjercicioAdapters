package com.example.ejercicioadapters

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random
import kotlin.random.nextInt

class StringAdapter(var listaString: MutableList<String>) : RecyclerView.Adapter<StringAdapter.StringViewHolder>() {
    var listaBoolean = mutableListOf<Boolean>()

    class StringViewHolder(var root: View, var textView: TextView, var checkBox: CheckBox) : RecyclerView.ViewHolder(root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val twTextView = view.findViewById<TextView>(R.id.textView)
        val box = view.findViewById<CheckBox>(R.id.checkbox)
        return StringViewHolder(view, twTextView, box)
    }

    override fun getItemCount(): Int {
        return listaString.size
    }

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        if (position == 0) {
            holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.purple_200))
            holder.textView.text = "Borrar"
            holder.root.setOnClickListener {
                val toast = Toast.makeText(it.context, "Borrando...", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
                var random = Random
                var borraraleatorio = random.nextInt(1..listaString.size - 2)
                listaString.remove(listaString[borraraleatorio])
                listaBoolean.remove(listaBoolean[borraraleatorio])
                notifyDataSetChanged()
            }
            return
        }
        if (position == itemCount - 2) {
            holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.purple_200))
            holder.textView.text = "Contar checks"
            holder.root.setOnClickListener {
                var count = 0
                listaBoolean.forEach {
                    if (it == true)
                        count++
                }
                val toast = Toast.makeText(it.context, "El total de checks es $count", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }
            return
        }
        if (position == itemCount - 1) {
            holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.purple_200))
            holder.textView.text = "Insertar"
            holder.root.setOnClickListener {
                val toast = Toast.makeText(it.context, "Añadiendo...", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
                listaString.add("PC-$position")
                it.setOnClickListener(null)
                notifyDataSetChanged()
            }
            return
        }
        var random = Random
        var checkeadoaleatorio = random.nextInt(1..2)
        if (checkeadoaleatorio == 1) {
            holder.checkBox.isChecked = false
            listaBoolean.add(false)
            holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.rojo))
        } else {
            holder.checkBox.isChecked = true
            listaBoolean.add(true)
            holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.verde))
        }
        holder.checkBox.setOnCheckedChangeListener{buttonView, isChecked->
            if (isChecked){
                holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.verde))
                listaBoolean.set(position,true)
            }

            else{
                holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.rojo))
                listaBoolean.set(position,false)
            }
        }
        holder.textView.setText(listaString[position])



    }

}