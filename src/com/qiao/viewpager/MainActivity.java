package com.qiao.viewpager;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qiao.view.ViewPagerCompat;
import com.qiao.view.ZoomOutPageTransformer;
import com.qiao.view.ViewPagerCompat.OnPageChangeListener;

/** 
* ViewPager 一屏多个 3D滑动效果。。。。。。 
* @author 有点凉了 
* QQ群：123869487 
* 求基友共同进步，求大神入群指点 
* 
*/  

public class MainActivity extends FragmentActivity
{    
	private static int     TOTAL_COUNT = 3;

	private RelativeLayout viewPagerContainer;
	int oneTouch = 0 ;
	int TwoTouch = 0;
	int ThrTouch = 0;
	private ViewPagerCompat mViewPager;
	private int[] mImgIds = new int[] { 
			R.drawable.image1,
			R.drawable.image2, 
			R.drawable.image3 ,
			R.drawable.image1 ,
			R.drawable.image3,
			R.drawable.guide_image1,
			R.drawable.guide_image2,
			R.drawable.guide_image3,
			R.drawable.guide_image5,
//			R.drawable.image1,
//			R.drawable.image1,
//			R.drawable.image2, 
//			R.drawable.image3 ,
//			R.drawable.image1 ,
//			R.drawable.image3,
//			R.drawable.guide_image1,
//			R.drawable.guide_image2,
//			R.drawable.guide_image3,
//			R.drawable.guide_image5,
//			R.drawable.image1
			};
	private List<ImageView> mImageViews = new ArrayList<ImageView>();
	private int current=0;
	private MyPagerAdapter2  myPagerAdapter;
	private int[] locationOne = null;
	private int[] locationTwo = null;
	private List<Fragment> listFragment = new ArrayList<Fragment>();
	private List<String> listMessage = new ArrayList<String>();
	
	public static MainActivity mActivity;
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 0:
				
				break;

			default:
				break;
			}
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		mActivity = this;
		listMessage.add("拉布");
		listMessage.add("吉娃娃");
		listMessage.add("大葱");
		listMessage.add("大葱1");
		listMessage.add("大葱2");
		listMessage.add("大葱11");
		listMessage.add("大葱22");
		listMessage.add("大葱33");
		listMessage.add("大葱44");
		listMessage.add("大葱55");
//		listMessage.add("拉布");
//		listMessage.add("吉娃娃");
//		listMessage.add("大葱");
//		listMessage.add("大葱1");
//		listMessage.add("大葱2");
//		listMessage.add("大葱11");
//		listMessage.add("大葱22");
//		listMessage.add("大葱33");
//		listMessage.add("大葱44");
//		listMessage.add("大葱55");
		initData();
		viewPagerContainer = (RelativeLayout) findViewById(R.id.pager_layout);
		mViewPager = (ViewPagerCompat) findViewById(R.id.id_viewpager);
		locationOne = new int[2];  
		locationTwo = new int[2];  
		
		mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
//		mViewPager.setPageTransformer(true, new DepthPageTransformer());
//		mViewPager.setPageTransformer(true, new RotateDownPageTransformer());
		myPagerAdapter = new MyPagerAdapter2(getSupportFragmentManager());
		mViewPager.setAdapter(myPagerAdapter);
//		mViewPager.setOffscreenPageLimit(TOTAL_COUNT);
		mViewPager.setOffscreenPageLimit(20);
		mViewPager.setPageMargin(10);
		viewPagerContainer.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // dispatch the events to the ViewPager, to solve the problem that we can swipe only the middle view.
            	/*if (event.getAction() == MotionEvent.ACTION_DOWN) {
					v.getLocationInWindow(locationTwo);
					int singPostion = locationTwo[0];
					if (singPostion>0&&singPostion<oneTouch) {
						int pos = mViewPager.getCurrentItem();
						if (pos==0) {
							
						}else {
							mViewPager.setCurrentItem(mViewPager.getCurrentItem()-1);
						}
					}
					
				}*/
                return mViewPager.dispatchTouchEvent(event);
            }
        });
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				myPagerAdapter.notifyDataSetChanged();
				View view = mViewPager.getChildAt(position);
				ImageView img = (ImageView) view.findViewById(R.id.imageView_show);
				TextView textView_show = (TextView) view.findViewById(R.id.textView_show);
				TextView textView_id = (TextView) view.findViewById(R.id.textView_id);
				img.setPadding(0, 0, 0, 0);
//				img.setImageResource(mImgIds[position]);
				img.setImageBitmap(readBitMap(mActivity, mImgIds[position]));
				textView_show.setText(listMessage.get(position));
				textView_id.setVisibility(View.VISIBLE);
				textView_id.setText(listMessage.get(position));
				
				
				int count = mViewPager.getChildCount();
				for (int i = 0; i < count; i++) {
					if (i==current) {
//						View view2 = mViewPager.getChildAt(i);
//						TextView textView_id2 = (TextView) view2.findViewById(R.id.textView_id);
//						TextView textView_show2 = (TextView) view2.findViewById(R.id.textView_show);
//						ImageView img2 = (ImageView) view2.findViewById(R.id.imageView_show);
//						textView_id2.setVisibility(View.VISIBLE);
//						textView_id2.setText(listMessage.get(i));
//						textView_show2.setText(listMessage.get(i));
//						img2.setPadding(0, 0, 0, 0);
//						myPagerAdapter.notifyDataSetChanged();
					}else {
						View view2 = mViewPager.getChildAt(i);
						TextView textView_id2 = (TextView) view2.findViewById(R.id.textView_id);
						TextView textView_show2 = (TextView) view2.findViewById(R.id.textView_show);
						ImageView img2 = (ImageView) view2.findViewById(R.id.imageView_show);
						textView_id2.setVisibility(View.GONE);
						textView_show2.setText(listMessage.get(i));
						img2.setPadding(5, 5, 5,5);
						myPagerAdapter.notifyDataSetChanged();
					}
				}
	            myPagerAdapter.notifyDataSetChanged();
	            current = position;
			}
			
			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {
				// TODO Auto-generated method stub
				
				if (viewPagerContainer != null) {
	                viewPagerContainer.invalidate();
	            }
				int count = mViewPager.getChildCount();
				
				for (int i = 0; i < count; i++) {
					if (i==current) {
						View view = mViewPager.getChildAt(i);
						TextView textView_id2 = (TextView) view.findViewById(R.id.textView_id);
						TextView textView_show = (TextView) view.findViewById(R.id.textView_show);
						ImageView img = (ImageView) view.findViewById(R.id.imageView_show);
						textView_id2.setVisibility(View.VISIBLE);
						textView_id2.setText(listMessage.get(i));
						textView_show.setText(listMessage.get(i));
						img.setPadding(0, 0, 0, 0);
						myPagerAdapter.notifyDataSetChanged();
					}else {
						View view = mViewPager.getChildAt(i);
						TextView textView_id2 = (TextView) view.findViewById(R.id.textView_id);
						TextView textView_show = (TextView) view.findViewById(R.id.textView_show);
						ImageView img = (ImageView) view.findViewById(R.id.imageView_show);
						textView_id2.setVisibility(View.GONE);
						textView_show.setText(listMessage.get(i));
						img.setPadding(5, 5, 5,5);
						myPagerAdapter.notifyDataSetChanged();
					}
				}
			}
			
			@Override
			public void onPageScrollStateChanged(int state) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	/*class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return TOTAL_COUNT;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
        	ImageView imageView = mImageViews.get(position);
			imageView.setPadding(5, 5, 5, 5);
			container.addView(imageView);
			return imageView;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
        	 ((ViewPager)container).removeView((View)object);
        }
    }*/

	class MyPagerAdapter2 extends FragmentStatePagerAdapter {

		public MyPagerAdapter2(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int arg0) {
			Fragment fragment = new One(mImgIds[arg0],listMessage.get(arg0));
			listFragment.add(fragment);
			return fragment;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mImgIds.length;
		}
		
	}
	private void initData()
	{
		for (int imgId : mImgIds)
		{
			ImageView imageView = new ImageView(getApplicationContext());
			imageView.setScaleType(ScaleType.CENTER_CROP);
			imageView.setImageResource(imgId);
			mImageViews.add(imageView);
		}
	}

	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mViewPager.getLocationInWindow(locationOne);
		int oneX = locationOne[0];
		int oneY = locationOne[1];
		XyLog.v("TAGX", oneX+"");
		XyLog.v("TAGY", oneY+"");
		int width =  mViewPager.getWidth();
		int everyWidth = width / 3;
		 oneTouch = everyWidth;
		 TwoTouch = 2*everyWidth;
		 ThrTouch = 3*everyWidth;
	}
	
	/** 
	 * 以最省内存的方式读取本地资源的图片 
	 * @param context 
	 * @param resId 
	 * @return 
	 */  
	public static Bitmap readBitMap(Context context, int resId){  
	    BitmapFactory.Options opt = new BitmapFactory.Options();  
	    opt.inPreferredConfig = Bitmap.Config.RGB_565;   
	    opt.inPurgeable = true;  
	    opt.inInputShareable = true;  
	       //获取资源图片  
	    InputStream is = context.getResources().openRawResource(resId);  
	        return BitmapFactory.decodeStream(is,null,opt);  
	}  
	
    private Bitmap mergeBitmap(Bitmap firstBitmap, Bitmap secondBitmap) {
        Bitmap bitmap = Bitmap.createBitmap(firstBitmap.getWidth(), firstBitmap.getHeight(),
                firstBitmap.getConfig());
        Canvas canvas = new Canvas(bitmap);
        canvas.drawBitmap(firstBitmap, new Matrix(), null);
        canvas.drawBitmap(secondBitmap, 0, 0, null);
        return bitmap;
    }
}
