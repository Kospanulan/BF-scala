FROM adoptopenjdk/openjdk15:latest

RUN mkdir -pv /TSIS10
WORKDIR /TSIS10

COPY . /TSIS10

EXPOSE 9000

CMD ["sbt", "clean", "compile"]