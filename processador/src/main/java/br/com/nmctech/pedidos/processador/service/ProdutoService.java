package br.com.nmctech.pedidos.processador.service;

import br.com.nmctech.pedidos.processador.entity.ItemPedido;
import br.com.nmctech.pedidos.processador.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public void save(List<ItemPedido> itens) {
        itens.forEach(item -> {
            repository.save(item.getProduto());
        });
    }
}
