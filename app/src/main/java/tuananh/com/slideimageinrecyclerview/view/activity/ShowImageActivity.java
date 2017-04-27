package tuananh.com.slideimageinrecyclerview.view.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import tuananh.com.slideimageinrecyclerview.R;
import tuananh.com.slideimageinrecyclerview.databinding.ActivityShowImageBinding;
import tuananh.com.slideimageinrecyclerview.model.Constant;
import tuananh.com.slideimageinrecyclerview.model.Profile;
import tuananh.com.slideimageinrecyclerview.view.binding.ViewBindingAdapter;

public class ShowImageActivity extends AppCompatActivity {
    private ActivityShowImageBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_show_image);
        initViews();
    }

    private void initViews() {
        Intent intent = getIntent();
        if (intent == null) return;
        int positionImage = intent.getIntExtra(Constant.KEY_POSITION_IMAGE, -1);
        if (positionImage != -1) {
            Profile profile = (Profile) intent.getSerializableExtra(Constant.KEY_DATA_PROFILE);
            if (profile != null) {
                String urlImage = profile.getImageList().get(positionImage);
                ViewBindingAdapter.loadImage(mBinding.imageShow, urlImage);
            }
        }
    }
}
