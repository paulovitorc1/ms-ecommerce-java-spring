package com.alurafood.pagamentos.DTO;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import com.alurafood.pagamentos.model.Status;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class PagamentoDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Positive
	private BigDecimal valor;

	@NotBlank
	@Size(max = 100)
	private String nome;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status;

	@NotNull
	private Long pedidoId;

	@NotNull
	private Long formaDePagamento;

	public PagamentoDTO() {
	}

	public PagamentoDTO(Long id, @NotNull @Positive BigDecimal valor, @NotBlank @Size(max = 100) String nome,
			@NotNull Status status, @NotNull Long pedidoId, @NotNull Long formaDePagamento) {
		this.id = id;
		this.valor = valor;
		this.nome = nome;
		this.status = status;
		this.pedidoId = pedidoId;
		this.formaDePagamento = formaDePagamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Long getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(Long formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

}
