---  

1) Используя команду cat в терминале операционной системы Linux, создать
   два файла Домашние животные (заполнив файл собаками, кошками,
   хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
   ослы), а затем объединить их. Просмотреть содержимое созданного файла.
   Переименовать файл, дав ему новое имя (Друзья человека)

---  

```console
cd /home

mkdir specialisation

cd specialisation/

cat > Домашние\ животные
собаки
кошки
хомяки

cat > Вьючные\ животные
лошади
верблюды
ослы

cat Домашние\ животные Вьючные\ животные > Животные

cat Животные

mv Животные Друзья\ человека
```
<br>

---
2) Создать директорию, переместить файл туда.

---  
```console
mkdir zoo

mv Друзья\ человека zoo

cd zoo

ls -ali
```
<br>

---
3) Подключить дополнительный репозиторий MySQL. Установить любой пакет
из этого репозитория.
--- 
```console
sudo su
wget https://dev.mysql.com/get/mysql-apt-config_0.8.23-1_all.deb    
dpkg -i mysql-apt-config_0.8.23-1_all.deb    
apt-get update    
apt-get install mysql-server
```
<br>

---
4) Установить и удалить deb-пакет с помощью dpkg.

---
```console
sudo wget https://download.docker.com/linux/ubuntu/dists/jammy/pool/stable/amd64/docker-ce-cli_20.10.13~3-0~ubuntu-jammy_amd64.deb    
sudo dpkg -i docker-ce-cli_20.10.13~3-0~ubuntu-jammy_amd64.deb    
sudo dpkg -r docker-ce-cli
```