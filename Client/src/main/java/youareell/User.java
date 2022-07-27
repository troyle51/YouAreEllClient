package youareell;

import controllers.ServerController;

import java.io.UnsupportedEncodingException;

import java.util.List;

public class User {

    static ServerController serverController = new ServerController();
    public static void main(String[] args) throws UnsupportedEncodingException {
        serverController.idGet("ids");
        serverController.idPost();
        serverController.idPut();
    }
    private String name;
    private int age;
    private List<String> messages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
