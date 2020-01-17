/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.15).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Truck;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-12T01:04:43.045Z[GMT]")
@Api(value = "trucks", description = "the trucks API")
public interface TrucksApi {

	@CrossOrigin(origins = "*")
    @ApiOperation(value = "Adds a new truck", nickname = "addTruck", notes = "", tags={ "truck", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Truck added successfully"),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/trucks",
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addTruck(@ApiParam(value = "Truck object" ,required=true )  @Valid @RequestBody Truck body
);

    @CrossOrigin(origins = "*")
    @ApiOperation(value = "Deletes a truck", nickname = "deleteTruck", notes = "", tags={ "truck", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Truck not found") })
    @RequestMapping(value = "/trucks/{truckId}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteTruck(@ApiParam(value = "Truck id to delete",required=true) @PathVariable("truckId") Long truckId
);

    @CrossOrigin(origins = "*")
    @ApiOperation(value = "Find truck by ID", nickname = "getTruckById", notes = "Returns a single truck", response = Truck.class, tags={ "truck", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Truck.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Truck not found") })
    @RequestMapping(value = "/trucks/{truckId}",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Truck> getTruckById(@ApiParam(value = "ID of truck to return",required=true) @PathVariable("truckId") Long truckId
);

    @CrossOrigin(origins = "*")
    @ApiOperation(value = "List all trucks", nickname = "listTruck", notes = "", response = Truck.class, responseContainer = "List", tags={ "truck", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Truck.class, responseContainer = "List") })
    @RequestMapping(value = "/trucks",
        produces = { "application/xml", "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Truck>> listTruck();


    @CrossOrigin(origins = "*")
    @ApiOperation(value = "Update an existing truck", nickname = "updateTruck", notes = "", tags={ "truck", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Truck updated successfully"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Truck not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/trucks/{truckId}",
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateTruck(@ApiParam(value = "Truck object that needs to be updated" ,required=true )  @Valid @RequestBody Truck body
,@ApiParam(value = "ID of truck to return",required=true) @PathVariable("truckId") Long truckId
);

    @CrossOrigin(origins = "*")
    @ApiOperation(value = "Updates a truck with form data", nickname = "updateTruckWithForm", notes = "", tags={ "truck", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Truck updated successfully"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/trucks/{truckId}",
        consumes = { "application/x-www-form-urlencoded" },
        method = RequestMethod.POST)
    ResponseEntity<Void> updateTruckWithForm(@ApiParam(value = "", required=true) @RequestParam(value="id", required=true)  Long id
,@ApiParam(value = "", required=true) @RequestParam(value="name", required=true)  String name
,@ApiParam(value = "", required=true) @RequestParam(value="engineHP", required=true)  Integer engineHP
,@ApiParam(value = "", required=true) @RequestParam(value="engineVolume", required=true)  Integer engineVolume
,@ApiParam(value = "", required=true) @RequestParam(value="fuel", required=true)  String fuel
,@ApiParam(value = "", required=true, allowableValues="Long Haul, Construction, Firedepartment, Distribution (Food), Wastedisposal") @RequestParam(value="segments", required=true)  List<String> segments
,@ApiParam(value = "", required=true) @RequestParam(value="colors", required=true)  List<String> colors
,@ApiParam(value = "ID of truck that needs to be updated",required=true) @PathVariable("truckId") Long truckId
);

}
