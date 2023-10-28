package com.authentication.AuthenticationService.service;

import com.authentication.AuthenticationService.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator{


    @Value("${jwt.expiration}")
    private Long jwtExpirationMillis;
    Map<String,String> jwtMap=new HashMap<>();

    @Override
    public Map<String, String> generateToken(User user) {
        String jwtToken;

        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + jwtExpirationMillis);

        jwtToken= Jwts.builder().setSubject(user.getUserEmail()).setIssuedAt(new Date()).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS256,"userkey").compact();
        jwtMap.put("token",jwtToken);
        jwtMap.put("message","token generated");
//        String isAdmin = "false";
//        if(user.getAdmin()==null){
//            isAdmin = "false";
//        }else{
//            isAdmin = "true";
//        }
//        jwtMap.put("isAdmin",isAdmin);
        return jwtMap;

    }
}
