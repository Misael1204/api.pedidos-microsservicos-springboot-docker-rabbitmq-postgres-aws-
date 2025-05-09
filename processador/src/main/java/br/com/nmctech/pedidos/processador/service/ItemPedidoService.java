package br.com.nmctech.pedidos.processador.service;

import br.com.nmctech.pedidos.processador.entity.ItemPedido;
import br.com.nmctech.pedidos.processador.entity.Pedido;
import br.com.nmctech.pedidos.processador.repository.ItemPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository repository;

    public ItemPedidoService(ItemPedidoRepository repository) {
        this.repository = repository;
    }

    public List<ItemPedido> save(List<ItemPedido> itens) {

         return repository.saveAll(itens);
    }

    public  void save(ItemPedido item){
        repository.save(item);
    }


    public void updatedItemPedido(List<ItemPedido> itemPedidos, Pedido pedido) {
        itemPedidos.forEach(item -> {
            item.setPedido(pedido); //informando ao item o seu pedido
            this.save(item);
        });
    }
}
