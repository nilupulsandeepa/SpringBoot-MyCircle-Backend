package com.polyticstudios.mycircle.authservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class AppUser {
    @Id @Column(nullable = false, updatable = true)
    private String email;

    private String firstName;
    private String lastName;

    private String password;

    private String role = "ROLE_USER";
}
