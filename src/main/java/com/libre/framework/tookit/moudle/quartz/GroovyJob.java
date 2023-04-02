package com.libre.framework.tookit.moudle.quartz;

import com.libre.framework.tookit.moudle.quartz.groovy.GroovyRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author: Libre
 * @Date: 2023/3/5 5:07 PM
 */
@Component
public class GroovyJob {

    public void execute() throws Exception {
        GroovyRunner groovyRunner = new GroovyRunner();

        String code = Files.readString(Paths.get("/Users/libre/code/java/libre/src/test/resources/Test.groovy"));
        groovyRunner.setCodeSource(code);

        groovyRunner.execute();
    }
}
