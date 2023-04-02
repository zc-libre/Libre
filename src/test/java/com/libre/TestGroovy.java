package com.libre;

import com.libre.framework.tookit.moudle.quartz.groovy.GroovyRunner;


import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author: Libre
 * @Date: 2023/3/5 4:49 PM
 */
public class TestGroovy {

	public static void main(String[] args) throws Exception {
        GroovyRunner groovyRunner = new GroovyRunner();
        String code = Files.readString(Paths.get("/Users/libre/code/java/libre/src/test/resources/Test.groovy"));
        groovyRunner.setCodeSource(code);
        groovyRunner.setParam(null);

        groovyRunner.execute();
    }
}
