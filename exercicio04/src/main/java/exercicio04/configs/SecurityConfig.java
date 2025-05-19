package exercicio04.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Base64;

@Configuration // para virar um bean
@EnableWebSecurity // habilita o bean
public class SecurityConfig {

    //bean para codificação da senha
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    // configuração principal de autorizações
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .formLogin(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/login").permitAll() // especificações de autorizacao
                        .anyRequest().authenticated() // caso nao seja especificado precisa ser autenticado
                );
        return http.build();
    }

    //configuração de usuario
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) { // parametros injetam uma dependencia
        String password = encoder.encode("password");
        UserDetails userDetails = User.withUsername("user") //User é uma classe que implementa a interface UserDetails
                .password(password)
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }

}
