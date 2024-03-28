package com.alurafood.pagamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alurafood.pagamentos.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
	
}
