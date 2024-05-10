package com.github.jonashonecker.springweb02;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageController {
    List<Message> messages = new ArrayList<>();

    @PostMapping("/messages")
    public Message postMessage(@RequestBody Message message) {
        messages.add(message);
        return message;
    }

    @GetMapping("/messages")
    public List<Message> getMessages() {
        return messages;
    }

    @DeleteMapping("/messages/{id}")
    public Message deleteMessage(@PathVariable String id) {
        Message messageToDelete = null;
        for (Message m : messages) {
            if (id.equals(m.getId())) {
                messageToDelete = m;
                break;
            }
        }
        if (messageToDelete != null) {
            messages.remove(messageToDelete);
        }
        return messageToDelete;
    }
}
