package cn.net.liaowei.sc.message.receiver;

import cn.net.liaowei.sc.message.domain.dto.OrderDTO;
import cn.net.liaowei.sc.message.domain.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author LiaoWei
 */
@Slf4j
@Component
public class MessageReceiver {

    /**
     * 通用消息处理
     * 使用@RabbitListener(queues = "commonQueue")注解需要先建立好对应的队列 commonQueue,否则会报错
     * 使用@RabbitListener(queuesToDeclare = @Queue("commonQueue"))注解可以自动创建队列commonQueue
     * @param object 待处理的消息
     */
    // @RabbitListener(queues = "commonQueue")
    @RabbitListener(queuesToDeclare = @Queue("commonQueue"))
    public void processCommon(UserDTO object) {
        log.info("Process common Object: {}", object);
    }

    /**
     * Exchange消息处理-fina消息
     * 在orderQueue通过key值fina获取理财订单的消息
     * @param object 待处理的消息
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("orderQueue"),
            key = "fina",
            value = @Queue("finaOrderQueue")
    ))
    public void processFina(OrderDTO object) {
        log.info("Process fina Object: {}", object);
    }

    /**
     * Exchange消息处理-loan消息
     * 在orderQueue通过key值loan获取贷款订单的消息
     * @param object 待处理的消息
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("orderQueue"),
            key = "loan",
            value = @Queue("loanOrderQueue")
    ))
    public void processLoan(OrderDTO object) {
        log.info("Process loan Object: {}", object);
    }
}
