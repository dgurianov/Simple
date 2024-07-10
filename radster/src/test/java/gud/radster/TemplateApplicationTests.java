package gud.radster;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

//@WebMvcTest(controllers = TreeSearchController.class) - partial load of controller
//@RunWith(SpringRunner.class) ?????
@SpringBootTest
class TemplateApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        {
            assertThat(applicationContext).isNotNull();
        }

    }

}