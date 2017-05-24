import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成所有 MBG 配置文件里，与表相关的代码
 * 需要配置数据表名，见 main 函数里的变量 schemaName
 */
public class GetSchemaTables
{
    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) throws Exception
    {
        String schemaName = "mbg";
        String getPrimaryKeySqlFormat = "select column_name from information_schema.key_column_usage where table_schema='" + schemaName + "' and table_name='%s';";
        String getPrimaryKeySql;
        String primaryKey;
        ResultSet rs;

        initConnection("com.mysql.jdbc.Driver", "jdbc:mysql://192.168.0.130:3306/" + schemaName + "?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&autoReconnect=true&failOverReadOnly=false&socketTimeout=20000", "root", "root");
        ResultSet resultSet = getMetaDataTables();
        List<String> tableNames = new ArrayList();
        StringBuilder sb = new StringBuilder();
        StringBuilder sbMapperXml = new StringBuilder();

        while (resultSet.next())
        {
            tableNames.add(resultSet.getString("Tables_in_" + schemaName + ""));
        }

        for (String tableName : tableNames)
        {
            getPrimaryKeySql = String.format(getPrimaryKeySqlFormat, tableName);
            rs = statement.executeQuery(getPrimaryKeySql);
            primaryKey = "";

            while (rs.next()) //这里没有深究，应该有更好的方式。
            {
                primaryKey = rs.getString("column_name");
                break;
            }

            sb.append("<table tableName=\"");
            sb.append(tableName);
            sb.append("\"");
            sb.append(" domainObjectName=\"");

            //如果有某些表不希望去掉前缀，则特别处理
            if (tableName.equals("erpTrade"))
            {
                sb.append("erpTrade");
            }
            //下面的代码是去掉表名前缀，这里是去掉前面三个字母，如果没有前缀或者希望保留前缀，则请注释掉下面的代码。
            else
            {
                sb.append(tableName.substring(3));
            }

            sb.append("\"><property name=\"useActualColumnNames\" value=\"true\"/>");
            sb.append("<generatedKey identity=\"true\" type=\"post\" column=\"" + primaryKey + "\" sqlStatement=\"Mysql\"/>");
            sb.append("</table>\r\n");
        }

        sb.append("\r\n\r\n");
        sb.append(sbMapperXml.toString());
        System.out.println(sb.toString());
    }

    private static void initConnection(String driverClass, String dbUrl, String username, String password) throws Exception
    {
        Class.forName(driverClass);//指定连接类型
        connection = DriverManager.getConnection(dbUrl, username, password);//获取连接
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    private static ResultSet getMetaDataTables() throws Exception
    {
        String sql = "show tables;";
        ResultSet rs = statement.executeQuery(sql);
        return rs;
    }
}