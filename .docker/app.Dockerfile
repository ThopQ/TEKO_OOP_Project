FROM gradle:7.5.1-jdk18

LABEL maintainer="thomas.iseli@webyourself.ch"

RUN curl -fsSL https://deb.nodesource.com/setup_lts.x | bash -
RUN apt-get install -y nodejs

COPY ./ /app/

WORKDIR /app/src/frontend
RUN npm install

WORKDIR /app
RUN gradle clean build --no-daemon

FROM openjdk:18.0.2.1-jdk-oracle

WORKDIR /app
COPY --from=0 /app/build ./build

ENTRYPOINT ["java", "-jar", "./build/libs/kotlin-vue-finance-0.0.1-SNAPSHOT.jar"]