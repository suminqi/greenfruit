package com.monster.greenfruit.config;


import com.monster.greenfruit.dao.ToolMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackageClasses = {ToolMapper.class})
public class MapperConfig {
}
