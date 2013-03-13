package com.spr.hib.web;

import java.security.Principal;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spr.hib.domain.Tag;
import com.spr.hib.domain.Thing;
import com.spr.hib.service.PersonService;
import com.spr.hib.service.TagService;
import com.spr.hib.service.ThingService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/thing")
public class ThingController extends AbstractController {

	@Autowired
	ThingService thingService;
	@Autowired
	PersonService personService;
	@Autowired
	TagService tagService;

	private static final Logger logger = LoggerFactory.getLogger(ThingController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public void list(Locale locale, Model model) {
		model.addAttribute("allThings", thingService.findAllThings());
	}

	@RequestMapping(value = "/today", method = RequestMethod.GET)
	public String today(Locale locale, Model model) {
		model.addAttribute("allThings", thingService.findThingsForToday());
		return "thing/all";
	}

	@RequestMapping(value = "/tomorrow", method = RequestMethod.GET)
	public String tomorrow(Locale locale, Model model) {
		model.addAttribute("allThings", thingService.findThingsForTomorrow());
		return "thing/all";
	}

	@RequestMapping(value = "/thisweek", method = RequestMethod.GET)
	public String thisWeek(Locale locale, Model model) {
		model.addAttribute("allThings", thingService.findThingsForThisWeek());
		return "thing/all";
	}

	@RequestMapping(value = "/delete/{number}", method = RequestMethod.GET)
	public String delete(@PathVariable long number) {
		logger.info("delete: " + number);
		thingService.delete(number);
		return "redirect:/thing/all";
	}

	@RequestMapping(value = "/delete/{number}", method = RequestMethod.DELETE)
	public @ResponseBody
	String deleteAjax(@PathVariable long number) {
		thingService.delete(number);
		return "deleted by Ajax calll : " + number;
	}

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
	public String create(@Valid Thing thing, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
		System.out.println("insdie : create.POST" + httpServletRequest.getMethod());
		if (bindingResult.hasErrors()) {
			populateEditForm(uiModel, thing);
			return "thing/create";
		}
		uiModel.asMap().clear();
		thingService.persist(thing);
		return "redirect:/thing/all";// + encodeUrlPathSegment(thing.getId().toString(), httpServletRequest);
	}

	@RequestMapping(params = "form", produces = "text/html")
	public String createForm(Model uiModel) {
		System.out.println("insdie : create.GET");
		populateEditForm(uiModel, new Thing());
		return "thing/create";
	}

	private void populateEditForm(Model uiModel, Thing thing) {
		uiModel.addAttribute("thing", thing);
		uiModel.addAttribute("owners", personService.findAllPersons());
		uiModel.addAttribute("tags",   tagService.findAllTags());
		
	}

	@RequestMapping(value = "/{id}", produces = "text/html")
	public String show(@PathVariable("id") Long id, Model uiModel) {
		uiModel.addAttribute("thing", thingService.findThing(id));
		uiModel.addAttribute("itemId", id);
		return "thing/show";
	}

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
	public String update(@Valid Thing thing, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
		System.out.println("insdie : create.PUT" + httpServletRequest.getMethod() + thing.getId());
		if (bindingResult.hasErrors()) {
			populateEditForm(uiModel, thing);
			return "thing/update";
		}
		uiModel.asMap().clear();
		thingService.merge(thing);
		return "redirect:/thing/" + thing.getId();// + encodeUrlPathSegment(thing.getId().toString(), httpServletRequest);
	}

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
	public String updateForm(@PathVariable("id") Long id, Model uiModel) {
		populateEditForm(uiModel, thingService.findThing(id));
		return "thing/update";
	}

}