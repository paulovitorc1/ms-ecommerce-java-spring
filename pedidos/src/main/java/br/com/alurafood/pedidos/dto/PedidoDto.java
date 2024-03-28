package br.com.alurafood.pedidos.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.alurafood.pedidos.model.Status;

public class PedidoDto {

	private Long id;
	private LocalDateTime dataHora;
	private Status status;
	private List<ItemDoPedidoDto> itens = new ArrayList<>();

	public PedidoDto() {
	}

	public PedidoDto(Long id, LocalDateTime dataHora, Status status, List<ItemDoPedidoDto> itens) {
		this.id = id;
		this.dataHora = dataHora;
		this.status = status;
		this.itens = itens;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<ItemDoPedidoDto> getItens() {
		return itens;
	}

	public void setItens(List<ItemDoPedidoDto> itens) {
		this.itens = itens;
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
		PedidoDto other = (PedidoDto) obj;
		return Objects.equals(id, other.id);
	}

}
