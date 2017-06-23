package huas.fur.newsbeijing.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import huas.fur.newsbeijing.R;
import itcast.lib_arl.AutoRollLayout;
import itcast.lib_arl.RollItem;

/**
 * 作者：Jacky
 * 邮箱：550997728@qq.com
 * 时间：2017/2/13 15:18
 */
public class HomeFragment extends BaseFragment {

          private SwipeRefreshLayout swipeRefreshLayout;
          private String ip_address="http://192.168.1.141:8080";
          @Override
          public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                    View rootView=inflater.inflate(R.layout.fragment_home,null);
                    return rootView;
          }

          @Override
          protected void initView(View childView, TextView titleTv, ImageView titleIv) {
                    titleTv.setText("首页");
                    titleIv.setVisibility(View.VISIBLE);
                    AutoRollLayout autoRollLayout = (AutoRollLayout) childView.findViewById(R.id.home_arl);
                    List<RollItem> items =new ArrayList<>();
                    items.add(new RollItem("吃饭", ip_address+"/zhbj/10007/1452327318UU91.jpg"));
                    items.add(new RollItem("喝汤", ip_address+"/zhbj/10007/1452327318UU92.jpg"));
                    items.add(new RollItem("睡觉", ip_address+"/zhbj/10007/1452327318UU93.jpg"));
                    items.add(new RollItem("打屁", ip_address+"/zhbj/10007/1452327318UU94.png"));

                    autoRollLayout.setItems(items);
                    autoRollLayout.setAutoRoll(true);

                    swipeRefreshLayout = (SwipeRefreshLayout) childView.findViewById(R.id.home_srl);
                    swipeRefreshLayout.setOnRefreshListener(refreshListener);
                    // 箭头的颜色在转一圈会变一次，到最后一个颜色，下个颜色又是第一个
                    swipeRefreshLayout.setColorSchemeColors(Color.RED,Color.GREEN,Color.BLUE);
                    // 设置圆圈背景色
                    swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Color.YELLOW);
          }

          static Handler handler  = new Handler();
          @Override
          protected int getContentLayoutRes() {
                    return R.layout.fragment_home;
          }

          private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                              handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                                  swipeRefreshLayout.setRefreshing(false);
                                                  System.out.println("下滑");
                                        }
                              }, 2000);
                              Toast.makeText(swipeRefreshLayout.getContext(), "onRefresh", Toast.LENGTH_SHORT).show();
                              System.out.println("下滑2");
                    }
          };
}
