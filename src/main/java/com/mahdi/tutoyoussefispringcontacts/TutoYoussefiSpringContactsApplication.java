package com.mahdi.tutoyoussefispringcontacts;

import com.mahdi.tutoyoussefispringcontacts.dao.ContactRepository;
import com.mahdi.tutoyoussefispringcontacts.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class TutoYoussefiSpringContactsApplication implements CommandLineRunner {
    @Autowired
    private ContactRepository contactRepository;

    public static void main(String[] args) {
        SpringApplication.run(TutoYoussefiSpringContactsApplication.class, args);
    }

    //commandlinerunner function for testing
    @Override
    public void run(String... args) throws Exception {
        /*
        //enregistrer des contacts

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        contactRepository.save(new Contact("Behi","Mahdi",df.parse("26/02/1998"),
                "mahdi.bahi@gmail.com",00000000,"no"));
        contactRepository.save(new Contact("Binzarti","Faouzi",df.parse("10/05/1950"),
                "email@gmail.com",00000000,"no"));

        //afficher les contacts
        contactRepository.findAll().forEach(c->{
            System.out.println(c.getNom());
        });

         */
       }
}
