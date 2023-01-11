package com.az.mykowel.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.az.mykowel.model.entity.Contacts;

public interface ContactsRepository  extends JpaRepository<Contacts, Long> {

    public List<Contacts> findAllByOwnerStartsWith(String owner);
}
