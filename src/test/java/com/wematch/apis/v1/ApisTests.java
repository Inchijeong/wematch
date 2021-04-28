package com.wematch.apis.v1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wematch.models.Company;
import com.wematch.models.Customer;
import com.wematch.models.HomeMovingOrder;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("API 통합 테스트")
public class ApisTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext ctx;
	
	@BeforeEach
	void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
				.addFilter(new CharacterEncodingFilter("UTF-8", true))
				.build();
	}
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	@DisplayName("1. 이사업체 정보 목록 조회")
	public void _01_findAllCompanyApiTest() throws Exception {
		
		// 등록
		for(int i = 1; i < 10; i++) {
			Company company = Company.builder()
					.name("회사"+i)
					.tel("010-1234-5678")
					.address("서울시 강남구")
					.isMatching(true)
					.build();
			
			String content = objectMapper.writeValueAsString(company);
			
			ResultActions result = mockMvc.perform(
					post("/api/v1/companies")
					.content(content)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)
			);
			result.andExpect(status().isOk());
		}
		
		// 조회		
		ResultActions result2 = mockMvc.perform(
				get("/api/v1/companies")
		);
		result2.andDo(print())
			.andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("2. 고객 정보 목록 조회")
	public void _02_findAllCustomerApiTest() throws Exception {
		
		// 등록
		for(int i = 1; i < 10; i++) {
			Customer customer = Customer.builder()
					.name("고객"+i)
					.tel("010-1234-5678")
					.isServiceTerms(true)
					.isPrivacyTerms(true)
					.isMarketingTerms(true)
					.build();
			
			String content = objectMapper.writeValueAsString(customer);
			
			ResultActions result = mockMvc.perform(
					post("/api/v1/customers")
					.content(content)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)
			);
			result.andExpect(status().isOk());
		}
		
		// 조회		
		ResultActions result2 = mockMvc.perform(
				get("/api/v1/customers")
		);
		result2.andDo(print())
			.andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("3. 주문 정보 목록 조회")
	public void _03_findAllOrderApiTest() throws Exception {
		
		// 등록
		for(int i = 1; i < 10; i++) {
			Customer customer = Customer.builder().customerId(1l).build();
			
			HomeMovingOrder homeMovingOrder = HomeMovingOrder.builder()
					.customer(customer)
					.startAddress("서울시 강남구")
					.startFloor(12)
					.endAddress("서울시 동작구")
					.endFloor(5)
					.movingDate(LocalDateTime.now())
					.isStorage(true)
					.build();
			
			String content = objectMapper.writeValueAsString(homeMovingOrder);
			
			ResultActions result = mockMvc.perform(
					post("/api/v1/moving/orders")
					.content(content)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)
					);
			result.andExpect(status().isOk());
		}
		
		// 조회		
		ResultActions result2 = mockMvc.perform(
				get("/api/v1/moving/orders")
		);
		result2.andDo(print())
		.andExpect(status().isOk());
	}
	
	
}
