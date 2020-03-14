package com.bw.fivemonth1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.fivemonth1.R;
import com.bw.fivemonth1.bean.EventBean;
import com.bw.fivemonth1.bean.ShopBean;
import com.bw.fivemonth1.customview.MyAdd;
import com.bw.fivemonth1.net.ImageUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 15:54
 * @Description: 用途：完成特定功能
 */
public class ShopAdapter extends BaseExpandableListAdapter {
    private List<ShopBean.ResultBean> list = new ArrayList<>();
    private Context context;
    private CheckBox checkBoxGroup;
    private TextView tvCategoryName;
    private CheckBox checkBoxChild;
    private ImageView ivPic;
    private TextView tvCommodityName;
    private TextView tvPrice;

    public ShopAdapter(List<ShopBean.ResultBean> result, Context context) {
        this.list.addAll( result );
        this.context = context;
    }

    /**
     * Gets the number of groups.
     *
     * @return the number of groups
     */
    @Override
    public int getGroupCount() {
        return list.size();
    }

    /**
     * Gets the number of children in a specified group.
     *
     * @param groupPosition the position of the group for which the children
     *                      count should be returned
     * @return the children count in the specified group
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        ShopBean.ResultBean resultBean = list.get( groupPosition );
        List<ShopBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
        return shoppingCartList.size();
    }

    /**
     * Gets the data associated with the given group.
     *
     * @param groupPosition the position of the group
     * @return the data child for the specified group
     */
    @Override
    public Object getGroup(int groupPosition) {
        ShopBean.ResultBean resultBean = list.get( groupPosition );
        return resultBean;
    }

    /**
     * Gets the data associated with the given child within the given group.
     *
     * @param groupPosition the position of the group that the child resides in
     * @param childPosition the position of the child with respect to other
     *                      children in the group
     * @return the data of the child
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ShopBean.ResultBean resultBean = list.get( groupPosition );
        List<ShopBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
        ShopBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get( childPosition );
        return shoppingCartListBean;
    }

    /**
     * Gets the ID for the group at the given position. This group ID must be
     * unique across groups. The combined ID (see
     * {@link #getCombinedGroupId(long)}) must be unique across ALL items
     * (groups and all children).
     *
     * @param groupPosition the position of the group for which the ID is wanted
     * @return the ID associated with the group
     */
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /**
     * Gets the ID for the given child within the given group. This ID must be
     * unique across all children within the group. The combined ID (see
     * {@link #getCombinedChildId(long, long)}) must be unique across ALL items
     * (groups and all children).
     *
     * @param groupPosition the position of the group that contains the child
     * @param childPosition the position of the child within the group for which
     *                      the ID is wanted
     * @return the ID associated with the child
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupPosition + childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    //外层
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from( context ).inflate( R.layout.item_group_shop, parent, false );
        checkBoxGroup = view.findViewById( R.id.checkBoxGroup );
        tvCategoryName = view.findViewById( R.id.tvCategoryName );

        ShopBean.ResultBean resultBean = list.get( groupPosition );
        String categoryName = resultBean.getCategoryName();
        tvCategoryName.setText( categoryName );

        boolean isChecked = resultBean.getIsChecked();
        checkBoxGroup.setChecked( isChecked );

        checkBoxGroup.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                resultBean.setIsChecked( isChecked );
                List<ShopBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
                for (int i = 0; i < shoppingCartList.size(); i++) {
                    ShopBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get( i );
                    shoppingCartListBean.setIsChecked( isChecked );
                }
                //刷新
                EventBean eventBean = new EventBean();
                eventBean.setList( list );
                EventBus.getDefault().postSticky(eventBean);
                notifyDataSetChanged();

                notifyDataSetChanged();
            }
        } );

        return view;
    }


    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from( context ).inflate( R.layout.item_child_shop, parent, false );
        checkBoxChild = view.findViewById( R.id.checkBoxChild );
        ivPic = view.findViewById( R.id.ivPic );
        MyAdd myadd = view.findViewById( R.id.myadd );
        tvCommodityName = view.findViewById( R.id.tvCommodityName );
        tvPrice = view.findViewById( R.id.tvPrice );

        ShopBean.ResultBean resultBean = list.get( groupPosition );
        List<ShopBean.ResultBean.ShoppingCartListBean> shoppingCartList = resultBean.getShoppingCartList();
        ShopBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get( childPosition );

        String commodityName = shoppingCartListBean.getCommodityName();
        tvCommodityName.setText( commodityName );
        int price = shoppingCartListBean.getPrice();
        tvPrice.setText( "￥ "+price );
        String pic = shoppingCartListBean.getPic();
        ImageUtil instance = ImageUtil.getInstance();
        instance.setImg( pic,ivPic );

        boolean isChecked = shoppingCartListBean.getIsChecked();
        checkBoxChild.setChecked( isChecked );

        checkBoxChild.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    shoppingCartListBean.setIsChecked( isChecked );
                EventBean eventBean = new EventBean();
                eventBean.setList( list );
                EventBus.getDefault().postSticky(eventBean);
            }
        } );

        int count = shoppingCartListBean.getCount();
        myadd.content.setText( count+"" );
        myadd.setOnContentListener( new MyAdd.OnContentListener() {
            @Override
            public void onConent(int i) {
                shoppingCartListBean.setCount( i );
                EventBean eventBean = new EventBean();
                eventBean.setList( list );
                EventBus.getDefault().postSticky(eventBean);
            }
        } );


        return view;
    }

    /**
     * Whether the child at the specified position is selectable.
     *
     * @param groupPosition the position of the group that contains the child
     * @param childPosition the position of the child within the group
     * @return whether the child is selectable.
     */
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public List<ShopBean.ResultBean> getList() {
        return list;
    }
}
