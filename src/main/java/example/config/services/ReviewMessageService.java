package example.config.services;

import example.config.models.dto.ReviewMessage;

public interface ReviewMessageService {
    void sendMessage(ReviewMessage reviewMessage);
}
