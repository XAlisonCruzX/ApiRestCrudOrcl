package br.com.prod.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prod.datasource.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{


}
