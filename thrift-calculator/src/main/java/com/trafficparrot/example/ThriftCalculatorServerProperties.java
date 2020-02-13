package com.trafficparrot.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ThriftCalculatorServerProperties {

    private static final String PROPERTIES_FILE = "thrift.calculator.server.properties";

    private final Properties properties;

    public ThriftCalculatorServerProperties(Properties properties) {
        this.properties = properties;
    }

    public static ThriftCalculatorServerProperties loadProperties() throws IOException {
        Properties properties = new Properties();
        try (InputStream inputStream = ThriftCalculatorServerProperties.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            properties.load(inputStream);
        }
        return new ThriftCalculatorServerProperties(properties);
    }

    public int nonTlsPort() {
        return Integer.parseInt(properties.getProperty("thrift.non.tls.port"));
    }
}
