package com.example.simplestorage.model;

import com.example.simplestorage.constant.ItemStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "received_note_items")
public class ReceivedNoteItems extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "received_note_id")
    private String receivedNoteId;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "unit_amount")
    private BigDecimal unitAmount;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "item_condition")
    @Enumerated(EnumType.STRING)
    private ItemStatus itemCondition;

    @ManyToOne
    @JoinColumn(name = "received_note_id", insertable = false, updatable = false, nullable = false)
    private ReceivedNotes receivedNotes;

    @PrePersist
    public void test() {
        this.receivedNoteId = this.receivedNotes.getId();
    }
}