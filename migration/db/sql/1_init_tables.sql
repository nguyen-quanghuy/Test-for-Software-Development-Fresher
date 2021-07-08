CREATE TABLE received_notes
(
    id           BIGINT AUTO_INCREMENT,
    receive_from VARCHAR(100) NULL,
    address      VARCHAR(100) NULL,
    total_amount DECIMAL      NULL,
    created_at   DATETIME     NULL,
    updated_at   DATETIME     NULL,
    CONSTRAINT received_notes_pk PRIMARY KEY (id)
);

create table received_note_items
(
    id               BIGINT AUTO_INCREMENT,
    received_note_id BIGINT               NOT NULL,
    name             VARCHAR(100)         NULL,
    code             VARCHAR(100)         NULL,
    unit_amount      DECIMAL              NULL,
    quantity         INT                  NULL,
    total_amount     DECIMAL              NULL,
    item_condition   ENUM ('NEW', 'USED') NULL,
    created_at       DATETIME             NULL,
    updated_at       DATETIME             NULL,
    CONSTRAINT received_note_item_pk PRIMARY KEY (id)
);

