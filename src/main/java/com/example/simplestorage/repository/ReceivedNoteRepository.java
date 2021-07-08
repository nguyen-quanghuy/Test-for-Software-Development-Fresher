package com.example.simplestorage.repository;

import com.example.simplestorage.model.ReceivedNotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReceivedNoteRepository extends JpaRepository<ReceivedNotes, Integer> {

    @Query("SELECT r from ReceivedNotes r JOIN FETCH r.items")
    List<ReceivedNotes> getAllWithItems();

    @Query("SELECT r from ReceivedNotes r JOIN FETCH r.items WHERE r.id = ?1")
    Optional<ReceivedNotes> getAllWithItems(String id);
}
