package org.mybatis.generator.table.property;

import table.property.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// 告诉JUnit运行使用Spring的测试支持。SpringRunner是SpringJUnit4ClassRunner的新名字，这个名字只是让名字看起来简单些。
@RunWith(SpringRunner.class)
// @RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
// 通过webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT我们可以让内置的服务器在随机端口启动。
// 意思是“带有Spring Boot支持的引导程序”（例如，加载应用程序、属性，为我们提供Spring Boot的所有精华部分）。
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
public class BasicUtClass {
}
