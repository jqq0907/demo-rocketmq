package com.example.procuder;

import com.example.domain.User;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jiangqiangqiang
 * @description:
 * @date 2023/3/16 09:37
 */
@Service
public class MQProcuderService implements ApplicationRunner {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        SendResult kitty = rocketMQTemplate.syncSend("DEMO-TOPIC", new User().setUserAge((byte) 18).setUserName("Kitty"));
        System.out.println();
    }
}
