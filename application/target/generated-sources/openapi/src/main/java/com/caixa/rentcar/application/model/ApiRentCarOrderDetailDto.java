package com.caixa.rentcar.application.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ApiRentCarOrderDetailDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-13T09:38:15.714951+01:00[Europe/Madrid]")
public class ApiRentCarOrderDetailDto   {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("client_dni")
  private String clientDni;

  @JsonProperty("client_fullname")
  private String clientFullname;

  @JsonProperty("car_plate")
  private String carPlate;

  @JsonProperty("car_detail")
  private String carDetail;

  @JsonProperty("start_date")
  private String startDate;

  @JsonProperty("end_date")
  private String endDate;

  @JsonProperty("return_date")
  private String returnDate;

  public ApiRentCarOrderDetailDto id(Long id) {
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

  public ApiRentCarOrderDetailDto clientDni(String clientDni) {
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

  public ApiRentCarOrderDetailDto clientFullname(String clientFullname) {
    this.clientFullname = clientFullname;
    return this;
  }

  /**
   * Get clientFullname
   * @return clientFullname
  */
  @ApiModelProperty(value = "")


  public String getClientFullname() {
    return clientFullname;
  }

  public void setClientFullname(String clientFullname) {
    this.clientFullname = clientFullname;
  }

  public ApiRentCarOrderDetailDto carPlate(String carPlate) {
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

  public ApiRentCarOrderDetailDto carDetail(String carDetail) {
    this.carDetail = carDetail;
    return this;
  }

  /**
   * Get carDetail
   * @return carDetail
  */
  @ApiModelProperty(value = "")


  public String getCarDetail() {
    return carDetail;
  }

  public void setCarDetail(String carDetail) {
    this.carDetail = carDetail;
  }

  public ApiRentCarOrderDetailDto startDate(String startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Get startDate
   * @return startDate
  */
  @ApiModelProperty(value = "")


  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public ApiRentCarOrderDetailDto endDate(String endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Get endDate
   * @return endDate
  */
  @ApiModelProperty(value = "")


  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public ApiRentCarOrderDetailDto returnDate(String returnDate) {
    this.returnDate = returnDate;
    return this;
  }

  /**
   * Get returnDate
   * @return returnDate
  */
  @ApiModelProperty(value = "")


  public String getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(String returnDate) {
    this.returnDate = returnDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiRentCarOrderDetailDto apiRentCarOrderDetail = (ApiRentCarOrderDetailDto) o;
    return Objects.equals(this.id, apiRentCarOrderDetail.id) &&
        Objects.equals(this.clientDni, apiRentCarOrderDetail.clientDni) &&
        Objects.equals(this.clientFullname, apiRentCarOrderDetail.clientFullname) &&
        Objects.equals(this.carPlate, apiRentCarOrderDetail.carPlate) &&
        Objects.equals(this.carDetail, apiRentCarOrderDetail.carDetail) &&
        Objects.equals(this.startDate, apiRentCarOrderDetail.startDate) &&
        Objects.equals(this.endDate, apiRentCarOrderDetail.endDate) &&
        Objects.equals(this.returnDate, apiRentCarOrderDetail.returnDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, clientDni, clientFullname, carPlate, carDetail, startDate, endDate, returnDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiRentCarOrderDetailDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    clientDni: ").append(toIndentedString(clientDni)).append("\n");
    sb.append("    clientFullname: ").append(toIndentedString(clientFullname)).append("\n");
    sb.append("    carPlate: ").append(toIndentedString(carPlate)).append("\n");
    sb.append("    carDetail: ").append(toIndentedString(carDetail)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    returnDate: ").append(toIndentedString(returnDate)).append("\n");
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

