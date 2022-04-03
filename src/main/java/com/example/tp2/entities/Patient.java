package com.example.tp2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
//indiquer que c'est une entité jpa
@Entity
//Ajouter getters et setters
@Data
//Ajout constructor par defaut
@NoArgsConstructor
//Ajout contructor d'initialisation
@AllArgsConstructor
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nom", length = 50)
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaiss;
    private boolean malade;
    private int score;
}
