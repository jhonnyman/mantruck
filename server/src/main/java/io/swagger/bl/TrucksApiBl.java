package io.swagger.bl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.api.NotFoundException;
import io.swagger.entity.TruckEntity;
import io.swagger.model.Truck;
import io.swagger.repository.TrucksApiRepository;

@Component
public class TrucksApiBl {

	@Autowired
	private TrucksApiRepository truckRepository;
	
	public List<Truck> listTrucks() throws NotFoundException{
		List<Truck> trucks = new ArrayList<>();
		Iterable<TruckEntity> result = truckRepository.findAll();
//		if(result == null) {
//			throw new NotFoundException(404, "No trucks available.");
//		}
		for(TruckEntity tuckEntity : result) {
			trucks.add(new Truck(tuckEntity));
		}
		if(trucks.isEmpty()) {
			throw new NotFoundException(404,"No trucks available.");
		}
		return trucks;
	}

	public Long addTruck(Truck truck) {
		TruckEntity result = truckRepository.save(new TruckEntity(truck));
		return result.getId();
	}
	
	public Truck getTruck(Long truckId) throws NotFoundException {
		TruckEntity truckEntity = truckRepository.findOne(truckId);
		if(truckEntity == null)
			throw new NotFoundException(404, "The truckId " + truckId + " does not exist.");
		return new Truck(truckEntity);
	}
	
	public void updateTruck(Long truckId, Truck truck) throws NotFoundException {
		validateTruckExists(truckId);
		truckRepository.save(new TruckEntity(truck));
	}
	
	public void updateTruck(Truck truck) throws NotFoundException {
		validateTruckExists(truck.getId());
		truckRepository.save(new TruckEntity(truck));
	}
	
	public void deleteTruck(Long truckId) throws NotFoundException {
		validateTruckExists(truckId);
		truckRepository.delete(truckId);
	}
	
	public void validateTruckExists(Long truckId) throws NotFoundException {
		if(truckRepository.findOne(truckId) == null) {
			throw new NotFoundException(404, "The truckId " + truckId + " does not exist.");
		}
	}
}
