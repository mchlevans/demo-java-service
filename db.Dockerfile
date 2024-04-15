FROM postgres

# scripts in docker-entrypoint-initdb.d automatically run on start
COPY scripts/restore.sql /docker-entrypoint-initdb.d/
RUN chmod 777 /docker-entrypoint-initdb.d/*

# sql upload script will look for data in this folder
WORKDIR /usr/src/app
ADD pgdata/custom/automobileEDA.csv ./initdata/

RUN chmod 777 ./initdata/*
