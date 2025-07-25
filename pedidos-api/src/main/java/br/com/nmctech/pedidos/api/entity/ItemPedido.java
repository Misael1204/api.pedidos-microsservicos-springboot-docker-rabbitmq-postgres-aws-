package br.com.nmctech.pedidos.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;


@Data
public class ItemPedido {

    private UUID id = UUID.randomUUID();
    private Produto produto;
    private Integer quantidade;

    public ItemPedido() {
    }

    public ItemPedido(Produto produto, Integer quantidade, UUID id) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.id = id;
    }

    public ItemPedido(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "id=" + id +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                '}';
    }
}
