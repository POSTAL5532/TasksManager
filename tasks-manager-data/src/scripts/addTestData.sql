/**
* Test data adding scripts
*/

INSERT INTO users (id, first_name, last_name, email, password, role, reg_date, status, confirm_status)
VALUES ('4028e48f713215020171321690280001', 'Igor', 'Shcherbachenya', 'postal@qwe.qwe',
        '$2a$10$daTJ4qjtST0oYw48qP0EweI9sR9x8Wjrgzty5nbEfCbmytrfcoaiO',
        'ROLE_USER', '2020-09-05', 'ACTIVE', 'CONFIRMED'),

       ('4028e48f713215020171321690280002', 'UserOne', 'ActiveUnconfirmed', 'user1@qwe.qwe',
        '$2a$10$daTJ4qjtST0oYw48qP0EweI9sR9x8Wjrgzty5nbEfCbmytrfcoaiO',
        'ROLE_USER', '2020-03-23', 'ACTIVE', 'UNCONFIRMED'),

       ('4028e48f713215020171321690280003', 'UserTwo', 'BannedConfirmed', 'user2@qwe.qwe',
        '$2a$10$daTJ4qjtST0oYw48qP0EweI9sR9x8Wjrgzty5nbEfCbmytrfcoaiO',
        'ROLE_USER', '2020-04-24', 'BANNED', 'CONFIRMED'),

       ('4028e48f713215020171321690280004', 'UserThree', 'DeletedConfirmed', 'user3@qwe.qwe',
        '$2a$10$daTJ4qjtST0oYw48qP0EweI9sR9x8Wjrgzty5nbEfCbmytrfcoaiO',
        'ROLE_USER', '2020-02-22', 'DELETED', 'CONFIRMED'),

       ('4028e48f713215020171321690280005', 'UserFour', 'BannedUnconfirmed', 'user4@qwe.qwe',
        '$2a$10$daTJ4qjtST0oYw48qP0EweI9sR9x8Wjrgzty5nbEfCbmytrfcoaiO',
        'ROLE_USER', '2020-05-25', 'BANNED', 'UNCONFIRMED'),

       ('4028e48f713215020171321690280006', 'UserFive', 'DeletedUnconfirmed', 'user5@qwe.qwe',
        '$2a$10$daTJ4qjtST0oYw48qP0EweI9sR9x8Wjrgzty5nbEfCbmytrfcoaiO',
        'ROLE_USER', '2020-09-18', 'ACTIVE', 'CONFIRMED'),

       ('4028e48f713215020171321690280007', 'UserSix', 'SixSix', 'user6@qwe.qwe',
        '$2a$10$daTJ4qjtST0oYw48qP0EweI9sR9x8Wjrgzty5nbEfCbmytrfcoaiO',
        'ROLE_USER', '2020-09-18', 'ACTIVE', 'CONFIRMED'),

       ('4028e48f713215020171321690280008', 'UserSeven', 'SevenSeven', 'user7@qwe.qwe',
        '$2a$10$daTJ4qjtST0oYw48qP0EweI9sR9x8Wjrgzty5nbEfCbmytrfcoaiO',
        'ROLE_USER', '2020-09-18', 'ACTIVE', 'CONFIRMED'),

       ('4028e48f713215020171321690280009', 'UserEight', 'EightEight', 'user8@qwe.qwe',
        '$2a$10$daTJ4qjtST0oYw48qP0EweI9sR9x8Wjrgzty5nbEfCbmytrfcoaiO',
        'ROLE_USER', '2020-09-18', 'ACTIVE', 'CONFIRMED'),

       ('4028e48f713215020171321690280010', 'UserNine', 'NineNine', 'user9@qwe.qwe',
        '$2a$10$daTJ4qjtST0oYw48qP0EweI9sR9x8Wjrgzty5nbEfCbmytrfcoaiO',
        'ROLE_USER', '2020-09-18', 'ACTIVE', 'CONFIRMED'),

       ('4028e48f713215020171321690280011', 'UserTen', 'TenTen', 'user10@qwe.qwe',
        '$2a$10$daTJ4qjtST0oYw48qP0EweI9sR9x8Wjrgzty5nbEfCbmytrfcoaiO',
        'ROLE_USER', '2020-09-18', 'ACTIVE', 'CONFIRMED'),

       ('4028e48f713215020171321690280012', 'Admen', 'Admenenya', 'admen@qwe.qwe',
        '$2a$10$daTJ4qjtST0oYw48qP0EweI9sR9x8Wjrgzty5nbEfCbmytrfcoaiO',
        'ROLE_ADMIN', '2012-12-12', 'ACTIVE', 'CONFIRMED');

INSERT INTO colour_themes (id, name, main_colour, secondary_colour)
VALUES ('4028e48f713215020171321690280011', 'WhiteBlack', '#ffffff', '#000000'),
       ('4028e48f713215020171321690280012', 'YellowBlack', '#ffd400', '#000000'),
       ('4028e48f713215020171321690280013', 'RedWhite', '#ff0000', '#ffffff');

INSERT INTO projects (id, owner_id, name, short_name, description, colour_theme_id, status, creation_date)
VALUES ('4028e48f713215020171321690280101', '4028e48f713215020171321690280001', 'Start TasksManager', 'STM',
        'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley',
        '4028e48f713215020171321690280011', 'PUBLISHED', '2020-09-05'),

       ('4028e48f713215020171321690280102', '4028e48f713215020171321690280001', 'SomeProject', 'SPP',
        ' Proin placerat interdum dolor sed ultrices. Sed dapibus quis tellus sit amet convallis. Donec lacinia consectetur lacus, vitae congue nunc ultrices nec. Sed sed augue risus. Nam sagittis efficitur arcu',
        '4028e48f713215020171321690280011', 'PUBLISHED', '2012-12-12'),

       ('4028e48f713215020171321690280103', '4028e48f713215020171321690280002', 'End TasksManger', 'ETM',
        'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a',
        '4028e48f713215020171321690280012', 'PUBLISHED', '2020-03-23'),

       ('4028e48f713215020171321690280104', '4028e48f713215020171321690280001', 'Sell TasksManager', 'MMT',
        'Ut aliquet diam ac ultricies pellentesque. Morbi quis auctor eros. Phasellus vel magna et augue fringilla fermentum commodo vel sem. Duis tempus libero dolor, eu sagittis ex pulvinar nec.',
        '4028e48f713215020171321690280012', 'DRAFT', '2020-05-25'),

       ('4028e48f713215020171321690280105', '4028e48f713215020171321690280002', 'Some Tasks', 'SST',
        'Nam rutrum dictum justo et aliquam. Vivamus luctus nec odio ultrices ultrices. Duis quis vehicula libero, ut accumsan ante. Nulla in pharetra elit. Suspendisse potenti.',
        '4028e48f713215020171321690280013', 'DRAFT', '2020-09-18');

INSERT INTO tasks (id, project_id, author_id, executor_id, name, description, level, status, type, creation_date, ending_date, change_date)
VALUES ('4028e48f713215020171321690201001', '4028e48f713215020171321690280101', '4028e48f713215020171321690280001', NULL,
        'Start TasksManager story 1', 'story 1 some task description', 'MAJOR', 'NEED_TO_SOLVE', 'STORY',
        '2020-11-18', NULL, NULL),
       ('4028e48f713215020171321690202001', '4028e48f713215020171321690280101', '4028e48f713215020171321690280001', NULL,
        'Start TasksManager task 0', 'task 0 some task description', 'MAJOR', 'NEED_TO_SOLVE', 'TASK',
        '2020-11-18', NULL, '2020-11-19'),
       ('4028e48f713215020171321690203001', '4028e48f713215020171321690280101', '4028e48f713215020171321690280001', '4028e48f713215020171321690280002',
        'Start TasksManager task 2', 'story_1_subtask_1 some task description', 'MAJOR', 'IN_PROCESS', 'TASK',
        '2020-11-18', NULL, '2020-11-19'),
       ('4028e48f713215020171321690204001', '4028e48f713215020171321690280101', '4028e48f713215020171321690280002', '4028e48f713215020171321690280001',
        'Start TasksManager task 3', 'story_1_subtask_1_subtask_1 some task description', 'MINOR', 'READY_TO_CHECK', 'TASK',
        '2020-11-18', NULL, NULL),
       ('4028e48f713215020171321690205001', '4028e48f713215020171321690280101', '4028e48f713215020171321690280001', '4028e48f713215020171321690280001',
        'Start TasksManager task 4', 'story_1_subtask_1_subtask_2 some task description', 'MINOR', 'NEED_TO_SOLVE', 'TASK',
        '2020-11-17', NULL, '2020-11-18'),
       ('4028e48f713215020171321690206001', '4028e48f713215020171321690280101', '4028e48f713215020171321690280002', NULL,
        'Start TasksManager task 4', 'task_2_relate_story_1_subtask_1 some task description', 'MAJOR', 'IN_PROCESS', 'TASK',
        '2020-11-17', NULL, '2020-11-18'),
       ('4028e48f713215020171321690207001', '4028e48f713215020171321690280101', '4028e48f713215020171321690280002', NULL,
        'Start TasksManager task 4', 'task_3_relate_story_1_subtask_1_subtask_2 some task description', 'MAJOR', 'IN_PROCESS', 'TASK',
        '2020-11-17', NULL, '2020-11-18');

INSERT INTO tasks_relations (id, task_id, relation_type, related_task_id)
VALUES ('4028e48f713215020171321690217001', '4028e48f713215020171321690203001', 'SUB_TASK', '4028e48f713215020171321690201001'),
       ('4028e48f713215020171321690227001', '4028e48f713215020171321690204001', 'SUB_TASK', '4028e48f713215020171321690203001'),
       ('4028e48f713215020171321690237001', '4028e48f713215020171321690205001', 'SUB_TASK', '4028e48f713215020171321690203001'),
       ('4028e48f713215020171321690247001', '4028e48f713215020171321690206001', 'SIMPLE', '4028e48f713215020171321690204001'),
       ('4028e48f713215020171321690257001', '4028e48f713215020171321690207001', 'BLOCKER', '4028e48f713215020171321690205001');