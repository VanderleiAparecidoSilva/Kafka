package com.maganets.kafkaproducer.entity.store;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.maganets.kafkaproducer.config.json.LocalDateTimeDeserializer;
import com.maganets.kafkaproducer.config.json.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@Slf4j
public class StoreOrder implements Serializable {

  private static final String NCARD = "NCARD";
  public static final String PAYMENT_CARD_NAME = "CARTAO";

  @NotBlank(message = "O NÚMERO DO PEDIDO NÃO DEVE SER NULO OU VAZIO")
  private String orderNumber;

  private String catalogCode;

  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @NotBlank(message = "A DATA DE VENDA NÃO DEVE SER NULA OU VAZIA")
  private LocalDateTime saleDate;

  private StoreOrderStatus status;
  private String couponCode;
  private String campaignCode;

  @NotBlank(message = "O CAMPO 'CODIGO DO CLIENTE' NÃO DEVE SER NULO OU VAZIO")
  private String customerCode;

  private String customerEmail;

  @NotBlank(message = "O CAMPO CPFCNPJ NÃO DEVE SER NULO OU VAZIO")
  private String customerCPFCNPJ;

  private BigDecimal subTotal;

  @NotNull(message = "O CAMPO 'VALOR DO DESCONTO' NÃO DEVE SER NULO")
  private BigDecimal discountValue;

  @NotNull(message = "O CAMPO 'VALOR DO DESCONTO DO BOLETO' NÃO DEVE SER NULO")
  private BigDecimal billetDiscountValue;

  @NotNull(
      message = "O CAMPO 'VALOR DO DESCONTO PARA OUTRAS FORMAS DE PAGAMENTO' NÃO DEVE SER NULO")
  private BigDecimal otherDiscountValue;

  @NotNull(message = "O CAMPO 'VALOR DO PEDIDO' NÃO DEVE SER NULO")
  private BigDecimal totalOrderValue;

  private StoreOrderSummary orderSummary;

  private List<StoreProduct> products;

  @NotNull(message = "A LISTA DE PAGAMENTOS NÃO PODE SER NULA")
  private List<StorePayment> payments;

  private List<StoreShipping> shippings;
  private List<StorePromotion> promotions;
  private String utmcampaignCode;
  private String ipAddress;
  private String phoneNumber;
  private String phoneDDD;
  private String origin;
  private String guidReserve;
  private Boolean reservedStock;
  private String fingerprint;
  private String storeId;
}
