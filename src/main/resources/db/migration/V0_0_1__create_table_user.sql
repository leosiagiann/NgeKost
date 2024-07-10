CREATE TABLE IF NOT EXISTS users
(
    id                      BIGINT          unsigned auto_increment PRIMARY KEY,
    email                   VARCHAR(128)    DEFAULT NULL comment 'Email',
    password                VARCHAR(255)    DEFAULT NULL comment 'Password',
    firstname               VARCHAR(32)     DEFAULT NULL comment 'First Name',
    lastname                VARCHAR(32)     DEFAULT NULL comment 'Last Name',
    role                    VARCHAR(32)     DEFAULT NULL comment 'Role',
    is_active               TINYINT         DEFAULT 0 NOT NULL,
    created_at              TIMESTAMP       DEFAULT CURRENT_TIMESTAMP NOT NULL comment 'created at',
    created_by              VARCHAR(32)     DEFAULT 'NgeKost server'     NOT NULL ,
    modified_at             TIMESTAMP       DEFAULT CURRENT_TIMESTAMP NOT NULL comment 'modified at',
    modified_by             VARCHAR(32)     DEFAULT 'NgeKost server'     NOT NULL,
    deleted_at              TIMESTAMP       comment 'deleted at' NULL,
    deleted_by              VARCHAR(32)     comment 'deleted by' NULL
);

CREATE UNIQUE INDEX idx_users_email ON users(email);
CREATE INDEX idx_users_is_active ON users(is_active);