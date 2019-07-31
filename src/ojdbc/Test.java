package ojdbc;

import oracle.jdbc.OracleTypes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Test {

    public static final String SCHEMA = "SEC_ASSETS";

    public static final String PATH = "E:\\JavaEEworkspace\\JavaEEworkspace\\JSEpro\\src\\ojdbc\\SEC_ASSETS.txt";

    /**
     * 数据库扫描
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
    @org.junit.Test
    public void test1() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@speedcn.vicp.cc:1921:assets";
        String username = "sec_base";
        String password = "base";
        Properties props = new Properties();
        props.put("user", username);
        props.put("password", password);
        props.put("remarksReporting", "true");
        Connection connection = DriverManager.getConnection(url, props);

        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet tables = metaData.getTables(null, SCHEMA, "ASSETS_CHANGE", null);

        FileOutputStream fos = new FileOutputStream(PATH);

        while (tables.next()) {

            String tableName = tables.getString(3);
            String Tremarks = tables.getString("REMARKS");

            if (Tremarks == null) {
                Tremarks = "";
            }

            Tremarks.replaceAll("\n", "");

            String tableInfo = SCHEMA + "." + tableName + "\t" + Tremarks + "\n";
            fos.write(tableInfo.getBytes());

            ResultSet columns = metaData.getColumns(null, SCHEMA, tableName, null);

            while (columns.next()) {
                String colName = columns.getString(4);
                String type = columns.getString(6);
                String Cremarks = columns.getString("REMARKS");
                if (Cremarks == null) {
                    Cremarks = "";
                }

                Cremarks = Cremarks.replaceAll("\n", "").replaceAll(" ", "");

                String columuInfo = "\t\t\t" + colName + "\t" + type + "\t" + Cremarks + "\n";
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

    /**
     * bean生成器
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
    @org.junit.Test
    public void test82() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@speedcn.vicp.cc:1921:assets";
        String username = "sec_base";
        String password = "base";
        Properties props = new Properties();
        props.put("user", username);
        props.put("password", password);
        props.put("remarksReporting", "true");
        Connection connection = DriverManager.getConnection(url, props);

        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet tables = metaData.getTables(null, SCHEMA, "ASSETS_CHANGE", null);

        FileOutputStream fos = new FileOutputStream(PATH);

        while (tables.next()) {
            String tableName = tables.getString(3);
            String Tremarks = tables.getString("REMARKS");

            if (Tremarks == null) {
                Tremarks = "";
            }
            Tremarks.replaceAll("\n", "");
            StringBuilder header = new StringBuilder();
            if (Tremarks != null) {
                header.append("//").append(Tremarks).append(System.lineSeparator());
            }
            header.append("public class " + mapUnderscoreToCamelCase(tableName, true) + " {" + "\n").append(System.lineSeparator());
            fos.write(header.toString().getBytes());

            ResultSet columns = metaData.getColumns(null, SCHEMA, tableName, null);
            while (columns.next()) {
                StringBuilder field = new StringBuilder();
                String Cremarks = columns.getString("REMARKS");
                if (Cremarks == null) {
                    Cremarks = "";
                }
                Cremarks = Cremarks.replaceAll("\n", "").replaceAll(" ", "");
                if (!Cremarks.equals("")) {
                    field.append("\t//").append(Cremarks).append(System.lineSeparator());
                }
                field.append("\t").append("private ");
                String type = columns.getString(6);
                switch (type) {
                    case "NUMBER":
                        field.append("Integer ");
                        break;
                    case "VARCHAR2":
                        field.append("String ");
                        break;
                    case "DATE":
                        field.append("Date ");
                        break;
                    case "CLOB":
                        field.append("String ");
                        break;
                    default:
                        field.append("Object ");
                }
                String colName = columns.getString(4);
                field.append(mapUnderscoreToCamelCase(colName, false)).append(";").append(System.lineSeparator());
                fos.write(field.toString().getBytes());
            }
            fos.write("}".getBytes());
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

    public static String camelCaseToMapUnderscore(String s) {
        StringBuilder fieldStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c > 64 && c < 91) {
                fieldStr.append('_').append(Character.toLowerCase(c));
            } else {
                fieldStr.append(c);
            }
        }
        return fieldStr.toString();
    }

    public static String mapUnderscoreToCamelCase(String s, boolean titleCase) {
        s = s.toLowerCase();
        StringBuilder fieldStr = new StringBuilder();
        boolean upperCase = titleCase;
        for (char c : s.toCharArray()) {
            if (c == '_') {
                upperCase = true;
            } else {
                if (upperCase) {
                    fieldStr.append(Character.toUpperCase(c));
                    upperCase = false;
                } else {
                    fieldStr.append(c);
                }
            }
        }
        return fieldStr.toString();
    }
}