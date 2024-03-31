FROM openjdk:21

MAINTAINER Libre "zc150622@gmail.com"

VOLUME  /tmp

WORKDIR /libre

ADD  libre-web/target/*.jar /libre/app.jar

ENV TZ=Asia/Shanghai JAVA_OPTS="-Xms128m -Xmx1024m -Djava.security.egd=file:/dev/./urandom"

#ENV LC_ALL zh_CN.UTF-8

EXPOSE 9870

CMD java $JAVA_OPTS -jar libre/*.jar

ENTRYPOINT ["sh","-c","java  ${JAVA_OPTS} -jar /libre/app.jar --spinrg.profiles.active=${ACTIVE} --spring.config.location=${LOCALTION}/application.yml  --jasypt.encryptor.password=${VIDEO_PASSWORD}"]
