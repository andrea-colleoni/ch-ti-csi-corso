package ch.ti.csi.corso.batch;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class BatchConfig {

	@Bean(name="dataSource")
	public DataSource jdbcDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://dev.sdi.ti.ch:15432/corso_spring");
		ds.setUsername("postgres");
		ds.setPassword("postgres");
		return ds;
	}	
}
