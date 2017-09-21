package liangjianchao.com.bwei.week3_deamo2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by lenovo、 on 2017/8/19.
 */
public class MyAdapter extends BaseAdapter {

      List<Data.DataBean.ComicsBean> list;
          Context context;

          public MyAdapter(List<Data.DataBean.ComicsBean> list,Context context) {
              this.list = list;
              this.context = context;
          }


          @Override
          public int getCount() {
              return list == null ? 0 : list.size();
          }

          @Override
          public Object getItem(int i) {
              return list.get(i);
          }

          @Override
          public long getItemId(int i) {
              return i;
          }

          @Override
          public View getView(int i, View view, ViewGroup viewGroup) {
              ViewHolder holder=null;
              if(view==null){
                view= View.inflate(context,R.layout.item,null);
                  holder=new ViewHolder();

                  x.view().inject(holder,view);

                  view.setTag(holder);
              }else{
                  holder= (ViewHolder) view.getTag();
              }

             Data.DataBean.ComicsBean data = (Data.DataBean.ComicsBean) getItem(i);
              holder.tv_tilte.setText(data.getTitle());
              holder.tv_label_text.setText(data.getLabel_text());
              x.image().bind(holder.image,data.getCover_image_url());
              return view;
          }

          class ViewHolder{


              @ViewInject(R.id.imageView1)
               ImageView image;
              @ViewInject(R.id.textView_title)
               TextView tv_tilte;

              @ViewInject(R.id.textview_laybotitle)
              TextView tv_label_text;

          }
}
