package com.bossabox.vuttr.api.infra.db;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * 
 * @author Iury Teixeira
 *
 */
@Configuration
public class DatabaseConfig {

	/**
	 * Called by Spring to work database connection. It's ready two way: system
	 * variable and dotenv variable.
	 * 
	 * @return DataSource
	 */
	@Bean
	public DataSource dataSource() {
		String dbUrl = System.getenv("SPRING_DATASOURCE_URL");// HEROKU
		if (dbUrl == null) {
			Dotenv dotenv = Dotenv.load();
			dbUrl = dotenv.get("DATASOURCE_URL");
		}
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(dbUrl);
		return new HikariDataSource(config);
	}

}