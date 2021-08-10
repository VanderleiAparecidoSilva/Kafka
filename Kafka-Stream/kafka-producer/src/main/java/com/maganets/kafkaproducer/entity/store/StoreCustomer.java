package com.maganets.kafkaproducer.entity.store;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.maganets.kafkaproducer.config.json.DocumentDeserializer;
import com.maganets.kafkaproducer.config.json.LocalDateDeserializer;
import com.maganets.kafkaproducer.config.json.LocalDateSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class StoreCustomer implements Serializable {

  private String catalog;
  private Long externalCode;

  @NotBlank(message = "O CAMPO NOME NÃO DEVE SER NULO OU VAZIO")
  private String name;

  private String lastName;
  private String email;
  private boolean htmlEmail;
  private boolean wishReceiveSms;
  private boolean individualPerson;
  private String storeId;

  @JsonDeserialize(using = DocumentDeserializer.class)
  @NotBlank(message = "O CAMPO CPFCNPJ NÃO DEVE SER NULO OU VAZIO")
  private String cpfCnpj;

  private String stateInscription;

  @JsonSerialize(using = LocalDateSerializer.class)
  @JsonDeserialize(using = LocalDateDeserializer.class)
  private LocalDate birthDate;

  private LocalDateTime createDate;
  private LocalDateTime updateDate;
  private String gender;
  private String phoneDDD;
  private String phoneNumber;
  private String mobileDDD;
  private String mobileNumber;
  private boolean wishReceiveEmail;
  private StoreAddress deliveryAddress;
  private StoreAddress billingAddress;
  private LocalDateTime lastUpdate;
  private String profileStatus;
}
