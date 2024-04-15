FROM gradle:8-jdk17-alpine

WORKDIR /usr/src/app

# COPY gradle /gradle
ADD src/main/ ./src/main/
RUN cd src/main && ls

COPY build.gradle .
COPY gradlew gradlew.bat settings.gradle .
RUN mkdir scripts
COPY scripts/buildApiCode.sh ./scripts/
COPY scripts/start.sh ./scripts/

# build
RUN source scripts/buildApiCode.sh

# start app
RUN chmod 777 scripts/start.sh
CMD ["scripts/start.sh"]
