package com.az.mykowel.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.az.mykowel.model.modules.Contacts;

public interface ContactsRepository  extends JpaRepository<Contacts, Long> {

    public Contacts findByOwner(String owner);
}
