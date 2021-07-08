package com.example.simplestorage.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "received_notes")
public class ReceivedNotes extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "receive_from")
    private String receiveFrom;

    @Column(name = "address")
    private String address;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @OneToMany(
            mappedBy = "receivedNotes",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ReceivedNoteItems> items = new ArrayList<>();

    public void addItem(List<ReceivedNoteItems> item) {
        this.items.addAll(item);
        item.forEach(it -> it.setReceivedNotes(this));
    }
}