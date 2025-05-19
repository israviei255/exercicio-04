package exercicio04.services;

import exercicio04.dtos.usuarios.UsuarioRequestDto;
import exercicio04.dtos.usuarios.UsuarioResponseDto;
import exercicio04.entities.Usuario;
import exercicio04.mappers.UsuarioMapper;
import exercicio04.repositories.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;

    UsuarioServiceImpl(UsuarioRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public UsuarioResponseDto create(UsuarioRequestDto requestDto) {
        Usuario usuario = UsuarioMapper.toEntity(new Usuario(), requestDto);

        usuario.setSenha(encoder.encode(requestDto.getSenha()));

        return UsuarioMapper.toResponseDto(repository.save(usuario));
    }

    @Override
    public List<UsuarioResponseDto> findAll() {
        return UsuarioMapper.toResponseDtos(repository.findAll());
    }

    @Override
    public UsuarioResponseDto findById(Long id) {
        Optional<Usuario> usuarioOpt = repository.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            return UsuarioMapper.toResponseDto(usuario);
        }
        return null;
    }

    @Override
    public UsuarioResponseDto updateById(Long id, UsuarioRequestDto requestDto) {
        Optional<Usuario> usuarioOpt = repository.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            UsuarioMapper.toEntity(usuario, requestDto);

            usuario.setSenha(encoder.encode(requestDto.getSenha()));

            return UsuarioMapper.toResponseDto(repository.save(usuario));
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Usuario> usuarioOpt = repository.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            repository.delete(usuario);
        }
    }
}
