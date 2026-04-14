package controller;

import model.Pessoa;
import java.util.ArrayList;

public class PessoaController {
    private ArrayList<Pessoa> pessoas;
    
    public PessoaController() {
        this.pessoas = new ArrayList<>();
    }
    
    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }
    
    public ArrayList<Pessoa> listarPessoas() {
        return pessoas;
    }
    
    public Pessoa buscarPorNome(String nome) {
        for (Pessoa p : pessoas) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }
    
    public boolean removerPessoa(String nome) {
        Pessoa pessoa = buscarPorNome(nome);
        if (pessoa != null) {
            pessoas.remove(pessoa);
            return true;
        }
        return false;
    }
}