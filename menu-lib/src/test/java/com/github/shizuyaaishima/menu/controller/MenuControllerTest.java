package com.github.shizuyaaishima.menu.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.github.shizuyaaishima.menu.MenuTestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(
    classes = MenuTestConfiguration.class,
    properties = {"spring.flyway.enabled=true", "spring.jpa.hibernate.ddl-auto=validate"})
@AutoConfigureMockMvc
class MenuControllerTest {

  @Autowired private MockMvc mockMvc;

  @Test
  void getAllMenuItems_正常系() throws Exception {
    mockMvc
        .perform(get("/api/menu"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$.length()").value(3));
  }

  @Test
  void getRootMenuItems_正常系() throws Exception {
    mockMvc
        .perform(get("/api/menu/root"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$.length()").value(2));
  }
}
