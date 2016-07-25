package xzp.fsh.org;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private GridView mGridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGridview = (GridView) findViewById(R.id.gridview);
        mGridview.setAdapter(new MyAdapter(this));
    }

    //自定义适配器
    class MyAdapter extends BaseAdapter {
        //上下文对象
        private Context context;
        //图片数组
        private String[] texts = {
                "pic0", "pic1", "pic2",
                "pic3", "pic4", "pic5",
                "pic6", "pic7", "pic8",
        };

        MyAdapter(Context context) {
            this.context = context;
        }

        public int getCount() {
            return texts.length;
        }

        public Object getItem(int item) {
            return item;
        }

        public long getItemId(int id) {
            return id;
        }

        //创建View方法
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(context).inflate(R.layout.gridview_item, null);
                viewHolder.textView = (TextView) convertView.findViewById(R.id.tv);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.textView.setText(texts[position]);












            return convertView;
        }

        class ViewHolder {
            TextView textView;
        }
    }
}
