package com.example.projeto.gestao_de_chamados.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.projeto.gestao_de_chamados.dto.UsuarioCreateDTO;
import com.example.projeto.gestao_de_chamados.dto.UsuarioResponseDTO;
import com.example.projeto.gestao_de_chamados.entity.Usuario;
import com.example.projeto.gestao_de_chamados.exception.UsuarioNotFoundException;
import com.example.projeto.gestao_de_chamados.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioResponseDTO> listarUsuario() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuario -> new UsuarioResponseDTO(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getEmail(),
                        usuario.getRole()))
                .toList();
    }

    public UsuarioResponseDTO buscarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário não existe"));
        return new UsuarioResponseDTO(usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRole());
    }

    public UsuarioResponseDTO inserirUsuario(UsuarioCreateDTO usuarioCreateDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioCreateDTO.nome());
        usuario.setEmail(usuarioCreateDTO.email());
        usuario.setSenha(usuarioCreateDTO.senha());
        usuario.setRole(usuarioCreateDTO.role());

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(usuarioSalvo.getId(), usuarioSalvo.getNome(), usuarioSalvo.getEmail(),
                usuarioSalvo.getRole());
    }

    public UsuarioResponseDTO atualizarUsuario(Long id, UsuarioCreateDTO usuarioCreateDTO) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário não existe"));
        usuario.setNome(usuarioCreateDTO.nome());
        usuario.setEmail(usuarioCreateDTO.email());
        usuario.setSenha(usuarioCreateDTO.senha());
        usuario.setRole(usuarioCreateDTO.role());
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(usuarioSalvo.getId(), usuarioSalvo.getNome(), usuarioSalvo.getEmail(),
                usuarioSalvo.getRole());
    }

    public void deletarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário não existe"));
        usuarioRepository.delete(usuario);
    }
}
