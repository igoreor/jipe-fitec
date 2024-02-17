package br.upe.ecoenergy.service;

import br.upe.ecoenergy.domain.Usuario;
import br.upe.ecoenergy.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repository;

    public Usuario buscarUsuarioPorId(Long id) {
        Optional<Usuario> usuario = repository.findById(id);

        if (usuario.isEmpty()) {
            throw new RuntimeException("Não foi encontrado usuário com esse ID.");
        }

        return usuario.get();
    }

    public Usuario registrarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuarioAtualizado) {
        Usuario usuarioAntigo = buscarUsuarioPorId(usuarioAtualizado.getId());
        usuarioAntigo.setNome(usuarioAtualizado.getNome());
        usuarioAntigo.setTarifa(usuarioAtualizado.getTarifa());

        return repository.save(usuarioAtualizado);
    }

    public void deletarUsuario(Long id) {
        Usuario usuario = buscarUsuarioPorId(id);
        repository.delete(usuario);
    }
}
