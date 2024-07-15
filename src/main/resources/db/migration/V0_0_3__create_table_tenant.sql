CREATE TABLE IF NOT EXISTS tenants
(
    id                      BIGINT          unsigned auto_increment PRIMARY KEY,
    room_id                 BIGINT          NOT NULL comment "Id of Room",
    full_name               VARCHAR(128)    NOT NULL comment 'Full Name',
    phone_number            VARCHAR(50)     NOT NULL comment 'Phone Number',
    id_number               VARCHAR(50)     NOT NULL comment 'Id Number (KTP)',
    last_payment            TIMESTAMP       NOT NULL comment 'Last Payment',
    is_active               TINYINT         DEFAULT 0 NOT NULL,
    created_at              TIMESTAMP       DEFAULT CURRENT_TIMESTAMP NOT NULL comment 'created at',
    created_by              VARCHAR(32)     DEFAULT 'NgeKost server'     NOT NULL ,
    modified_at             TIMESTAMP       DEFAULT CURRENT_TIMESTAMP NOT NULL comment 'modified at',
    modified_by             VARCHAR(32)     DEFAULT 'NgeKost server'     NOT NULL,
    deleted_at              TIMESTAMP       comment 'deleted at' NULL,
    deleted_by              VARCHAR(32)     comment 'deleted by' NULL
);

CREATE UNIQUE INDEX idx_tenants_phone_number ON tenants(phone_number);
CREATE UNIQUE INDEX idx_tenants_id_number ON tenants(id_number);
