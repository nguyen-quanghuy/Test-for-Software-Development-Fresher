package com.example.simplestorage.service.mapper;

import com.example.simplestorage.dto.ReceivedNoteDto;
import com.example.simplestorage.dto.request.CreateReceivedNoteRequest;
import com.example.simplestorage.dto.response.ReceiveNoteResponse;
import com.example.simplestorage.model.ReceivedNoteItems;
import com.example.simplestorage.model.ReceivedNotes;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public abstract class ReceivedNoteMapper {

    @Autowired
    ReceivedNoteItemMapper receivedNoteItemMapper;

    public abstract ReceivedNoteDto toDto(ReceivedNotes entity);

    public abstract ReceiveNoteResponse toResponse(ReceivedNoteDto entity);

    @Mapping(target = "items", ignore = true)
    public abstract ReceivedNotes toEntity(CreateReceivedNoteRequest request);

    @AfterMapping
    void setReceivedNoteItem(@MappingTarget ReceivedNotes entity, CreateReceivedNoteRequest request) {

        List<ReceivedNoteItems> items = request.getItems()
                .stream()
                .map(receivedNoteItemMapper::toEntity)
                .collect(Collectors.toList());

        entity.addItem(items);
    }

    @AfterMapping
    void calculateTotalAmount(@MappingTarget ReceivedNotes entity) {

        BigDecimal totalAmount = entity.getItems().stream()
                .map(ReceivedNoteItems::getTotalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        entity.setTotalAmount(totalAmount);
    }
}
