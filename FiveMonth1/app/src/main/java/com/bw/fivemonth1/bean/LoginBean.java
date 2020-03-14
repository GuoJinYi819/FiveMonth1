package com.bw.fivemonth1.bean;

import java.io.Serializable;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 14:58
 * @Description: 用途：完成特定功能
 */
public class LoginBean implements Serializable {
    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}
