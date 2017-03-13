package Util;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Bean.NewsBean;

/**
 * Created by XQM on 2017/3/11.
 */

public class Utility {
    public static List<NewsBean> handleNewsBeanResponse(String response){
        final List<NewsBean> newsBeanList = new ArrayList<NewsBean>();
        if (!TextUtils.isEmpty(response)){
            NewsBean bean;//封装
//            JSONArray jsonArray = null;
            try {
                JSONArray jsonArray = new JSONObject(response).getJSONArray("data");
                for (int i = 0;i < jsonArray.length();i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    bean = new NewsBean();
                    bean.newsPicUrl = jsonObject.getString("picSmall");
                    bean.newsTitle = jsonObject.getString("name");
                    bean.newsContent = jsonObject.getString("description");
                    newsBeanList.add(bean);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return newsBeanList;
    }
}
