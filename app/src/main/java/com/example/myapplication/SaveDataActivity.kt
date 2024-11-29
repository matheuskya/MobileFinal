package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class SaveDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_data)

        findViewById<Button>(R.id.btnSubmit).setOnClickListener {
            val data = findViewById<EditText>(R.id.etData).text.toString()
            if (data.isNotEmpty()) {
                saveData(data)
            } else {
                Toast.makeText(this, "Please enter data", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveData(data: String) {
        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.api.saveData(DataModel(name = data))
                if (response.isSuccessful) {
                    Toast.makeText(this@SaveDataActivity, "Data saved successfully", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this@SaveDataActivity, "Error saving data", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this@SaveDataActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()

            }
        }
    }
}