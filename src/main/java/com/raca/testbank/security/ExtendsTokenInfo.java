package com.raca.testbank.security;

import com.raca.testbank.models.User;
import com.raca.testbank.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ExtendsTokenInfo implements TokenEnhancer {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {

        User user = userService.findByUsername(oAuth2Authentication.getName());
        Map<String,Object> additionalInfo = new HashMap<>();
        additionalInfo.put("email",user.getEmail());
        additionalInfo.put("username",user.getUsername());
        additionalInfo.put("identification",user.getIdentification());
        additionalInfo.put("names",user.getNames());
        additionalInfo.put("lastnames",user.getLastnames());
        additionalInfo.put("telephone",user.getTelephone());
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);

        return oAuth2AccessToken;
    }

}
