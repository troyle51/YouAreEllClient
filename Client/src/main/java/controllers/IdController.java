package controllers;

import java.util.Arrays;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import java.net.*;
import java.util.List;

public class IdController {
    URL url;
    //private HashMap<String, Id> allIds;
    //private ObjectMapper mapper = new ObjectMapper();
    private List<Id> idlist;
    private ServerController svr = ServerController.shared();
    private Id[] myId;

    public IdController(){
//        url = new URL("http://zipcode.rocks:8085");
    }

    public Id[] getMyId(){
        return myId;
    }
    public List<Id> getIds() {

            if(this.idlist == null) {
                String resultJSON = null;
                resultJSON = svr.idGet("ids");
                final ObjectMapper objectMapper = new ObjectMapper();
                try {
                    this.myId = objectMapper.readValue(resultJSON, Id[].class);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
                this.idlist = (List<Id>) Arrays.asList(this.myId);
            }
        return this.idlist;
    }

        public Id postId(Id id) {
        // create json from id
        // call server, get json result Or error
        // result json to Id obj


        return null;
    }

    public Id putId(Id id) {
        return null;
    }
 
}