package com.example.samap.setting.config.result;


import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class ObjectResultIMPL implements ObjectResult {

    private HttpEntity<Object> inputData;

    private HttpStatus status() {

        if (inputData == null){
            return HttpStatus.EXPECTATION_FAILED;
        }
        return null;
    }


    private String message() {
        return "";
    }


    private Object data() {

        return null;
    }

    @Override
    public void setData(HttpEntity<Object> inputData) {
        this.inputData = inputData;

    }

    @Override
    public ObjectResult getResult() {
        return null;
    }
}
