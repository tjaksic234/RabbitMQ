package example.services.impl;

import example.services.RabbitMQService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class RabbitMQServiceImpl implements RabbitMQService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void notifyGroupMembers() {

    }
}
