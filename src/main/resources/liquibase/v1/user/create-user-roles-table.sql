CREATE TABLE tbl_user_role (
    id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL,
    user_id BIGINT UNSIGNED NOT NULL,
    role varchar(255) NOT NULL,
    is_active TINYINT(1) NOT NULL DEFAULT 1,
    CONSTRAINT pk_id_tbl_user_role PRIMARY KEY (id),
    CONSTRAINT fk_user_id_tbl_user_role FOREIGN KEY (user_id) REFERENCES tbl_user (id)
);
