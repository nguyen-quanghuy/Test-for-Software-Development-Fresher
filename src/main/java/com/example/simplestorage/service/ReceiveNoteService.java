package com.example.simplestorage.service;

import com.example.simplestorage.dto.ReceivedNoteDto;
import com.example.simplestorage.dto.request.CreateReceivedNoteRequest;

import java.util.List;

public interface ReceiveNoteService {
    List<ReceivedNoteDto> getReceivedNotes();

    ReceivedNoteDto getReceivedNotes(String id);

    ReceivedNoteDto createReceivedNotes(CreateReceivedNoteRequest request);
}
