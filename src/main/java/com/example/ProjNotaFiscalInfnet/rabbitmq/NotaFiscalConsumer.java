package com.example.ProjNotaFiscalInfnet.rabbitmq;

import com.example.ProjNotaFiscalInfnet.model.NotaFiscal;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotaFiscalConsumer {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @RabbitListener(queues = {"nota-fiscal-ok.queue"})
    public void received(@Payload NotaFiscal notaFiscal){
        // TUDO GRABAR com STATUS de CONCLUIDO

    }

}

