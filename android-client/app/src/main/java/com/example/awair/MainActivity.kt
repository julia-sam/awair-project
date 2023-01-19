package com.example.awair

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.awair.ui.theme.AwairTheme
import kotlinx.coroutines.launch
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)

        button.setOnClickListener { loadData() }
    }

    private fun loadData() {
        val volleyQueue = Volley.newRequestQueue(this)
        val url = "http://127.0.0.1:8000/air_quality/request_json/"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            { response ->
                val data = response.getString("data")
                textView.setText(data);
            },
            { error ->
                Toast.makeText(this, "Some error occurred! Cannot fetch data", Toast.LENGTH_LONG).show()
                Log.e("MainActivity", "loadData error: ${error.localizedMessage}")
            }
        )

        volleyQueue.add(jsonObjectRequest)
    }
}