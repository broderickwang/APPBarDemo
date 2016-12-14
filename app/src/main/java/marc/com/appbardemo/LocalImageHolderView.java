package marc.com.appbardemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.adapter.CBPageAdapter;
import com.bigkoo.convenientbanner.holder.Holder;

/**
 * Created by Broderick on 2016/12/14.
 */
public class LocalImageHolderView implements Holder<Bitmap>{
	private ImageView imageView;
	@Override
	public View createView(Context context) {
		imageView = new ImageView(context);
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		return imageView;
	}

	@Override
	public void UpdateUI(Context context, int position, Bitmap data) {
		imageView.setImageBitmap(data);
	}
}
