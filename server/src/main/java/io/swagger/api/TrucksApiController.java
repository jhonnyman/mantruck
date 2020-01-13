package io.swagger.api;

import io.swagger.model.Truck;
import io.swagger.model.Truck.SegmentsEnum;
import javassist.NotFoundException;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.bl.TrucksApiBl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-12T01:04:43.045Z[GMT]")
@RestController
public class TrucksApiController implements TrucksApi {

    private static final Logger log = LoggerFactory.getLogger(TrucksApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private TrucksApiBl truckBl;

    @org.springframework.beans.factory.annotation.Autowired
    public TrucksApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addTruck(@ApiParam(value = "Truck object" ,required=true )  @Valid @RequestBody Truck body) {
        String accept = request.getHeader("Accept");
        truckBl.addTruck(body);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    public ResponseEntity<Void> deleteTruck(@ApiParam(value = "Truck id to delete",required=true) @PathVariable("truckId") Long truckId) {
        String accept = request.getHeader("Accept");
        try {
			truckBl.deleteTruck(truckId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
    }

    public ResponseEntity<Truck> getTruckById(@ApiParam(value = "ID of truck to return",required=true) @PathVariable("truckId") Long truckId) {
        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("application/json")) {
//            try {
//                return new ResponseEntity<Truck>(objectMapper.readValue("{\n  \"engineVolume\" : 10518,\n  \"fuel\" : \"diesel\",\n  \"segment\" : \"Long Haul\",\n  \"name\" : \"TGX 18.44\",\n  \"engineHP\" : 440,\n  \"id\" : 0,\n  \"colors\" : [ \"red\", \"red\" ]\n}", Truck.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type application/json", e);
//                return new ResponseEntity<Truck>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }
        try {
			Truck truck = truckBl.getTruck(truckId);
			return new ResponseEntity<Truck>(truck, HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<Truck>(HttpStatus.NOT_FOUND);
		}
    }

    public ResponseEntity<List<Truck>> listTruck() {
        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("application/json")) {
//            try {
//                return new ResponseEntity<List<Truck>>(objectMapper.readValue("[ {\n  \"engineVolume\" : 10518,\n  \"fuel\" : \"diesel\",\n  \"segment\" : \"Long Haul\",\n  \"name\" : \"TGX 18.44\",\n  \"engineHP\" : 440,\n  \"id\" : 0,\n  \"colors\" : [ \"red\", \"red\" ]\n}, {\n  \"engineVolume\" : 10518,\n  \"fuel\" : \"diesel\",\n  \"segment\" : \"Long Haul\",\n  \"name\" : \"TGX 18.44\",\n  \"engineHP\" : 440,\n  \"id\" : 0,\n  \"colors\" : [ \"red\", \"red\" ]\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
//            } catch (IOException e) {
//                log.error("Couldn't serialize response for content type application/json", e);
//                return new ResponseEntity<List<Truck>>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }
        List<Truck> trucks;
		try {
			trucks = truckBl.listTrucks();
			return new ResponseEntity<List<Truck>>(trucks, HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<List<Truck>>(HttpStatus.NOT_FOUND);
		}

    }

    public ResponseEntity<Void> updateTruck(@ApiParam(value = "Truck object that needs to be updated" ,required=true )  @Valid @RequestBody Truck body) {
        String accept = request.getHeader("Accept");
        try {
			truckBl.updateTruck(body);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
    }
    
    public ResponseEntity<Void> updateTruckWithForm(@ApiParam(value = "", required=true) @RequestParam(value="id", required=true)  Long id
,@ApiParam(value = "", required=true) @RequestParam(value="name", required=true)  String name
,@ApiParam(value = "", required=true) @RequestParam(value="engineHP", required=true)  Integer engineHP
,@ApiParam(value = "", required=true) @RequestParam(value="engineVolume", required=true)  Integer engineVolume
,@ApiParam(value = "", required=true) @RequestParam(value="fuel", required=true)  String fuel
,@ApiParam(value = "", required=true, allowableValues="Long Haul, Construction, Firedepartment, Distribution (Food), Wastedisposal") @RequestParam(value="segments", required=true)  List<String> segments
,@ApiParam(value = "", required=true) @RequestParam(value="colors", required=true)  List<String> colors
,@ApiParam(value = "ID of truck that needs to be updated",required=true) @PathVariable("truckId") Long truckId) {
    	String accept = request.getHeader("Accept");
        try {
			truckBl.updateTruck(id, new Truck(id, name, engineHP, engineVolume, fuel, segments, colors));
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
    }

}





























