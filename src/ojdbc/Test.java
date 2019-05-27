package ojdbc;

import oracle.jdbc.OracleTypes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Test {

    public static final String SCHEMA="SEC_ASSETS";

    public static final String PATH="d:/SEC_ASSETS.txt";

    @org.junit.Test
    public void test1() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@192.168.1.19:1521:assets";
        String username = "sec_base";
        String password = "base";
        Properties props =new Properties();
        props.put("user", username);
        props.put("password", password);
        props.put("remarksReporting","true");
        Connection connection = DriverManager.getConnection(url,props);

        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet tables = metaData.getTables(null, SCHEMA, null, null);

        FileOutputStream fos=new FileOutputStream(PATH);



        while (tables.next()) {

            String tableName =tables.getString(3);
            String Tremarks = tables.getString("REMARKS");

            if (Tremarks == null) {
                Tremarks = "";
            }

            Tremarks.replaceAll("\n", "");

            String tableInfo = SCHEMA+"."+tableName + "\t" + Tremarks+"\n";
            fos.write(tableInfo.getBytes());

            ResultSet columns = metaData.getColumns(null, SCHEMA, tableName, null);

            while (columns.next()) {
                String colName = columns.getString(4);
                String Cremarks = columns.getString("REMARKS");
                if (Cremarks == null) {
                    Cremarks = "";
                }

                Cremarks=Cremarks.replaceAll("\n", "").replaceAll(" ","");

                String  columuInfo="\t\t\t"+colName+"\t"+Cremarks+"\n";
                fos.write(columuInfo.getBytes());
            }

           fos.write("-------------------------------------------------\n".getBytes());
        }

    }

    @org.junit.Test
    public void test3() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("d:/gss.txt");

        for (int i = 0; i < 10; i++) {
            fileOutputStream.write("SBSBSBSB!!!".getBytes());
        }
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