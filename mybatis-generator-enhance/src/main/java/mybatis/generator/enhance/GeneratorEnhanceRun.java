package mybatis.generator.enhance;

import common.lib.ConfigProperties;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.api.VerboseProgressCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class GeneratorEnhanceRun {
    public static void main(String[] args) {
        try {
            List<String> warnings = new ArrayList<String>();
            /**
             * 初始化配置解析器
             */
            ConfigurationParser cp = new ConfigurationParser(warnings);

            /**
             * 获取配置文件信息
             */
            FileInputStream fileInputStream = new FileInputStream(ConfigProperties.getValue("configFile"));

            /**
             * 调用配置解析器创建配置对象
             */
            Configuration config = cp.parseConfiguration(fileInputStream);
            /**
             * shellcallback接口主要用来处理文件的创建和合并，传入overwrite参数；默认的shellcallback是不支持文件合并的；
             */
            DefaultShellCallback callback = new DefaultShellCallback(true);
            /**
             * 创建一个MyBatisGenerator对象。MyBatisGenerator类是真正用来执行生成动作的类
             */
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            /**
             * 用System.out打印执行过程
             */
            ProgressCallback progressCallback = new VerboseProgressCallback();

            /**
             *  执行生成操作
             */
            myBatisGenerator.generate(progressCallback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
