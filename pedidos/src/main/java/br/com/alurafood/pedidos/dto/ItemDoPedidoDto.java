package br.com.alurafood.pedidos.dto;

import java.util.Objects;

public class ItemDoPedidoDto {

	private Long id;
	private Integer quantidade;
	private String descricao;

	public ItemDoPedidoDto(Long id, Integer quantidade, String descricao) {
		this.id = id;
		this.quantidade = quantidade;
		this.descricao = descricao;
	}

	public ItemDoPedidoDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDoPedidoDto other = (ItemDoPedidoDto) obj;
		return Objects.equals(id, other.id);
	}

}
