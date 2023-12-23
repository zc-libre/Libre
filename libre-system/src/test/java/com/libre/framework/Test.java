package com.libre.framework;

import com.libre.toolkit.json.JsonUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream in = new FileInputStream(new File("/Users/libre/code/java/project/libre/index.json"));
        Map<String, Object> map = JsonUtil.readMap(in);
        System.out.println(map.get("content"));
    }

}
