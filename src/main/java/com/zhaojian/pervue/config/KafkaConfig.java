package com.zhaojian.pervue.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.util.backoff.FixedBackOff;

//@Configuration
public class KafkaConfig {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    //创建主题
    @Bean
    public NewTopic topic() {
        return new NewTopic("1707d", 1, (short) 1);
    }


    //监听工厂
    @Bean
    public ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory(
            ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
            ConsumerFactory<Object, Object> kafkaConsumerFactory,
            KafkaTemplate<Object, Object> template) {
        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        configurer.configure(factory, kafkaConsumerFactory);
        factory.setErrorHandler(new SeekToCurrentErrorHandler(
                new DeadLetterPublishingRecoverer(template), new FixedBackOff(0L, 2))); // dead-letter after 3 tries
        return factory;
    }

    //转换器
    @Bean
    public RecordMessageConverter converter() {
        return new StringJsonMessageConverter();
    }


   /* @KafkaListener(topics = "1707d", id = "userGroup")
    public void listenMsg(User user) {
        System.err.println(user);
        ESUtilsExtends.saveObject(elasticsearchTemplate,user.getId()+"",user);
    }
*/
}
