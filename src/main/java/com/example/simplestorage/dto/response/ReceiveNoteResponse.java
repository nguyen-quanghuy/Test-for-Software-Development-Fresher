package com.example.simplestorage.dto.response;

import com.example.simplestorage.constant.ItemStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
public class ReceiveNoteResponse {
    private String id;
    private String receiveFrom;
    private String address;
    private BigDecimal totalAmount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Set<ReceiveNoteItemsResponse> items = new HashSet<>();

    @Getter
    @Setter
    public static class ReceiveNoteItemsResponse {
        private String name;
        private String code;
        private BigDecimal unitAmount;
        private Integer quantity;
        private BigDecimal totalAmount;
        private ItemStatus itemCondition;
    }
}
