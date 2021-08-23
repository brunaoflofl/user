package com.instituto.atlantico.consumidorEmail;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.instituto.atlantico.constantes.RabbitmqConstantes;
import com.instituto.atlantico.dto.EmailDTO;

@Component
@EnableRabbit
public class EmailConsumer {

	@Autowired
	private ObjectMapper objectMapper;

	@RabbitListener(queues = RabbitmqConstantes.FILA_EMAIL)
	private void consumidor(String mensagem) throws JsonProcessingException {

		EmailDTO emailDTO = this.objectMapper.readValue(mensagem, EmailDTO.class);
		System.out.println("Consumindo ...");

		System.out.println("Email ID: " + emailDTO.getIdEmail());

		System.out.println("Email: " + emailDTO.getEmail());
		System.out.println("------------------------------------");
	}
}