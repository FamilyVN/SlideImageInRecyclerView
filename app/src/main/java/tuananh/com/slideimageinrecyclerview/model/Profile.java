package tuananh.com.slideimageinrecyclerview.model;

import java.util.List;

/**
 * Created by framgia on 27/04/2017.
 */
public class Profile {
    private int mId;
    private String mName;
    private int mAge;
    private List<String> mImageList;

    public Profile(int id, String name, int age, List<String> imageList) {
        mId = id;
        mName = name;
        mAge = age;
        mImageList = imageList;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public List<String> getImageList() {
        return mImageList;
    }

    public void setImageList(List<String> imageList) {
        mImageList = imageList;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }

    public String getNameAge() {
        return String.format("%s, %d", getName(), getAge());
    }
}
