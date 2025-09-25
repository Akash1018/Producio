package com.producio.backend.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.producio.backend.dto.BidDTO;
import com.producio.backend.model.NotificationMessage;

@Controller
public class ChatController {
    
    @MessageMapping("/bid") // maps to /app/notify
    @SendTo("/topic/notifications") // sends to all subscribers
    public NotificationMessage send(BidDTO message) {
        System.out.println(">>>> got message: " + message);
        return new NotificationMessage("🔔 Server says: " + message);
    }
}
