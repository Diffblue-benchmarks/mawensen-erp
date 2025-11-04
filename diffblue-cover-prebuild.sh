#!/usr/bin/env bash

# Start the MySQL server on port 3306, with the expected root password from src/main/resources/application.yml, loading in the database specified in resources/sql/db.sql
# Ensure the root account can be accessed through the docker bridge host (172.17.0.1)
docker run --detach --rm \
--name mysql-server \
--env MYSQL_ROOT_PASSWORD=admin123456 \
--env MYSQL_ROOT_HOST=172.17.0.1 \
--publish 3306:3306 \
--volume "$PWD/resources/sql/db.sql:/docker-entrypoint-initdb.d/db.sql" \
mysql/mysql-server:5.5
