package com.SpringBootWebCrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SpringBootWebCrud.dao.MessageDao;
import com.SpringBootWebCrud.domain.Message;

@Service
@Transactional(readOnly=true)
public class MessageService {
	
	@Autowired
	MessageDao dao;
	
	public void insert(Message m) {
	    dao.save(m);
	}
	
	public Optional<Message> getById(Integer id) {
        return dao.findById(id);
	}
	
	public List<Message> getAll(){
        return dao.findAll();
	}

	public void delete(Message msg) {
		dao.delete(msg);
	}

}
