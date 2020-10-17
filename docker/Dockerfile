FROM eed3si9n/sbt:jdk11-alpine
COPY ./ /opt/workspace
COPY ./start.sh /start.sh

RUN chmod +x /start.sh
ENTRYPOINT ["/start.sh"]
