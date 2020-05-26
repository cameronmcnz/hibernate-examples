package com.mcnz.jpa.examples;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaExport.Action;
import org.hibernate.tool.schema.TargetType;

public class CreateDatabaseWithSchemaExport {

	public static void main(String[] args) {
        Map<String, String> settings = new HashMap<>();
        settings.put("connection.driver_class", "com.mysql.jdbc.Driver");
        settings.put("dialect", "org.hibernate.dialect.MySQLDialect");
        settings.put("hibernate.connection.url", "jdbc:mysql://localhost/hibernate_examples");
        settings.put("hibernate.connection.username", "root");
        settings.put("hibernate.connection.password", "password");
        settings.put("hibernate.show_sql", "true");
        settings.put("hibernate.format_sql", "true");

 
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(settings)
                .build();
        
        MetadataSources metadata = new MetadataSources(serviceRegistry);
        metadata.addAnnotatedClass(Player.class);
        
        EnumSet<TargetType> enumSet = EnumSet.of(TargetType.DATABASE);
        
        SchemaExport schemaExport = new SchemaExport();
        schemaExport.execute(enumSet, Action.BOTH, metadata.buildMetadata());
	}
}
