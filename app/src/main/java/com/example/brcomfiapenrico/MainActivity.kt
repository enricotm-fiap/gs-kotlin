package com.example.brcomfiapenrico

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.brcomfiapenrico.adapter.ItemsAdapter
import com.example.brcomfiapenrico.model.Praia
import com.example.brcomfiapenrico.ui.theme.BrcomfiapenricoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        val itemsAdapter = ItemsAdapter()

        recyclerView.adapter = itemsAdapter

        val nome = findViewById<EditText>(R.id.nome)
        val cidade = findViewById<EditText>(R.id.cidade)
        val estado = findViewById<EditText>(R.id.estado)
        val button = findViewById<Button>(R.id.button)

        var items = mutableListOf<Praia>()
        val itemsLiveData = MutableLiveData<List<Praia>>()

        itemsLiveData.observe(this) { items ->
            itemsAdapter.updateItems(items)
        }

        fun removeItem(item: Praia) {
            items.remove(item)
            itemsLiveData.value = items
        }

        fun addItem(nome: String, cidade: String, estado: String) {
            val item = Praia(nome = nome, cidade = cidade, estado = estado, onRemove = ::removeItem)
            items.add(item)
            itemsLiveData.value = items
        }

        button.setOnClickListener {
            addItem(nome.text.toString(), cidade.text.toString(), estado.text.toString())

            nome.text.clear()
            cidade.text.clear()
            estado.text.clear()
        }






    }
}