package cn.net.liaowei.sc.message.controller;

import cn.net.liaowei.sc.message.domain.dto.OrderDTO;
import cn.net.liaowei.sc.message.domain.dto.UserDTO;
import lombok.Data;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author LiaoWei
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    private AmqpTemplate amqpTemplate;

    public MessageController(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @PostMapping("/common/send")
    public void commonSend(@RequestBody UserDTO userDTO) {
        amqpTemplate.convertAndSend("commonQueue", userDTO);
    }

    @PostMapping("/order/send")
    public void orderSend(@RequestBody OrderDTO orderDTO) {
        amqpTemplate.convertAndSend("orderQueue", orderDTO.getOrderType(), orderDTO);
    }
}
