package com.donjavidev.restcurso.models;

import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    protected long id;

    //TODO: Arreglar el nullable en la bd a false
    @Column(columnDefinition = "DATETIME", updatable = false, nullable = true)
    protected Date createdDate;

    @Column(columnDefinition = "DATETIME", updatable = false, nullable = true)
    protected Date updatedDate;

    @PrePersist
    protected void onCreate(){
        updatedDate = new Date();
        if(createdDate == null){
            createdDate = new Date();
        }
    }
}
