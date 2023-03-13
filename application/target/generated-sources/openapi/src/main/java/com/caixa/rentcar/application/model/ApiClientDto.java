package com.caixa.rentcar.application.model;

import java.util.Objects;
import com.caixa.rentcar.application.model.ApiRentCarOrderClientInfoDto;
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
 * ApiClientDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-13T09:38:15.714951+01:00[Europe/Madrid]")
public class ApiClientDto   {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("dni")
  private String dni;

  @JsonProperty("name")
  private String name;

  @JsonProperty("surname")
  private String surname;

  /**
   * Gets or Sets gender
   */
  public enum GenderEnum {
    VARON("VARON"),
    
    HEMBRA("HEMBRA");

    private String value;

    GenderEnum(String value) {
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
    public static GenderEnum fromValue(String value) {
      for (GenderEnum b : GenderEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("gender")
  private GenderEnum gender;

  @JsonProperty("loyalty")
  private Long loyalty;

  @JsonProperty("created_on")
  private String createdOn;

  @JsonProperty("order_history")
  @Valid
  private List<ApiRentCarOrderClientInfoDto> orderHistory = null;

  public ApiClientDto id(Long id) {
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

  public ApiClientDto dni(String dni) {
    this.dni = dni;
    return this;
  }

  /**
   * Get dni
   * @return dni
  */
  @ApiModelProperty(value = "")

@Size(max=10) 
  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public ApiClientDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ApiClientDto surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Get surname
   * @return surname
  */
  @ApiModelProperty(value = "")


  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public ApiClientDto gender(GenderEnum gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Get gender
   * @return gender
  */
  @ApiModelProperty(value = "")


  public GenderEnum getGender() {
    return gender;
  }

  public void setGender(GenderEnum gender) {
    this.gender = gender;
  }

  public ApiClientDto loyalty(Long loyalty) {
    this.loyalty = loyalty;
    return this;
  }

  /**
   * Get loyalty
   * @return loyalty
  */
  @ApiModelProperty(value = "")


  public Long getLoyalty() {
    return loyalty;
  }

  public void setLoyalty(Long loyalty) {
    this.loyalty = loyalty;
  }

  public ApiClientDto createdOn(String createdOn) {
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

  public ApiClientDto orderHistory(List<ApiRentCarOrderClientInfoDto> orderHistory) {
    this.orderHistory = orderHistory;
    return this;
  }

  public ApiClientDto addOrderHistoryItem(ApiRentCarOrderClientInfoDto orderHistoryItem) {
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

  public List<ApiRentCarOrderClientInfoDto> getOrderHistory() {
    return orderHistory;
  }

  public void setOrderHistory(List<ApiRentCarOrderClientInfoDto> orderHistory) {
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
    ApiClientDto _apiClient = (ApiClientDto) o;
    return Objects.equals(this.id, _apiClient.id) &&
        Objects.equals(this.dni, _apiClient.dni) &&
        Objects.equals(this.name, _apiClient.name) &&
        Objects.equals(this.surname, _apiClient.surname) &&
        Objects.equals(this.gender, _apiClient.gender) &&
        Objects.equals(this.loyalty, _apiClient.loyalty) &&
        Objects.equals(this.createdOn, _apiClient.createdOn) &&
        Objects.equals(this.orderHistory, _apiClient.orderHistory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, dni, name, surname, gender, loyalty, createdOn, orderHistory);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiClientDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    dni: ").append(toIndentedString(dni)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    loyalty: ").append(toIndentedString(loyalty)).append("\n");
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

