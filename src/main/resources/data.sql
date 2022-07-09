insert into AUTHORS (NAME) values ('Leo Tolstoy');
insert into AUTHORS (NAME) values ('Alex Pushkin');
insert into AUTHORS (NAME) values ('Michael Sholokhov');
insert into AUTHORS (NAME) values ('Arthur Conan Doyle');
insert into AUTHORS (NAME) values ('Nikolay Gogol');
insert into GENRES (TITLE) values ('Tale');
insert into GENRES (TITLE) values ('Drama');
insert into GENRES (TITLE) values ('Detective');
insert into BOOKS (TITLE, AUTHOR, GENRE) values ('War and peace', 'Leo Tolstoy', 'Drama');
insert into BOOKS (TITLE, AUTHOR, GENRE) values ('Eugene Onegin', 'Alex Pushkin', 'Drama');
insert into BOOKS (TITLE, AUTHOR, GENRE) values ('Kazaks', 'Leo Tolstoy', 'Tale');
insert into BOOKS (TITLE, AUTHOR, GENRE) values ('Silent Don', 'Michael Sholokhov', 'Drama');
insert into BOOKS (TITLE, AUTHOR, GENRE) values ('Sherlock Holmes', 'Arthur Conan Doyle', 'Detective');
insert into BOOKS (TITLE, AUTHOR, GENRE) values ('Taras Bulba', 'Nikolay Gogol', 'Tale');

insert into COMMENTS (BOOK_ID, COMMENT) values (1, 'Good example of traditional Russian culture');
insert into COMMENTS (BOOK_ID, COMMENT) values (1, 'One of the most epic drama in the world');
insert into COMMENTS (BOOK_ID, COMMENT) values (1, 'Leo Tolstoy wrote it when he was old boy');