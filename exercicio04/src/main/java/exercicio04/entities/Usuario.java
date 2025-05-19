package exercicio04.entities;


import exercicio04.enums.UsuarioPerfil;
import exercicio04.enums.UsuarioStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String nomeUsuario;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private UsuarioPerfil perfil = UsuarioPerfil.USER; //USER OU ADMIN

    @Enumerated(EnumType.STRING)
    private UsuarioStatus status = UsuarioStatus.ACTIVE; // ACTIVE OU INATIVE

    // IMPLEMENTAÇÃO DO USERDETAILS

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return nomeUsuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> perfil.name());
    }

    @Override
    public boolean isEnabled() {
        return UsuarioStatus.ACTIVE == status;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isEnabled();
    }

    @Override
    public boolean isAccountNonLocked() {
        return isEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isEnabled();
    }
}
