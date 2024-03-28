package com.alurafood.pagamentos.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.alurafood.pagamentos.DTO.PagamentoDTO;
import com.alurafood.pagamentos.http.PedidoClient;
import com.alurafood.pagamentos.model.Pagamento;
import com.alurafood.pagamentos.model.Status;
import com.alurafood.pagamentos.repository.PagamentoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PagamentoService {

	@Autowired
	PagamentoRepository pagamentoRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PedidoClient pedido;

	public PagamentoDTO obterPagamentoPorId(Long Id) {
		Pagamento pagamento = pagamentoRepository.findById(Id).orElseThrow(() -> new EntityNotFoundException());
		return modelMapper.map(pagamento, PagamentoDTO.class);
	}

	public Page<PagamentoDTO> obterPagamentos(Pageable pageable) {
		Page<PagamentoDTO> pagamentos = pagamentoRepository.findAll(pageable)
				.map(p -> modelMapper.map(p, PagamentoDTO.class));
		return pagamentos;
	}

	public PagamentoDTO criarPagamento(PagamentoDTO dto) {
		Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
		pagamento.setStatus(Status.CRIADO);
		pagamentoRepository.save(pagamento);
		return modelMapper.map(pagamento, PagamentoDTO.class);
	}

	public PagamentoDTO atualizarPagamento(Long Id, PagamentoDTO dto) {
		Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
		pagamento.setId(Id);
		pagamento = pagamentoRepository.save(pagamento);
		return modelMapper.map(pagamento, PagamentoDTO.class);
	}

	public PagamentoDTO deletarPagamento(Long Id) {
		pagamentoRepository.deleteById(Id);
		return null;
	}

	public void confirmarPagamento(Long Id) {
		Optional<Pagamento> pagamento = pagamentoRepository.findById(Id);

		if (!pagamento.isPresent()) {
			throw new EntityNotFoundException();
		}

		pagamento.get().setStatus(Status.CONFIRMADO);
		pagamentoRepository.save(pagamento.get());
		pedido.atualizarPagamento(pagamento.get().getPedidoId());

	}

}
