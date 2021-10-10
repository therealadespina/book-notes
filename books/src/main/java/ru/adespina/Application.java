package ru.adespina;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.adespina.models.Book;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class Application {

    @Bean
    public DataSource h2DataSource(@Value("${jdbcUrl}") String jdbcUrl) {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL(jdbcUrl);
        dataSource.setUser("user");
        dataSource.setPassword("password");
        return dataSource;
    }

    @Bean
    public CommandLineRunner cmd(DataSource dataSource) {
        return args -> {
            try (InputStream inputStream = this.getClass().getResourceAsStream("/initial.sql")) {
                String sql = new String(inputStream.readAllBytes());
                try (
                        Connection connection = dataSource.getConnection();
                        Statement statement = connection.createStatement()
                ) {
                    statement.executeUpdate(sql);
                    ResultSet rs = statement.executeQuery("SELECT book_id, name, author, pages FROM book");
                    while (rs.next()) {
                        Book book = new Book(
                                rs.getString(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getInt(4));
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