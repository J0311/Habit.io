package com.juggernauts.todoapp.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

/**
 * A service for loading properties from a file path
 * @author Jacob
 */
@Service
public class PropertiesFileLoaderService {
    private static final Logger logger = LogManager.getLogger(PropertiesFileLoaderService.class);

    /**
     * Gets the properties from a file path
     * @param filePath The path to the properties file
     * @return The properties in the file or an empty properties object if file not found
     */
    public Properties getProperties(String filePath) {
        try (InputStream input = Files.newInputStream(Paths.get(filePath))) {
            Properties prop = new Properties();
            prop.load(input);
            return prop;
        } catch (IOException ex) {
            logger.warn("could not open {}", filePath);
            return new Properties();
        }
    }
    /**
     * Gets the properties from a class path resource
     * @param resource The resource
     * @return The properties in the resource or an empty properties object if resource could not be opened
     */
    public Properties getProperties(ClassPathResource resource) {
        try (InputStream input = resource.getInputStream()) {
            Properties prop = new Properties();
            prop.load(input);
            return prop;
        } catch (IOException ex) {
            logger.warn("could not open {}", resource.getPath());
            return new Properties();
        }
    }
}
