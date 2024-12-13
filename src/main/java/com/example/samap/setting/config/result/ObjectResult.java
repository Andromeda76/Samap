package com.example.samap.setting.config.result;


import org.springframework.http.HttpEntity;


public interface ObjectResult {

    void setData(HttpEntity<Object> data);
    ObjectResult getResult();

}
