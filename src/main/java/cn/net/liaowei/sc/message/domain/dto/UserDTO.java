package cn.net.liaowei.sc.message.domain.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;

/**
 * @author LiaoWei
 */
@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 4056799608921584153L;
    private String name;
    private String age;
    private String address;
}
