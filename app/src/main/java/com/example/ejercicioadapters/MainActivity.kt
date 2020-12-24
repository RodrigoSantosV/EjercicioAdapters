package com.example.ejercicioadapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicioadapters.databinding.ActivityMainBinding
import kotlin.random.nextInt
import kotlin.random.Random as Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter : StringAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createRecyclerView()
    }

    private fun createRecyclerView() {
        val random = Random
        var aleatorio =random.nextInt(5..10)
        val listaString = mutableListOf<String>("PC-1")

        for( i in 1..aleatorio){

            listaString.add("PC-$i")

        }
        adapter = StringAdapter(listaString.toMutableList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

}