package huas.fur.newsbeijing.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import huas.fur.newsbeijing.R;

/**
 * 作者：Jacky
 * 邮箱：550997728@qq.com
 * 时间：2017/2/13 15:18
 */
public class SettingFragment extends BaseFragment {
          @Nullable
          @Override
          public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                    View rootView=inflater.inflate(R.layout.fragment_setting,null);
                    return rootView;
          }

          @Override
          protected void initView(View childView, TextView titleTv, ImageView titleIv) {

          }

          @Override
          protected int getContentLayoutRes() {
                    return 0;
          }
}
