package tuananh.com.slideimageinrecyclerview.view.binding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import tuananh.com.slideimageinrecyclerview.R;

/**
 * Created by framgia on 27/04/2017.
 */
public class ViewBindingAdapter {
    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        Picasso.with(imageView.getContext())
            .load(url)
            .placeholder(R.drawable.image_default)
            .into(imageView);
    }
}
