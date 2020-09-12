package com.swagger2.easyswagger;

import org.springframework.web.bind.annotation.RequestParam;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class TestController {

    public int pageData(
            String keyWord,
            @RequestParam("page_num")
                    int pageNum,
            int size,
            int pageSize
    ) {
        return -1;
    }

    public static void main(String[] args) {
        Class cls = TestController.class;
        Method[] methods = cls.getMethods();
        for (Method m : methods) {
            if ("pageData".equals(m.getName())) {
                Annotation[][] an = m.getParameterAnnotations();
                Parameter[] parameters = m.getParameters();
                for (int i = 0; i < an.length; i++) {
                    if (an[i].length == 0) continue;
                    RequestParam requestParam = findRequestParam(an[i]);
                    if (requestParam == null) continue;
                    String paramName = parameters[i].getName();
                    String apiName = requestParam.value();
                }
                break;
            }
        }
    }

    private static RequestParam findRequestParam(Annotation[] annotations) {
        for (Annotation an : annotations) {
            if (an instanceof RequestParam) {
                return (RequestParam) an;
            }
        }
        return null;
    }
}
