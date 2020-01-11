package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Truck
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-11T19:53:18.487Z[GMT]")
public class Truck   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("engineHP")
  private String engineHP = null;

  @JsonProperty("engineVolume")
  private String engineVolume = null;

  @JsonProperty("fuel")
  private String fuel = null;

  /**
   * truck segment
   */
  public enum SegmentEnum {
    LONG_HAUL("Long Haul"),
    
    CONSTRUCTION("Construction"),
    
    FIREDEPARTMENT("Firedepartment"),
    
    DISTRIBUTION_FOOD_("Distribution (Food)"),
    
    WASTEDISPOSAL("Wastedisposal");

    private String value;

    SegmentEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SegmentEnum fromValue(String text) {
      for (SegmentEnum b : SegmentEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("segment")
  private SegmentEnum segment = null;

  @JsonProperty("colors")
  @Valid
  private List<String> colors = new ArrayList<String>();

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

  public Truck engineHP(String engineHP) {
    this.engineHP = engineHP;
    return this;
  }

  /**
   * Get engineHP
   * @return engineHP
  **/
  @ApiModelProperty(example = "440 HP", required = true, value = "")
      @NotNull

    public String getEngineHP() {
    return engineHP;
  }

  public void setEngineHP(String engineHP) {
    this.engineHP = engineHP;
  }

  public Truck engineVolume(String engineVolume) {
    this.engineVolume = engineVolume;
    return this;
  }

  /**
   * Get engineVolume
   * @return engineVolume
  **/
  @ApiModelProperty(example = "10.518", required = true, value = "")
      @NotNull

    public String getEngineVolume() {
    return engineVolume;
  }

  public void setEngineVolume(String engineVolume) {
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

  public Truck segment(SegmentEnum segment) {
    this.segment = segment;
    return this;
  }

  /**
   * truck segment
   * @return segment
  **/
  @ApiModelProperty(required = true, value = "truck segment")
      @NotNull

    public SegmentEnum getSegment() {
    return segment;
  }

  public void setSegment(SegmentEnum segment) {
    this.segment = segment;
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
        Objects.equals(this.segment, truck.segment) &&
        Objects.equals(this.colors, truck.colors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, engineHP, engineVolume, fuel, segment, colors);
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
    sb.append("    segment: ").append(toIndentedString(segment)).append("\n");
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
