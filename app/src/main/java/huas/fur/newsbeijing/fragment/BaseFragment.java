package huas.fur.newsbeijing.fragment;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import huas.fur.newsbeijing.R;


/**
 * 抽取父类的原因：
 * <p/>
 * 一 各个子类中有相同或相似的代码（功能）
 * 界面
 * 有共同的 标题区域 加载具有头部标题区域的布局
 * 标题文字的样式一致
 * 标题图片
 * <p/>
 * 下方有一块界面 inflater.inflate(getContentLayoutRes(), childContainer)
 * 数据
 * <p/>
 * 二 各个子类中有不同的代码或功能
 * 界面
 * <p/>
 * 标题文字的内容不一样 initView
 * 标题图片可见性不一样 initView
 * <p/>
 * 下方的界面不一样  getContentLayoutRes
 * 数据
 * <p/>
 * <p/>
 * <p/>
 * <p/>
 * 模板模式：
 * 类似 奖状/身份证
 * <p/>
 * 祝贺__（由子类去做）___同学：
 * 在___（抽象方法）________比赛中 获取了_______________。
 */
public abstract class BaseFragment extends Fragment {


          private View rootView;

          @Nullable
          @Override
          public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                    Log.d("onCreateView", getClass().getSimpleName());
                    // 复用view，避免反复加载布局及数据
                    if (rootView == null) {
                              rootView = inflater.inflate(R.layout.fragment_base, null);
                              TextView titleTv = (TextView) rootView.findViewById(R.id.fragment_base_title_tv);
                              ImageView titleIv = (ImageView) rootView.findViewById(R.id.fragment_base_title_iv);
                              FrameLayout childContainer = (FrameLayout) rootView.findViewById(R.id.fragment_base_child_container);

                              View childView = inflater.inflate(getContentLayoutRes(), childContainer);

                              initView(childView, titleTv, titleIv);
                    }
                    return rootView;
          }

          protected abstract void initView(View childView, TextView titleTv, ImageView titleIv);

          protected abstract int getContentLayoutRes();
}
