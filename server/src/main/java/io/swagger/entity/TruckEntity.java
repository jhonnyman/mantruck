package io.swagger.entity;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.model.Truck;
import io.swagger.model.Truck.SegmentsEnum;

@Entity
@Table(name="TRUCK")
public class TruckEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator_truck")
    @SequenceGenerator(name = "sequence_generator_truck", sequenceName="seq_truck", allocationSize = 1)
    private Long id;
	
	@NotNull
    @Size(max = 256)
    @Column(name = "name", length = 256, nullable = false, unique = true)
    private String name;
	
	@NotNull
    @Column(name = "engine_hp", nullable = false)
    private Integer engineHP;
	
	@NotNull
    @Column(name = "engine_volume", nullable = false)
    private Integer engineVolume;
	
	@NotNull
    @Size(max = 10)
    @Column(name = "fuel", length = 10, nullable = false)
    private String fuel;
	
	@NotNull
    @Size(max = 256)
    @Column(name = "segments", length = 256, nullable = false)
    private String segments;
	
	@NotNull
    @Size(max = 256)
    @Column(name = "colors", length = 256)
    private String colors;
	
	public TruckEntity() {
		
	}
	
	public TruckEntity(Truck truck) {
		setId(truck.getId());
		setName(truck.getName());
		setEngineHP(truck.getEngineHP());
		setEngineVolume(truck.getEngineVolume());
		setFuel(truck.getFuel());
		setSegments(truck.getSegments());
		setColors(truck.getColors());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEngineHP() {
		return engineHP;
	}

	public void setEngineHP(Integer engineHP) {
		this.engineHP = engineHP;
	}

	public Integer getEngineVolume() {
		return engineVolume;
	}

	public void setEngineVolume(Integer engineVolume) {
		this.engineVolume = engineVolume;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getSegments() {
		return segments;
	}

	public void setSegments(String segments) {
		this.segments = segments;
	}
	
	public void setSegments(List<SegmentsEnum> segments) {
		if(segments != null)
			for (SegmentsEnum segment : segments) {
				if(this.segments == null || this.segments.isEmpty()) {
					this.segments = segment.toString();
				}else {
					this.segments += "," + segment.toString();
				}
			}
	}

	public String getColors() {
		return colors;
	}

	public void setColors(String colors) {
		this.colors = colors;
	}
	
	public void setColors(List<String> colorsList) {
		if(colorsList != null)
			for (String color : colorsList) {
				if(this.colors == null || this.colors.isEmpty()) {
					this.colors = color;
				}else {
					this.colors += "," + color;
				}
			}
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TruckEntity)) {
            return false;
        }
        return id != null && id.equals(((TruckEntity) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Country{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", engineHP='" + getEngineHP() + "'" +
            ", engineVolume='" + getEngineVolume() + "'" +
            ", fuel='" + getFuel() + "'" +
            ", segment='" + getSegments() + "'" +
            ", colors='" + getColors() + "'" +
            "}";
    }
}
