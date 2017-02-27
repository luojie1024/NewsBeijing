package huas.fur.newsbeijing;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.viewpagerindicator.CirclePageIndicator;

/**
 * 作者：Jacky
 * 邮箱：550997728@qq.com
 * 时间：2017/2/9 11:56
 */
public class GuideActivity extends Activity {
          @ViewInject(R.id.guide_vp)
          ViewPager vp;
          @ViewInject(R.id.guide_btn)
          Button btn;
          @ViewInject(R.id.guide_cpi)
          CirclePageIndicator cpi;


          @Override
          protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_guide);
                    ViewUtils.inject(this);
                    System.out.println(123);
                    vp.setAdapter(pagerAdapter);
                    float pxFor6dp= TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,6,getResources().getDisplayMetrics());
                    cpi.setRadius(pxFor6dp);
                    cpi.setFillColor(Color.RED);
                    cpi.setPageColor(Color.GRAY);
                    cpi.setViewPager(vp);
                    //设置页面变化引起点变化
                    cpi.setOnPageChangeListener(pagerListener);
                    System.out.println(123456);
                    //页面变化监听
                    //vp.setOnPageChangeListener(pagerListener);
                    //默认进入页面隐藏btn,代码复用
                    pagerListener.onPageSelected(0);
          }
          //向导图片ID
          int[] picRes=new int[]{R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};
          private PagerAdapter pagerAdapter=new PagerAdapter() {
                    @Override
                    public int getCount() {
                              return picRes==null?0:picRes.length;
                    }

                    @Override
                    public boolean isViewFromObject(View view, Object object) {
                              return view==object;
                    }

                    @Override
                    public Object instantiateItem(ViewGroup container, int position) {
                              ImageView iv = new ImageView(container.getContext());
                              iv.setImageResource(picRes[position]);
                              iv.setScaleType(ImageView.ScaleType.FIT_XY);
                              container.addView(iv);
                              return iv;
                    }

                    @Override
                    public void destroyItem(ViewGroup container, int position, Object object) {
                              container.removeView((View) object);
                    }
          };

          private ViewPager.OnPageChangeListener pagerListener=new ViewPager.SimpleOnPageChangeListener(){
                    //选择页面变化时
                    @Override
                    public void onPageSelected(int position) {
                              //如果是最后一个向导页面，则显示btn
                              if (position == pagerAdapter.getCount() - 1) {
                                        btn.setVisibility(View.VISIBLE);
                              } else {
                                        btn.setVisibility(View.GONE);
                              }

                    }
          };
}
