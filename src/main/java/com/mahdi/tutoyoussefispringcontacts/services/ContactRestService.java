package com.mahdi.tutoyoussefispringcontacts.services;

import com.mahdi.tutoyoussefispringcontacts.dao.ContactRepository;
import com.mahdi.tutoyoussefispringcontacts.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //REST service
@CrossOrigin(origins = "*", allowedHeaders = "*") //to fix cors policy error in angular
public class ContactRestService {
    @Autowired
    private ContactRepository contactRepository;

    //GET contact list
    @RequestMapping(value = "/contacts",method = RequestMethod.GET)//recevoir la liste des contact en utilisant /contacts
    public List<Contact> getContacts(){
        return contactRepository.findAll();
    }

    //GET contact by id
    @RequestMapping(value = "/contacts/{id}",method = RequestMethod.GET)
    public Optional<Contact> getContactByID(@PathVariable Long id){
        return contactRepository.findById(id);
    }

    //Search for contacts
    @RequestMapping(value = "/searchContacts",method = RequestMethod.GET)
    public Page<Contact> search(
            @RequestParam(name = "mc",defaultValue = "") String mc,
            @RequestParam(name = "page",defaultValue = "0") int page,
            @RequestParam(name = "size",defaultValue = "5") int size) {
        return contactRepository.search("%"+mc+"%", PageRequest.of(page,size));
    }

    //POST save/add contact
    @RequestMapping(value = "/contacts",method = RequestMethod.POST)
    public Contact saveContact(@RequestBody Contact c){
        return contactRepository.save(c);
    }

    //DELETE contact
    @RequestMapping(value = "/contacts/{id}",method = RequestMethod.DELETE)
    public boolean deleteContact(@PathVariable Long id){
        contactRepository.deleteById(id);
        return true;
    }

    //PUT update contact
    @RequestMapping(value = "/contacts/{id}",method = RequestMethod.PUT)
    public Contact updateContact(@PathVariable Long id,@RequestBody Contact c){
        c.setId(id);
        return contactRepository.save(c);
    }
}
