package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ygxy.xqm.jsonlistview.R;

import java.util.List;

import Bean.NewsBean;

/**
 * Created by XQM on 2017/3/11.
 */

public class NewsAdapter extends BaseAdapter{
    private List<NewsBean> list;
    private Context mContext;
    private LayoutInflater inflater;

    public NewsAdapter(Context context,List<NewsBean> list){
        this.list = list;
        inflater = LayoutInflater.from(context);
        mContext = context;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        mContext = viewGroup.getContext();
        ViewHolder viewHolder = null;
        NewsBean bean = list.get(position);
        if (viewHolder == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item,null);
            viewHolder.title = (TextView) convertView.findViewById(R.id.item_title);
            viewHolder.pic = (ImageView) convertView.findViewById(R.id.item_pic);
            viewHolder.content = (TextView) convertView.findViewById(R.id.item_content);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.pic.setImageResource(R.mipmap.ic_launcher);

        String url = bean.newsPicUrl;
//        viewHolder.pic.setTag(url);
        Glide.with(mContext).load(url).into(viewHolder.pic);
        viewHolder.title.setText(bean.newsTitle);
        viewHolder.content.setText(bean.newsContent);
//        Log.i("Adapter",bean.newsTitle+"\n");
        return convertView;
    }

    class ViewHolder{
        public TextView title,content;
        public ImageView pic;
    }
}
