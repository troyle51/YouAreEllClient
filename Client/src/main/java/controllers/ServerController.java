package controllers;


import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

//import spiffyUrlManipulator;

public class ServerController {
    private String rootURL = "http://zipcode.rocks:8085";
    private static ServerController svr = new ServerController();

    public ServerController(){

    }

    public static ServerController shared() {
        return svr;
    }

    public String idGet(String url) {
        String responseBody;
        try {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(rootURL + "/" + url);
            System.out.println("Executing request " + request.getRequestLine());

            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if(status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };

            responseBody = client.execute(request, responseHandler);
            System.out.println("-----------------------");
            //System.out.println(responseBody);
            client.close();
            //return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // url -> /ids/
        // send the server a get with url
        // return json from server

        return responseBody;
    }

    public String idPost(String url) {
        try {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(rootURL + "/" + url);

        //Post Headers
            httpPost.setHeader("Accept", "application/json"); //Accept : what you are expecting to receive
            httpPost.setHeader("Content-type", "application/json"); //Content-Type : what you are sending to the server


            //ObjectMapper mapper = new ObjectMapper();
            String json = "{ \"userid\" : \"-\", \"name\" : \"Testroy\", \"github\" : \"BMWHub\" }";


        StringEntity stringEntity = new StringEntity(json);
        httpPost.setEntity(stringEntity);

            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if(status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();;
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = client.execute(httpPost, responseHandler);
            System.out.println("-----------------------");
            System.out.println(responseBody);

            client.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // url -> /ids/
        // create json from Id
        // request
        // reply
        // return json


        return null;
    }
    public String idPut() {
        CloseableHttpClient client = HttpClients.createDefault();

        try {
        HttpPut httpPut = new HttpPut(rootURL);
        httpPut.setEntity(new StringEntity(String.valueOf(httpPut), ContentType.APPLICATION_JSON));
        CloseableHttpResponse response = client.execute(httpPut);

        response.close();
        client.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // url -> /ids/
        return null;
    }

//    public static void main(String[] args) {
//      svr.idGet("ids");
//      svr.idPost("ids");
//    }

}

// ServerController.shared.doGet()