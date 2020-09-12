package com.swagger2.easyswagger.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 实体文档信息
 */
public class ModelDoc {
    public String description;
    public Map<String, String> fieldMap = new HashMap<>();   //属性文档信息
}
