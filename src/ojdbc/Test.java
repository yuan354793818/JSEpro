package ojdbc;

import oracle.jdbc.OracleTypes;

import java.sql.*;

public class Test {


    @org.junit.Test
    public void test1() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@192.168.191.100:1521:orcl";
        String username = "yuanjiayu";
        String password = "yuan1995";
        Connection connection = DriverManager.getConnection(url, username, password);

        CallableStatement state = connection.prepareCall("{call proc_gettotalsal(?,?)}");

        state.setInt(1, 7788);
        state.registerOutParameter(2, OracleTypes.NUMBER);

        state.execute();

        int anInt = state.getInt(2);
        System.out.println(anInt);
    }

    @org.junit.Test
    public void test2() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@192.168.191.100:1521:orcl";
        String username = "yuanjiayu";
        String password = "yuan1995";
        Connection connection = DriverManager.getConnection(url, username, password);

        CallableStatement callableStatement = connection.prepareCall("{?= call findtotalsal(?)}");

        callableStatement.registerOutParameter(1, OracleTypes.NUMBER);
        callableStatement.setInt(2, 7788);

        callableStatement.execute();

        int anInt = callableStatement.getInt(1);
        System.out.println(anInt);

        callableStatement.close();
        connection.close();
    }
}