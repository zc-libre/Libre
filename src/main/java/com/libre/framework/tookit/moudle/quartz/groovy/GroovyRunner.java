package com.libre.framework.tookit.moudle.quartz.groovy;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import lombok.Data;

/**
 * @author: Libre
 * @Date: 2023/3/5 4:39 PM
 */
@Data
public class GroovyRunner {

    private String codeSource;

    private String param;

    public void execute() throws Exception {
        GroovyScriptFactory groovyScriptFactory = GroovyScriptFactory.getInstance();
        Script script = groovyScriptFactory.loadNewInstance(codeSource);

        String id = IdWorker.getIdStr();
        ScriptExecutor executor = new ScriptExecutor();
        executor.register(id, script);
        executor.run(id, param);
    }
}
