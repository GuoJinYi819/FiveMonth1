package com.bw.fivemonth2.bean;

import java.io.Serializable;

/**
 * ClassName: FiveMonth2
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/16 9:11
 * @Description: 用途：完成特定功能
 */
public class RegisterBean implements Serializable {

    /**
     * message : 该手机号已注册，不能重复注册！
     * status : 1001
     */

    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
