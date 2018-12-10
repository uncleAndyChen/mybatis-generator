package org.mybatis.generator.property.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix="database")
public class DatabaseConfig {
    private String driverClassName;
    private String databaseUrl;
    private String schemaName;
    private String username;
    private String password;
    /**
     * 要保留的表名前缀
     */
    private String keepPrefix;
    /**
     * 表名前缀长度，后面生成的配置会将前缀去掉，根据自己的业务适当修改即可。
     */
    private int tableNamePrefixCount;
    /**
     * 需要保留表前缀的表名，这里仅仅是示例，并没有任何业务逻辑。
     */
    private List<String> keepPrefixTableList;
    /**
     * 是否使用原始字段名
     */
    private boolean flagUseActualColumnNames;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKeepPrefix() {
        return keepPrefix;
    }

    public void setKeepPrefix(String keepPrefix) {
        this.keepPrefix = keepPrefix;
    }

    public int getTableNamePrefixCount() {
        return tableNamePrefixCount;
    }

    public void setTableNamePrefixCount(int tableNamePrefixCount) {
        this.tableNamePrefixCount = tableNamePrefixCount;
    }

    public List<String> getKeepPrefixTableList() {
        return keepPrefixTableList;
    }

    public void setKeepPrefixTableList(List<String> keepPrefixTableList) {
        this.keepPrefixTableList = keepPrefixTableList;
    }

    public boolean isFlagUseActualColumnNames() {
        return flagUseActualColumnNames;
    }

    public void setFlagUseActualColumnNames(boolean flagUseActualColumnNames) {
        this.flagUseActualColumnNames = flagUseActualColumnNames;
    }
}
