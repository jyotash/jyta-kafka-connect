FROM confluentinc/cp-kafka-connect:3.2.0

WORKDIR /jyta-kafka-connect
COPY config config
COPY target target

VOLUME /jyta-kafka-connect/config
VOLUME /jyta-kafka-connect/offsets

CMD CLASSPATH="$(find target/ -type f -name '*.jar'| grep '\-package' | tr '\n' ':')" connect-standalone config/worker.properties config/GitHubSourceConnectorExample.properties