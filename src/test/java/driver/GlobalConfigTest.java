package driver;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.*;

class GlobalConfigTest {


    @Test
    void load() {
        GlobalConfig globalConfig = GlobalConfig.load("/data/globalConfig.yaml");
        assertThat(globalConfig.xueqiuConfig, not(equalTo(null)));
        System.out.println(globalConfig.xueqiuConfig.password);

    }
}