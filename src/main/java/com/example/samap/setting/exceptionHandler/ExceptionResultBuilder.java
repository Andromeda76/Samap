package com.example.samap.setting.exceptionHandler;


import java.util.HashMap;
import java.util.Map;

import com.example.samap.setting.config.ConfigurationPlus;
import com.example.samap.setting.config.result.ObjectResult;
import org.aspectj.lang.JoinPoint;
import org.springframework.http.HttpEntity;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Aspect
@RestControllerAdvice
public class ExceptionResultBuilder {


    private final ObjectResult configModel;

    public ExceptionResultBuilder(ObjectResult configModel) {
        this.configModel = configModel;
    }


    @ResponseBody
    @AfterReturning(value = "execution(* com.example.samap.controller..*(..)))")
    public ObjectResult afterReturning(JoinPoint joinPoint) {
        Map<String, Object> data = new HashMap<>();
        HttpEntity<Object> httpEntity = new HttpEntity<>(data);

        data.put("message", joinPoint.getSignature().getName());
        data.put("result", joinPoint.getArgs());

        configModel.setData(httpEntity);
         return configModel.getResult();
    }


    @ResponseBody
    @AfterThrowing(value = "execution(* com.example.samap..*(..)))", throwing = "ex")
    public ObjectResult AfterThrowingAdvice(JoinPoint joinPoint, Exception ex){
        Map<String, Object> data = new HashMap<>();
        var signature = (MethodSignature) joinPoint.getSignature();
        HttpEntity<Object> httpEntity = new HttpEntity<>(data);

        data.put("DeclaringType", signature.getDeclaringType());
        data.put("ReturnType", signature.getReturnType());
        data.put("MethodName", signature.getName());
        data.put("ExceptionMessage", ex.getMessage());
        data.put("ExceptionCause", ex.getCause());
        data.put("Target", joinPoint.getTarget());
        data.put("Args", joinPoint.getArgs());

        configModel.setData(httpEntity);
        return configModel.getResult();
    }

}
