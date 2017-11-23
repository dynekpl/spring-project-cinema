package pl.kodolamacz.spring.dao.repository.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement // odpowiednik <tx:annotation-driven /> w XML
@EnableJpaRepositories(basePackages = "pl.kodolamacz.spring.dao")
@Profile("hsql")
// aby aktywować -> w VM options: -Dspring.profiles.active=hsql
public class PersistanceHsqlConfig extends PersistanceBaseConfig {

  @Bean
  public DataSource getHSQLDataSource() {
    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    return builder
            .setType(EmbeddedDatabaseType.HSQL)
            .addScript("db/schema.sql")
            .addScript("db/insertData.sql")
            .build();
  }
}