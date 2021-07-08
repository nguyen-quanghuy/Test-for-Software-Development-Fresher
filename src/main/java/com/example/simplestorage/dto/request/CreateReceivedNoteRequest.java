package com.example.simplestorage.dto.request;

import com.example.simplestorage.constant.ItemStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;


@Getter
@Setter
public class CreateReceivedNoteRequest {

    @NotBlank(message = "receiveFrom is required")
    private String receiveFrom;

    @NotBlank(message = "address is required")
    private String address;

    @Valid
    @NotNull
    private Set<Items> items;

    @Getter
    @Setter
    public static class Items {

        @NotBlank(message = "name is required")
        private String name;

        @NotBlank(message = "code is required")
        private String code;

        @NotNull(message = "unitAmount is required")
        private BigDecimal unitAmount;

        @NotNull(message = "quantity is required")
        private Integer quantity;

        @NotNull(message = "itemCondition is required")
        private ItemStatus itemCondition;
    }
}
