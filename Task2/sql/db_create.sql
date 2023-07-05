DROP TABLE IF EXISTS animal_classes;
CREATE TABLE animal_classes
(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Class_name VARCHAR(20)
);

INSERT INTO animal_classes (Class_name)
VALUES ('вьючные'),
       ('домашние');

CREATE TABLE pack_animals
(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Genus_name VARCHAR (20),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animal_classes (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pack_animals (Genus_name, Class_id)
VALUES ('Лошади', 1),
       ('Ослы', 1),
       ('Верблюды', 1);

CREATE TABLE pets
(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Genus_name VARCHAR (20),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animal_classes (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO pets (Genus_name, Class_id)
VALUES ('Кошки', 2),
       ('Собаки', 2),
       ('Хомяки', 2);

CREATE TABLE cats
(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20),
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO cats (Name, Birthday, Commands, Genus_id)
VALUES ('Снежок', '2021-04-01', 'кись кись', 1),
       ('Рыжик', '2016-05-05', 'кушать', 1),
       ('Дизель', '2017-03-12', 'ко мне', 1),
       ('Мурзик', '2018-06-04', 'спать', 1);

CREATE TABLE dogs
(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20),
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO dogs (Name, Birthday, Commands, Genus_id)
VALUES ('Барбос', '2010-09-15', 'сидеть, лежать', 2),
       ('Шарик', '2016-07-10', 'сидеть, лежать', 2),
       ('Муха', '2017-05-05', 'сидеть, лежать', 2),
       ('Тузик', '2020-06-16', 'сидеть, лежать', 2);

CREATE TABLE hamsters
(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20),
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO hamsters (Name, Birthday, Commands, Genus_id)
VALUES ('Хома', '2023-06-12', '', 3),
       ('Жирный', '2023-06-12', '', 3),
       ('Злой', '2023-06-12', '', 3),
       ('Мася', '2023-06-12', '', 3);

CREATE TABLE horses
(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20),
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO horses (Name, Birthday, Commands, Genus_id)
VALUES ('Граф', '2020-12-12', 'шагом, рысью, галопом, гох, стоять', 1),
       ('Чемпион', '2017-03-03', 'шагом, рысью, галопом, барьер, стоять', 1),
       ('Кассеопея', '2016-07-07', 'шагом, рысью, галопом, карьером, стоять', 1),
       ('Атлантида', '2027-10-10', 'шагом, рысью, галопом, стоять', 1);

CREATE TABLE donkeys
(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20),
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO donkeys (Name, Birthday, Commands, Genus_id)
VALUES ('Альтаир', '2019-05-15', 'вперед, стоять', 2),
       ('Нельсон', '2019-03-02', 'вперед, стоять', 2),
       ('Юрмала', '2021-07-09', 'вперед, стоять', 2),
       ('Шрам', '2013-10-12', 'вперед, стоять', 2);

CREATE TABLE camels
(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20),
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES pack_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO camels (Name, Birthday, Commands, Genus_id)
VALUES ('Вася', '2021-05-15', 'вперед, стоять, лежать', 3),
       ('Симба', '2018-05-06', 'вперед, стоять, лежать, быстрее', 3),
       ('Мисти', '2014-06-07', 'вперед, стоять, лежать', 3),
       ('Балу', '2021-10-10', 'вперед, стоять, лежать, быстрее', 3);
