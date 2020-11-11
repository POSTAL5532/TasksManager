CREATE TABLE users
(
    id             varchar(36)  NOT NULL,
    first_name     varchar(255) NOT NULL,
    last_name      varchar(255) NOT NULL,
    email          varchar(255) NOT NULL UNIQUE,
    password       varchar(255) NOT NULL,
    role           varchar(255) NOT NULL,
    reg_date       date         NOT NULL,
    status         varchar(255) NOT NULL,
    confirm_status varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE colour_themes
(
    id               varchar(36)  NOT NULL,
    name             varchar(255) NOT NULL UNIQUE,
    main_colour      varchar(7)   NOT NULL,
    secondary_colour varchar(7)   NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE projects
(
    id              varchar(36)  NOT NULL,
    owner_id        varchar(36)  NOT NULL,
    name            varchar(255) NOT NULL,
    description     longvarchar  NOT NULL,
    colour_theme_id varchar(36)  NOT NULL,
    status          varchar(255) NOT NULL,
    creation_date   date         NOT NULL,
    FOREIGN KEY (owner_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (colour_theme_id) REFERENCES colour_themes (id),
    PRIMARY KEY (id)
)
