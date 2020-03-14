package com.bw.fivemonth1.bean;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 15:48
 * @Description: 用途：完成特定功能
 */
public class ShopBean implements Serializable {

    /**
     * result : [{"categoryName":"手机数码","shoppingCartList":[{"commodityId":103,"commodityName":"【送自拍杆】魅族 魅蓝 E3 64G 全面屏 全网通手机","count":1,"pic":"http://mobile.bwstudent.com/images/small/commodity/sjsm/sj/4/1.jpg","price":1638},{"commodityId":114,"commodityName":"羽博 可悬挂无线蓝牙便携音响 布面工艺方形户外超重低音蓝牙音响车载手机迷你蓝牙音箱","count":1,"pic":"http://mobile.bwstudent.com/images/small/commodity/sjsm/yyyl/1/1.jpg","price":49}]},{"categoryName":"美妆护肤","shoppingCartList":[{"commodityId":13,"commodityName":"贝览得美妆蛋","count":1,"pic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/3/1.jpg","price":44},{"commodityId":14,"commodityName":"美诺MENOW面部刷","count":1,"pic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/4/1.jpg","price":47}]}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * categoryName : 手机数码
         * shoppingCartList : [{"commodityId":103,"commodityName":"【送自拍杆】魅族 魅蓝 E3 64G 全面屏 全网通手机","count":1,"pic":"http://mobile.bwstudent.com/images/small/commodity/sjsm/sj/4/1.jpg","price":1638},{"commodityId":114,"commodityName":"羽博 可悬挂无线蓝牙便携音响 布面工艺方形户外超重低音蓝牙音响车载手机迷你蓝牙音箱","count":1,"pic":"http://mobile.bwstudent.com/images/small/commodity/sjsm/yyyl/1/1.jpg","price":49}]
         */

        private String categoryName;
        private List<ShoppingCartListBean> shoppingCartList;
        private boolean isChecked;

        public void setIsChecked(boolean b){
            this.isChecked = b;
        }

        public boolean getIsChecked(){
            return isChecked;
        }
        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public List<ShoppingCartListBean> getShoppingCartList() {
            return shoppingCartList;
        }

        public void setShoppingCartList(List<ShoppingCartListBean> shoppingCartList) {
            this.shoppingCartList = shoppingCartList;
        }

        public static class ShoppingCartListBean {
            /**
             * commodityId : 103
             * commodityName : 【送自拍杆】魅族 魅蓝 E3 64G 全面屏 全网通手机
             * count : 1
             * pic : http://mobile.bwstudent.com/images/small/commodity/sjsm/sj/4/1.jpg
             * price : 1638
             */

            private int commodityId;
            private String commodityName;
            private int count;
            private String pic;
            private int price;

            private boolean isChecked;

            public void setIsChecked(boolean b){
                this.isChecked = b;
            }

            public boolean getIsChecked(){
                return isChecked;
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

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }
        }
    }
}
