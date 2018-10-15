package com.SpringBootWebCrud.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SpringBootWebCrud.domain.Message;
import com.SpringBootWebCrud.service.MessageService;



@Controller
public class MsgBean {
	@Autowired
	private MessageService service;
	
	Message newMessage = new Message();
	
	public MsgBean(){}
	
	@GetMapping
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("list");
		List<Message> list = service.getAll();
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String newMessage(Model model){
		model.addAttribute("msg", new Message());
		return "insert";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String create(Message msg){
		service.insert(msg);
		System.out.println("Mensagen cadastrada!!");
		return "redirect:/";
	}
	
	@RequestMapping("/{id}/delete")
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Message> m = service.getById(id);
				if(m.isPresent()) {
					service.delete(m.get());
					redirectAttributes.addFlashAttribute("success", "Removido com sucesso");
				}
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "Erro!");
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/";
	}

	@GetMapping("/{id}/edit")
	public String edit(Model model, @PathVariable("id") Long id) {
		
		try {
			if (id != null) {
				Message m = service.getById(id).get();
				model.addAttribute("msg", m);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "/insert";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Message entity, BindingResult result, 
			             RedirectAttributes redirectAttributes) {
		try {
			service.insert(entity);
			redirectAttributes.addFlashAttribute("success", "Sucesso");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "Erro");
			e.printStackTrace();
		}
		return "redirect:/";
	}
}
