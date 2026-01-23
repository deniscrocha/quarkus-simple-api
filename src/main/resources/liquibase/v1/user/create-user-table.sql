CREATE TABLE tbl_user (
    id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL,
    username varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    creation_date TIMESTAMP DEFAULT now(),
    modification_date TIMESTAMP DEFAULT now(),
    is_active TINYINT(1) NOT NULL DEFAULT 1,
    CONSTRAINT pk_id_tbl_user PRIMARY KEY (id)
);