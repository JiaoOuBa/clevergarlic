FROM java:8

VOLUME /tmp
ARG JAR_FILE=target/clevergarlic-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# 设置时区
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

# 运行jar包 profiles 指定环境
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","--spring.profiles.active=${profiles}","-c"]
