package pl.kodolamacz.spring.dao.repository.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class PersistanceConfig {

  @Bean
  public DataSource getHSQLDataSource(){
    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    EmbeddedDatabase db = builder
            .setType(EmbeddedDatabaseType.HSQL)
            .addScript("db/schema.sql")
            .addScript("db/insertData.sql")
            .build();
    System.out.println("DB builder...");
    return db;
  }
}
