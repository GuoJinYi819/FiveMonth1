package com.bw.fivemonth1.bean;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 16:28
 * @Description: 用途：完成特定功能
 */
public class EventBean implements Serializable {

    private List<ShopBean.ResultBean> list;

    public List<ShopBean.ResultBean> getList() {
        return list;
    }

    public void setList(List<ShopBean.ResultBean> list) {
        this.list = list;
    }
}
