package marc.com.appbardemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	Toolbar toolbar;
	ConvenientBanner convenientBanner;
	private ArrayList<Integer> localImages = new ArrayList<Integer>();
	private List<String> networkImages;
	private String[] images = {"http://img2.imgtn.bdimg.com/it/u=3093785514,1341050958&fm=21&gp=0.jpg",
			"http://img2.3lian.com/2014/f2/37/d/40.jpg",
			"http://d.3987.com/sqmy_131219/001.jpg",
			"http://img2.3lian.com/2014/f2/37/d/39.jpg",
			"http://www.8kmm.com/UploadFiles/2012/8/201208140920132659.jpg",
			"http://f.hiphotos.baidu.com/image/h%3D200/sign=1478eb74d5a20cf45990f9df460b4b0c/d058ccbf6c81800a5422e5fdb43533fa838b4779.jpg",
			"http://f.hiphotos.baidu.com/image/pic/item/09fa513d269759ee50f1971ab6fb43166c22dfba.jpg"
	};
	private ArrayList<Bitmap> bts = new ArrayList<>();



	private ListView listView;
	private ArrayAdapter transformerArrayAdapter;
	private ArrayList<String> transformerList = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		for(int i=0 ;i<3;i++){
			bts.add(BitmapFactory.decodeResource(getResources(),R.drawable.images));
			bts.add(BitmapFactory.decodeResource(getResources(),R.drawable.itp));
		}

		convenientBanner = (ConvenientBanner)findViewById(R.id.convenientBanner);

		convenientBanner.setPages(new CBViewHolderCreator() {
			@Override
			public Object createHolder() {
				return new LocalImageHolderView();
			}
		}, bts)
		/*.setPageIndicator(new int[]{R.drawable.dot, R.drawable.dot_selected})
				.setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)*/;
	}
	@Override
	protected void onResume() {
		super.onResume();
		convenientBanner.startTurning(2000);// 2s 换一张
	}

	@Override
	protected void onPause() {
		super.onPause();
		convenientBanner.stopTurning();
	}
}

