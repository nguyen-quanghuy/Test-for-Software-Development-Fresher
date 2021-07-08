package com.example.simplestorage.controller;

import com.example.simplestorage.dto.ReceivedNoteDto;
import com.example.simplestorage.dto.request.CreateReceivedNoteRequest;
import com.example.simplestorage.dto.response.BaseResponse;
import com.example.simplestorage.dto.response.ReceiveNoteResponse;
import com.example.simplestorage.service.ReceiveNoteService;
import com.example.simplestorage.service.mapper.ReceivedNoteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@RequestMapping("received-notes")
public class ReceivedNoteController {
    private final ReceiveNoteService receiveNoteService;
    private final ReceivedNoteMapper receivedNoteMapper;

    @GetMapping
    public BaseResponse<List<ReceiveNoteResponse>> getReceivedNotes() {
        List<ReceiveNoteResponse> response = receiveNoteService.getReceivedNotes()
                .stream()
                .map(receivedNoteMapper::toResponse)
                .collect(Collectors.toList());

        return BaseResponse.ok(response);
    }

    @GetMapping({"{id}"})
    public BaseResponse<ReceiveNoteResponse> getReceivedNotes(@PathVariable String id) {
        ReceivedNoteDto dto = receiveNoteService.getReceivedNotes(id);
        return BaseResponse.ok(receivedNoteMapper.toResponse(dto));
    }

    @PostMapping
    public BaseResponse<ReceiveNoteResponse> createReceivedNote(@Valid @RequestBody final CreateReceivedNoteRequest request) {
        ReceivedNoteDto dto = receiveNoteService.createReceivedNotes(request);
        return BaseResponse.ok(receivedNoteMapper.toResponse(dto));
    }
}
