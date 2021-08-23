package com.instituto.atlantico.consumidorEmail;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.instituto.atlantico.constantes.RabbitmqConstantes;
import com.instituto.atlantico.dto.EmailDTO;

@Component
@EnableRabbit
public class EmailConsumer {

	@RabbitListener(queues = RabbitmqConstantes.FILA_EMAIL)
	private void consumidor(EmailDTO email) {
		System.out.println(email.getIdEmail());

		System.out.println(email.getEmail());
		System.out.println("------------------------------------");
	}
}