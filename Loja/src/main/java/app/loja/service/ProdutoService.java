package app.loja.service;

import app.loja.entity.Produto;
import app.loja.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public String save(Produto produto) {
        this.produtoRepository.save(produto);
        return produto.getNome()+"Produto adicionado com sucesso!";

    }

    public String update(long id, Produto produto) {
        produto.setId(id);
        this.produtoRepository.save(produto);

        return "Produto alterado com sucesso";
    }

    public List<Produto> listAll(){
        return this.produtoRepository.findAll();

    }

    public String delete(long id) {
        this.produtoRepository.deleteById(id);
        return "Produto deletado com sucesso";
    }
    public Produto findById(long id) {

        Produto produto = this.produtoRepository.findById(id).get();

        return produto;
    }

    public List<Produto> findByNome(String nome){
        return produtoRepository.findByNome(nome);

    }

    public List<Produto> findByValor(double valor){
        return produtoRepository.findByValor(valor);
    }

    public List<Produto> findByCategoria(String categoria){
        return produtoRepository.findByCategoria(categoria);
    }
}
