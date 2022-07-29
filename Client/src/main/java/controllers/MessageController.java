package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.Message;

public class MessageController {
    private List<Message> msglist;
    private Message[] msgs;
    private ServerController svr = ServerController.shared();

    private HashSet<Message> messagesSeen;
    // why a HashSet??

    private Message message;

    public List<Message> getMessages() {
        if(this.msglist == null) {
            String resultJSON = null;

            resultJSON = svr.idGet("messages");
            final ObjectMapper objectMapper = new ObjectMapper();
            try {
                this.msgs = objectMapper.readValue(resultJSON, Message[].class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            this.msglist = (List<Message>) Arrays.asList(this.msgs);
        }

        return this.msglist;
    }
    public ArrayList<Message> getMessagesForId(Id Id) {
        return new ArrayList<>();
    }
    public Message getMessageForSequence(String seq) {
        return null;
    }
    public ArrayList<Message> getMessagesFromFriend(Id myId, Id friendId) {
        return new ArrayList<>();
    }

    public Message postMessage(Id myId, Id toId, Message msg) {
        return null;
    }
 
}