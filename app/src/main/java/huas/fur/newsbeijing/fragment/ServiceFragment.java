package huas.fur.newsbeijing.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import huas.fur.newsbeijing.R;

/**
 * 作者：Jacky
 * 邮箱：550997728@qq.com
 * 时间：2017/2/13 15:18
 */
public class ServiceFragment extends Fragment {
          @Nullable
          @Override
          public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                    View rootView=inflater.inflate(R.layout.fragment_service,null);
                    return rootView;
          }
}
