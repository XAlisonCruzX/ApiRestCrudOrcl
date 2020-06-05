package br.com.prod.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prod.datasource.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
