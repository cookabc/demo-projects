package com.chuangcius.demoagent.agent;

import java.lang.instrument.Instrumentation;
import java.util.logging.Logger;

/**
 * com.chuangcius.demoagent.JavaAgent
 *
 * @author chuangcius
 * @date 2022.12.06
 */
public class JavaAgent {

    private static final Logger log = Logger.getLogger(JavaAgent.class.getName());

    public static void premain(String args, Instrumentation instrumentation) {
        log.info("Starting Java Agent......");

        String className = "com.chuangcius.demoagent.app.JavaApplication";
        MyClassFileTransformer interceptingClassTransformer = new MyClassFileTransformer(className);
        instrumentation.addTransformer(interceptingClassTransformer);
    }
}
