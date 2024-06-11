package com.MVCValidation.MVCValidation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.ModelAndView;

@AutoConfigureMockMvc
@WebMvcTest(controllers = {MVCController.class}) // can specify the conteroller's we want to test
class MvcValidationApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	private static MockHttpServletRequest servreq;
	
	@BeforeAll
	public static void setUp()
	{
		servreq = new MockHttpServletRequest();
		servreq.setParameter("firstName", "sov");
		servreq.setParameter("lastName", "singha");
	}
	
	@Test
	void testgetHomePageRequest() throws Exception {
		
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/")).andReturn();
		ModelAndView modelAndView = mvcResult.getModelAndView();
		ModelAndViewAssert.assertViewName(modelAndView, "index");
	}
	
	@Test
	void testgetStudentData() throws Exception {
		
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/saveStudent")
				.contentType(MediaType.APPLICATION_JSON)
				.param("firstName", servreq.getParameterValues("firstName"))
				.param("lastName", servreq.getParameterValues("lastName"))
				)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		ModelAndView modelAndView = mvcResult.getModelAndView();
		ModelAndViewAssert.assertViewName(modelAndView, "studentdata");
	}

}
