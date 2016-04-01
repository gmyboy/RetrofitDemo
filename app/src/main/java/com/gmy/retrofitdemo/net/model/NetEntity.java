package com.gmy.retrofitdemo.net.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gmy on 16/4/1.
 */
public class NetEntity implements Parcelable {

    /**
     * date : 20160401
     * stories : [{"images":["http://pic4.zhimg.com/dac2414582107491045fc9f0f58a6be3.jpg"],"type":0,"id":8086788,"ga_prefix":"040111","title":"如何摆脱抑郁？"},{"images":["http://pic3.zhimg.com/6ecb2d6243dd65afc855bb616269e79e.jpg"],"type":0,"id":8081499,"ga_prefix":"040110","title":"排队（搭讪）技巧一则"},{"title":"去《Legal High》古美门律师事务所吃法餐","ga_prefix":"040109","images":["http://pic1.zhimg.com/1205cbbcaed4c53eb2138eb6256df540.jpg"],"multipic":true,"type":0,"id":8082626},{"images":["http://pic4.zhimg.com/683ea62eab6830c4889c78b7511238cb.jpg"],"type":0,"id":8084347,"ga_prefix":"040108","title":"「摄影不就是按个快门吗，怎么就成艺术了？」"},{"title":"一代女建筑大师去世了，这是她设计的望京 SOHO","ga_prefix":"040107","images":["http://pic4.zhimg.com/3c82bd9e0f13217e56550c3d8897e7a3.jpg"],"multipic":true,"type":0,"id":8085203},{"images":["http://pic1.zhimg.com/f1ad03a469f83c2026e16eb01e3a07ac.jpg"],"type":0,"id":8082616,"ga_prefix":"040107","title":"几乎所有人都在围观，却少有人出手相助"},{"images":["http://pic4.zhimg.com/0a89a1357f3285fa94f96cb332dfd41f.jpg"],"type":0,"id":8065407,"ga_prefix":"040107","title":"别只谈大龄女性，大龄男性生娃也有风险"},{"images":["http://pic2.zhimg.com/c27ac1c169724fc9a5fbb5263ed96e59.jpg"],"type":0,"id":8085143,"ga_prefix":"040107","title":"读读日报 24 小时热门 TOP 5 · 柳岩当伴娘，全程找不到绅士"},{"images":["http://pic2.zhimg.com/3193da87a94a51071bffc1f718b01265.jpg"],"type":0,"id":8064572,"ga_prefix":"040106","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic2.zhimg.com/2cafb434aa83b774eb57a04515766f51.jpg","type":0,"id":8086788,"ga_prefix":"040111","title":"如何摆脱抑郁？"},{"image":"http://pic3.zhimg.com/fed6ffa2444d4e0ac6fdc6336226964e.jpg","type":0,"id":8085203,"ga_prefix":"040107","title":"一代女建筑大师去世了，这是她设计的望京 SOHO"},{"image":"http://pic3.zhimg.com/b8079ec2d7f638b5848effc1a4b8631a.jpg","type":0,"id":8085143,"ga_prefix":"040107","title":"读读日报 24 小时热门 TOP 5 · 柳岩当伴娘，全程找不到绅士"},{"image":"http://pic3.zhimg.com/09796e9eb366d974d6a0a2caff81da36.jpg","type":0,"id":8082626,"ga_prefix":"040109","title":"去《Legal High》古美门律师事务所吃法餐"},{"image":"http://pic4.zhimg.com/86cd70da7f73fdac0e73c7b559aa4d13.jpg","type":0,"id":8082616,"ga_prefix":"040107","title":"几乎所有人都在围观，却少有人出手相助"}]
     */

    private String date;
    /**
     * images : ["http://pic4.zhimg.com/dac2414582107491045fc9f0f58a6be3.jpg"]
     * type : 0
     * id : 8086788
     * ga_prefix : 040111
     * title : 如何摆脱抑郁？
     */

    private List<StoriesBean> stories;
    /**
     * image : http://pic2.zhimg.com/2cafb434aa83b774eb57a04515766f51.jpg
     * type : 0
     * id : 8086788
     * ga_prefix : 040111
     * title : 如何摆脱抑郁？
     */

    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.date);
        dest.writeList(this.stories);
        dest.writeList(this.top_stories);
    }

    public NetEntity() {
    }

    protected NetEntity(Parcel in) {
        this.date = in.readString();
        this.stories = new ArrayList<StoriesBean>();
        in.readList(this.stories, StoriesBean.class.getClassLoader());
        this.top_stories = new ArrayList<TopStoriesBean>();
        in.readList(this.top_stories, TopStoriesBean.class.getClassLoader());
    }

    public static final Creator<NetEntity> CREATOR = new Creator<NetEntity>() {
        @Override
        public NetEntity createFromParcel(Parcel source) {
            return new NetEntity(source);
        }

        @Override
        public NetEntity[] newArray(int size) {
            return new NetEntity[size];
        }
    };
}
