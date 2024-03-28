package com.alurafood.pagamentos.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.alurafood.pagamentos.DTO.PagamentoDTO;
import com.alurafood.pagamentos.service.PagamentoService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentoController {

	@Autowired
	private PagamentoService pagamentoService;

	@GetMapping
	public Page<PagamentoDTO> buscarTodos(@PageableDefault(size = 10) Pageable pageable) {
		return pagamentoService.obterPagamentos(pageable);
	}

	@GetMapping("/{Id}")
	public ResponseEntity<PagamentoDTO> buscarPorId(@PathVariable @NotNull Long Id) {
		PagamentoDTO dto = pagamentoService.obterPagamentoPorId(Id);
		return ResponseEntity.ok(dto);
	}

	@PostMapping
	public ResponseEntity<PagamentoDTO> criarPagamento(@RequestBody @Valid PagamentoDTO dto,
			UriComponentsBuilder uriBuilder) {
		PagamentoDTO pagamento = pagamentoService.criarPagamento(dto);
		URI endereco = uriBuilder.path("/pagamentos/{id}").buildAndExpand(pagamento.getId()).toUri();
		return ResponseEntity.created(endereco).body(pagamento);
	}

	@PutMapping("/{Id}")
	public ResponseEntity<PagamentoDTO> atualizarPagamento(@PathVariable @NotNull Long Id,
			@RequestBody @Valid PagamentoDTO dto) {
		PagamentoDTO pagamentoAtualizado = pagamentoService.atualizarPagamento(Id, dto);
		return ResponseEntity.ok(pagamentoAtualizado);
	}

	@DeleteMapping("/{Id}")
	public ResponseEntity<PagamentoDTO> deletarPagamento(@PathVariable @NotNull Long Id) {
		pagamentoService.deletarPagamento(Id);
		return ResponseEntity.noContent().build();
	}
	
	
	@PatchMapping("{Id}/confirmar")
	public void confirmarPagamento(@PathVariable @NotNull Long Id) {
		pagamentoService.confirmarPagamento(Id);
	}

}
