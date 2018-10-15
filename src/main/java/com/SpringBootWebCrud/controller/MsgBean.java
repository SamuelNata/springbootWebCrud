package com.SpringBootWebCrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/msg")
public class MsgBean {
	//@Autowired
	//private MessageService service;
	
	//Message newMessage = new Message();
	
	public MsgBean(){}
	
	@GetMapping
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("lista");
		//Iterable<Message> list = service.getAll();
		//mv.addObject("list", list);
		return mv;
	}
	
	@GetMapping("/a")
	public String init() {
		return "lista";
	}
	
//	
//	public String insert(){
//		service.insert(newMessage);
//		newMessage = new Message();
//		return "list.xhtml";
//	}
//	
//	
//	public String delete(Message m) {
//		service.delete(m);
//		return "list.xhtml";
//	}
//	
////	public void loadEditMsg() {
////		String id;
////		FacesContext context = FacesContext.getCurrentInstance();
////		id = context.getExternalContext().getRequestParameterMap().get("id");
////		System.out.println("id: " + id);
////		if(id!=null && !id.equals("")) {
////			newMessage = service.getById(Integer.parseInt(id));
////		}
////	}
//	
//	public Message getNewMessage() {
//		return newMessage;
//	}
}
