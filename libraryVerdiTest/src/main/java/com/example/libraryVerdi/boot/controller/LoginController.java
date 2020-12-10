package com.example.libraryVerdi.boot.controller;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.libraryVerdi.boot.service.CustomerService;
import com.example.libraryVerdi.boot.service.ReservationsService;

@Controller
public class LoginController {

	@Autowired
	CustomerService customerservice;

	@Autowired
	ReservationsService Resaservice;
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {

		//if (session.getAttribute("sid") == null) {

			logger.info("Welcome home! The client locale is {}.", locale);

			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

			String formattedDate = dateFormat.format(date);

			model.addAttribute("serverTime", formattedDate);
			model.addAttribute("msg",
					"Welcome to our shooping center, enjoy your stay, and buy some beans or entities ...");

			String sid = session.getId();
			session.setAttribute("sid", sid);
			// System.out.println("Session id: " + sid);

			
			session.setAttribute("timestamp", formattedDate);

			// System.out.println(session.getServletContext());
			// System.out.println(session.getSessionContext());
			// to-do as a LOG

			model.addAttribute("clients", customerservice.findAll());

			return "library/login";
		//}

		//else
		//	return "redirect:products/show";
	}

	@RequestMapping(value = { "/loginCustomer" }, method = RequestMethod.POST)
	public String loginCustomer(@RequestParam("idCustomer") Long id, Model model, HttpSession session) {

		Optional<Customer> foundCustomer = customerservice.findById(id);

		// Search for a book with an invalid ID
		if (foundCustomer.isPresent())

		{
			session.setAttribute("customer", foundCustomer.get());		
			

		}

		return "/home";
	}

	@RequestMapping(value = { "/*" }, method = RequestMethod.GET)
	public String error(Locale locale, Model model, HttpSession session) {

		// to-do error site
		return "shoping/error";
	}

}