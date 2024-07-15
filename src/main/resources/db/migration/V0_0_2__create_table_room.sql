CREATE TABLE IF NOT EXISTS rooms
(
    id                      BIGINT          unsigned auto_increment PRIMARY KEY,
    room_number             VARCHAR(128)    NOT NULL comment 'Room Number',
    price                   DECIMAL(10,2)   NOT NULL comment 'Price Room',
    floor                   INTEGER         NOT NULL comment 'Room floor',
    facilities              TEXT            DEFAULT NULL comment 'Facilites Room',
    status                  VARCHAR(20)     NOT NULL DEFAULT 'available',
    is_active               TINYINT         DEFAULT 0 NOT NULL,
    created_at              TIMESTAMP       DEFAULT CURRENT_TIMESTAMP NOT NULL comment 'created at',
    created_by              VARCHAR(32)     DEFAULT 'NgeKost server'     NOT NULL ,
    modified_at             TIMESTAMP       DEFAULT CURRENT_TIMESTAMP NOT NULL comment 'modified at',
    modified_by             VARCHAR(32)     DEFAULT 'NgeKost server'     NOT NULL,
    deleted_at              TIMESTAMP       comment 'deleted at' NULL,
    deleted_by              VARCHAR(32)     comment 'deleted by' NULL
);

CREATE UNIQUE INDEX idx_rooms_number ON rooms(room_number);
CREATE INDEX idx_rooms_floor ON rooms(floor);
CREATE INDEX idx_rooms_is_active ON rooms(is_active);

