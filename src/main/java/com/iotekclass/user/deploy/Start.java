package com.iotekclass.user.deploy;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * 本地启动provider项目，使用spring容器方式加载。
 * 具体用法：
 * 1.现在启动项中配置参数，以idea为例，配置一个java启动项(edit configuration中)
 * 2.在program arguments中配置好被容器加载的xml参数(一般是这三个
 *  classpath:conf/spring-context.xml
 *  classpath:dubbo/applicationContext-dubbo-provider.xml
 *  classpath:conf/spring-mybatis.xml
 *  classpath:conf/spring-service.xml
 *  )
 *  3.执行run或者debug就可以启动了
 */
public class Start {
    private static Logger log = LogManager.getLogger(Start.class);

    public static void main(String[] args)
            throws IOException {

//        com.alibaba.dubbo.container.Main.main(args);
        /* classpath:spring/dataSource.xml classpath:spring/spring-config.xml
         classpath:spring/service-provider.xml*/
        if (args == null || args.length <= 0) {
            log.error("no service configuration file");
            return;
        }

        try {
            File log4jProp = new
                    File(Start.class.getResource("/log4j.properties").toURI());
            System.out.println("[INIT] log4j.properties path is [" +
                    log4jProp.getCanonicalPath() + "]");
            PropertyConfigurator.configureAndWatch(log4jProp.getCanonicalPath());

        } catch (URISyntaxException e) {
            System.err.println("log4j配置异常!");
            e.printStackTrace();
        }

        try {
            ClassPathXmlApplicationContext context = new
                    ClassPathXmlApplicationContext(args);
            context.start();
        } catch (Exception e) {
            log.error("can not start service server", e);
            return;
        }

        log.info("service server started successfully");

        synchronized (Start.class) {
            while (true) {
                try {
                    Start.class.wait();
                } catch (InterruptedException e) {
                    log.info("server thread was interupted", e);
                }
            }
        }
    }
}
