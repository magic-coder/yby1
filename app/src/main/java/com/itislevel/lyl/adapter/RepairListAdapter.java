package com.itislevel.lyl.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.flexbox.FlexboxLayout;
import com.itislevel.lyl.R;
import com.itislevel.lyl.app.App;
import com.itislevel.lyl.app.Constants;
import com.itislevel.lyl.mvp.model.bean.CatelistBean;
import com.itislevel.lyl.mvp.model.bean.FamilyListBean;
import com.itislevel.lyl.mvp.model.bean.RepairListBean;
import com.itislevel.lyl.utils.DateUtil;

import static io.rong.imkit.utilities.RongUtils.dip2px;

/**
 * desc:功能说明必写
 * user:itisi
 * date:2017/12/12.17:14
 * path:com.itislevel.lyl.adapter.FamilyListAdapter
 **/
public class RepairListAdapter extends BaseQuickAdapter<RepairListBean.ListBean,
        BaseViewHolder> {
    private Activity mActivity;
    public RepairListAdapter(int layoutResId, Activity activity) {
        super(layoutResId);
        this.mActivity = activity;
    }

    @Override
    protected void convert(BaseViewHolder helper, RepairListBean.ListBean item) {

        helper.addOnClickListener(R.id.call_phone);

        Glide.with(App.getInstance())
                .load(Constants.IMG_SERVER_PATH + item.getHeadurl())
                .asBitmap()
                .error(R.mipmap.family_adderror)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into((ImageView) helper.getView(R.id.iv_photo));
        float score = 0.0f;
        if(item.getScoreAverage()!=null)
        {
             score = Float.parseFloat(item.getScoreAverage());
        }
        helper.setText(R.id.rating_fen,score+"");
        helper.setText(R.id.repair_username,item.getRealname());
        helper.setText(R.id.location_name,item.getAddress());
        helper.setRating(R.id.ratingBar,item.getScore()/2);
        FlexboxLayout fbl_parent = helper.getView(R.id.fbl_parent);
        RatingBar ratingBar = helper.getView(R.id.ratingBar);
        ratingBar.setRating(score/2);
        //设置外间距
        FlexboxLayout.LayoutParams params1 = new FlexboxLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params1.setMargins(0,dip2px(3),dip2px(6),0);

        if (item.getCatelist() != null && item.getCatelist().size() > 0) {
            fbl_parent.removeAllViews();
            for (CatelistBean fab : item.getCatelist()) {
                TextView textView = new TextView(App.getInstance());
                textView.setText(fab.getCatename());
                textView.setTextSize(12);
                textView.setTextColor(Color.parseColor("#ffffff"));
                textView.setPadding(3,1, 3, 1);
                textView.setBackgroundResource(R.drawable.repair_fshape);
                textView.setLayoutParams(params1);
                fbl_parent.addView(textView);
            }
        } else {
            fbl_parent.removeAllViews();
        }
       // ratingBar.setRating();
    }


}
