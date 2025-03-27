package com.iot.iotprojectnew.dto;

import lombok.Data;

@Data
public class SePayWebhookDTO {
    private long id;
    private String gateway;
    private String transactionDate;
    private String accountNumber;
    private String code;
    private String content;
    private String transferType;
    private long transferAmount;
    private long accumulated;
    private String subAccount;
    private String referenceCode;
    private String description;
}
