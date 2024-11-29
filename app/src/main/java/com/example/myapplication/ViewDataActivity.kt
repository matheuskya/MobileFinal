package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class ViewDataActivity : AppCompatActivity() {
    private lateinit var adapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        println("OIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_data)

        setupRecyclerView()
        loadData()
    }

    private fun setupRecyclerView() {
        adapter = DataAdapter()
        findViewById<RecyclerView>(R.id.rvData).apply {
            layoutManager = LinearLayoutManager(this@ViewDataActivity)
            adapter = this@ViewDataActivity.adapter
        }
    }

    private fun loadData() {
        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.api.getData()
                println("OIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII")
                println(response)
                println(response.body())

                if (response.isSuccessful) {
                    response.body()?.let { data ->
                        adapter.submitList(data)
                    }
                } else {
                    Toast.makeText(this@ViewDataActivity, "Error loading data", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this@ViewDataActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}