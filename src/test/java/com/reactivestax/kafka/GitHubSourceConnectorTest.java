package com.reactivestax.kafka;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.reactivestax.kafka.GitHubSourceConnectorConfig.*;
import static com.reactivestax.kafka.GitHubSourceConnectorConfig.BATCH_SIZE_CONFIG;
import static com.reactivestax.kafka.GitHubSourceConnectorConfig.OWNER_CONFIG;
import static com.reactivestax.kafka.GitHubSourceConnectorConfig.REPO_CONFIG;
import static com.reactivestax.kafka.GitHubSourceConnectorConfig.SINCE_CONFIG;
import static com.reactivestax.kafka.GitHubSourceConnectorConfig.TOPIC_CONFIG;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class GitHubSourceConnectorTest {

  private Map<String, String> initialConfig() {
    Map<String, String> baseProps = new HashMap<>();
    baseProps.put(OWNER_CONFIG, "foo");
    baseProps.put(REPO_CONFIG, "bar");
    baseProps.put(SINCE_CONFIG, "2017-04-26T01:23:45Z");
    baseProps.put(BATCH_SIZE_CONFIG, "100");
    baseProps.put(TOPIC_CONFIG, "github-issues");
    return (baseProps);
  }

  @Test
  public void taskConfigsShouldReturnOneTaskConfig() {
      GitHubSourceConnector gitHubSourceConnector = new GitHubSourceConnector();
      gitHubSourceConnector.start(initialConfig());
      assertEquals(gitHubSourceConnector.taskConfigs(1).size(),1);
      assertEquals(gitHubSourceConnector.taskConfigs(10).size(),1);
  }
}
