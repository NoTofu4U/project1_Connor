package dev.Connor.daotests.smoketest;


import dev.Connor.util.ConnectionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTests {

    @Test
    void connection_available() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        System.out.println(connection);
        Assertions.assertNotNull(connection);
    }
}
