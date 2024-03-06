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

    public Usuario buscarUsuarioPorId(String id) {
        Optional<Usuario> usuario = repository.findById(id);

        if (usuario.isEmpty()) {
            throw new RuntimeException("Não foi encontrado usuário com esse ID.");
        }

        return usuario.get();
    }

    public Usuario registrarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario atualizarUsuario(String id, Usuario usuarioAtualizado) {
        Usuario usuario = buscarUsuarioPorId(id);

        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setTarifa(usuarioAtualizado.getTarifa());

        return registrarUsuario(usuario);
    }

    public void deletarUsuario(String id) {
        Usuario usuario = buscarUsuarioPorId(id);
        repository.delete(usuario);
    }
}
