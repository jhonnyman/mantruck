package io.swagger.api;

import io.swagger.model.Truck;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-11T19:53:18.487Z[GMT]")
@Controller
public class TrucksApiController implements TrucksApi {

    private static final Logger log = LoggerFactory.getLogger(TrucksApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TrucksApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addTruck(
    		@ApiParam(value = "Truck object" ,required=true ) 
    		@Valid @RequestBody Truck body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteTruck(
    		@ApiParam(value = "Truck id to delete",required=true)
    		@PathVariable("truckId") Long truckId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Truck> getTruckById(
    		@ApiParam(value = "ID of truck to return",required=true)
    		@PathVariable("truckId") Long truckId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Truck>(objectMapper.readValue("{\n  \"engineVolume\" : \"10.518\",\n  \"fuel\" : \"diesel\",\n  \"segment\" : \"Long Haul\",\n  \"name\" : \"TGX 18.44\",\n  \"engineHP\" : \"440 HP\",\n  \"id\" : 0,\n  \"colors\" : [ \"red\", \"red\" ]\n}", Truck.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Truck>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Truck>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Object>> listTruck() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Object>>(objectMapper.readValue("[ { }, { } ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Object>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateTruck(
    		@ApiParam(value = "Truck object that needs to be added to the store" ,required=true )
    		@Valid @RequestBody Truck body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateTruckWithForm(
    		@ApiParam(value = "", required=true)
    			@RequestParam(value="id", required=true)  Long id
    		,@ApiParam(value = "", required=true)
    			@RequestParam(value="name", required=true)  String name
    		,@ApiParam(value = "", required=true)
    			@RequestParam(value="engineHP", required=true)  String engineHP
			,@ApiParam(value = "", required=true)
    			@RequestParam(value="engineVolume", required=true)  String engineVolume
			,@ApiParam(value = "", required=true)
    			@RequestParam(value="fuel", required=true)  String fuel
			,@ApiParam(value = "", required=true, allowableValues="Long Haul, Construction, Firedepartment, Distribution (Food), Wastedisposal")
    			@RequestParam(value="segment", required=true)  String segment
			,@ApiParam(value = "", required=true)
    			@RequestParam(value="colors", required=true)  List<String> colors
			,@ApiParam(value = "ID of truck that needs to be updated",required=true)
				@PathVariable("truckId") Long truckId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
