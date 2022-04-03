package com.example.tp2.repositories;

import com.example.tp2.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    //fonction qui retourn les patients qui sont malade
    //public List<Patient> findByMalade(boolean m);

    //Faire de la pagination dans une fonction personnaliser :
    //dans le 2em parametre il faut indiquer num de page et le size
    //public Page<Patient> findByMalade(boolean m, Pageable pageable);

    //Patient malade dans le score est inferieur à x :
    //public List<Patient> findByMaladeAndScoreLessThan(boolean m, int score);

    //Patient malade(true=>IsTrue) dans le score est inferieur à x :
    //public List<Patient> findByMaladeIsTrueAndScoreLessThan(int score);

    //Patient entre 2 date :
    //public List<Patient> findByDateNaissBetween(Date d1, Date d2, String mc);

    //pour des methodes complexe il faut utiliser des requette HQL :
    @Query("select p from Patient p where p.nom like :x and p.score<:y")
    List<Patient> chercherPatient(@Param("x") String nom, @Param("y") int score);
}
