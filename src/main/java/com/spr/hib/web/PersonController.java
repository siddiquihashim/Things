package com.spr.hib.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spr.hib.domain.Person;
import com.spr.hib.exceptions.EmailAlreadyExistException;
import com.spr.hib.service.PersonService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/persons")
public class PersonController extends AbstractController{

	@Autowired
	PersonService personService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public void list(Locale locale, Model model) {
		model.addAttribute("allPersons", personService.findAllPersons());
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
	public String create(@Valid Person person, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
		System.out.println("insdie : Person#create.POST" + httpServletRequest.getMethod());
		if (bindingResult.hasErrors()) {
			populateEditForm(uiModel, person);
			return "persons/create";
		}
		
		try{
			personService.persist(person);
		}catch(EmailAlreadyExistException e){ //TODO find a better way of doing it
			ObjectError error = new ObjectError("", "Email already registered with another user");
			bindingResult.addError(error );
			populateEditForm(uiModel, person);
			return "persons/create";
		}
		uiModel.asMap().clear();
		return "redirect:/persons/"+person.getId();// + encodeUrlPathSegment(thing.getId().toString(), httpServletRequest);
	}

	@RequestMapping(params = "form", produces = "text/html")
	public String createForm(Model uiModel) {
		populateEditForm(uiModel, new Person());
		return "persons/create";
	}

	private void populateEditForm(Model uiModel, Person person) {
		uiModel.addAttribute("person", person);
	}
	
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("person", personService.findPerson(id));
        uiModel.addAttribute("personId", id);
        return "persons/show";
    }
    
    @ExceptionHandler
    public String emailExistsException( EmailAlreadyExistException e){
    	//TODO code for handling exception
    	return null;
    }
    
    
}
