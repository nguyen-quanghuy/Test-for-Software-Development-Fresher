package com.example.simplestorage.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ReceivedNoteDto extends BaseDto {

    private String id;
    private String receiveFrom;
    private String address;
    private BigDecimal totalAmount;
    private Set<ReceivedNoteItemDto> items = new HashSet<>();
}