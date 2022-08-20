package com.juggernauts.todoapp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;


public class PropertiesFileLoaderServiceTest {
    private PropertiesFileLoaderService propertiesFileLoaderService;

    @Before
    public void init() {
        propertiesFileLoaderService = new PropertiesFileLoaderService();
    }

    @Test
    public void givenValidFilePath_whenGetProperties_thenReturnProperties() {
        Properties props = propertiesFileLoaderService.getProperties("src/test/resources/test.properties");
        assertEquals("daisy", props.getProperty("cat.daisy.name", ""));
        assertEquals("benedict", props.getProperty("cat.benedict.name", ""));
        assertEquals("francis", props.getProperty("cat.francis.name", ""));
    }

    @Test
    public void givenInvalidFilePath_whenGetProperties_thenReturnEmptyProperties() {
        Properties props = propertiesFileLoaderService.getProperties("invalid/path");
        assertEquals(new Properties(), props);
    }

    @Test
    public void givenValidClassPathResource_whenGetProperties_thenReturnProperties() {
        ClassPathResource resource = new ClassPathResource("test.properties");
        Properties props = propertiesFileLoaderService.getProperties(resource);
        assertEquals("daisy", props.getProperty("cat.daisy.name", ""));
        assertEquals("benedict", props.getProperty("cat.benedict.name", ""));
        assertEquals("francis", props.getProperty("cat.francis.name", ""));
    }

    @Test
    public void givenInvalidClassPathResource_whenGetProperties_thenReturnEmptyProperties() {
        ClassPathResource resource = new ClassPathResource("invalid.properties");
        Properties props = propertiesFileLoaderService.getProperties(resource);
        assertEquals(new Properties(), props);
    }
}
