package br.edu.fatecpg.filmes.dao

import br.edu.fatecpg.filmes.modelo.Filme

class FilmeDao {
    companion object {
        val filmes = mutableListOf<Filme>()
    }

    fun adicionarFilme(filme: Filme) {
        filmes.add(filme)
    }

    fun obterFilmes(): List<Filme> {
        return filmes
    }
}
