package com.bw.fivemonth1.bean;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 17:16
 * @Description: 用途：完成特定功能
 */
public class OrderBean implements Serializable {

    /**
     * orderList : [{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":124,"commodityName":"台湾AC5高清4K摄像机数码DV12倍光学变焦专业家用旅游","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/sjsm/zxj/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/zxj/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/zxj/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/zxj/4/4.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/zxj/4/5.jpg","commodityPrice":1998,"orderDetailId":15658}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020030514273837928055","orderStatus":1,"orderTime":1583389658000,"payAmount":1998,"payMethod":1,"userId":28055},{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":124,"commodityName":"台湾AC5高清4K摄像机数码DV12倍光学变焦专业家用旅游","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/sjsm/zxj/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/zxj/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/zxj/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/zxj/4/4.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/zxj/4/5.jpg","commodityPrice":1998,"orderDetailId":15461}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020030421050798628055","orderStatus":2,"orderTime":1583327108000,"payAmount":1998,"payMethod":1,"userId":28055},{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":132,"commodityName":"10升不锈钢智能垃圾桶 时尚香槟金感应收纳桶 家用酒店用厨房环保桶","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/sjsm/znsb/5/1.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/znsb/5/2.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/znsb/5/3.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/znsb/5/4.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/znsb/5/5.jpg","commodityPrice":298,"orderDetailId":15458}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020030421045648528055","orderStatus":2,"orderTime":1583327096000,"payAmount":298,"payMethod":1,"userId":28055},{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":179,"commodityName":"莎米特SUMMIT拉杆箱22英寸PC材质万向轮旅行箱行李箱PC154T4A可扩容","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/xbsd/lgx/3/1.jpg,http://mobile.bwstudent.com/images/small/commodity/xbsd/lgx/3/2.jpg,http://mobile.bwstudent.com/images/small/commodity/xbsd/lgx/3/3.jpg,http://mobile.bwstudent.com/images/small/commodity/xbsd/lgx/3/4.jpg","commodityPrice":199,"orderDetailId":15457}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020030421044285928055","orderStatus":1,"orderTime":1583327083000,"payAmount":199,"payMethod":1,"userId":28055},{"detailList":[{"commentStatus":2,"commodityCount":1,"commodityId":113,"commodityName":"闪充充电器 9V-2A快充 适用 X21/X20/X9s/X9sPlus/X9/XPlay6/Xplay5/X7/X7Plus","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/sjsm/sjpj/7/1.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/sjpj/7/2.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/sjpj/7/3.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/sjpj/7/4.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/sjpj/7/5.jpg","commodityPrice":85,"orderDetailId":15205}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020030414092048128055","orderStatus":9,"orderTime":1583302160000,"payAmount":85,"payMethod":1,"userId":28055}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<OrderListBean> orderList;

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

    public List<OrderListBean> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderListBean> orderList) {
        this.orderList = orderList;
    }

    public static class OrderListBean {
        /**
         * detailList : [{"commentStatus":1,"commodityCount":1,"commodityId":124,"commodityName":"台湾AC5高清4K摄像机数码DV12倍光学变焦专业家用旅游","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/sjsm/zxj/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/zxj/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/zxj/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/zxj/4/4.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/zxj/4/5.jpg","commodityPrice":1998,"orderDetailId":15658}]
         * expressCompName : 京东快递
         * expressSn : 1001
         * orderId : 2020030514273837928055
         * orderStatus : 1
         * orderTime : 1583389658000
         * payAmount : 1998
         * payMethod : 1
         * userId : 28055
         */

        private String expressCompName;
        private String expressSn;
        private String orderId;
        private int orderStatus;
        private long orderTime;
        private int payAmount;
        private int payMethod;
        private int userId;
        private List<DetailListBean> detailList;

        public String getExpressCompName() {
            return expressCompName;
        }

        public void setExpressCompName(String expressCompName) {
            this.expressCompName = expressCompName;
        }

        public String getExpressSn() {
            return expressSn;
        }

        public void setExpressSn(String expressSn) {
            this.expressSn = expressSn;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public int getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
        }

        public long getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(long orderTime) {
            this.orderTime = orderTime;
        }

        public int getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(int payAmount) {
            this.payAmount = payAmount;
        }

        public int getPayMethod() {
            return payMethod;
        }

        public void setPayMethod(int payMethod) {
            this.payMethod = payMethod;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public List<DetailListBean> getDetailList() {
            return detailList;
        }

        public void setDetailList(List<DetailListBean> detailList) {
            this.detailList = detailList;
        }

        public static class DetailListBean {
            /**
             * commentStatus : 1
             * commodityCount : 1
             * commodityId : 124
             * commodityName : 台湾AC5高清4K摄像机数码DV12倍光学变焦专业家用旅游
             * commodityPic : http://mobile.bwstudent.com/images/small/commodity/sjsm/zxj/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/zxj/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/zxj/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/zxj/4/4.jpg,http://mobile.bwstudent.com/images/small/commodity/sjsm/zxj/4/5.jpg
             * commodityPrice : 1998
             * orderDetailId : 15658
             */

            private int commentStatus;
            private int commodityCount;
            private int commodityId;
            private String commodityName;
            private String commodityPic;
            private int commodityPrice;
            private int orderDetailId;

            public int getCommentStatus() {
                return commentStatus;
            }

            public void setCommentStatus(int commentStatus) {
                this.commentStatus = commentStatus;
            }

            public int getCommodityCount() {
                return commodityCount;
            }

            public void setCommodityCount(int commodityCount) {
                this.commodityCount = commodityCount;
            }

            public int getCommodityId() {
                return commodityId;
            }

            public void setCommodityId(int commodityId) {
                this.commodityId = commodityId;
            }

            public String getCommodityName() {
                return commodityName;
            }

            public void setCommodityName(String commodityName) {
                this.commodityName = commodityName;
            }

            public String getCommodityPic() {
                return commodityPic;
            }

            public void setCommodityPic(String commodityPic) {
                this.commodityPic = commodityPic;
            }

            public int getCommodityPrice() {
                return commodityPrice;
            }

            public void setCommodityPrice(int commodityPrice) {
                this.commodityPrice = commodityPrice;
            }

            public int getOrderDetailId() {
                return orderDetailId;
            }

            public void setOrderDetailId(int orderDetailId) {
                this.orderDetailId = orderDetailId;
            }
        }
    }
}
