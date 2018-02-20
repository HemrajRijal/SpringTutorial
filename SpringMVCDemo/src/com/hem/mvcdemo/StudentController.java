package com.hem.mvcdemo;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Author: hemraj
 * Date:  2/3/18.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

//    Add an init binder to convert trim input string
//    remove leading trailing whitespace
//    resolve issue for validation

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor editor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, editor);

    }

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        // create student object
        Student student = new Student();

        // add student object to the model
        model.addAttribute("student", student);

        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("student") Student theStudent, BindingResult theBindingResult) {

//        log the data
        if (theBindingResult.hasErrors()) {

            System.out.println("Binding Result-------->" + theBindingResult);
            return "student-form";
        } else {
            return "student-confirmation";
        }
    }
}
