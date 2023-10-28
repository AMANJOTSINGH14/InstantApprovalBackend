package com.project.LoanApplicationService.config;


import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProjectConfig {
    @Bean
    public Cloudinary getCloudinary(){

        // Open Account in Cloudinary and add below credential according to that
        Map map = new HashMap();
        map.put("cloud_name",  "dduwnfkuu");
        map.put("api_key", "797279542565595");
        map.put("api_secret","kV8vJdZGJVQX7sRHXA550eS0VV4");
        map.put("secure",true);
        return new Cloudinary(
         map
        );
    }
}
