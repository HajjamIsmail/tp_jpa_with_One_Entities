package com.example.tp2;

import com.example.tp2.entities.Patient;
import com.example.tp2.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Tp2Application implements CommandLineRunner {

    //Faire l'injection des dependances
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(Tp2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Supposons qu'on a enrgistrement de plus de 100
        //Add 100 Patient
        for(int i=0;i<100;i++){
            patientRepository.save(new Patient(null,""+i,new Date(),Math.random()>0.5?true:false, (int)(Math.random()*100)));
        }

        //Solution => Faire de la pagination :
        //dans la pagination la 1er page c'est 0
        //Page<Patient> patients = patientRepository.findAll(PageRequest.of(0,10));

        //Totale Page :
        /*System.out.println("Total de page : "+patients.getTotalPages());*/

        //Total elt :
        //System.out.println("Totale elements : "+patients.getTotalElements());

        //Num de page :
        //System.out.println("Numero de page : "+patients.getNumber());

        //return contenu de patient :
        //List<Patient> content = patients.getContent();

        //Parcourir content :
        /*content.forEach(p->{
            System.out.println("-----------------------");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getScore());
            System.out.println(p.getDateNaiss());
            System.out.println(p.isMalade());
        });*/

        //Appel de la fonction :
        //Page<Patient> byMalade=patientRepository.findByMalade(true, PageRequest.of(0,10));

        //Affichage :
        /*byMalade.forEach(p->{
            System.out.println("-----------------------");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getScore());
            System.out.println(p.getDateNaiss());
            System.out.println(p.isMalade());
        });*/

        //Add some Patient
        /*patientRepository.save(new Patient(null, "AAAA", new Date(), false, 56));
        patientRepository.save(new Patient(null, "BBBB", new Date(), false, 46));
        patientRepository.save(new Patient(null, "CCCC", new Date(), false, 85));*/

        //Select Patient
        /*List<Patient> patients = patientRepository.findAll();
        patients.forEach(p->{
            System.out.println("-----------------------");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getScore());
            System.out.println(p.getDateNaiss());
            System.out.println(p.isMalade());
        });*/

        //Search patient with ID :
        //System.out.println("--------------------------------------");
        //.orElse chercher  le id sinn return null
        //Patient patient=patientRepository.findById(1L).orElse(null);

        //.orElseThrow checher le id sinn return exception
        //Patient patient=patientRepository.findById(1L).orElseThrow(()->new RuntimeException("Patient not found"));

        //.get() chercher le id sinn erreur(exception non traité)
        //Patient patient=patientRepository.findById(1L).get();

        /*Patient patient=patientRepository.findById(1L).orElse(null);
        if(patient!=null){
            System.out.println("-------------------------");
            System.out.println(patient.getId());
            System.out.println(patient.getNom());
            System.out.println(patient.getScore());
            System.out.println(patient.getDateNaiss());
            System.out.println(patient.isMalade());
        }*/

        //Update :
        /*.setScore(870);
        patientRepository.save(patient);
        System.out.println("Update with success");*/

        //Delete :
        /*patientRepository.deleteById(1L);
        System.out.println("Delete with succes");*/
        List<Patient> patientList=patientRepository.chercherPatient("%1%",5);
        patientList.forEach(p->{
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getScore());
            System.out.println(p.getDateNaiss());
            System.out.println(p.isMalade());
        });
    }
}
