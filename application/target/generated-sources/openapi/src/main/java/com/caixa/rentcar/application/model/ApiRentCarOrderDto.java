package com.caixa.rentcar.application.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ApiRentCarOrderDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-13T09:38:15.714951+01:00[Europe/Madrid]")
public class ApiRentCarOrderDto   {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("client_dni")
  private String clientDni;

  @JsonProperty("car_plate")
  private String carPlate;

  @JsonProperty("start_date")
  private LocalDate startDate = null;

  @JsonProperty("end_date")
  private LocalDate endDate = null;

  public ApiRentCarOrderDto id(Long id) {
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

  public ApiRentCarOrderDto clientDni(String clientDni) {
    this.clientDni = clientDni;
    return this;
  }

  /**
   * Get clientDni
   * @return clientDni
  */
  @ApiModelProperty(value = "")

@Size(max=10) 
  public String getClientDni() {
    return clientDni;
  }

  public void setClientDni(String clientDni) {
    this.clientDni = clientDni;
  }

  public ApiRentCarOrderDto carPlate(String carPlate) {
    this.carPlate = carPlate;
    return this;
  }

  /**
   * Get carPlate
   * @return carPlate
  */
  @ApiModelProperty(value = "")

@Size(max=8) 
  public String getCarPlate() {
    return carPlate;
  }

  public void setCarPlate(String carPlate) {
    this.carPlate = carPlate;
  }

  public ApiRentCarOrderDto startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Get startDate
   * @return startDate
  */
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public ApiRentCarOrderDto endDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Get endDate
   * @return endDate
  */
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiRentCarOrderDto apiRentCarOrder = (ApiRentCarOrderDto) o;
    return Objects.equals(this.id, apiRentCarOrder.id) &&
        Objects.equals(this.clientDni, apiRentCarOrder.clientDni) &&
        Objects.equals(this.carPlate, apiRentCarOrder.carPlate) &&
        Objects.equals(this.startDate, apiRentCarOrder.startDate) &&
        Objects.equals(this.endDate, apiRentCarOrder.endDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, clientDni, carPlate, startDate, endDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiRentCarOrderDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    clientDni: ").append(toIndentedString(clientDni)).append("\n");
    sb.append("    carPlate: ").append(toIndentedString(carPlate)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
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

