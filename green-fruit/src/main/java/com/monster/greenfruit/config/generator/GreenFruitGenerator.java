package com.monster.greenfruit.config.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GreenFruitGenerator {


    public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException,
            SQLException, InterruptedException {

        List<String> warnings = new ArrayList<>();

        boolean overwrite = true;

        InputStream inputStream = GreenFruitGenerator.class.getResourceAsStream("/config/generatorConfig.xml");

        ConfigurationParser cp = new ConfigurationParser(warnings);

        Configuration config = cp.parseConfiguration(inputStream);

        inputStream.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);

        MyBatisGenerator generator = new MyBatisGenerator(config, callback, warnings);

        generator.generate(null);

        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
