/**
 * Users table
 *
 * id - user ID
 * first_name - user first name
 * last_name - user last name
 * email - user email
 * password - user password
 * role - user role
 * reg_date - user registration date
 * status - user account status
 * confirm_status - user email confirmation status
 */
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

/**
 * OAuth tokens table
 */
CREATE TABLE oauth_access_token
(
    authentication_id varchar(255) NOT NULL PRIMARY KEY,
    token_id          varchar(255) NOT NULL,
    token             blob         NOT NULL,
    user_name         varchar(255) NOT NULL,
    client_id         varchar(255) NOT NULL,
    authentication    blob         NOT NULL,
    refresh_token     varchar(255) NOT NULL
);

/**
 * OAuth refresh-tokens table
 */
CREATE TABLE oauth_refresh_token
(
    token_id       varchar(255) NOT NULL,
    token          blob         NOT NULL,
    authentication blob         NOT NULL
);

/**
 * Project colour themes table
 *
 * id - theme ID
 * name - theme name
 * main_colour - main colour in HEX
 * secondary_colour - secondary colour in HEX
 */
CREATE TABLE colour_themes
(
    id               varchar(36)  NOT NULL,
    name             varchar(255) NOT NULL UNIQUE,
    main_colour      varchar(7)   NOT NULL,
    secondary_colour varchar(7)   NOT NULL,
    PRIMARY KEY (id)
);

/**
 * Projects table
 *
 * id - project ID
 * name - project name
 * short_name - project short name
 * description - project description
 * colour_theme_id - project colour theme
 * status - project status (published/draft)
 * creation_date - project creation date
 */
CREATE TABLE projects
(
    id              varchar(36)  NOT NULL,
    name            varchar(255) NOT NULL,
    short_name      varchar(255) NOT NULL,
    description     longvarchar  NOT NULL,
    colour_theme_id varchar(36)  NOT NULL,
    status          varchar(255) NOT NULL,
    creation_date   date         NOT NULL,
    FOREIGN KEY (colour_theme_id) REFERENCES colour_themes (id),
    PRIMARY KEY (id)
);

/**
 * Tasks table
 *
 * id - task ID
 * project_id - project id
 * author_id - task author (user) id
 * executor_id - task executor (user) id
 * name - task name
 * short_name - task short name (project short name + task number)
 * description - task description
 * level - task level (minor/major/critical)
 * status - task status (need_to_solve/in_process/ready_to_check/solved)
 * type - task type (story/task)
 * creation_date - task creation date
 * change_date - task last change date
 */
CREATE TABLE tasks
(
    id             varchar(36)  NOT NULL,
    project_id     varchar(36)  NOT NULL,
    parent_task_id varchar(36),
    author_id      varchar(36),
    executor_id    varchar(36),
    name           varchar(255) NOT NULL,
    short_name     varchar(255) NOT NULL,
    description    longvarchar,
    level          varchar(255) NOT NULL,
    status         varchar(255) NOT NULL,
    type           varchar(255) NOT NULL,
    creation_date  timestamp    NOT NULL,
    ending_date    date,
    change_date    timestamp,
    FOREIGN KEY (project_id) REFERENCES projects (id) ON DELETE CASCADE,
    FOREIGN KEY (parent_task_id) REFERENCES tasks (id) ON DELETE CASCADE,
    FOREIGN KEY (author_id) REFERENCES users (id) ON DELETE SET NULL,
    FOREIGN KEY (executor_id) REFERENCES users (id) ON DELETE SET NULL,
    PRIMARY KEY (id)
);

/**
 * Tasks relations table
 *
 * id - relation ID
 * task_id - from task relation
 * relation_type - relation type (sub_task/blocker/simple)
 * related_task_id - to task relation
 */
CREATE TABLE tasks_relations
(
    id              varchar(36)  NOT NULL,
    task_id         varchar(36)  NOT NULL,
    relation_type   varchar(255) NOT NULL,
    related_task_id varchar(36)  NOT NULL,
    FOREIGN KEY (task_id) REFERENCES tasks (id) ON DELETE CASCADE,
    FOREIGN KEY (related_task_id) REFERENCES tasks (id) ON DELETE CASCADE,
    PRIMARY KEY (id)
);

/**
 * Project participant access table
 *
 * id - user project access ID
 * project_id - project id
 * user_id - user id
 * is_owner - user is owner of project
 * can_see_team - user is owner of project
 * can_see_project - user can see project info
 * can_edit_project - user can edit project
 * can_see_other_tasks - user can see other project tasks
 * can_add_tasks - user can add tasks to project
 * can_delete_tasks - user can delete tasks from project
 */
CREATE TABLE project_participant_access
(
    id                   varchar(36) NOT NULL,
    project_id           varchar(36) NOT NULL,
    user_id              varchar(36) NOT NULL,
    is_owner             bit(1)      NOT NULL,
    can_see_team         bit(1)      NOT NULL,
    can_see_project      bit(1)      NOT NULL,
    can_edit_project     bit(1)      NOT NULL,
    can_see_other_tasks  bit(1)      NOT NULL,
    can_add_tasks        bit(1)      NOT NULL,
    can_edit_other_tasks bit(1)      NOT NULL,
    can_delete_tasks     bit(1)      NOT NULL,
    FOREIGN KEY (project_id) REFERENCES projects (id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    PRIMARY KEY (id)
);

/**
 * Tags table
 *
 * id - tag ID
 * project_id - project id
 * colour - tag mark colour
 * value - tag text
 */
CREATE TABLE tags
(
    id         varchar(36)  NOT NULL,
    project_id varchar(36)  NOT NULL,
    colour     varchar(7)   NOT NULL,
    value      varchar(255) NOT NULL,
    FOREIGN KEY (project_id) REFERENCES projects (id) ON DELETE CASCADE,
    PRIMARY KEY (id)
);

/**
 * Tasks tags relations table
 *
 * id - relation ID
 * task_id - task ID
 * tag_id - tag ID
 */
CREATE TABLE tasks_tags
(
    id      varchar(36) NOT NULL,
    task_id varchar(36) NOT NULL,
    tag_id  varchar(36) NOT NULL,
    FOREIGN KEY (task_id) REFERENCES tasks (id) ON DELETE CASCADE,
    FOREIGN KEY (tag_id) REFERENCES tags (id) ON DELETE CASCADE,
    PRIMARY KEY (id)
);

/**
 * Entity comments table
 *
 * id - comment ID
 * author_id - author ID
 * entity_id - entity ID
 * entity_type - entity type
 * content - comment content
 * creation_date - comment creation date
 * change_date - comment change date
 */
CREATE TABLE comments
(
    id            varchar(36)  NOT NULL,
    author_id     varchar(36),
    entity_id     varchar(36)  NOT NULL,
    entity_type   varchar(255) NOT NULL,
    content       varchar(255) NOT NULL,
    creation_date timestamp    NOT NULL,
    change_date   timestamp,
    FOREIGN KEY (author_id) REFERENCES users (id) ON DELETE SET NULL,
    PRIMARY KEY (id)
);
