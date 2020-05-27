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
	
	public static MetadataSources entityList;
	
	static {
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
        
        entityList = new MetadataSources(serviceRegistry);
	}
	
	public static void createDatabase() {

        EnumSet<TargetType> enumSet = EnumSet.of(TargetType.DATABASE);
        SchemaExport schemaExport = new SchemaExport();
        schemaExport.execute(enumSet, Action.BOTH, entityList.buildMetadata());
	}

	public static void main(String[] args) {
		entityList.addAnnotatedClass(Player.class);
        CreateDatabaseWithSchemaExport.createDatabase();
	}
}
/*
C:\_workspace>javac -classpath "C:\_hiblib\*" C:\_workspace\com\mcnz\jpa\examples\*.java
C:\_workspace>java -classpath "C:\_hiblib\*";C:\_workspace com.mcnz.jpa.examples.MyDatabaseWizard
*/
