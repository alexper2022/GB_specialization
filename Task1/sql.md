```sql
-- +---------------------------------------------------------------------------+
-- | 7. В подключенном MySQL репозитории создать базу данных “Друзья человека” |
-- +---------------------------------------------------------------------------+

DROP DATABASE IF EXISTS human_friends; 
CREATE DATABASE human_friends;

-- +---------------------------------------------------------------------------+
-- | 8. Создать таблицы с иерархией из диаграммы в БД                          |
-- +---------------------------------------------------------------------------+

USE human_friends;
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

-- +---------------------------------------------------------------------------+
-- | 9. Заполнить низкоуровневые таблицы именами(животных),                    |
-- | командамикоторые они выполняют и датами рождения                          |
-- +---------------------------------------------------------------------------+

INSERT INTO cats (Name, Birthday, Commands, Genus_id)
VALUES ('Снежок', '2021-04-01', 'кись кись', 1),
('Рыжик', '2016-05-05', 'кушать', 1),  
('Дизель', '2017-03-12', 'ко мне', 1),
('Мурзик', '2018-06-04', 'спать', 1);

CREATE TABLE Dogs 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO Dogs (Name, Birthday, Commands, Genus_id)
VALUES ('Барбос', '2010-09-15', 'сидеть, лежать', 2),
('Шарик', '2016-07-10', 'сидеть, лежать', 2),  
('Муха', '2017-05-05', 'сидеть, лежать', 2), 
('Тузик', '2020-06-16', 'сидеть, лежать', 2);

CREATE TABLE Hamsters 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES pets (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO Hamsters (Name, Birthday, Commands, Genus_id)
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

-- +---------------------------------------------------------------------------+
-- | 10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой |
-- | питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.    |
-- +---------------------------------------------------------------------------+

SET SQL_SAFE_UPDATES = 0;
DELETE FROM camels;

SELECT Name, Birthday, Commands FROM horses
UNION SELECT  Name, Birthday, Commands FROM donkeys;

-- +---------------------------------------------------------------------------+
-- | 11. Создать новую таблицу “молодые животные” в которую попадут все        |
-- | животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью |
-- | до месяца подсчитать возраст животных в новой таблице                     |
-- +---------------------------------------------------------------------------+
 
CREATE TEMPORARY TABLE animals AS 
SELECT *, 'Лошади' as genus FROM horses
UNION SELECT *, 'Ослы' AS genus FROM donkeys
UNION SELECT *, 'Собаки' AS genus FROM Dogs
UNION SELECT *, 'Кошки' AS genus FROM cats
UNION SELECT *, 'Хомяки' AS genus FROM Hamsters;

CREATE TABLE young_animals AS
SELECT Name, Birthday, Commands, genus, TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS Age_in_month
FROM animals WHERE Birthday BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);
 
SELECT * FROM young_animals;

-- +---------------------------------------------------------------------------+
-- | 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на |
-- | прошлую принадлежность к старым таблицам.                                 |
-- +---------------------------------------------------------------------------+

SELECT h.Name, h.Birthday, h.Commands, pa.Genus_name, ya.Age_in_month 
FROM horses h
LEFT JOIN young_animals ya ON ya.Name = h.Name
LEFT JOIN pack_animals pa ON pa.Id = h.Genus_id
UNION 
SELECT d.Name, d.Birthday, d.Commands, pa.Genus_name, ya.Age_in_month 
FROM donkeys d 
LEFT JOIN young_animals ya ON ya.Name = d.Name
LEFT JOIN pack_animals pa ON pa.Id = d.Genus_id
UNION
SELECT c.Name, c.Birthday, c.Commands, ha.Genus_name, ya.Age_in_month 
FROM cats c
LEFT JOIN young_animals ya ON ya.Name = c.Name
LEFT JOIN pets ha ON ha.Id = c.Genus_id
UNION
SELECT d.Name, d.Birthday, d.Commands, ha.Genus_name, ya.Age_in_month 
FROM Dogs d
LEFT JOIN young_animals ya ON ya.Name = d.Name
LEFT JOIN pets ha ON ha.Id = d.Genus_id
UNION
SELECT hm.Name, hm.Birthday, hm.Commands, ha.Genus_name, ya.Age_in_month 
FROM Hamsters hm
LEFT JOIN young_animals ya ON ya.Name = hm.Name
LEFT JOIN pets ha ON ha.Id = hm.Genus_id;
```