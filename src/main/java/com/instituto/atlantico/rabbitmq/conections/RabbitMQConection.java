package com.instituto.atlantico.rabbitmq.conections;


import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.instituto.atlantico.rabbitmq.constantes.RabbitmqConstantes;

@Component
public class RabbitMQConection {
	
  private static final String NOME_EXCHANGE = "amq.direct";

  @Autowired
  private AmqpAdmin amqpAdmin;

  public RabbitMQConection(AmqpAdmin amqpAdmin){
    this.amqpAdmin = amqpAdmin;
  }

  private Queue fila(String nomeFila){
    return new Queue(nomeFila, true, false, false);
  }

  private DirectExchange trocaDireta() {
    return new DirectExchange(NOME_EXCHANGE);
  }

  private Binding relacionamento(Queue fila, DirectExchange troca){
    return new Binding(fila.getName(), Binding.DestinationType.QUEUE, troca.getName(), fila.getName(), null);
  }

  //está função é executada assim que nossa classe é instanciada pelo Spring
  @PostConstruct
  private void adiciona(){
	  
    Queue filaEmail = this.fila(RabbitmqConstantes.FILA_EMAIL);
    DirectExchange troca = this.trocaDireta();
    Binding ligacaoEmail   = this.relacionamento(filaEmail, troca);

    //Criando as filas no RabbitMQ
    this.amqpAdmin.declareQueue(filaEmail);
    this.amqpAdmin.declareExchange(troca);
    this.amqpAdmin.declareBinding(ligacaoEmail);
  }
}