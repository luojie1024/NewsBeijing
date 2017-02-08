package huas.fur.newsbeijing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * 作者：Jacky
 * 邮箱：550997728@qq.com
 * 时间：2017/2/8 13:23
 */
public class WelcomeActivity extends Activity {
          @ViewInject(R.id.welcome_iv)
          ImageView iv;

          @Override
          protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_welcome);
                    ViewUtils.inject(this);
          }

          private void playAnimation() {
                    //组合动画
                    AnimationSet animationSet = new AnimationSet(false);

                    //设置缩放动画
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1,
                         Animation.RELATIVE_TO_SELF,0.5f,
                         Animation.RELATIVE_TO_SELF,0.5f
                         );
                    //设置播放时间
                    scaleAnimation.setDuration(2000);
                    //添加缩放动画
                    animationSet.addAnimation(scaleAnimation);

                    //设置透明动画
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
                    //设置播放时间
                    alphaAnimation.setDuration(2000);
                    //添加透明动画
                    animationSet.addAnimation(alphaAnimation);

                    //设置动画结束监听
                    animationSet.setAnimationListener(animationListener);
                    //播放动画效果
                    iv.startAnimation(animationSet);
          }

          static Handler handler=new android.os.Handler();
          private Animation.AnimationListener animationListener=new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                              //过一会跳转
                              handler.postDelayed(goNextUiRunnabl,2000);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
          };

          //跳转到下一个界面
          private void goNextUi() {
                    startActivity(new Intent(this,MainActivity.class));
                    finish();
          }

          //跳转界面
          private Runnable goNextUiRunnabl =new Runnable() {
                              @Override
                              public void run() {
                                        goNextUi();
                              }
          };

          //规避返回不走逻辑的BUG
          @Override
          protected void onStart() {
                    super.onStart();
                    //播放动画
                    playAnimation();
          }

          //规避误触操作
          @Override
          protected void onStop() {
                    super.onStop();
                    handler.removeCallbacks(goNextUiRunnabl);

          }
}
