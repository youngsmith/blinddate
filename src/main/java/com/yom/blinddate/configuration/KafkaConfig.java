//package com.yom.blinddate.configuration;
//
//
//import com.yom.blinddate.model.Foo2;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.clients.admin.AdminClientConfig;
//import org.apache.kafka.clients.admin.NewTopic;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.task.SimpleAsyncTaskExecutor;
//import org.springframework.core.task.TaskExecutor;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.*;
//import org.springframework.kafka.support.converter.RecordMessageConverter;
//import org.springframework.kafka.support.converter.StringJsonMessageConverter;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Slf4j
//@EnableKafka
//@Configuration
//public class KafkaConfig {
//    private final TaskExecutor exec = new SimpleAsyncTaskExecutor();
//
//    private final String bootstrapAddress = "localhost:9092";
//
////    @Bean
////    public ProducerFactory<String, String> producerFactory() {
////        Map<String, Object> configProps = new HashMap<>();
////        configProps.put(
////                ProducerConfig.ACKS_CONFIG,
////                "1");
////        configProps.put(
////                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
////                bootstrapAddress);
////        configProps.put(
////                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
////                StringSerializer.class);
////        configProps.put(
////                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
////                StringSerializer.class);
////        return new DefaultKafkaProducerFactory<>(configProps);
////    }
//
////    @Bean
////    public KafkaTemplate<String, String> kafkaTemplate() {
////        return new KafkaTemplate<>(producerFactory());
////    }
//
//    @Bean
//    public ConsumerFactory<String, String> consumerFactory() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(
//                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
//                bootstrapAddress);
//        props.put(
//                ConsumerConfig.GROUP_ID_CONFIG,
//                "foo");
//        props.put(
//                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
//                StringDeserializer.class);
//        props.put(
//                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
//                StringDeserializer.class);
//        return new DefaultKafkaConsumerFactory<>(props);
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, String>
//    kafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, String> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }
//
////    @Bean
////    public KafkaAdmin kafkaAdmin() {
////        Map<String, Object> configs = new HashMap<>();
////        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
////        return new KafkaAdmin(configs);
////    }
//
////    @Bean
////    public SeekToCurrentErrorHandler errorHandler(KafkaOperations<Object, Object> template) {
////        return new SeekToCurrentErrorHandler(
////                new DeadLetterPublishingRecoverer(template), new FixedBackOff(1000L, 2));
////    }
//
//    @Bean
//    public RecordMessageConverter converter() {
//        return new StringJsonMessageConverter();
//    }
//
//    @KafkaListener(id = "fooGroup", topics = "topic2")
//    public void listen(Foo2 foo) {
//        log.info("Received: " + foo);
//        if (foo.getFoo().startsWith("fail")) {
//            throw new RuntimeException("failed");
//        }
//        //this.exec.execute(() -> System.out.println("Hit Enter to terminate..."));
//    }
//
//    @KafkaListener(id = "dltGroup", topics = "topic2")
//    public void dltListen(String in) {
//        log.info("Received from DLT: " + in);
//        //this.exec.execute(() -> System.out.println("Hit Enter to terminate..."));
//    }
//
//    @Bean
//    public NewTopic topic2() {
//        return new NewTopic("topic2", 1, (short) 1);
//    }
//}
