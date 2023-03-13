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
 * ApiRentCarOrderCarInfoDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-13T09:38:15.714951+01:00[Europe/Madrid]")
public class ApiRentCarOrderCarInfoDto   {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("client_dni")
  private String clientDni;

  @JsonProperty("client_fullname")
  private String clientFullname;

  @JsonProperty("start_date")
  private LocalDate startDate = null;

  @JsonProperty("end_date")
  private LocalDate endDate = null;

  @JsonProperty("created_on")
  private String createdOn;

  public ApiRentCarOrderCarInfoDto id(Long id) {
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

  public ApiRentCarOrderCarInfoDto clientDni(String clientDni) {
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

  public ApiRentCarOrderCarInfoDto clientFullname(String clientFullname) {
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

  public ApiRentCarOrderCarInfoDto startDate(LocalDate startDate) {
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

  public ApiRentCarOrderCarInfoDto endDate(LocalDate endDate) {
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

  public ApiRentCarOrderCarInfoDto createdOn(String createdOn) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiRentCarOrderCarInfoDto apiRentCarOrderCarInfo = (ApiRentCarOrderCarInfoDto) o;
    return Objects.equals(this.id, apiRentCarOrderCarInfo.id) &&
        Objects.equals(this.clientDni, apiRentCarOrderCarInfo.clientDni) &&
        Objects.equals(this.clientFullname, apiRentCarOrderCarInfo.clientFullname) &&
        Objects.equals(this.startDate, apiRentCarOrderCarInfo.startDate) &&
        Objects.equals(this.endDate, apiRentCarOrderCarInfo.endDate) &&
        Objects.equals(this.createdOn, apiRentCarOrderCarInfo.createdOn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, clientDni, clientFullname, startDate, endDate, createdOn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiRentCarOrderCarInfoDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    clientDni: ").append(toIndentedString(clientDni)).append("\n");
    sb.append("    clientFullname: ").append(toIndentedString(clientFullname)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
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

