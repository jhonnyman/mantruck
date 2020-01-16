package io.swagger;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import io.swagger.entity.TruckEntity;
import io.swagger.model.ModelApiResponse;
import io.swagger.model.Truck;

@RunWith(SpringRunner.class)
public class ModelApiResponseTest {

	private ModelApiResponse apiResponse;
	
	@Before
	public void setupMock() {
		apiResponse = new ModelApiResponse();
	}
	
	@Test
	public void validateInputFieldsTest() throws Exception {
		apiResponse.message("message");
		assertEquals("message", apiResponse.getMessage());
		apiResponse.setMessage("message2");
		assertEquals("message2", apiResponse.getMessage());
		
		apiResponse.code(100);
		assertEquals(100, (int) apiResponse.getCode());
		apiResponse.setCode(200);
		assertEquals(200, (int) apiResponse.getCode());
		
		apiResponse.type("type");
		assertEquals("type", apiResponse.getType());
		apiResponse.setType("type");
		assertEquals("type", apiResponse.getType());
	}
	
	@Test
	public void validateEqualsTest() throws Exception {
		apiResponse.message("message");
		apiResponse.code(100);
		apiResponse.type("type");
		
		ModelApiResponse response2 = null;
		assert(!apiResponse.equals(response2));
		response2 = apiResponse;
		assert(apiResponse.equals(response2));
		
		response2 = new ModelApiResponse();
		response2.message("message");
		response2.code(100);
		response2.type("type");
		assert(apiResponse.equals(response2));
		
		assertEquals(apiResponse.hashCode(), response2.hashCode());
	}
	
	@Test
	public void validateHashCodeTest() throws Exception {
		apiResponse.message("message");
		apiResponse.code(100);
		apiResponse.type("type");
		
		ModelApiResponse response2 = null;
		response2 = new ModelApiResponse();
		response2.message("message");
		response2.code(100);
		response2.type("type");
		
		assertEquals(apiResponse.hashCode(), response2.hashCode());
	}
	
	@Test
	public void validateToStringTest() throws Exception {
		apiResponse.message("message");
		apiResponse.code(100);
		
		assert(!apiResponse.toString().isEmpty());
	}
	
}
