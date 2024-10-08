package example.services;

import example.models.dto.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class STOMPService {

    private final SimpMessagingTemplate messagingTemplate;

    public Message notifyGroupMembers() {

        Message message = new Message();
        message.setContent("Bing chilling");
        message.setType("IMPORTANT");
        message.setSender("John Cena");

        messagingTemplate.convertAndSend("/topic/test", message);
        return message;
    }
}
