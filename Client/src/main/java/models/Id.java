package models;

import com.fasterxml.jackson.annotation.*;

/*
 * POJO for an Id object
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "userid",
        "name",
        "github"
})

public class Id {

    @JsonProperty("userid")
    private String userid;
    @JsonIgnoreProperties
    private String name;

    private String github;


    public Id (String name, String githubId) {
    }

    public Id (){}

    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGithub() {
        return github;
    }
    public void setGithub(String github) {
        this.github = github;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.github + ") ";
    }
}