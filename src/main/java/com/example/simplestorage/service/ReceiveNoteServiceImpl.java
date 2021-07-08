package com.example.simplestorage.service;

import com.example.simplestorage.dto.ReceivedNoteDto;
import com.example.simplestorage.dto.request.CreateReceivedNoteRequest;
import com.example.simplestorage.exception.ResourceNotFoundException;
import com.example.simplestorage.model.ReceivedNotes;
import com.example.simplestorage.repository.ReceivedNoteRepository;
import com.example.simplestorage.service.mapper.ReceivedNoteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReceiveNoteServiceImpl implements ReceiveNoteService {
    private final ReceivedNoteRepository receivedNoteRepository;
    private final ReceivedNoteMapper receivedNoteMapper;

    @Override
    public List<ReceivedNoteDto> getReceivedNotes() {
        return receivedNoteRepository.getAllWithItems()
                .stream()
                .map(receivedNoteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReceivedNoteDto getReceivedNotes(String id) {
        return receivedNoteRepository.getAllWithItems(id)
                .map(receivedNoteMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Received Note not found. ID " + id));
    }

    @Override
    @Transactional
    public ReceivedNoteDto createReceivedNotes(CreateReceivedNoteRequest request) {
        ReceivedNotes entity = receivedNoteRepository.save(receivedNoteMapper.toEntity(request));
        return receivedNoteMapper.toDto(entity);
    }
}
