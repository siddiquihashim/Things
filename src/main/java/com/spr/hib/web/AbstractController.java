package com.spr.hib.web;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class AbstractController {

 /*   
    @InitBinder
    private void dateBinder(WebDataBinder binder) {
                //The date format to parse or output your dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM, yyy");
                //Create a new CustomDateEditor
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
                //Register it as custom editor for the Date type
        binder.registerCustomEditor(Date.class, editor);
    }*/
	
    //TODO investigate further these binders... i have used it with date pickers
    //TODO use an easy approach from fav questions on stack overflow
    @InitBinder
    public void binder(WebDataBinder binder) {
    	binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
    	    public void setAsText(String value) {
    	        try {
    	        	
    	            setValue(new SimpleDateFormat("dd MMM, yy").parse(value));
    	        } catch(ParseException e) {
    	            setValue(null);
    	        }
    	    }

    	    public String getAsText() {
    	    	String value = null;
    	    	if( getValue() != null ) {
					value = new SimpleDateFormat("dd MMM, yy").format((Date) getValue());//TODO check fi this works d M, y
    	        }
    	        return value;
    	    }        

    	});
    	
    }
}
