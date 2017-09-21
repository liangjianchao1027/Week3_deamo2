package liangjianchao.com.bwei.week3_deamo2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lenovo、 on 2017/8/14.
 */
public class TwoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = View.inflate(getActivity(),R.layout.item2,null);
      TextView tv =  (TextView) view.findViewById(R.id.textView_two);
        tv.setText("热点");
        return view;
    }
}
