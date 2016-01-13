package com.qiao.viewpager;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


@SuppressLint("ValidFragment") public class One extends Fragment{

	private ImageView imageView_show;
	private TextView textView_show;
	private TextView textView_id;
	private int id;
	private String str;
	public One(int id,String str){
		this.id=id;
		this.str=str;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.itemshow, null);
		imageView_show = (ImageView) view.findViewById(R.id.imageView_show);
		textView_show = (TextView) view.findViewById(R.id.textView_show);
		textView_id = (TextView) view.findViewById(R.id.textView_id);
//		imageView_show.setImageBitmap(MainActivity.mActivity.readBitMap(getActivity(), id));
		textView_id.setVisibility(View.VISIBLE);
//		imageView_show.setImageResource(R.drawable.bk_empty);
//		imageView_show.setImageResource(id);
		/*Glide.with(getActivity())
		.load(id)
		.diskCacheStrategy(DiskCacheStrategy.SOURCE)
		.fitCenter()
		.placeholder(R.drawable.bk_empty)
		.crossFade()
		.into(imageView_show);
		textView_show.setText(str);*/
		return view;
	}
}
