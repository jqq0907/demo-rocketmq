package com.example.consume;

import com.example.domain.User;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author jiangqiangqiang
 * @description:
 * @date 2023/3/15 15:33
 */
@Component
public class MQConsumerService {
    @Service
    @RocketMQMessageListener(consumerGroup = "mygroup1", topic = "DEMO-TOPIC")
    public class ConsumerSend implements RocketMQListener<User> {

        @Override
        public void onMessage(User user) {
            System.out.println("收到消息:" + user.toString());
        }
    }
}
