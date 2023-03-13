package com.caixa.rentcar.application.model;

import java.util.Objects;
import com.caixa.rentcar.application.model.ApiRentCarOrderCarInfoDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ApiCarInfoDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-13T09:38:15.714951+01:00[Europe/Madrid]")
public class ApiCarInfoDto   {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("plate")
  private String plate;

  @JsonProperty("make")
  private String make;

  @JsonProperty("model")
  private String model;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    PREMIUN("PREMIUN"),
    
    SUV("SUV"),
    
    SMALL("SMALL");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("type")
  private TypeEnum type;

  @JsonProperty("year")
  private Long year;

  @JsonProperty("created_on")
  private String createdOn;

  @JsonProperty("order_history")
  @Valid
  private List<ApiRentCarOrderCarInfoDto> orderHistory = null;

  public ApiCarInfoDto id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ApiCarInfoDto plate(String plate) {
    this.plate = plate;
    return this;
  }

  /**
   * Get plate
   * @return plate
  */
  @ApiModelProperty(value = "")

@Size(max=8) 
  public String getPlate() {
    return plate;
  }

  public void setPlate(String plate) {
    this.plate = plate;
  }

  public ApiCarInfoDto make(String make) {
    this.make = make;
    return this;
  }

  /**
   * Get make
   * @return make
  */
  @ApiModelProperty(value = "")


  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public ApiCarInfoDto model(String model) {
    this.model = model;
    return this;
  }

  /**
   * Get model
   * @return model
  */
  @ApiModelProperty(value = "")


  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public ApiCarInfoDto type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @ApiModelProperty(value = "")


  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public ApiCarInfoDto year(Long year) {
    this.year = year;
    return this;
  }

  /**
   * Get year
   * @return year
  */
  @ApiModelProperty(value = "")


  public Long getYear() {
    return year;
  }

  public void setYear(Long year) {
    this.year = year;
  }

  public ApiCarInfoDto createdOn(String createdOn) {
    this.createdOn = createdOn;
    return this;
  }

  /**
   * Get createdOn
   * @return createdOn
  */
  @ApiModelProperty(value = "")


  public String getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(String createdOn) {
    this.createdOn = createdOn;
  }

  public ApiCarInfoDto orderHistory(List<ApiRentCarOrderCarInfoDto> orderHistory) {
    this.orderHistory = orderHistory;
    return this;
  }

  public ApiCarInfoDto addOrderHistoryItem(ApiRentCarOrderCarInfoDto orderHistoryItem) {
    if (this.orderHistory == null) {
      this.orderHistory = new ArrayList<>();
    }
    this.orderHistory.add(orderHistoryItem);
    return this;
  }

  /**
   * Get orderHistory
   * @return orderHistory
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<ApiRentCarOrderCarInfoDto> getOrderHistory() {
    return orderHistory;
  }

  public void setOrderHistory(List<ApiRentCarOrderCarInfoDto> orderHistory) {
    this.orderHistory = orderHistory;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiCarInfoDto apiCarInfo = (ApiCarInfoDto) o;
    return Objects.equals(this.id, apiCarInfo.id) &&
        Objects.equals(this.plate, apiCarInfo.plate) &&
        Objects.equals(this.make, apiCarInfo.make) &&
        Objects.equals(this.model, apiCarInfo.model) &&
        Objects.equals(this.type, apiCarInfo.type) &&
        Objects.equals(this.year, apiCarInfo.year) &&
        Objects.equals(this.createdOn, apiCarInfo.createdOn) &&
        Objects.equals(this.orderHistory, apiCarInfo.orderHistory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, plate, make, model, type, year, createdOn, orderHistory);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiCarInfoDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    plate: ").append(toIndentedString(plate)).append("\n");
    sb.append("    make: ").append(toIndentedString(make)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
    sb.append("    orderHistory: ").append(toIndentedString(orderHistory)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

