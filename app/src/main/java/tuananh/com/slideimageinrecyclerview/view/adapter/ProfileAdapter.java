package tuananh.com.slideimageinrecyclerview.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import tuananh.com.slideimageinrecyclerview.R;
import tuananh.com.slideimageinrecyclerview.databinding.ItemRecyclerProfileBinding;

/**
 * Created by TuanAnh on 4/26/2017.
 */
public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public ProfileAdapter(Context context) {
        mContext = context;
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
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ProfileViewHolder extends RecyclerView.ViewHolder {
        private ItemRecyclerProfileBinding mBinding;

        public ProfileViewHolder(ItemRecyclerProfileBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }
    }
}
