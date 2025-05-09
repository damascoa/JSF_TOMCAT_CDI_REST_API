package br.com.exemplo.config;

import javax.enterprise.inject.spi.CDI;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CDIStartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // ⚠️ REMOVER o uso de @Inject — não funciona aqui no Tomcat
        CDI.current().select(StartupBean.class).get(); // força instanciamento CDI
        System.out.println("✅ StartupBean forçado via CDI.current()");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {}
}
