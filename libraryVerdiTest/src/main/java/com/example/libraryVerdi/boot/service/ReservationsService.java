package com.example.libraryVerdi.boot.service;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libraryVerdi.boot.model.Reservations;
import com.example.libraryVerdi.boot.repository.ReservationsRepository;

@Service
public class ReservationsService {
	    @Autowired
		ReservationsRepository repository;
	    
		

		public Iterable<Reservations> findAll() {

			return repository.findAll();
		}

		public void insertReservations (Reservations reservations) {

			repository.save(reservations);
		}

		public Optional<Reservations> findById(long id) {

			return repository.findById(id);
		}
			
		public void setStatusReservations(HttpSession session) {

			Optional<Reservations> ReservationsFound = this.findById((Long) session.getAttribute("idReservations"));

			if (ReservationsFound.isPresent()) {

				Reservations ReservationsStatusUpdate = ReservationsFound.get();
				ReservationsStatusUpdate.setStatus(session.getAttribute("status").toString());

				this.insertReservations(ReservationsStatusUpdate);

			}

		}

		
	}