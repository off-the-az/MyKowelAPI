package com.az.mykowel.model.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.az.mykowel.model.entity.Contacts;
import com.az.mykowel.model.repositories.ContactsRepository;

@Service
@Transactional
public class ContactsService {

    @Autowired
    private ContactsRepository contactsRepository;

    public List<Contacts> listAllNumber(){
        return contactsRepository.findAll();
    }

    public Contacts findNumberById(Long Id){
        return contactsRepository.getById(Id);
    }

    public Optional<Contacts> findById(Long Id){
        return contactsRepository.findById(Id);
    }

    public Contacts findNumberByOwner(String owner){
        return contactsRepository.findAllByOwner(owner);
    }

    public void saveNumber(Contacts contact){
        contactsRepository.save(contact);
    }

    public void deleteNumber(Long Id){
        contactsRepository.deleteById(Id);
    }
}
