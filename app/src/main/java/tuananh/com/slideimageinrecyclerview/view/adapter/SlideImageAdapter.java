package tuananh.com.slideimageinrecyclerview.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import tuananh.com.slideimageinrecyclerview.R;
import tuananh.com.slideimageinrecyclerview.databinding.FragmentSlideProfileBinding;

/**
 * Created by framgia on 27/04/2017.
 */
public class SlideImageAdapter extends PagerAdapter {
    private Context mContext;
    private List<String> mImageList;
    private LayoutInflater mLayoutInflater;

    public SlideImageAdapter(Context context, List<String> imageList) {
        mContext = context;
        mImageList = imageList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return mImageList == null ? 0 : mImageList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        FragmentSlideProfileBinding binding = DataBindingUtil.inflate(mLayoutInflater,
            R.layout.fragment_slide_profile, container, false);
        binding.setUrl(mImageList.get(position));
        binding.setPosition(position);
        binding.getRoot().setTag(position);
        container.addView(binding.getRoot(), 0);
        return binding.getRoot();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
