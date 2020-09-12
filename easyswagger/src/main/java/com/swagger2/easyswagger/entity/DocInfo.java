package com.swagger2.easyswagger.entity;

import java.util.HashMap;
import java.util.Map;

public class DocInfo {
    public Map<String, com.swagger2.easyswagger.entity.ApiDoc> apiMap = new HashMap<>();
    public Map<String, com.swagger2.easyswagger.entity.ModelDoc> modelMap = new HashMap<>();
}
