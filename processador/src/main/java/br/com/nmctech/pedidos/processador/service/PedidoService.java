package br.com.nmctech.pedidos.processador.service;

import br.com.nmctech.pedidos.processador.entity.ItemPedido;
import br.com.nmctech.pedidos.processador.entity.Pedido;
import br.com.nmctech.pedidos.processador.repository.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final Logger logger = LoggerFactory.getLogger(PedidoService.class);
    private final PedidoRepository repository;
    private final ProdutoService produtoService;
    private final ItemPedidoService itemPedidoService;

    public PedidoService(PedidoRepository repository, ProdutoService produtoService, ItemPedidoService itemPedidoService) {
        this.repository = repository;
        this.produtoService = produtoService;
        this.itemPedidoService = itemPedidoService;
    }

    public void save(Pedido pedido){
        //salvamos os produtos
        produtoService.save(pedido.getItens());

        //salvamos os itens do pedido
        List<ItemPedido> itemPedidos = itemPedidoService.save(pedido.getItens());

        //salvamos o pedido
        repository.save(pedido);

        //atualiza o item pedido definindo ao qual faz parte
        itemPedidoService.updatedItemPedido(itemPedidos, pedido);

        logger.info("Pedido salvo: {}", pedido.toString());
    }
}
