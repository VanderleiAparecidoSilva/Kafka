package com.maganets.kafkaconsumer.entity.store;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.maganets.kafkaconsumer.config.json.LocalDateTimeDeserializer;
import com.maganets.kafkaconsumer.config.json.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.util.StringUtils.trimAllWhitespace;

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

  @JsonIgnore private boolean hasSummaryValidationError;

  public String getOrderId() {
    return this.storeId.concat("-").concat(this.orderNumber);
  }

  public Boolean isOrderNCard() {
    return Objects.nonNull(this.payments)
        ? this.payments.stream()
            .filter(Objects::nonNull)
            .filter(p -> PAYMENT_CARD_NAME.equals(p.getTypePayment().getValue()))
            .filter(p -> Objects.nonNull(p.getCard().getFlag()))
            .anyMatch(p -> p.getCard().getFlag().contains(NCARD))
        : false;
  }

  public String getOrderIPAddress() {
    final boolean canReturnIp = this.ipAddress.length() <= 15;
    if (canReturnIp) {
      return this.ipAddress.trim();
    } else {
      return trimAllWhitespace(this.ipAddress).substring(0, 15);
    }
  }

  public boolean isGiftOrder() {
    return Objects.nonNull(this.products) && this.products.stream().allMatch(prd -> prd.getGift());
  }

  public boolean canConverterSummaryItems() {
    return Objects.nonNull(this.getOrderSummary())
        && Objects.nonNull(this.getOrderSummary().getItemsSummary())
        && !CollectionUtils.isEmpty(
            this.getOrderSummary().getItemsSummary().getItems().stream()
                .map(StoreItem::getItemGroupSummaryList)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));
  }

  public void setIdentifierForPersonalizations(boolean hasItemSummary, String sellerId) {
    final List<StoreProduct> productsWithPersonalizations =
        this.getProducts().stream()
            .filter(prd -> prd.getSellerID().equalsIgnoreCase(sellerId))
            .filter(prd -> prd.hasPersonalizations())
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

    if (!CollectionUtils.isEmpty(productsWithPersonalizations)) {
      productsWithPersonalizations.stream()
          .forEach(
              prd -> {
                final UUID uuid = UUID.randomUUID();
                if (StringUtils.isBlank(prd.getUuid())) {
                  prd.setUuid(uuid.toString());
                }
                if (hasItemSummary) {
                  final Optional<StoreItem> optItemSummary =
                      this.getOrderSummary().getItemsSummary().getItems().stream()
                          .filter(
                              itm ->
                                  itm.getSku().equalsIgnoreCase(prd.getSku())
                                      && itm.getSellerID().equalsIgnoreCase(prd.getSellerID())
                                      && StringUtils.isBlank(itm.getUuid()))
                          .filter(Objects::nonNull)
                          .findFirst();

                  if (optItemSummary.isPresent()) {
                    optItemSummary.get().setUuid(uuid.toString());
                  }
                }
              });
    }
  }
}
