package exercicio04.mappers;

import exercicio04.dtos.usuarios.UsuarioRequestDto;
import exercicio04.dtos.usuarios.UsuarioResponseDto;
import exercicio04.entities.Usuario;

import java.util.List;

public class UsuarioMapper {

    private UsuarioMapper() {}

    public static Usuario toEntity(Usuario usuario, UsuarioRequestDto requestDto) {
        usuario.setNome(requestDto.getNome());
        usuario.setNomeUsuario(requestDto.getNomeUsuario());
        usuario.setPerfil(requestDto.getPerfil());
        return usuario;
    }

    public static UsuarioResponseDto toResponseDto(Usuario usuario) {
        return UsuarioResponseDto.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .nomeUsuario(usuario.getNomeUsuario())
                .perfil(usuario.getPerfil())
                .status(usuario.getStatus())
                .build();
    }

    public static List<UsuarioResponseDto> toResponseDtos(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(UsuarioMapper::toResponseDto)
                .toList();
    }
}
