package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import youareell.User;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
//import spiffyUrlManipulator;

public class ServerController {
    private String rootURL = "http://zipcode.rocks:8085";
    private ServerController svr = new ServerController();

    public ServerController(){

    }

    public ServerController shared() {
        return svr;
    }

    public String idGet(String url) {
        CloseableHttpClient client = HttpClients.createDefault();
        String results = "";

        try {
        HttpGet request = new HttpGet(rootURL + "/" + url);
        CloseableHttpResponse response = client.execute(request);
        HttpEntity entity = response.getEntity();

        if(response.getStatusLine().getStatusCode() != 200){
            System.out.println("Connection is bad" + response.getStatusLine().getStatusCode());
        }
        results = EntityUtils.toString(entity);
            System.out.println(results);

            response.close();
            client.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // url -> /ids/
        // send the server a get with url
        // return json from server

        return results;
    }
    ObjectMapper mapper = new ObjectMapper();
    User user = createDummyUser();
    Id id = new Id();
    public String idPost() {
        CloseableHttpClient client = HttpClients.createDefault();
        String results = "";

        try {
        HttpPost httpPost = new HttpPost(rootURL);


            mapper.writeValue(new File("scratch.json"), user);
            mapper.writeValueAsString(user);
            String jsonInString;

            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
            System.out.println(jsonInString);

        StringEntity json = new StringEntity(mapper.writeValueAsString(user), ContentType.APPLICATION_JSON);
        httpPost.setEntity(json);
        CloseableHttpResponse response = client.execute(httpPost);
        HttpEntity entity = response.getEntity();

//        if(response.getStatusLine().getStatusCode() != 200){
//            System.out.println("Connection is bad" + response.getStatusLine().getStatusCode());
//            return;
//        }
            response.close();
            client.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // url -> /ids/
        // create json from Id
        // request
        // reply
        // return json
        return results;
    }
    public String idPut() {
        CloseableHttpClient client = HttpClients.createDefault();
        String results = "";

        try {
        HttpPut httpPut = new HttpPut(rootURL);
        httpPut.setEntity(new StringEntity(String.valueOf(user), ContentType.APPLICATION_JSON));
        CloseableHttpResponse response = client.execute(httpPut);

        response.close();
        client.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // url -> /ids/
        return results;
    }

    private static User createDummyUser(){
        User user = new User();

        user.setName("Troy");
        user.setAge(33);

        List<String> msg = new ArrayList<String>();
        msg.add("Hello Jackson 1");
        msg.add("Hello Jackson 2");
        msg.add("Hello Jackson 3");

        user.setMessages(msg);

        return user;
    }

}

// ServerController.shared.doGet()