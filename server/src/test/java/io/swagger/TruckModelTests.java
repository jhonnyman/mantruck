package io.swagger;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import io.swagger.api.NotFoundException;
import io.swagger.bl.TrucksApiBl;
import io.swagger.entity.TruckEntity;
import io.swagger.model.Truck;
import io.swagger.repository.TrucksApiRepository;

@RunWith(SpringRunner.class)
public class TruckModelTests {
	
	@MockBean
	private TrucksApiRepository truckRepository;
	
	@MockBean
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
	
	@Test
	public void truckObjectTest() throws Exception {
		assertEquals(truckId, truckMock.getId());
		assertEquals(truckName, truckMock.getName());
		assertEquals(engineHP, truckMock.getEngineHP());
		assertEquals(engineVolume, truckMock.getEngineVolume());
		assertEquals(fuel, truckMock.getFuel());
		assertEquals(segments.size(), truckMock.getSegments().size());
		assertEquals(colors.size(), truckMock.getColors().size());
		
		truckMock = new Truck(truckEntityMock);
		assertEquals(truckId, truckMock.getId());
		assertEquals(truckName, truckMock.getName());
		assertEquals(engineHP, truckMock.getEngineHP());
		assertEquals(engineVolume, truckMock.getEngineVolume());
		assertEquals(fuel, truckMock.getFuel());
		assertEquals(segments.size(), truckMock.getSegments().size());
		assertEquals(colors.size(), truckMock.getColors().size());
	}
	
	@Test
	public void validateTruckEqualsTest() throws Exception {
		Truck truck2 = null; 
		assert(!truckMock.equals(truck2));
		truck2 = truckMock;
		assert(truckMock.equals(truck2));
		truck2 = new Truck(truckId,truckName,engineHP, engineVolume, fuel, segments,colors);
		assert(truck2.equals(truckMock));
	}
	
	@Test
	public void validateTruckUtilsTest() throws Exception {
		Truck truck2 = new Truck(truckId,truckName,engineHP, engineVolume, fuel, segments,colors);
		assertEquals(truckMock.hashCode(), truck2.hashCode());
	}
	
	@Test
	public void truckEntityObjectTest() throws Exception {
		assertEquals(truckId, truckEntityMock.getId());
		assertEquals(truckName, truckEntityMock.getName());
		assertEquals(engineHP, truckEntityMock.getEngineHP());
		assertEquals(engineVolume, truckEntityMock.getEngineVolume());
		assertEquals(fuel, truckEntityMock.getFuel());
		assertEquals("Long Haul,Wastedisposal", truckEntityMock.getSegments());
		assertEquals("blue,white", truckEntityMock.getColors());
	}
	
	@Test
	public void validateTruckEntityEqualsTest() throws Exception {
		TruckEntity truckEntity2 = null; 
		assert(!truckEntityMock.equals(truckEntity2));
		truckEntity2 = truckEntityMock;
		assert(truckEntityMock.equals(truckEntity2));
		truckEntity2 = new TruckEntity(truckMock);
		assert(truckEntity2.equals(truckEntityMock));
	}
	
	@Test
	public void validateTruckEntityUtilsTest() throws Exception {
		TruckEntity truck2 = new TruckEntity(truckMock);
		assertEquals(truckEntityMock.hashCode(), truck2.hashCode());
	}

}
