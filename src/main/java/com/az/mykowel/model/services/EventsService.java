package com.az.mykowel.model.services;

import com.az.mykowel.model.entity.*;
import com.az.mykowel.model.repositories.EventsRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EventsService {
    @Autowired
    public EventsRepository eventsRepository;

    public List<Events> listAll(){
        return eventsRepository.findAll();
    }
    
    public void save(Events event){
        eventsRepository.save(event);
    }

    public void delete(Long Id){
        eventsRepository.deleteById(Id);
    }

}
