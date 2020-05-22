package sia.tacocloud;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import sia.tacocloud.controller.HomeController;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)       // 针对 HomeController 的 Web 测试
public class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;            // 注入 MockMvc

    @Test
    public void testHomepage() throws Exception {

        mockMvc.perform(get("/"))       // 发起对 "/" 的 GET
                .andExpect(status().isOk())        // 期望得到 HTTP 200
                .andExpect(view().name("home"))     // 期望得到 home 视图
                .andExpect(content().string(
                        containsString("Welcome to...")     // 期望包含 "Welcome to"
                ));
    }
}
