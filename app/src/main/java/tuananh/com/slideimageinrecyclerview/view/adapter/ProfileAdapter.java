package tuananh.com.slideimageinrecyclerview.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import tuananh.com.slideimageinrecyclerview.BR;
import tuananh.com.slideimageinrecyclerview.R;
import tuananh.com.slideimageinrecyclerview.databinding.ItemRecyclerProfileBinding;
import tuananh.com.slideimageinrecyclerview.model.Profile;

/**
 * Created by TuanAnh on 4/26/2017.
 */
public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {
    private static final int MAX_SIZE_IMAGE_LOAD = 8;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<Profile> mProfileList;

    public ProfileAdapter(Context context, List<Profile> profileList) {
        mContext = context;
        mProfileList = profileList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemRecyclerProfileBinding binding = DataBindingUtil.inflate(mLayoutInflater,
            R.layout.item_recycler_profile, parent, false);
        return new ProfileViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ProfileViewHolder holder, int position) {
        Profile profile = mProfileList.get(position);
        holder.bind(profile);
    }

    @Override
    public int getItemCount() {
        return mProfileList == null ? 0 : mProfileList.size();
    }

    public class ProfileViewHolder extends RecyclerView.ViewHolder {
        private ItemRecyclerProfileBinding mBinding;

        public ProfileViewHolder(ItemRecyclerProfileBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(Profile profile) {
            mBinding.setVariable(BR.viewModel, profile);
            SlideImageAdapter slideImageAdapter =
                new SlideImageAdapter(mContext, profile.getImageList());
            mBinding.sliderImageViewPager.setAdapter(slideImageAdapter);
            mBinding.sliderImageViewPager.setOffscreenPageLimit(MAX_SIZE_IMAGE_LOAD);
            mBinding.indicator.setViewPager(mBinding.sliderImageViewPager);
            mBinding.executePendingBindings();
        }
    }
}
