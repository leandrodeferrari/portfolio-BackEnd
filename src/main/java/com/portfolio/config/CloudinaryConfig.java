package com.portfolio.config;

import com.cloudinary.Cloudinary;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Value("${app.cloudinary.api.key}")
    private String cloudinaryKey;

    @Value("${app.cloudinary.api.secret}")
    private String cloudinaryApiSecret;

    @Value("${app.cloudinary.name}")
    private String cloudinaryName;

    @Bean
    public Cloudinary cloudinary() {
        String cloudinaryUrl = "cloudinary://"
                .concat(this.cloudinaryKey)
                .concat(":").concat(this.cloudinaryApiSecret)
                .concat("@").concat(this.cloudinaryName);

        return new Cloudinary(cloudinaryUrl);
    }

}


