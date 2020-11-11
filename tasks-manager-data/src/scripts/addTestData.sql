INSERT INTO users (id, first_name, last_name, email, password, role, reg_date, status, confirm_status)
VALUES ('4028e48f713215020171321690280001', 'Igor', 'Shcherbachenya', 'postal@qwe.qwe',
        '$2a$10$daTJ4qjtST0oYw48qP0EweI9sR9x8Wjrgzty5nbEfCbmytrfcoaiO',
        'ROLE_USER', '2020-09-05', 'ACTIVE', 'CONFIRMED'),

       ('4028e48f713215020171321690280002', 'Ivan', 'Yablochkin', 'ivan@qwe.qwe',
        '$2a$10$daTJ4qjtST0oYw48qP0EweI9sR9x8Wjrgzty5nbEfCbmytrfcoaiO',
        'ROLE_USER', '2020-03-23', 'ACTIVE', 'UNCONFIRMED'),

       ('4028e48f713215020171321690280003', 'Alex', 'Simonov', 'alex@qwe.qwe',
        '$2a$10$daTJ4qjtST0oYw48qP0EweI9sR9x8Wjrgzty5nbEfCbmytrfcoaiO',
        'ROLE_USER', '2020-04-24', 'BANNED', 'CONFIRMED'),

       ('4028e48f713215020171321690280004', 'Yuri', 'Danilov', 'yuri@qwe.qwe',
        '$2a$10$daTJ4qjtST0oYw48qP0EweI9sR9x8Wjrgzty5nbEfCbmytrfcoaiO',
        'ROLE_USER', '2020-02-22', 'DELETED', 'CONFIRMED'),

       ('4028e48f713215020171321690280005', 'Evgeniy', 'Otetcovich', 'evgen@qwe.qwe',
        '$2a$10$daTJ4qjtST0oYw48qP0EweI9sR9x8Wjrgzty5nbEfCbmytrfcoaiO',
        'ROLE_USER', '2020-05-25', 'BANNED', 'UNCONFIRMED'),

       ('4028e48f713215020171321690280006', 'Tatiana', 'Mamovna', 'Tatiana@qwe.qwe',
        '$2a$10$daTJ4qjtST0oYw48qP0EweI9sR9x8Wjrgzty5nbEfCbmytrfcoaiO',
        'ROLE_USER', '2020-09-18', 'DELETED', 'UNCONFIRMED'),

       ('4028e48f713215020171321690280007', 'Admen', 'Admenenya', 'admen@qwe.qwe',
        '$2a$10$daTJ4qjtST0oYw48qP0EweI9sR9x8Wjrgzty5nbEfCbmytrfcoaiO',
        'ROLE_ADMIN', '2012-12-12', 'ACTIVE', 'CONFIRMED');

INSERT INTO colour_themes (id, name, main_colour, secondary_colour)
VALUES ('4028e48f713215020171321690280011', 'WhiteBlack', '#ffffff', '#000000'),
       ('4028e48f713215020171321690280012', 'YellowBlack', '#ffd400', '#000000'),
       ('4028e48f713215020171321690280013', 'RedWhite', '#ff0000', '#ffffff');

INSERT INTO projects (id, owner_id, name, description, colour_theme_id, status, creation_date)
VALUES ('4028e48f713215020171321690280101', '4028e48f713215020171321690280001', 'Start TasksManager',
        'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley',
        '4028e48f713215020171321690280011', 'PUBLISHED', '2020-09-05'),

       ('4028e48f713215020171321690280102', '4028e48f713215020171321690280002', 'End TasksManger',
        'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a',
        '4028e48f713215020171321690280012', 'PUBLISHED', '2020-03-23'),

       ('4028e48f713215020171321690280103', '4028e48f713215020171321690280001', 'Fill TasksManager',
        'Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old.',
        '4028e48f713215020171321690280013', 'PUBLISHED', '2020-04-24'),

       ('4028e48f713215020171321690280104', '4028e48f713215020171321690280002', 'Drop TasksManager',
        'There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don''t look even slightly',
        '4028e48f713215020171321690280011', 'PUBLISHED', '2020-02-22'),

       ('4028e48f713215020171321690280105', '4028e48f713215020171321690280002', 'Sell TasksManager',
        'Ut aliquet diam ac ultricies pellentesque. Morbi quis auctor eros. Phasellus vel magna et augue fringilla fermentum commodo vel sem. Duis tempus libero dolor, eu sagittis ex pulvinar nec.',
        '4028e48f713215020171321690280012', 'DRAFT', '2020-05-25'),

       ('4028e48f713215020171321690280106', '4028e48f713215020171321690280001', 'Some Tasks',
        'Nam rutrum dictum justo et aliquam. Vivamus luctus nec odio ultrices ultrices. Duis quis vehicula libero, ut accumsan ante. Nulla in pharetra elit. Suspendisse potenti.',
        '4028e48f713215020171321690280013', 'DRAFT', '2020-09-18'),

       ('4028e48f713215020171321690280107', '4028e48f713215020171321690280001', 'SomeProject',
        ' Proin placerat interdum dolor sed ultrices. Sed dapibus quis tellus sit amet convallis. Donec lacinia consectetur lacus, vitae congue nunc ultrices nec. Sed sed augue risus. Nam sagittis efficitur arcu',
        '4028e48f713215020171321690280011', 'DRAFT', '2012-12-12');
