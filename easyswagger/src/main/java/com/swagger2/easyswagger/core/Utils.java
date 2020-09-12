package com.swagger2.easyswagger.core;

import org.springframework.web.bind.annotation.RequestParam;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Map;

class Utils {

    /**
     * 处理RequestParam注解
     */
    static void processRequestParam(Map<String, String> params, String controllerCls, String methodName) {
        try {
            Class cls = Class.forName(controllerCls);
            Method[] methods = cls.getMethods();
            for (Method m : methods) {
                if (methodName.equals(m.getName())) {
                    Annotation[][] an = m.getParameterAnnotations();
                    Parameter[] parameters = m.getParameters();
                    for (int i = 0; i < an.length; i++) {
                        if (an[i].length == 0) continue;
                        RequestParam requestParam = findRequestParam(an[i]);
                        if (requestParam == null) continue;
                        String paramName = parameters[i].getName();
                        String apiName = requestParam.value();
                        String paramDesc = params.get(paramName);
                        params.put(apiName, paramDesc);
                    }
                    break;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static RequestParam findRequestParam(Annotation[] annotations) {
        for (Annotation an : annotations) {
            if (an instanceof RequestParam) return (RequestParam) an;
        }
        return null;
    }
}
