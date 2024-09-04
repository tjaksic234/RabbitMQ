FROM rabbitmq:management

RUN rabbitmq-plugins enable --offline rabbitmq_stomp

EXPOSE 5672 15672 61613
