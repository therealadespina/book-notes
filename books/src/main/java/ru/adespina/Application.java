package ru.adespina;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.adespina.models.Book;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class Application {

    @Bean
    public DataSource h2DataSource() {
        JdbcDataSource jdbcDataSource = new JdbcDataSource();
        jdbcDataSource.setURL("jdbc:h2:./db");
        jdbcDataSource.setUser("user");
        jdbcDataSource.setPassword("password");
        return jdbcDataSource;
    }

    @Bean
    public CommandLineRunner cmd(DataSource dataSource) {
        return args -> {
            try (InputStream inputStream = this.getClass().getResourceAsStream("/initial.sql")) {
                String sql = new String(inputStream.readAllBytes());
                try (
                        Connection connection = dataSource.getConnection();
                        Statement statement = connection.createStatement();
                ) {
                    statement.executeUpdate(sql);
                    ResultSet rs = statement.executeQuery("SELECT book_id, pages, name, author FROM book");
                    while (rs.next()) {
                        Book book = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                        System.out.println(book);
                    }
                }
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}