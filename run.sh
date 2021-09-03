#!/usr/bin/env bash
export CLASSPATH="$(find target/ -type f -name '*.jar'| grep '\-package' | tr '\n' ':')"
if hash docker 2>/dev/null; then
    docker build . -t reactivestax/jyta-kafka-connect:1.0
    docker run --net=host --rm -t \
           -v $(pwd)/offsets:/jyta-kafka-connect/offsets \
           reactivestax/jyta-kafka-connect:1.0
elif hash connect-standalone 2>/dev/null; then

    connect-standalone config/worker.properties config/GitHubSourceConnectorExample.properties
elif [[ -z $KAFKA_HOME ]]; then
    # for people who installed kafka vanilla
    $KAFKA_HOME/bin/connect-standalone.sh $KAFKA_HOME/etc/schema-registry/connect-avro-standalone.properties config/GitHubSourceConnectorExample.properties
elif [[ -z $CONFLUENT_HOME ]]; then
    # for people who installed kafka confluent flavour
    $CONFLUENT_HOME/bin/connect-standalone $CONFLUENT_HOME/etc/schema-registry/connect-avro-standalone.properties config/GitHubSourceConnectorExample.properties
else
    printf "Couldn't find a suitable way to run kafka connect for you.\n \
Please install Docker, or download the kafka binaries and set the variable KAFKA_HOME."
fi;
