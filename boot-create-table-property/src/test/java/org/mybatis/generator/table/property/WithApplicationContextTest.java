package org.mybatis.generator.table.property;

import table.property.service.CreateTablePropertyService;
import table.property.config.DatabaseConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

public class WithApplicationContextTest extends BasicUtClass {
    @Autowired
    private DatabaseConfig databaseConfig;

    @Test
    public void getTablePropertiesTest() {
        try {
            StringBuilder sb = CreateTablePropertyService.getTableProperties(databaseConfig);
            // 每张表会有一个换行符
            assertTrue(sb.length() > 0);
            //assertEquals(S
            // tringHelper.appearNumber(sb.toString(), "\r\n"),5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
