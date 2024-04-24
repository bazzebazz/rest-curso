package com.donjavidev.restcurso.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "role")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity {
    @Column(name = "nombre")
    @Getter @Setter
    private String nombre;

    // permisos

    @OneToMany(cascade = CascadeType.ALL
            , fetch = FetchType.EAGER, mappedBy = "role")
    @Getter @Setter
    private Set<Permiso> permisos;

}
