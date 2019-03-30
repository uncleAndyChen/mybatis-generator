package mybatis.generator.enhance;

import org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3Impl;

public class IntrospectedTableEnhanceImpl extends IntrospectedTableMyBatis3Impl {
    @Override
    public String getFullyQualifiedTableNameAtRuntime() {
        return getTableNameFromConfigFile();
    }

    @Override
    public String getAliasedFullyQualifiedTableNameAtRuntime() {
        return getTableNameFromConfigFile();
    }

    private String getTableNameFromConfigFile() {
        String tableName = this.getTableConfiguration().getTableName();
        return "`" + tableName + "`";
    }
}
