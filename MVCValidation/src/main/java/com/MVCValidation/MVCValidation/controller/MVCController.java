package com.MVCValidation.MVCValidation.controller;

import java.time.LocalDateTime;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.MVCValidation.MVCValidation.model.Student;
import com.MVCValidation.MVCValidation.model.StudentWithCustomValidation;

@Controller
public class MVCController {

	@GetMapping("/")
	public String getHomePage(Model model)
	{
		model.addAttribute("date",LocalDateTime.now());
		model.addAttribute("student", new Student());
		return "index";
	}
	
	@PostMapping("/saveStudent")
	public String getStudentData(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult)
	{
		System.out.println(student);
		if(bindingResult.hasErrors())
		{
			return "studentform";
		}
		return "studentdata";
	}
	
	@GetMapping("/studentForm")
	public String getStudentForm(Model model)
	{
		model.addAttribute("student", new Student());
		return "studentform";
	}
	
	/*******************************************************************************************************/
	
	@GetMapping("/studentForm-custannotation")
	public String getStudentFormWithCustomAnnotation(Model model)
	{
		model.addAttribute("student", new StudentWithCustomValidation());
		return "studentformcustval";
	}
	
	@PostMapping("/saveStudentData")
	public String getStudentData(@Valid @ModelAttribute("student") StudentWithCustomValidation student, BindingResult bindingResult)
	{
		System.out.println(student);
		if(bindingResult.hasErrors())
		{
			return "studentformcustval";
		}
		return "studentdatacustval";
	}
	
}
