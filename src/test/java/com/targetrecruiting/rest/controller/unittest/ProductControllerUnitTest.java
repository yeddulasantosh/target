package com.targetrecruiting.rest.controller.unittest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.targetrecruiting.rest.controller.ProductController;
import com.targetrecruiting.rest.model.Item;
import com.targetrecruiting.rest.model.ProductDescription;
import com.targetrecruiting.rest.model.ProductDetails;
import com.targetrecruiting.rest.model.ProductPrice;
import com.targetrecruiting.rest.service.ServiceManager;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class, secure = false)
public class ProductControllerUnitTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ServiceManager manager;

	@Autowired
	private ObjectMapper mapper;
	
	ProductDetails details;
	String expected;
	Item item;
	ProductPrice price;
	String updatePriceJson;
	ProductPrice updatePrice;
	ProductDetails updatedDetails;

	@Before
	public void setUp() throws JsonProcessingException {
		ProductDescription desc = new ProductDescription("The Big Lebowski (Blu-ray)");
		item = new Item("13860428", desc);
		price = new ProductPrice("13860428", "10", "US");
		details = new ProductDetails("13860428", "The Big Lebowski (Blu-ray)", price);
		updatePrice = new ProductPrice("13860428", "20", "US");
		updatedDetails = new ProductDetails("13860428", "The Big Lebowski (Blu-ray)",updatePrice);
		updatePriceJson = mapper.writeValueAsString(updatedDetails);
		Mockito.when(manager.externalRestCall(Mockito.anyString(), Mockito.anyString())).thenReturn(item);
		Mockito.when(manager.findByProductId(Mockito.anyString())).thenReturn(price);
		Mockito.when(manager.save(Mockito.any())).thenReturn(updatePrice);
		expected = mapper.writeValueAsString(details);
	}

	@Test
	public void getProductDetails() throws Exception {
		RequestBuilder builder = MockMvcRequestBuilders.get("/products/13860428").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(builder).andReturn();
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
	}
	
	@Test
	public void updateProductPrice() throws Exception{
		
		RequestBuilder builder = MockMvcRequestBuilders.put("/products/13860428").
				                 accept(MediaType.APPLICATION_JSON).content(updatePriceJson).
				                 contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(builder).andReturn();
		JSONAssert.assertEquals(updatePriceJson,result.getResponse().getContentAsString(),true);
		
	}

}
