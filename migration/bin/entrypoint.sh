#!/usr/bin/env bash

liquibase \
--classpath=/liquibase/db/lib/mysql-connector-java-5.1.40.jar \
--driver=$MYSQL_DRIVER \
--changeLogFile=/liquibase/db/changelog/master-changelog.xml \
--url=$JDBC_MASTER_URL \
--username=$JDBC_MASTER_USERNAME \
--password=$JDBC_MASTER_PASSWORD \
--contexts=auto \
update
