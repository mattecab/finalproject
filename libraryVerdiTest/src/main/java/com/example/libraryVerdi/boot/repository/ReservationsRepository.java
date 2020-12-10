package com.example.libraryVerdi.boot.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.libraryVerdi.boot.model.Reservations;



public interface ReservationsRepository extends CrudRepository<Reservations, Long> {

}
