package com.security.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.Base64Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.security.entity.Employee;

@RunWith(SpringRunner.class)
@WebMvcTest({AppController.class})
@ActiveProfiles(value="true")
public class AppControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Value("${employee.get.url}")
	String getUrl;
	
	@Value("${employee.post.url}")
	String postUrl;
	
	@Value("${employee.put.url}")
	String putUrl;
	
	@Value("${employee.delete.url}")
	String deletUrl;
	
	@Value("${user.user1.username}")
	String username1;
	
	@Value("${user.user1.password}")
	String password1;
	
	@Value("${user.admin1.username}")
	String admin_name1;
	
	@Value("${user.admin1.password}")
	String admin_password1;
	
	@Test
	public void testEmployee() throws Exception {
		ResultActions responseEntity = processApiRequest(getUrl, HttpMethod.GET, null,null, username1, password1);
		
		responseEntity.andExpect(status().isOk());
		String result = responseEntity.andReturn().getResponse().getContentAsString();
		assertEquals("employee", result);
	}
	
	@Test
	public void testPostEmployee() throws Exception {
		Employee emp = new Employee();
		emp.setName("ram");
		emp.setRole("dev");
		
		ResultActions responseEntity = processApiRequest(getUrl, HttpMethod.GET, null,emp, admin_name1, admin_password1);
		ObjectMapper mapper = new ObjectMapper();
		Employee responseEmp = mapper.readValue(responseEntity.andReturn().getResponse().getContentAsString()
				, new TypeReference<Employee>() {});
		responseEntity.andExpect(status().isOk());
		assertEquals("ram", responseEmp.getName());
		assertEquals("dev", responseEmp.getRole());
	}

	private ResultActions processApiRequest(String url, HttpMethod method, String  name, Employee emp,
			String username, String password) {
		// TODO Auto-generated method stub
		ResultActions response = null;
		String secret = "Basic" + Base64Utils.encodeToString((username+":"+password).getBytes());
		try {
			switch (method) {
			case GET: {
//				response = mockMvc.perform(get(url).header(HttpHeaders.AUTHORIZATION, secret));
				response = mockMvc.perform(get(url).with(user(username).password(password).roles("USER")));
				break;
			}
			case POST: {
//				response = mockMvc.perform(post(url).header(HttpHeaders.AUTHORIZATION, secret)
//						.contentType(MediaType.APPLICATION_JSON).content(asJsonString(emp))
//						.accept(MediaType.APPLICATION_JSON));
				response = mockMvc.perform(post(url).with(user(username).password(password).roles("USER"))
				.contentType(MediaType.APPLICATION_JSON).content(asJsonString(emp))
				.accept(MediaType.APPLICATION_JSON));
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + method);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	private String asJsonString(Employee emp) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(emp);
	}

}
