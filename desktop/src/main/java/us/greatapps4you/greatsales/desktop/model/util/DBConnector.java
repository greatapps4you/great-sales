package us.greatapps4you.greatsales.desktop.model.util;

import us.greatapps4you.greatsales.desktop.common.FileUtil;
import us.greatapps4you.greatsales.desktop.model.ConfigModel;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;

public class DBConnector {
    public DBConnector() {
    }

    public static void main(String[] args) {
        buildSessionFactory();
    }

    public static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        Properties prop = (new ConfigModel()).carregar(FileUtil.getHome() + "cfg/config.xml");
        String host = prop.getProperty("host");
        String port = prop.getProperty("port");
        String dbPath = prop.getProperty("db-path");
        String database = prop.getProperty("database");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:tcp://" + host + ":" + port + "/" + dbPath + database);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.username", "greatsoft");
        configuration.setProperty("hibernate.connection.password", "Wort12");
        configuration.setProperty("hibernate.connection.pool_size", "10000");
        configuration.setProperty("hibernate.current_session_context_class", "thread");
        configuration.setProperty("hbm2ddl.auto", "update");
        configuration.setProperty("show_sql", "true");
        showInfo(configuration);
        generateSchema(configuration);
        return configuration.buildSessionFactory();
    }

    private static void generateSchema(Configuration configuration) {
        SchemaUpdate se = new SchemaUpdate(configuration);
        se.execute(true, true);
    }

    private static void showInfo(Configuration configuration) {
        System.out.println("Dialect: " + configuration.getProperty("hibernate.dialect"));
        System.out.println("URL: " + configuration.getProperty("hibernate.connection.url"));
        System.out.println("User: " + configuration.getProperty("hibernate.connection.username"));
        System.out.println("Password: " + configuration.getProperty("hibernate.connection.password"));
        System.out.println("Pool Size: " + configuration.getProperty("hibernate.connection.pool_size"));
        System.out.println("Context Class: " + configuration.getProperty("hibernate.current_session_context_class"));
        System.out.println("Hbmwddl.auto: " + configuration.getProperty("hbm2ddl.auto"));
        System.out.println("Show SQL: " + configuration.getProperty("show_sql"));
    }
}
