package pl.kodolamacz.spring.dao.repository.config;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement // odpowiednik <tx:annotation-driven /> w XML
public class PersistanceConfig {

  @Autowired
  private Environment env;

  @Bean
  public PropertiesFactoryBean jpaProperties() {
    PropertiesFactoryBean factoryBean = new PropertiesFactoryBean();
    factoryBean.setLocation(new ClassPathResource("db/jpa.properties"));
    return factoryBean;
  }

  private Properties getHibernateProperties() {
    return new Properties() {
      {
        setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
//                setProperty("hibernate.globally_quoted_identifiers", "true");   <--- not working with it
        setProperty("hibernate.default_schema", "PUBLIC");
        setProperty("show_sql", "true");
//                setProperty("hibernate.jdbc.use_streams_for_binary", "true");
//                setProperty("hibernate.jdbc.batch_size", "1000");
      }
    };
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Properties jpaProperties) {
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setPackagesToScan("pl.kodolamacz.spring.dao");
    entityManagerFactoryBean.setDataSource(dataSource);
    entityManagerFactoryBean.setJpaProperties(jpaProperties);
    entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
    return entityManagerFactoryBean;
  }

  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }

  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
    return new PersistenceExceptionTranslationPostProcessor();
  }

  @Bean
  public DataSource getHSQLDataSource() {
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
