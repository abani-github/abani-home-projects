package com.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import springapp.domain.Contact;
import springapp.service.contacts.ContactsDAO;

@Controller
@SessionAttributes
public class ContactController {
	
	private @Autowired ContactsDAO contactsDAO;
	
	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact")
			Contact contact, BindingResult result) {

		System.out.println("First Name:" + contact.getFirstname() +
				"Last Name:" + contact.getLastname());
		contactsDAO.addContact(contact);
		return "redirect:listall";
	}
	@RequestMapping("/contacts")
    public ModelAndView showContacts() {
        return new ModelAndView("contacts", "command", new Contact());
    }
	@RequestMapping("/listcontacts")
    public ModelAndView listAll() {
        return new ModelAndView("list", "contacts", contactsDAO.listAll());
    }
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id){
		System.out.println("ContactController.delete() id " + id);
		return "redirect:contacts";
	}
}
