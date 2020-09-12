package com.swagger2.easyswagger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RexTest {
    private static final String DOC_START = "^\\s*(/\\*\\*)$";
    private static final String DOC_END = "^\\s*\\*/$";
    private static final String DOC_CLASS = "^.* *class .+$";
    private static final String DOC_METHOD_KT = "^\\s*fun (\\S*)\\(.*$";
    private static final String DOC_METHOD_JAVA = "\\s*public \\S+ (\\S*)\\(.*$";
    private static final String DOC_PARAMS = "^\\s*\\* @param\\s+(.*)$";
    private static final String DOC_FIELD_JAVA = "^\\s*(public|private) \\S+ (\\S+);\\s*//(\\S+)$";
    private static final String DOC_FIELD_KT = "^\\s*(var|val) (\\S+):.*//(\\S+)$";

    public static void main(String[] args) {
        String text = "class LocalController";
        text = "    public StudentVO getByNO(@RequestParam(\"stu_no\") String stuNo) {";
        System.out.println(text.matches(DOC_METHOD_JAVA));
        String mn = getRexValue(DOC_METHOD_JAVA, text);
        mn = fixMethodName(mn);
        System.out.println(mn);
    }

    private static String getRexValue(String pattern, String text) {
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        return matcher.find() ? matcher.group(1) : null;
    }

    private static String fixMethodName(String methodName) {
        int index = methodName.indexOf("(");
        if (index != -1) return methodName.substring(0, index);
        return methodName;
    }
}
