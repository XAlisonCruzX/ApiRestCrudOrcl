package br.com.prod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.prod.datasource.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {


}
