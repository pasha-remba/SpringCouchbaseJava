package by.com.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitServerConfiguration extends AbstractStockAppRabbitConfiguration {

    @Value("${stocks.quote.pattern}")
    private String marketDataRoutingKey;

    @Bean
    public TopicExchange marketDataExchange(){
        return new TopicExchange("app.stock.marketdata");
    }

    @Bean
    public Queue marketDataQueue(){
        return amqpAdmin().declareQueue();
    }

    @Bean
    public Binding marketDataBinding(){
        return BindingBuilder.bind(marketDataQueue()).to(marketDataExchange()).with(marketDataRoutingKey);
    }
}
