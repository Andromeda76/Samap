package com.example.samap.setting.config;


import java.util.Map;
import com.example.samap.setting.config.result.ObjectResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;



@Configuration
public class ConfigurationPlus {

  static String revertValue(EnumBehaviors[] enumConstants, Integer id) {
          StringBuilder enumName = new StringBuilder();
          Arrays.stream(enumConstants)
                  .filter(constant -> Objects.equals(id, constant.revertId()))
                  .findFirst()
                  .ifPresentOrElse(enumName::append, () -> {throw new IllegalArgumentException("ENUM_VALUE_NOT_FOUND");});

          return enumName.toString();
     }
  
}
