package br.edu.fatecpg.filmes.adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.filmes.R
import br.edu.fatecpg.filmes.modelo.Filme

class FilmeAdapter(private val filmes: List<Filme>)
    : RecyclerView.Adapter<FilmeAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txvNome: TextView = itemView.findViewById(R.id.txvNome)
        val txvCategoria: TextView = itemView.findViewById(R.id.txvCategoria)
        val txvNota: TextView = itemView.findViewById(R.id.txvNota)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_filme, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filmes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val filme = filmes[position]
        holder.txvNome.text = filme.nome
        holder.txvCategoria.text = filme.categoria
        holder.txvNota.text = "Nota: ${filme.nota}"
    }
}
