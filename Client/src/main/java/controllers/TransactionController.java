package controllers;

import models.Id;
import models.Message;

import java.util.List;

public class TransactionController {
    private String rootURL = "http://zipcode.rocks:8085";
    private MessageController msgCtrl;
    private IdController idCtrl;

    public TransactionController(MessageController m, IdController j) {
        this.msgCtrl = m;
        this.idCtrl = j;
    }

    public List<Id> getIds() {
        List<Id> ids = idCtrl.getIds();
        return ids;
    }
    public List<Message> getMsg() {
        List<Message> msg = msgCtrl.getMessages();
        return msg;
    }
    public String postId(String idtoRegister, String githubName) {
        Id tid = new Id(idtoRegister, githubName);
        tid = idCtrl.postId(tid);
        return ("Id registered.");
    }

    public String makecall(String s, String get, String s1) {
        ServerController svr = new ServerController();
        return svr.idGet(s);
    }
}
