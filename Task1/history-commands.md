Задача 1

1)
-----------------------------------------------------
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

2)
-----------------------------------------------------
mkdir zoo

mv Друзья\ человека zoo

cd zoo

ls -ali

3)
sudo su
wget https://dev.mysql.com/get/mysql-apt-config_0.8.23-1_all.deb    
dpkg -i mysql-apt-config_0.8.23-1_all.deb    
apt-get update    
apt-get install mysql-server

4)

sudo wget https://download.docker.com/linux/ubuntu/dists/jammy/pool/stable/amd64/docker-ce-cli_20.10.13~3-0~ubuntu-jammy_amd64.deb    
sudo dpkg -i docker-ce-cli_20.10.13~3-0~ubuntu-jammy_amd64.deb    
sudo dpkg -r docker-ce-cli 