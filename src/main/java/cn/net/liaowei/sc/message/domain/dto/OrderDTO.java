package cn.net.liaowei.sc.message.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author LiaoWei
 */
@Data
public class OrderDTO implements Serializable {
    private static final long serialVersionUID = 340468143867233801L;
    private String orderId;
    private String orderType;
    private String productName;
    private BigDecimal orderAmt;
}
