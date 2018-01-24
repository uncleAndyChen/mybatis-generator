import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetSchemaTables {
    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) throws Exception {
        //System.out.println("UUID:" + java.util.UUID.randomUUID());
        String schemaName = "schemaName";
        boolean isUseActualColumnNames = true;
        String getPrimaryKeySqlFormat = "select column_name from information_schema.key_column_usage where table_schema='" + schemaName + "' and table_name='%s';";
        String getPrimaryKeySql;
        String getTinyintKeySqlFormat = "show columns from " + schemaName + ".%s";
        String getTinyintKeySql;
        String primaryKey;
        ResultSet rs;

        initConnection("com.mysql.jdbc.Driver", "jdbc:mysql://192.168.0.88:3306/" + schemaName + "?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&autoReconnect=true&failOverReadOnly=false&socketTimeout=20000", "admin", "adminpassword");
        ResultSet resultSet = getMetaDataTables();
        List<String> list = new ArrayList();
        StringBuilder sb = new StringBuilder();
        StringBuilder sbMapperXml = new StringBuilder();
        List<String> keepPrefixTableList = Arrays.asList("ep_biz", "ep_user", "ep_trade", "ep_order", "crmTrade", "crmOrder", "crmItem", "crmItemCategory");

        while (resultSet.next()) {
            list.add(resultSet.getString("Tables_in_" + schemaName));
        }

        for (int i = 0; i < list.size(); i++) {
            getPrimaryKeySql = String.format(getPrimaryKeySqlFormat, list.get(i));
            rs = statement.executeQuery(getPrimaryKeySql);
            primaryKey = "";

            while (rs.next()) {
                primaryKey = rs.getString("column_name");
                break;
            }

            rs.close();

            sb.append("<table tableName=\"");
            sb.append(list.get(i));
            sb.append("\"");
            sb.append(" domainObjectName=\"");

            String tableName = list.get(i);

            if (!keepPrefixTableList.contains(tableName) && !tableName.startsWith("gw_")) {
                tableName = tableName.substring(3);
            }

            sb.append(toCamelNameButFirstWord(tableName));

            if (isUseActualColumnNames) {
                sb.append("\"><property name=\"useActualColumnNames\" value=\"true\"/>");
            }
            else {
                sb.append("\"><property name=\"useActualColumnNames\" value=\"false\"/>");
            }

            sb.append("<generatedKey identity=\"true\" type=\"post\" column=\"" + primaryKey + "\" sqlStatement=\"Mysql\"/>");

            getTinyintKeySql = String.format(getTinyintKeySqlFormat, list.get(i)) + " where type like 'tinyint%';";
            rs = statement.executeQuery(getTinyintKeySql);

            while (rs.next()) {
                sb.append("<columnOverride column=\"" + rs.getString("Field") + "\" javaType=\"java.lang.Integer\" jdbcType=\"INTEGER\" />");
            }

            rs.close();

            sb.append("</table>\r\n");
        }

        sb.append("\r\n\r\n");
        sb.append(sbMapperXml.toString());
        System.out.println(sb.toString());
    }

    public static void initConnection(String driverClass, String dbUrl, String username, String password) throws Exception {
        Class.forName(driverClass);//指定连接类型
        connection = DriverManager.getConnection(dbUrl, username, password);//获取连接
        //statement = connection.createStatement();
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    public static ResultSet getMetaDataTables() throws Exception {
        String sql = "show tables;";
        ResultSet rs = statement.executeQuery(sql);
        return rs;
    }

    public static ResultSetMetaData getMetaDataFromTable(String tableName) throws Exception {
        String sql = "SELECT * FROM " + tableName + " WHERE 1 != 1";
        ResultSet rs = statement.executeQuery(sql);
        return rs.getMetaData();
    }

    public static void displayMetaData(ResultSetMetaData metaData) throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < metaData.getColumnCount(); i++) {
            sb.append("\n");
            sb.append(metaData.getTableName(i + 1));
            sb.append(".");
            sb.append(metaData.getColumnName(i + 1));
            sb.append("|");
            sb.append(metaData.getColumnType(i + 1));
            sb.append("|");
            sb.append(metaData.getColumnTypeName(i + 1));
            sb.append("|");
            sb.append(metaData.getColumnDisplaySize(i + 1));
            sb.append("|");
        }

        System.out.println(sb.toString());
    }

    public static String toCamelNameButFirstWord(String tableName) {
        StringBuilder result = new StringBuilder();

        // 快速检查
        if (tableName == null || tableName.isEmpty()) {
            // 没必要转换
            return "";
        }

        if (!tableName.contains("_")) {
            result.append(tableName.substring(0, 1).toUpperCase());
            result.append(tableName.substring(1));
            return result.toString();
        }

        // 用下划线将原始字符串分割
        String words[] = tableName.split("_");

        for (String word : words) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (word.isEmpty()) {
                continue;
            }

            result.append(word.substring(0, 1).toUpperCase());
            result.append(word.substring(1).toLowerCase());
        }

        return result.toString();
    }
}