DROP TABLE IF EXISTS animal_classes;
CREATE TABLE animal_classes
(
    Id         INTEGER PRIMARY KEY AUTOINCREMENT,
    Class_name VARCHAR(20)
);

INSERT INTO animal_classes (Class_name)
VALUES ('вьючные'),
       ('домашние');

DROP TABLE IF EXISTS pack_animals;
CREATE TABLE pack_animals
(
    Id         INTEGER PRIMARY KEY AUTOINCREMENT,
    Genus_name VARCHAR(20),
    Class_id   INT,
    FOREIGN KEY (Class_id) REFERENCES animal_classes (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pack_animals (Genus_name, Class_id)
VALUES ('Лошади', 1),
       ('Ослы', 1),
       ('Верблюды', 1);

DROP TABLE IF EXISTS pets;
CREATE TABLE pets
(
    Id         INTEGER PRIMARY KEY AUTOINCREMENT,
    Genus_name VARCHAR(20),
    Class_id   INT,
    FOREIGN KEY (Class_id) REFERENCES animal_classes (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pets (Genus_name, Class_id)
VALUES ('Кошки', 2),
       ('Собаки', 2),
       ('Хомяки', 2);

DROP TABLE IF EXISTS cats;
CREATE TABLE cats
(
    Id       INTEGER PRIMARY KEY AUTOINCREMENT,
    Name     VARCHAR(20),
    Birthday DATE,
    Commands VARCHAR(50),
    Gender VARCHAR(1),
    Genus_id INTEGER,
    Foreign KEY (Genus_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO cats (Name, Birthday, Commands, Gender, Genus_id)
VALUES ('Снежа', '2021-04-01', 'кись кись', 'ж', 1),
       ('Рыжик', '2016-05-05', 'кушать','м', 1),
       ('Дизель', '2017-03-12', 'ко мне', 'м', 1),
       ('Мурка', '2018-06-04', 'спать','ж', 1);

DROP TABLE IF EXISTS dogs;
CREATE TABLE dogs
(
    Id       INTEGER PRIMARY KEY AUTOINCREMENT,
    Name     VARCHAR(20),
    Birthday DATE,
    Commands VARCHAR(50),
    Gender VARCHAR(1),
    Genus_id INTEGER,
    Foreign KEY (Genus_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO dogs (Name, Birthday, Commands, Gender, Genus_id)
VALUES ('Барбос', '2010-09-15', 'сидеть, лежать', 'м', 2),
       ('Шарик', '2016-07-10', 'сидеть, лежать', 'м', 2),
       ('Муха', '2017-05-05', 'сидеть, лежать', 'ж', 2),
       ('Розка', '2020-06-16', 'сидеть, лежать', 'ж', 2);

DROP TABLE IF EXISTS hamsters;
CREATE TABLE hamsters
(
    Id       INTEGER PRIMARY KEY AUTOINCREMENT,
    Name     VARCHAR(20),
    Birthday DATE,
    Commands VARCHAR(50),
    Gender VARCHAR(1),
    Genus_id INTEGEREGER,
    Foreign KEY (Genus_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO hamsters (Name, Birthday, Commands, Gender, Genus_id)
VALUES ('Хома', '2023-06-12', '', 'ж', 3),
       ('Жирный', '2023-06-12', '', 'м', 3),
       ('Злой', '2023-06-12', '', 'м', 3),
       ('Мася', '2023-06-12', '', 'ж', 3);

DROP TABLE IF EXISTS horses;
CREATE TABLE horses
(
    Id       INTEGER PRIMARY KEY AUTOINCREMENT,
    Name     VARCHAR(20),
    Birthday DATE,
    Commands VARCHAR(50),
    Gender VARCHAR(1),
    Genus_id INTEGEREGER,
    Foreign KEY (Genus_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO horses (Name, Birthday, Commands, Gender, Genus_id)
VALUES ('Граф', '2020-12-12', 'шагом, рысью, галопом, гох, стоять', 'м', 1),
       ('Чемпион', '2017-03-03', 'шагом, рысью, галопом, барьер, стоять', 'м', 1),
       ('Кассиопея', '2016-07-07', 'шагом, рысью, галопом, карьером, стоять', 'ж', 1),
       ('Атлантида', '2027-10-10', 'шагом, рысью, галопом, стоять', 'ж', 1);

DROP TABLE IF EXISTS donkeys;
CREATE TABLE donkeys
(
    Id       INTEGER PRIMARY KEY AUTOINCREMENT,
    Name     VARCHAR(20),
    Birthday DATE,
    Commands VARCHAR(50),
    Gender VARCHAR(1),
    Genus_id INTEGEREGER,
    Foreign KEY (Genus_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO donkeys (Name, Birthday, Commands, Gender, Genus_id)
VALUES ('Альтаир', '2019-05-15', 'вперед, стоять', 'м', 2),
       ('Нельсон', '2019-03-02', 'вперед, стоять', 'м', 2),
       ('Юрмала', '2021-07-09', 'вперед, стоять', 'ж', 2),
       ('Шрам', '2013-10-12', 'вперед, стоять', 'м', 2);

DROP TABLE IF EXISTS camels;
CREATE TABLE camels
(
    Id       INTEGER PRIMARY KEY AUTOINCREMENT,
    Name     VARCHAR(20),
    Birthday DATE,
    Commands VARCHAR(50),
    Gender VARCHAR(1),
    Genus_id INTEGEREGER,
    Foreign KEY (Genus_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO camels (Name, Birthday, Commands, Gender, Genus_id)
VALUES ('Вася', '2021-05-15', 'вперед, стоять, лежать', 'м', 3),
       ('Симба', '2018-05-06', 'вперед, стоять, лежать, быстрее', 'м', 3),
       ('Мисти', '2014-06-07', 'вперед, стоять, лежать', 'ж', 3),
       ('Балу', '2021-10-10', 'вперед, стоять, лежать, быстрее', 'м', 3);

DROP TABLE IF EXISTS counter;
CREATE TABLE counter
(
    id    INTEGER,
    value integer
);

INSERT INTO counter (id, value)
VALUES (1,24);

