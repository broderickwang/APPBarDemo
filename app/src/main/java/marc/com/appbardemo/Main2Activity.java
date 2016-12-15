package marc.com.appbardemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
	ViewPager viewPager;
	Bitmap b1,b2;
	ImageView ig1,ig2;
	View v1,v2;
	List<View> list = new ArrayList<>();
	RelativeLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);

		viewPager = (ViewPager)findViewById(R.id.viewpager);

		layout = (RelativeLayout)findViewById(R.id.activity_main2);

		ig1 = new ImageView(this);
		ig2 = new ImageView(this);


		b1 = BitmapFactory.decodeResource(getResources(),R.drawable.images);
		b2 = BitmapFactory.decodeResource(getResources(),R.drawable.itp);

		ig1.setImageBitmap(b1);
		ig2.setImageBitmap(b2);
		LayoutInflater inflater = getLayoutInflater();
		v1 = inflater.inflate(R.layout.one, null);
		v2 = inflater.inflate(R.layout.two, null);
		list.add(v1); list.add(v2);


		viewPager.setAdapter(new MyAdapter());

		new A().run();

	}
	class  A implements Runnable{
		@Override
		public void run() {
			if(viewPager != null){
				int index = viewPager.getCurrentItem() + 1;
				if(index >= list.size())
					index = 0;
				viewPager.setCurrentItem(index);
				layout.postDelayed(new A(),3000);
			}
		}
	}

	class MyAdapter extends PagerAdapter{

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			View v = list.get(position);
			ViewGroup parent = (ViewGroup) v.getParent();
			if (parent != null) {
				parent.removeAllViews();
			}
			container.addView(v);
			return v;
		}

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(list.get(position));
		}

	}
}
