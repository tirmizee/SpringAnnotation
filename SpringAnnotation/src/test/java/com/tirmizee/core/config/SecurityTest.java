package com.tirmizee.core.config;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={AppConfig.class})
public class SecurityTest {
	
	@Autowired
    private WebApplicationContext wac;
 
    private MockMvc mockMvc;
 
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).apply(springSecurity()).build();
    }

    @Test
    @WithAnonymousUser
    public void hello_withoutPermission_mustLoginPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user").accept(MediaType.TEXT_HTML))
                .andExpect(status().is3xxRedirection());
    }
    
    @Test
    @WithMockUser(authorities="US000")
    public void hello_withoutName_mustDefaultWorld() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user").accept(MediaType.TEXT_HTML)).andExpect(status().isOk());
    }
    
    @Test
    @WithMockUser(authorities="US000")
    public void hello_withoutName_mustDefaultWorlds() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/service/user/findAll")
        		.accept(MediaType.APPLICATION_JSON)).andExpect(status().is4xxClientError());
    }
    
}
