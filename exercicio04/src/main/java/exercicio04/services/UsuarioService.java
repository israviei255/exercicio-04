package exercicio04.services;

import exercicio04.dtos.usuarios.UsuarioRequestDto;
import exercicio04.dtos.usuarios.UsuarioResponseDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioService extends UserDetailsService {

    UsuarioResponseDto create(UsuarioRequestDto requestDto);
    List<UsuarioResponseDto> findAll();
    UsuarioResponseDto findById(Long id);
    UsuarioResponseDto updateById(Long id, UsuarioRequestDto requestDto);
    void deleteById(Long id);
}
