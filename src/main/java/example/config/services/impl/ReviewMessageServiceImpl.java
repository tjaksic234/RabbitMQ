package example.config.services.impl;

import example.config.models.dto.ReviewMessage;
import example.config.services.ReviewMessageService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewMessageServiceImpl implements ReviewMessageService {
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(ReviewMessage reviewMessage) {
        rabbitTemplate.convertAndSend("companyRatingQueue", reviewMessage);
    }
}
