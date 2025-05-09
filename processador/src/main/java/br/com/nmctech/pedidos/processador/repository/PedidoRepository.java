package br.com.nmctech.pedidos.processador.repository;

import br.com.nmctech.pedidos.processador.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {

}
