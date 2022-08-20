package com.juggernauts.todoapp.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Configuration
@ConfigurationProperties
@EnableConfigurationProperties
public class MailgunPropertiesConfig {
    private String mailgunUsername;
    private String mailgunPassword;
    private String mailgunUrl;
    private String mailgunFrom;
}
