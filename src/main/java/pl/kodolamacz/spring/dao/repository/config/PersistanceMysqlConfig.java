package pl.kodolamacz.spring.dao.repository.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement // odpowiednik <tx:annotation-driven /> w XML
@EnableJpaRepositories(basePackages = "pl.kodolamacz.spring.dao")
@Profile("mysql")  // -> możliwość oznaczenia profilem per @Bean
// aby aktywować -> w VM options: -Dspring.profiles.active=mysql
public class PersistanceMysqlConfig extends PersistanceBaseConfig {



  //    gdybyśmy chcieli np. MySQL zamiast naszego Mocka Bazy
  @Bean
  @Primary // gdyby ktoś zapomniał podać profilu to domyślnie załaduje się ten DataSource
  public DataSource getMySqlDatasource() {
    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/mkyongjava");
    driverManagerDataSource.setUsername("root");
    driverManagerDataSource.setPassword("password");
    return driverManagerDataSource;
  }
//    to samo co:
//    <bean id="dataSource"
//        class="org.springframework.jdbc.datasource.DriverManagerDataSource">
//
//        <property name="driverClassName" value="com.mysql.jdbc.Driver" />
//        <property name="url" value="jdbc:mysql://localhost:3306/mkyongjava" />
//        <property name="username" value="root" />
//        <property name="password" value="password" />
//	  </bean>

}
