package com.example.libraryVerdi.boot.controller;

import java.io.OutputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.libraryVerdi.boot.model.Book;
import com.example.libraryVerdi.boot.model.BookRented;
import com.example.libraryVerdi.boot.model.Reservations;
import com.example.libraryVerdi.boot.service.BookService;
import com.example.libraryVerdi.boot.service.CustomerService;
import com.example.libraryVerdi.boot.service.ReservationsService;
import com.example.libraryVerdi.boot.utils.StatusSession;

import jdk.jshell.Snippet.Status;


@Controller
@RequestMapping(value = "cart")

public class CartController {


	@Autowired
	BookService service;
	
	@Autowired
	ReservationsService Resaservice;
	
	@Autowired
	CustomerService clientservice;

	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String home(HttpSession session) {

		return "library/Cart";
	}

	@RequestMapping(value = "rent", method = RequestMethod.POST)
	public String add(@RequestParam("bookId") Long book_id, HttpSession session,Locale locale,@RequestParam("customerId") Long customer_id) {

        System.out.println(book_id);
        System.out.println(customer_id);
		List<BookRented> cart ;

		// ProductModel productModel = new ProductModel();
		if (session.getAttribute("cart") == null) {

			cart = new ArrayList<BookRented>();
			cart.add(new BookRented(service.findById(book_id)));
			session.setAttribute("cart", cart);
            
           
            service.findById(book_id).setStatus(StatusSession.RENTED);
            
            //String sid = session.getId();
    		//session.setAttribute("sid", sid);
    		//System.out.println("Session id: " + sid);
    		
    		Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
            String formattedDate = dateFormat.format(date);
            
            Reservations resa = new Reservations();
            resa.setBook(service.findById(book_id));
            resa.setStatus(StatusSession.RENTED.toString());
            resa.setDate(formattedDate);
            resa.setCustomer(clientservice.findById(customer_id));
			Resaservice.insertReservations(resa);

		} 
		
		else {

			cart = (List<BookRented>) session.getAttribute("cart");
            cart.add(new BookRented(service.findById(book_id)));
			session.setAttribute("cart", cart);
			service.findById(book_id).setStatus(StatusSession.RENTED);
	            
	            
	            Date date = new Date();
				DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	            String formattedDate = dateFormat.format(date);
	           
	            Reservations resa = new Reservations();
	            resa.setDate(formattedDate);
				resa.setBook(service.findById(book_id));
	            resa.setStatus(StatusSession.RENTED.toString());
	            Resaservice.insertReservations(resa);
		}

		

		return "redirect:/cart/show";
	}

	@RequestMapping(value = "returnBook", method = RequestMethod.GET)
	public String bookback(@RequestParam("bookId") Long book_id, HttpSession session,Locale locale) {

		// ProductModel productModel = new ProductModel();
		List<BookRented> cart = (List<BookRented>) session.getAttribute("cart");
		int index = exists(book_id, cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		
		Book bookstatus= service.findById(book_id);
        bookstatus.setStatus(StatusSession.AVAILABLE);
        service.insertBook(bookstatus);
        
        Date date = new Date();
		DateFormat dateFormat= DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
		
        Reservations resa = new Reservations();
        resa.setStatus(StatusSession.AVAILABLE.toString());
		resa.setDate(formattedDate);
		resa.setBook(service.findById(book_id));
        Resaservice.insertReservations(resa);
		
		return "redirect:/cart/show";
	}

	@RequestMapping(value = "deleteSession", method = RequestMethod.GET)
	public String deleteSession(HttpSession session) {

		if (session.getAttribute("cart") != null) {
			session.invalidate();
		}

		return "library/home";
	}
	private static int exists(Long book_id, List<BookRented> cart) {

		for (int i = 0; i < cart.size(); i++) {

			if (cart.get(i).getBook().getId() == book_id) {
				return i;
			}

		}
		return -1;}

	@RequestMapping(value = "deleteCart", method = RequestMethod.GET)
	public String deleteCart(HttpSession session) {

		if (session.getAttribute("cart") != null) {

			// ProductModel productModel = new ProductModel();
			List<BookRented> cart = (List<BookRented>) session.getAttribute("cart");
			cart.removeAll(cart);
			session.setAttribute("cart", cart);

		}

		return "library/home";
	
	
}

	

	

	

	
}

