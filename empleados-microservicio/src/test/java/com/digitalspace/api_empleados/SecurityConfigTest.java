package com.digitalspace.api_empleados;

import com.digitalspace.api_empleados.infra.config.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest
//@Import(SecurityConfig.class)
//public class SecurityConfigTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void whenNotAuthenticated_thenRedirectToLogin() throws Exception {
//        mockMvc.perform(get("/dashboard"))
//                .andExpect(status().is3xxRedirection());
//    }
//
//    @Test
//    @WithMockUser
//    public void whenAuthenticated_thenAccessDashboard() throws Exception {
//        mockMvc.perform(get("/dashboard"))
//                .andExpect(status().isOk());
//    }
//}
