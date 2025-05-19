package exercicio04.dtos.usuarios;

import exercicio04.enums.UsuarioPerfil;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioRequestDto {
    public String nome;
    public String nomeUsuario;
    public String senha;
    public UsuarioPerfil perfil;
}
