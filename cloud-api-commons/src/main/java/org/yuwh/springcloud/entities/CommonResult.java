package org.yuwh.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/23 11:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;//在前端展示的字段

    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }
}
