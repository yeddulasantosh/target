package com.targetrecruiting.rest.service.unittest;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.targetrecruiting.rest.model.Item;
import com.targetrecruiting.rest.model.Product;
import com.targetrecruiting.rest.model.ProductData;
import com.targetrecruiting.rest.model.ProductDescription;
import com.targetrecruiting.rest.service.RestClientService;
import com.targetrecruiting.rest.service.RestClientServiceImpl;

@RunWith(SpringRunner.class)
@RestClientTest(RestClientServiceImpl.class)
public class ClientTest {

	@Autowired
	private RestClientService client;
	
	@Autowired
	private MockRestServiceServer server;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Before
	public void setUp() throws Exception{
		ProductDescription desc = new ProductDescription("The Big Lebowski");
		Item item = new Item("13860428",desc);
		Product prd = new Product(item);
		String productData = mapper.writeValueAsString(new ProductData(prd));
		this.server.expect(requestTo("https://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics,deep_red_labels"))
				.andRespond(withSuccess(productData, MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void getProductNameTest() throws Exception{
		ProductData data = this.client.getProductName("https://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics,deep_red_labels","13860428");
	    assertThat(data.getProduct().getItem().getDescription().getTitle(),is(equalTo("The Big Lebowski")));
	}
	
}
