package com.instituto.atlantico.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.instituto.atlantico.constantes.RabbitmqConstantes;
import com.instituto.atlantico.dto.EmailDTO;
import com.instituto.atlantico.service.impl.RabbitmqService;


@Controller
public class EmailController {
	
	@Autowired
	private RabbitmqService service;
	
	@PostMapping
	@RequestMapping("/email")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity enviarEmail(@RequestBody @Valid EmailDTO email) throws Exception {
		this.service.enviaMensagem(RabbitmqConstantes.FILA_EMAIL, email);
		return new ResponseEntity(HttpStatus.OK);

	}		


}
