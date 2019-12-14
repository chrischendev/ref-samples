package com.chris.oauth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringbootOauthDemoApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void token_password() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("username", "admin");
        params.add("password", "admin");
        params.add("scope", "scope1 scope2");
        String response = restTemplate.withBasicAuth("clientId", "clientSecret").
                postForObject("/oauth/token", params, String.class);
        System.out.println(response);
    }

    @Test
    public void token_client() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "client_credentials");
        String response = restTemplate.withBasicAuth("clientId", "clientSecret").
                postForObject("/oauth/token", params, String.class);
        System.out.println(response);
    }

    @Test
    public void token_code() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("code", "KpXcl2");
        String response = restTemplate.withBasicAuth("clientId", "clientSecret").postForObject("/oauth/token", params, String.class);
        System.out.println(response);
    }
    //???
    @Test
    public void token_refresh() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "refresh_token");
        params.add("refresh_token", "8dc19c8f-30a5-4652-b1e9-07ef309459fa");
        String response = restTemplate.withBasicAuth("clientId", "clientSecret").
                postForObject("/oauth/token", params, String.class);
        System.out.println(response);
    }


}
