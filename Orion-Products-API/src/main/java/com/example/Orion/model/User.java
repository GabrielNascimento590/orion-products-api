package com.example.Orion.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    // 🔒 Implementações obrigatórias do UserDetails:
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Converte o enum em uma autoridade que o Spring entende
        return List.of(() -> "ROLE_" + role.name());
    }

    @Override
    public String getUsername() {
        return username;
    }

    // indica se a conta está ativa
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // indica se a conta está desbloqueada
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // indica se as credenciais estão válidas
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // indica se o usuário está habilitado
    @Override
    public boolean isEnabled() {
        return true;
    }
}