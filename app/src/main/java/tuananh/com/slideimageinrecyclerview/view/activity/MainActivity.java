package tuananh.com.slideimageinrecyclerview.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import tuananh.com.slideimageinrecyclerview.CreateData;
import tuananh.com.slideimageinrecyclerview.R;
import tuananh.com.slideimageinrecyclerview.databinding.ActivityMainBinding;
import tuananh.com.slideimageinrecyclerview.model.Profile;
import tuananh.com.slideimageinrecyclerview.view.adapter.ProfileAdapter;

public class MainActivity extends AppCompatActivity {
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
        mProfileAdapter = new ProfileAdapter(this, mProfileList);
        mBinding.recyclerViewProfile.setAdapter(mProfileAdapter);
        mBinding.recyclerViewProfile.setLayoutManager(new LinearLayoutManager(this));
    }
}
