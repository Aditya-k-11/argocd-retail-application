package com.amazon.sample.orders.config.messaging;

import java.util.Properties;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.PropertiesPropertySource;

public class ApplicationEnvironmentPreparedListener
  implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

  @Override
  public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
    var environment = event.getEnvironment();

    var messagingProvider = environment.getProperty(
      "retail.orders.messaging.provider",
      environment.getProperty("RETAIL_ORDERS_MESSAGING_PROVIDER")
    );

    if ("rabbitmq".equals(messagingProvider)) {
      Properties props = new Properties();
      String addresses = environment.getProperty("retail.orders.messaging.rabbitmq.addresses");
      if (addresses != null) {
        props.put("spring.rabbitmq.addresses", addresses);
      }
      String username = environment.getProperty("retail.orders.messaging.rabbitmq.username");
      if (username != null) {
        props.put("spring.rabbitmq.username", username);
      }
      String password = environment.getProperty("retail.orders.messaging.rabbitmq.password");
      if (password != null) {
        props.put("spring.rabbitmq.password", password);
      }
      environment
        .getPropertySources()
        .addFirst(new PropertiesPropertySource("rabbitmqProps", props));
    }
  }
}
