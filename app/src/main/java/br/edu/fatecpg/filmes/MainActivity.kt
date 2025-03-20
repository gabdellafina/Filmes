package br.edu.fatecpg.filmes

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.filmes.dao.FilmeDao
import br.edu.fatecpg.filmes.modelo.Filme

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtCategoria = findViewById<EditText>(R.id.edtCategoria)
        val edtNota = findViewById<EditText>(R.id.edtNota)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val fabLista = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.fabList)
        val dao = FilmeDao()

        btnSalvar.setOnClickListener {
            val nome = edtNome.text.toString()
            val categoria = edtCategoria.text.toString()
            val nota = edtNota.text.toString().toFloatOrNull()

            if (nome.isNotBlank() && categoria.isNotBlank() && nota != null) {
                val filme = Filme(nome, categoria, nota)
                dao.adicionarFilme(filme)
                Toast.makeText(this, "Filme salvo com sucesso!", Toast.LENGTH_SHORT).show()
                edtNome.text.clear()
                edtCategoria.text.clear()
                edtNota.text.clear()
            } else {
                Toast.makeText(this, "Preencha todos os campos corretamente!", Toast.LENGTH_SHORT).show()
            }
        }

        fabLista.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
    }
}
