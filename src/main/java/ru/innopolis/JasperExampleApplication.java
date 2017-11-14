package ru.innopolis;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class JasperExampleApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(JasperExampleReport.class);
        return classes;
    }

}
