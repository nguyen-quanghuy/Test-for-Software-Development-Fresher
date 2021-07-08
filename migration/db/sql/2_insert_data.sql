INSERT INTO received_notes (id, receive_from, address, total_amount, created_at, updated_at)
VALUES (1, 'New Market', 'Hanoi, Vietnam', 500000, CURDATE(), CURDATE());

INSERT INTO received_note_items (id, received_note_id, name, code, unit_amount, quantity, total_amount, item_condition,
                                 created_at, updated_at)
VALUES (1, 1, 'Apple', 'APL', 20000, 10, 200000, 'NEW', CURDATE(), CURDATE()),
       (2, 1, 'Peach', 'PCH', 30000, 10, 300000, 'NEW', CURDATE(), CURDATE());


