package br.com.quarkus.infra;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.KafkaContainer;

import java.util.HashMap;
import java.util.Map;

public class InfrastructureTest implements QuarkusTestResourceLifecycleManager {

    static KafkaContainer kafka = new KafkaContainer();

    @Override
    public Map<String, String> start() {
        kafka.start();
        return configurationParameters();
    }

    private Map<String, String> configurationParameters() {
        final Map<String, String> conf = new HashMap<>();
        conf.put("kafka.bootstrap.servers", kafka.getBootstrapServers());
        conf.put("%test.mp.messaging.outgoing.customer-out.connector", "smallrye-kafka");
        return conf;
    }

    @Override
    public void stop() {
        if (kafka != null) {
            kafka.stop();
        }
    }
}
