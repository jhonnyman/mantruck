package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.entity.TruckEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Truck
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-12T01:04:43.045Z[GMT]")
public class Truck   {
	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("engineHP")
	private Integer engineHP = null;

	@JsonProperty("engineVolume")
	private Integer engineVolume = null;

	@JsonProperty("fuel")
	private String fuel = null;

	/**
	 * truck segment
	 */
	public enum SegmentsEnum {
		LONG_HAUL("Long Haul"),

		CONSTRUCTION("Construction"),

		FIREDEPARTMENT("Firedepartment"),

		DISTRIBUTION_FOOD_("Distribution (Food)"),

		WASTEDISPOSAL("Wastedisposal");

		private String value;

		SegmentsEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static SegmentsEnum fromValue(String text) {
			for (SegmentsEnum b : SegmentsEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}
	@JsonProperty("segments")
	@Valid
  	private List<SegmentsEnum> segments = null;

	@JsonProperty("colors")
	@Valid
	private List<String> colors = new ArrayList<String>();

	public Truck() {
	}
	
	
	public Truck(TruckEntity truck) {
		setId(truck.getId());
		setName(truck.getName());
		setEngineHP(truck.getEngineHP());
		setEngineVolume(truck.getEngineVolume());
		setFuel(truck.getFuel());
		if(truck.getSegments() != null && !truck.getSegments().isEmpty()) {
			List<String> entitySegments = Arrays.asList(truck.getSegments().split(","));
			for (String segment : entitySegments) {
				addSegmentsItem(SegmentsEnum.fromValue(segment));
			}
		}
		if(truck.getColors() != null && !truck.getColors().isEmpty()) {
			List<String> colors = new ArrayList<String>();
			setColors(Arrays.asList(truck.getColors().split(",")));
		}
	}

	public Truck(Long id, String name, Integer engineHP, Integer engineVolume, String fuel, List<String> segments, List<String> colors) {
		setId(id);
		setName(name);
		setEngineHP(engineHP);
		setEngineVolume(engineVolume);
		setFuel(fuel);
		for (String segment : segments) {
			addSegmentsItem(SegmentsEnum.fromValue(segment));
		}
		setColors(colors);
	}

	public Truck id(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * @return id
	 **/
	@ApiModelProperty(value = "")

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Truck name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * @return name
	 **/
	@ApiModelProperty(example = "TGX 18.44", required = true, value = "")
	@NotNull

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Truck engineHP(Integer engineHP) {
		this.engineHP = engineHP;
		return this;
	}

	/**
	 * Get engineHP
	 * @return engineHP
	 **/
	@ApiModelProperty(example = "440", required = true, value = "")
	@NotNull

	public Integer getEngineHP() {
		return engineHP;
	}

	public void setEngineHP(Integer engineHP) {
		this.engineHP = engineHP;
	}

	public Truck engineVolume(Integer engineVolume) {
		this.engineVolume = engineVolume;
		return this;
	}

	/**
	 * Get engineVolume
	 * @return engineVolume
	 **/
	@ApiModelProperty(example = "10518", required = true, value = "")
	@NotNull

	public Integer getEngineVolume() {
		return engineVolume;
	}

	public void setEngineVolume(Integer engineVolume) {
		this.engineVolume = engineVolume;
	}

	public Truck fuel(String fuel) {
		this.fuel = fuel;
		return this;
	}

	/**
	 * Get fuel
	 * @return fuel
	 **/
	@ApiModelProperty(example = "diesel", value = "")

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public Truck segments(List<SegmentsEnum> segments) {
	    this.segments = segments;
	    return this;
	}

	public Truck addSegmentsItem(SegmentsEnum segmentsItem) {
	    if (this.segments == null) {
	      this.segments = new ArrayList<SegmentsEnum>();
	    }
	    this.segments.add(segmentsItem);
	    return this;
	}

	/**
	 * Get segments
	 * @return segments
	 **/
	@ApiModelProperty(example = "[\"Construction\",\"Firedepartment\"]", value = "")
	
	public List<SegmentsEnum> getSegments() {
		return segments;
	}

	public void setSegments(List<SegmentsEnum> segments) {
		this.segments = segments;
	}

	public Truck colors(List<String> colors) {
		this.colors = colors;
		return this;
	}

	public Truck addColorsItem(String colorsItem) {
		this.colors.add(colorsItem);
		return this;
	}

	/**
	 * Get colors
	 * @return colors
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull

	public List<String> getColors() {
		return colors;
	}

	public void setColors(List<String> colors) {
		this.colors = colors;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Truck truck = (Truck) o;
		return Objects.equals(this.id, truck.id) &&
				Objects.equals(this.name, truck.name) &&
				Objects.equals(this.engineHP, truck.engineHP) &&
				Objects.equals(this.engineVolume, truck.engineVolume) &&
				Objects.equals(this.fuel, truck.fuel) &&
				Objects.equals(this.segments, truck.segments) &&
				Objects.equals(this.colors, truck.colors);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, engineHP, engineVolume, fuel, segments, colors);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Truck {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    engineHP: ").append(toIndentedString(engineHP)).append("\n");
		sb.append("    engineVolume: ").append(toIndentedString(engineVolume)).append("\n");
		sb.append("    fuel: ").append(toIndentedString(fuel)).append("\n");
		sb.append("    segment: ").append(toIndentedString(segments)).append("\n");
		sb.append("    colors: ").append(toIndentedString(colors)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
