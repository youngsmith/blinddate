package com.yom.blinddate.controller;

import com.yom.blinddate.model.FeatureType;
import com.yom.blinddate.model.Foo1;
import com.yom.blinddate.model.TestModel;
import com.yom.blinddate.service.TestService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Properties;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping("/")
    public List<TestModel> test() {
        return testService.test();
    }

    @GetMapping("/exist")
    public boolean test2() {
        return testService.isExist();
    }

    @GetMapping("/exception")
    public boolean test3() {
        int a = 0;
        int c = 10/a;
        return true;
    }

    @GetMapping("/farm")
    public FeatureType[] test4() {
        return FeatureType.featureTypes;
    }

//    private final KafkaTemplate<String, String> template;
//
//    @PostMapping(path = "/send/foo/{what}")
//    public void sendFoo(@PathVariable String what) {
//        ListenableFuture<SendResult<String, String>> future = this.template.send("topic2", what);
//
//        future.addCallback(new ListenableFutureCallback<>() {
//
//            @Override
//            public void onSuccess(SendResult<String, String> result) {
//                System.out.println("Sent message=[" + what +
//                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
//            }
//
//            @Override
//            public void onFailure(Throwable ex) {
//                System.out.println("Unable to send message=["
//                        + what + "] due to : " + ex.getMessage());
//            }
//        });
//    }
}
