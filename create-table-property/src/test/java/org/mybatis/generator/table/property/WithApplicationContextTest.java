package org.mybatis.generator.table.property;

import common.lib.StringHelper;
import mybatis.generator.table.property.CreateTablePropertyService;
import mybatis.generator.table.property.config.DatabaseConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class WithApplicationContextTest extends BasicUtClass {
    @Autowired
    private DatabaseConfig databaseConfig;

    @Test
    public void getTablePropertiesTest() {
        try {
            StringBuilder sb = CreateTablePropertyService.getTableProperties(databaseConfig);
            // 每张表会有一个换行符，一共5张表
            assertEquals(StringHelper.appearNumber(sb.toString(), "\r\n"),3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
