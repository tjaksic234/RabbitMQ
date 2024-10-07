package example.api;

import example.models.dto.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Slf4j
public class WebSocketController {
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message handleMessage(@RequestBody Message message) {
        log.info("Received message: {}", message);
        log.info("Sending message with rabbitMQ");
        return message;
    }
}
