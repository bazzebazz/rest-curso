package com.donjavidev.restcurso.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "user")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

/*   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(columnDefinition = "DATETIME", updatable = false, nullable = false)
    protected Date createdDate;

    @Column(columnDefinition = "DATETIME", updatable = false, nullable = false)
    protected Date updatedDate; */

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    @Getter @Setter
    private Role role;

    @JsonIgnore
    @Column(name = "password")
    @Getter @Setter
    private String password;

    @Column(name = "nombre")
    @Getter @Setter
    private String nombre;

    @Column(name = "apellido")
    @Getter @Setter
    private String apellido;

    @Column(name = "email")
    @Getter @Setter
    private String email;

    @Column(name = "telefono")
    @Getter @Setter
    private String telefono;

    @Column(name = "fecha_nacimiento")
    @Getter @Setter
    private Date fechaNacimiento;


    public User(long id, String nombre, Date createdDate, Date updatedDate , String apellido, String email, String telefono, Date fechaNacimiento) {
        this.setId(id);
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
