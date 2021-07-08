package com.example.simplestorage.service.mapper;

import com.example.simplestorage.dto.request.CreateReceivedNoteRequest;
import com.example.simplestorage.model.ReceivedNoteItems;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.math.BigDecimal;


@Mapper(componentModel = "spring")
public interface ReceivedNoteItemMapper {

    ReceivedNoteItems toEntity(CreateReceivedNoteRequest.Items item);

    @AfterMapping
    default void calculateTotalAmount(@MappingTarget ReceivedNoteItems entity) {
        BigDecimal totalAmount = entity.getUnitAmount().multiply(BigDecimal.valueOf(entity.getQuantity()));
        entity.setTotalAmount(totalAmount);
    }
}
