package com.chris.junit;

import com.chris.junit.config.WebMvcConfig;
import com.chris.junit.model.UserModel;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Create by Chris Chan
 * Create on 2019/12/31 20:28
 * Use for: Junit接口测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    private MockMvc mockMvc;
    @Autowired
    WebApplicationContext context;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void testController01() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/getUser");
        UserModel userModel = new UserModel("chrischen", 32, "男", "上海嘉定");
        String jsonContent = new Gson().toJson(userModel);
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(jsonContent))
                .andReturn().getResponse().getContentAsString();

    }
    @Test
    public void testController02() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/api/getUser2").param("name","chenfabao");
        UserModel userModel = new UserModel("chenfabao", 32, "男", "上海嘉定");
        String jsonContent = new Gson().toJson(userModel);
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(jsonContent))
                .andDo(MockMvcResultHandlers.print());

    }
}
