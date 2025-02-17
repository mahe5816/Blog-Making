package com.example.log.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.engine.internal.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.log.repository.blo;
import com.example.log.repository.bloo;
import com.example.log.repository.entry;
import com.example.log.repository.user;

import jakarta.servlet.http.HttpSession;

//import com.repp.user;

@Controller
public class HomeController {
	
	@Autowired
	public user u;
	
	@GetMapping("/home")
	public String rr() {
		return "login.html";
	}
	@GetMapping("/register")
	public String cc() {
		return "register.html";
	}
	@GetMapping("/maps")
	public String mmm() {
		return "maps.html";
	}
	@PostMapping("/reg")
	public String pp(entry per,@RequestParam("fname") String fname,@RequestParam("email") String email,@RequestParam("pass1") String pass1,@RequestParam("pass2") String pass2) {
		if(!pass1.equals(pass2)) {
			return "redirect:/register?error=Passwords do not match";
		}
		per.setEmail(email);
		per.setFname(fname);
		per.setPass(pass1);
		u.save(per);
		System.out.print(email+" "+fname+" "+pass1+" "+pass2);
		return "redirect:/home";
	}
	@PostMapping("/find")
	public String findByEmail(@RequestParam("email") String email,@RequestParam("password") String pass,Model m,HttpSession session) {
        Optional<entry> user = u.findByEmail(email);
        if(user.isPresent()) {
        	if(!user.get().getPass().equals(pass))
        		return "redirect:/home?error=Wrong Password";
        	else {
        	entry ee=user.get();
        	session.setAttribute("uu", ee);
        	//m.addAttribute("uu", ee);
        	return "welcome";
        	}
        }
        else {
        	return "redirect:/home?error=User not found";
        }
    }
	@PostMapping("/blog")
	public String bb() {
		return "blog.html";
	}
	@Autowired
	public blo b;
	@PostMapping("/bbbb")
	public String rrr(/*@ModelAttribute("uu") entry uu,*/bloo bb,@RequestParam("theme") String name,@RequestParam("content") String con,Model m,HttpSession session) {
		entry uu=(entry) session.getAttribute("uu");
		bb.setIdd(uu.getId());
		bb.setEmail(uu.getEmail());
		bb.setTheme(name);
		bb.setContent(con);
		b.save(bb);
		m.addAttribute("uu", uu);
		return "welcome";
	}
	@PostMapping("/fetch")
	public String ll(HttpSession session) {
		entry uu=(entry) session.getAttribute("uu");
		List<bloo> ll=b.findByIdd(uu.getId());
		/*for(bloo l:ll) {
			System.out.print(l);
		}*/
	//	bb.setIdd(uu.getId());
		session.setAttribute("ll", ll);
		return "all";
	}
	@PostMapping("/fetcgbyid")
	public String fett(HttpSession session,@RequestParam("id") int id) {
		List<bloo> ll=b.findByIdd(id);
		session.setAttribute("ll", ll);
		return "all";
	}
	
	@PostMapping("/logout")
	public String log(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}
	
}
