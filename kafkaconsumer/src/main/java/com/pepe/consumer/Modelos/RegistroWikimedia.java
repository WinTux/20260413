package com.pepe.consumer.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
@Entity
public class RegistroWikimedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String datos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }
}
