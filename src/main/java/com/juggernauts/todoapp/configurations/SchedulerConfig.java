package com.juggernauts.todoapp.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ComponentScan("com.juggernauts.todoapp.components")
public class SchedulerConfig { }
