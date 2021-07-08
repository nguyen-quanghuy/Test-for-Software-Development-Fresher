FROM webdevops/liquibase:mysql

ENV MYSQL_DRIVER=com.mysql.jdbc.Driver

COPY db /liquibase/db
COPY bin/entrypoint.sh /liquibase/bin/entrypoint.sh

RUN chmod a+x /liquibase/bin/entrypoint.sh

ENTRYPOINT ["bin/entrypoint.sh"]