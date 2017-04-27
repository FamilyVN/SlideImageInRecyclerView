package tuananh.com.slideimageinrecyclerview.view.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import tuananh.com.slideimageinrecyclerview.CreateData;
import tuananh.com.slideimageinrecyclerview.R;
import tuananh.com.slideimageinrecyclerview.databinding.ActivityMainBinding;
import tuananh.com.slideimageinrecyclerview.listener.OnClickShowImageListener;
import tuananh.com.slideimageinrecyclerview.model.Constant;
import tuananh.com.slideimageinrecyclerview.model.Profile;
import tuananh.com.slideimageinrecyclerview.view.adapter.ProfileAdapter;

public class MainActivity extends AppCompatActivity implements OnClickShowImageListener {
    private ActivityMainBinding mBinding;
    private ProfileAdapter mProfileAdapter;
    private List<Profile> mProfileList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initData();
        initViews();
    }

    private void initData() {
        mProfileList = CreateData.createProfile();
    }

    private void initViews() {
        mProfileAdapter = new ProfileAdapter(this, mProfileList, this);
        mBinding.recyclerViewProfile.setAdapter(mProfileAdapter);
        mBinding.recyclerViewProfile.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClickShowImage(Profile profile, int positionImage) {
        Intent intent = new Intent(this, ShowImageActivity.class);
        intent.putExtra(Constant.KEY_POSITION_IMAGE, positionImage);
        intent.putExtra(Constant.KEY_DATA_PROFILE, profile);
        startActivity(intent);
    }
}
