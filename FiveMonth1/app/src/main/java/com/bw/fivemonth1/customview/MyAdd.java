package com.bw.fivemonth1.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.fivemonth1.R;

import androidx.annotation.Nullable;

/**
 * ClassName: FiveMonth1
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/14 16:36
 * @Description: 用途：完成特定功能
 */
public class MyAdd extends LinearLayout {
    private TextView tvReduce;
    public Button content;
    private TextView tvAdd;
    private OnContentListener onContentListener;

    public void setOnContentListener(OnContentListener onContentListener) {
        this.onContentListener = onContentListener;
    }

    public MyAdd(Context context) {
        super( context );
        init( context );
    }

    public MyAdd(Context context, @Nullable AttributeSet attrs) {
        super( context, attrs );
        init( context );
    }

    public MyAdd(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super( context, attrs, defStyleAttr );
        init( context );
    }

    private void init(Context context) {
        View view = LayoutInflater.from( context ).inflate( R.layout.view_add, this, true );
        tvReduce = view.findViewById( R.id.tvReduce );
        content = view.findViewById( R.id.content );
        tvAdd = view.findViewById( R.id.tvAdd );


        tvReduce.setOnClickListener( new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = content.getText().toString().trim();
                int i = Integer.parseInt( text );
                i--;

                if(i>=1){
                    content.setText( i+"" );
                    if (onContentListener != null) {
                        onContentListener.onConent( i );
                    }

                }else {
                    Toast.makeText( context, "不能小于1", Toast.LENGTH_SHORT ).show();
                }

            }
        } );

        tvAdd.setOnClickListener( new OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = content.getText().toString().trim();
                int i = Integer.parseInt( text );
                i++;
                content.setText( i+"" );
                if (onContentListener != null) {
                    onContentListener.onConent( i );
                }
            }
        } );

    }

    public interface OnContentListener{
        void onConent(int i);
    }

}
