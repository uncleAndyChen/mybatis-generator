package mybatis.generator.table.property;

import mybatis.generator.table.property.config.DatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateTablePropertyController {
    @Autowired
    private DatabaseConfig databaseConfig;

    @RequestMapping("/getDatabaseConfig")
    public DatabaseConfig getDatabaseConfig(){
        return databaseConfig;
    }

    @RequestMapping("/getTableProperties")
    public StringBuilder getTableProperties(){
        try {
            StringBuilder sb = new StringBuilder();

            sb.append("<textarea rows=\"30\" cols=\"248\">");
            sb.append(CreateTablePropertyService.getTableProperties(databaseConfig));
            sb.append("</textarea>");

            return sb;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
