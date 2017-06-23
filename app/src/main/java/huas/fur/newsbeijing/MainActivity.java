package huas.fur.newsbeijing;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import huas.fur.newsbeijing.fragment.HomeFragment;
import huas.fur.newsbeijing.fragment.NewsFragment;
import huas.fur.newsbeijing.fragment.ServiceFragment;
import huas.fur.newsbeijing.fragment.SettingFragment;

public class MainActivity extends Activity {

          @ViewInject(R.id.main_bottom_rg)
          RadioGroup rg;

          @Override
          protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_main);
                    ViewUtils.inject(this);
                    fragments.add(new HomeFragment());
                    fragments.add(new NewsFragment());
                    fragments.add(new ServiceFragment());
                    fragments.add(new SettingFragment());

                    rg.setOnCheckedChangeListener(checedListener);
                    ((RadioButton) rg.getChildAt(1)).setChecked(true);
          }

          List<Fragment> fragments=new ArrayList<>();

          private RadioGroup.OnCheckedChangeListener checedListener=new RadioGroup.OnCheckedChangeListener() {

                    /***
                     *
                     * @param radioGroup  设置监听的RadioGroup
                     * @param i             选中的RadioButton的id
                     */
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                              View child=radioGroup.findViewById(i);
                              int index = radioGroup.indexOfChild(child);
                              Fragment fragment = fragments.get(index);

                              getFragmentManager().
                                   beginTransaction().
                                   replace(R.id.main_fragment_container,fragment).
                                   commit();

                    }
          };
}
