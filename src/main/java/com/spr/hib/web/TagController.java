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
import com.spr.hib.domain.Tag;
import com.spr.hib.service.PersonService;
import com.spr.hib.service.TagService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/tags")
public class TagController extends AbstractController {

	@Autowired
	TagService tagService;
	@Autowired
	PersonService personService;

	private static final Logger logger = LoggerFactory.getLogger(TagController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public void list(Locale locale, Model model) {
		model.addAttribute("allTags", tagService.findAllTags());
	}

	@RequestMapping(value = "/delete/{number}", method = RequestMethod.GET) //TODO Change it to delete
	public String delete(@PathVariable long number) {
		logger.info("delete: " + number);
		tagService.delete(number);
		return "redirect:/tags/all";
	}

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
	public String create(@Valid Tag tag, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
		System.out.println("insdie : create.POST" + httpServletRequest.getMethod());
		if (bindingResult.hasErrors()) {
			populateEditForm(uiModel, tag);
			return "tags/create";
		}
		uiModel.asMap().clear();
		tagService.persist(tag);
		return "redirect:/tags/all";// + encodeUrlPathSegment(tag.getId().toString(), httpServletRequest);
	}

	@RequestMapping(params = "form", produces = "text/html")
	public String createForm(Model uiModel) {
		populateEditForm(uiModel, new Tag());
		return "tags/create";
	}

	private void populateEditForm(Model uiModel, Tag tag) {
		uiModel.addAttribute("tag", tag);
		uiModel.addAttribute("owners", personService.findAllPersons());
	}

	@RequestMapping(value = "/{id}", produces = "text/html")
	public String show(@PathVariable("id") Long id, Model uiModel) {
		uiModel.addAttribute("tag", tagService.findTag(id));
		uiModel.addAttribute("itemId", id);
		return "tags/show";
	}

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
	public String update(@Valid Tag tag, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
		System.out.println("insdie : create.PUT" + httpServletRequest.getMethod() + tag.getId());
		if (bindingResult.hasErrors()) {
			populateEditForm(uiModel, tag);
			return "tags/update";
		}
		uiModel.asMap().clear();
		tagService.merge(tag);
		return "redirect:/tags/" + tag.getId();// + encodeUrlPathSegment(tag.getId().toString(), httpServletRequest);
	}

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
	public String updateForm(@PathVariable("id") Long id, Model uiModel) {
		populateEditForm(uiModel, tagService.findTag(id));
		return "tags/update";
	}

}