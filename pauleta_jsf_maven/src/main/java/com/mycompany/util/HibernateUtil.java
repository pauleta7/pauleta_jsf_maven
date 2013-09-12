package com.mycompany.util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    private static final String HIBERNATE_SESSION ="hibernate_session";
    static{
        try{
            
            System.out.println("Tentando configurar uma SF");
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory =configuration.buildSessionFactory(serviceRegistry);
            
            System.out.println("Session factory criada correctamente");
        }catch(Exception ex){
            System.out.println("Ocorreu um erro ao iniciar a SF. "+ex);
            throw new ExceptionInInitializerError(ex);
        }
        
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}
