package io.swagger;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.api.NotFoundException;
import io.swagger.bl.TrucksApiBl;
import io.swagger.entity.TruckEntity;
import io.swagger.model.Truck;
import io.swagger.repository.TrucksApiRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = Swagger2SpringBoot.class
)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class TruckapiApplicationITTests {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	private TrucksApiBl truckBl;
	
	private Truck truckMock;
	private TruckEntity truckEntityMock;
	
	private static Long truckId = (long) 1;
	private static String truckName = "TGX";
	private static Integer engineHP = 440;
	private static Integer engineVolume = 10500;
	private static String fuel = "Diesel";
	private static List<String> segments = Arrays.asList("Long Haul", "Wastedisposal");
	private static List<String> colors = Arrays.asList("blue", "white");
	
	
	@Before
	public void setupMock() {
		truckMock = new Truck(truckId,truckName,engineHP, engineVolume, fuel, segments,colors);
		truckEntityMock = new TruckEntity(truckMock);
	}

//	@Test
//	public void emptyListTrucksTest() throws Exception {
//		try {
//			truckBl.listTrucks();
//			assert(false);
//		}catch(NotFoundException e) {
//			assert(true);
//		}
//	}
	
	@Test
	public void addTruck() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String jsonTruck = mapper.writeValueAsString(truckMock);
		
		MvcResult result = mockMvc.perform(
			MockMvcRequestBuilders
			.post("/trucks")
			.accept(MediaType.APPLICATION_JSON)
			.content(jsonTruck)
			.contentType(MediaType.APPLICATION_JSON)
		).andReturn();
		MockHttpServletResponse response = result.getResponse();
	    assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		
	    //validate return from database
	    try{
	    	Truck truckSaved = truckBl.getTruck(truckId);
	    	assertEquals(truckId, truckSaved.getId());
	    }catch(NotFoundException e) {
	    	assert(false);
	    }
	}
	
	@Test
	public void getTruckListTest() throws Exception {
		Truck truckMock2 = new Truck((long) 2,truckName,engineHP, engineVolume, fuel, segments,colors);
		MvcResult getResult = mockMvc.perform(
				MockMvcRequestBuilders
				.get("/trucks","4")
				.accept(MediaType.APPLICATION_JSON)
				).andReturn();
		MockHttpServletResponse response = getResult.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void validateTruckExistsTest() throws Exception {
		Truck truckMock3 = new Truck((long) 3,truckName,engineHP, engineVolume, fuel, segments,colors);
		truckBl.addTruck(truckMock3);
		Truck result = truckBl.getTruck((long) 3);
		assertEquals(result.getId(), result.getId());
	}
	
	@Test
	public void deleteTruckTest() throws Exception {
		Truck truckMock4 = new Truck((long) 4,truckName,engineHP, engineVolume, fuel, segments,colors);
		truckBl.addTruck(truckMock4);
		
		MvcResult deleteResult = mockMvc.perform(
				MockMvcRequestBuilders
				.delete("/trucks/{id}","4")
				.accept(MediaType.APPLICATION_JSON)
				).andReturn();
		MockHttpServletResponse response = deleteResult.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		try {
			truckBl.getTruck((long) 4);
			assert(false);
		}catch(NotFoundException e) {
			assert(true);
		}
	}
	
	@Test
	public void deleteTruckNotFoundTest() throws Exception {
		MvcResult deleteResult = mockMvc.perform(
				MockMvcRequestBuilders
				.delete("/trucks/{id}","999")
				.accept(MediaType.APPLICATION_JSON)
				).andReturn();
		MockHttpServletResponse response = deleteResult.getResponse();
		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
	}
	
	@Test
	public void getTruckByIdTest() throws Exception {
		Truck truck = new Truck(null,truckName,engineHP, engineVolume, fuel, segments,colors);
		Long id = truckBl.addTruck(truck);
		MvcResult getResult = mockMvc.perform(
				MockMvcRequestBuilders
				.get("/trucks/{id}",id.toString())
				.accept(MediaType.APPLICATION_JSON)
				).andReturn();
		MockHttpServletResponse response = getResult.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void getTruckByIdNotFoundTest() throws Exception {
		MvcResult getResult = mockMvc.perform(
				MockMvcRequestBuilders
				.get("/trucks/{id}","9999")
				.accept(MediaType.APPLICATION_JSON)
				).andReturn();
		MockHttpServletResponse response = getResult.getResponse();
		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
	}
	
	@Test
	public void updateTruckPassingObjectInBodyTest() throws Exception {
		Truck truck = new Truck(null,truckName,engineHP, engineVolume, fuel, segments,colors);
		Long id = truckBl.addTruck(truck);
		
		Truck updatedTruck = new Truck(id,truckName,engineHP, engineVolume, fuel, segments,colors);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonTruck = mapper.writeValueAsString(updatedTruck);

		MvcResult getResult = mockMvc.perform(
				MockMvcRequestBuilders
				.put("/trucks/{id}", id.toString())
				.accept(MediaType.APPLICATION_JSON)
				.content(jsonTruck)
				.contentType(MediaType.APPLICATION_JSON)
				).andReturn();
		MockHttpServletResponse response = getResult.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void updateTruckPassingObjectInBodyNotFoundTest() throws Exception {
		Truck updatedTruck = new Truck((long) 1111,truckName,engineHP, engineVolume, fuel, segments,colors);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonTruck = mapper.writeValueAsString(updatedTruck);

		ResultActions getResult = mockMvc.perform(
				MockMvcRequestBuilders
				.put("/trucks/{id}", "1111")
				.accept(MediaType.APPLICATION_JSON)
				.content(jsonTruck)
				.contentType(MediaType.APPLICATION_JSON)
				).andExpect(status().is4xxClientError());
	}
}
