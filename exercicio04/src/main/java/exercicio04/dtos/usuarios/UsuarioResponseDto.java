package exercicio04.dtos.usuarios;

import exercicio04.enums.UsuarioPerfil;
import exercicio04.enums.UsuarioStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioResponseDto{
        public Long id;
        public String nome;
        public String nomeUsuario;
        public UsuarioPerfil perfil;
        public UsuarioStatus status;
}
