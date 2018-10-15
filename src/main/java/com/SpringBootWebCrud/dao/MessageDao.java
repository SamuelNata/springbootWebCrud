package com.SpringBootWebCrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootWebCrud.domain.Message;

@Repository
public interface MessageDao extends JpaRepository<Message, Long>{	}
