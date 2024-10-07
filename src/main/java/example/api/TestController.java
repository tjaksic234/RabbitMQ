package example.api;

import example.models.dto.Message;
import example.services.STOMPService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("api")
@AllArgsConstructor
public class TestController {

    private final SimpMessagingTemplate messagingTemplate;

    private final STOMPService stompService;

    @GetMapping("send")
    public String sendTestMessage(@RequestParam(value = "content", defaultValue = "Hello, RabbitMQ!") String content) {
        Message message = new Message("CHAT", content, "TestUser");
        messagingTemplate.convertAndSend("/topic/messages", message);
        return "Test message sent: " + content;
    }

    @GetMapping("send-to-queue")
    public String sendTestMessageToQueue(
            @RequestParam(value = "queue", defaultValue = "testQueue") String queueName,
            @RequestParam(value = "content", defaultValue = "Hello, Queue!") String content) {
        Message message = new Message("CHAT", content, "TestUser");
        messagingTemplate.convertAndSend("/queue/" + queueName, message);
        return "Test message sent to queue " + queueName + ": " + content;
    }

    //? this is a mock get request example which could be used in real project
    @GetMapping("send-to-topic")
    public ResponseEntity<Message> sendMessageToTopic() {
        return ResponseEntity.ok(stompService.notifyGroupMembers());
    }
}
