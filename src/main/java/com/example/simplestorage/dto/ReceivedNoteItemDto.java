package com.example.simplestorage.dto;

import com.example.simplestorage.constant.ItemStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ReceivedNoteItemDto extends BaseDto {
    private String id;
    private String receivedNoteId;
    private String name;
    private String code;
    private BigDecimal unitAmount;
    private Integer quantity;
    private BigDecimal totalAmount;
    private ItemStatus itemCondition;
}