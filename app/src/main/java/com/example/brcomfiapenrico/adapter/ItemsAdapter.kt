package com.example.brcomfiapenrico.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.brcomfiapenrico.R
import com.example.brcomfiapenrico.model.Praia

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    private var praias = listOf<Praia>()

    fun updateItems(newItems: List<Praia>) {
        praias = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.praia_layout, parent, false)
        return ItemViewHolder(view)
    }
    override fun getItemCount(): Int = praias.size
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = praias[position]
        holder.bind(item)
    }
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nome = view.findViewById<TextView>(R.id.textViewNome)
        val cidade = view.findViewById<TextView>(R.id.textViewCidade)
        val estado = view.findViewById<TextView>(R.id.textViewEstado)
        val button = view.findViewById<ImageButton>(R.id.excluirButton)
        fun bind(item: Praia) {
            nome.text = item.nome
            cidade.text = item.cidade
            estado.text = item.estado
            button.setOnClickListener {
                item.onRemove(item)
            }
        }
    }
}