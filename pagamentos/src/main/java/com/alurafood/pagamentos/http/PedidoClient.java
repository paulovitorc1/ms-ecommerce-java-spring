package com.alurafood.pagamentos.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("pedidos-ms")
public interface PedidoClient {

	@PutMapping("/pedidos/{id}/pago")
	void atualizarPagamento(@PathVariable Long id);

}
