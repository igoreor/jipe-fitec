package br.upe.ecoenergy.repository;

import br.upe.ecoenergy.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
