package br.edu.fatecpg.filmes

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.filmes.dao.FilmeDao
import br.edu.fatecpg.filmes.adaptador.FilmeAdapter

class ListaActivity : AppCompatActivity(R.layout.activity_list) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val dao = FilmeDao()
        val filmes = dao.obterFilmes()
        Log.i("ListaFilmes", filmes.toString())
        val rvFilmes = findViewById<RecyclerView>(R.id.rvFilmes)

        rvFilmes.layoutManager = LinearLayoutManager(this)
        rvFilmes.adapter = FilmeAdapter(filmes)
    }
}
