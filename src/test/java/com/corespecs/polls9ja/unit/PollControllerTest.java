package com.corespecs.polls9ja.unit;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;

import com.corespecs.polls9ja.Polls9jaApplication;
import com.corespecs.polls9ja.controller.v1.PollController;
import com.corespecs.polls9ja.domain.Poll;
import com.corespecs.polls9ja.respository.springdatajpa.PollRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class PollControllerTest {
	@Mock
	private PollRepository pollRepository;
	
	@InjectMocks
	PollController pollController;

	private MockMvc mockMvc;
	
    @Before()
	public void setUp() throws Exception {
    	MockitoAnnotations.initMocks(this);
    	mockMvc = standaloneSetup(pollController).build();
    }
    
    @Test
    public void testGetAllPolls() throws Exception {
    	when(pollRepository.findAll()).thenReturn(new ArrayList<Poll>());
    	mockMvc.perform(get("/v1/polls"))
    			.andExpect(status().isOk())
    			.andExpect(content().string("[]")); 
    }
}
