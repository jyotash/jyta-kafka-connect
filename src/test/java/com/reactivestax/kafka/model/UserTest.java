package com.reactivestax.kafka.model;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class UserTest {

    String userStr = "{\n" +
            "\"login\": \"jyotash\",\n" +
            "\"id\": 20851561,\n" +
            "\"avatar_url\": \"https://avatars3.githubusercontent.com/u/20851561?v=3\",\n" +
            "\"gravatar_id\": \"\",\n" +
            "\"url\": \"https://api.github.com/users/jyotash\",\n" +
            "\"html_url\": \"https://github.com/jyotash\",\n" +
            "\"followers_url\": \"https://api.github.com/users/jyotash/followers\",\n" +
            "\"following_url\": \"https://api.github.com/users/jyotash/following{/other_user}\",\n" +
            "\"gists_url\": \"https://api.github.com/users/jyotash/gists{/gist_id}\",\n" +
            "\"starred_url\": \"https://api.github.com/users/jyotash/starred{/owner}{/repo}\",\n" +
            "\"subscriptions_url\": \"https://api.github.com/users/jyotash/subscriptions\",\n" +
            "\"organizations_url\": \"https://api.github.com/users/jyotash/orgs\",\n" +
            "\"repos_url\": \"https://api.github.com/users/jyotash/repos\",\n" +
            "\"events_url\": \"https://api.github.com/users/jyotash/events{/privacy}\",\n" +
            "\"received_events_url\": \"https://api.github.com/users/jyotash/received_events\",\n" +
            "\"type\": \"User\",\n" +
            "\"site_admin\": false\n" +
            "}";

    private JSONObject userJson = new JSONObject(userStr);


    @Test
    public void canParseJson(){
        User user = User.fromJson(userJson);
        assertEquals(user.getId(),(Integer) 20851561);
        assertEquals(user.getUrl(), "https://api.github.com/users/jyotash");
        assertEquals(user.getLogin(), "jyotash");
    }
}
