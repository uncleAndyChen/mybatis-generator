package table.property.controller;

import table.property.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CreateTablePropertyService {
    private static Statement statement;

    public static StringBuilder getTableProperties(DatabaseConfig databaseConfig) throws Exception {
        String getPrimaryKeySqlFormat = "select column_name from information_schema.key_column_usage where table_schema='" + databaseConfig.getSchemaName() + "' and table_name='%s';";
        String getTinyintKeySqlFormat = "show columns from " + databaseConfig.getSchemaName() + ".%s";
        String getPrimaryKeySql;
        String getTinyintKeySql;
        String primaryKey;
        String tableNameForMapper;
        List<String> tableNameList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        StringBuilder sbMapperXml = new StringBuilder();
        ResultSet rs;

        // 请修改成你自己的数据库连接配置
        initConnection(databaseConfig);
        ResultSet resultSet = getMetaDataTables();

        while (resultSet.next()) {
            tableNameList.add(resultSet.getString("Tables_in_" + databaseConfig.getSchemaName()));
        }

        for (String tableName : tableNameList) {
            tableNameForMapper = tableName;
            getPrimaryKeySql = String.format(getPrimaryKeySqlFormat, tableName);
            rs = statement.executeQuery(getPrimaryKeySql);

            rs.next(); //只有一条记录，因为只定义了一个主键，如果有多个主键（联合主键），请根据情况调整此处代码。
            primaryKey = rs.getString("column_name");
            rs.close();

            sb.append("<table tableName=\"");
            sb.append(tableName);
            sb.append("\"");
            sb.append(" domainObjectName=\"");

            // 如果不需要去掉表名前缀，删除下面的 if 语句块即可。
            if (!databaseConfig.getKeepPrefixTableList().contains(tableName) && !tableName.startsWith(databaseConfig.getKeepPrefix())) {
                tableNameForMapper = tableName.substring(databaseConfig.getTableNamePrefixCount());
            }

            sb.append(toCamelNameButFirstWord(tableNameForMapper));

            if (databaseConfig.isFlagUseActualColumnNames()) {
                sb.append("\"><property name=\"useActualColumnNames\" value=\"true\"/>");
            } else {
                sb.append("\"><property name=\"useActualColumnNames\" value=\"false\"/>");
            }

            sb.append("<generatedKey identity=\"true\" type=\"post\" column=\"" + primaryKey + "\" sqlStatement=\"Mysql\"/>");

            getTinyintKeySql = String.format(getTinyintKeySqlFormat, tableName) + " where type like 'tinyint%';";
            rs = statement.executeQuery(getTinyintKeySql);

            // 将 tinyint 替换成 Integer，否则会生成 bool 类型的字段，会导致程序处理复杂化，建议根据自己的业务权衡
            while (rs.next()) {
                sb.append("<columnOverride column=\"" + rs.getString("Field") + "\" javaType=\"java.lang.Integer\" jdbcType=\"INTEGER\" />");
            }

            rs.close();

            sb.append("</table>\r\n");
        }

        sb.append(sbMapperXml.toString());
        System.out.println(sb.toString());

        return sb;
    }

    private static void initConnection(DatabaseConfig databaseConfig) throws Exception {
        Class.forName(databaseConfig.getDriverClassName());//指定连接类型
        //获取连接
        Connection connection = DriverManager.getConnection(
                databaseConfig.getDatabaseUrl(),
                databaseConfig.getUsername(),
                databaseConfig.getPassword());
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    private static ResultSet getMetaDataTables() throws Exception {
        String sql = "show tables;";
        return statement.executeQuery(sql);
    }

    private static String toCamelNameButFirstWord(String tableName) {
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
        String[] words = tableName.split("_");

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