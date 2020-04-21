# GULI MALL

## Environment
- mysql config
```properties
[client]
default-character-set=utf8

[mysql]
default-character-set=utf8


[mysqld]
init_connect='SET collation_connection = utf8_unicode_ci'
init_connect='SET NAMES utf8'
character-set-server=utf8
collation-server=utf8_unicode_ci
skip-character-set-client-handshake
skip-name-resolve
```
```shell script
docker run -p 3306:3306 --name mysql -v ~/dev/data/mysql/log:/var/log/mysql 
-v ~/dev/data/mysql/data/:/var/lib/mysql 
-v ~/dev/data/mysql/conf/:/etc/mysql 
-e MYSQL_ROOT_PASSWORD=password -d mysql:5.7
```
