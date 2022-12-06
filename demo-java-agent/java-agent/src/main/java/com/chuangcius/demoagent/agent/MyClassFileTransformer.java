package com.chuangcius.demoagent.agent;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.runtime.Desc;
import javassist.scopedpool.ScopedClassPoolFactoryImpl;
import javassist.scopedpool.ScopedClassPoolRepositoryImpl;

import java.io.ByteArrayInputStream;
import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ClassFileTransformer
 *
 * @author chuangcius
 * @date 2022.12.06
 */
public class MyClassFileTransformer implements ClassFileTransformer {

    private static final Logger log = Logger.getLogger(MyClassFileTransformer.class.getName());

    private final ScopedClassPoolFactoryImpl scopedClassPoolFactory = new ScopedClassPoolFactoryImpl();

    private final String targetClassName;
    private final ClassPool rootPool;

    public MyClassFileTransformer(String targetClassName) {
        this.targetClassName = targetClassName;
        Desc.useContextClassLoader = true;
        rootPool = ClassPool.getDefault();
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        byte[] byteCode = classfileBuffer;

        String finalTargetClassName = this.targetClassName.replaceAll("\\.", "/");
        if (className.equals(finalTargetClassName)) {
            log.info("Transforming the class " + className);
            try {
                ClassPool classPool = scopedClassPoolFactory.create(loader, rootPool, ScopedClassPoolRepositoryImpl.getInstance());
                CtClass ctClass = classPool.makeClass(new ByteArrayInputStream(classfileBuffer));
                CtMethod[] methods = ctClass.getDeclaredMethods();
                for (CtMethod method : methods) {
                    if (method.getName().equals("main")) {
                        method.insertAfter("System.out.println(\"Logging using Agent\");");
                    }
                }
                byteCode = ctClass.toBytecode();
                ctClass.detach();
            } catch (Throwable ex) {
                log.log(Level.SEVERE, "Error in transforming the class: " + className, ex);
            }
        }
        return byteCode;
    }
}
