package com.example.owl;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	SoundPool mpool;
	int mDook;
	AudioManager mAm;
	Vibrator mv;
	ImageView howl;
	View yellow;
	View red;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Button bt1=(Button)findViewById(R.id.button1);//아니오
		final Button bt2=(Button)findViewById(R.id.button2);//네
		yellow=(View)findViewById(R.layout.yellow);
		red=(View)findViewById(R.layout.red);
		
		mpool= new SoundPool(1,AudioManager.STREAM_MUSIC,0);
		mDook=mpool.load(this, R.raw.owlsound, 1);
		mAm=(AudioManager)getSystemService(AUDIO_SERVICE);
		mv=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
		
		final ImageView wowl=(ImageView)findViewById(R.id.imageView1);
		final ImageView owl=(ImageView)findViewById(R.id.imageView2);
		
		final TextView ys=(TextView)findViewById(R.id.clky);
		final TextView no=(TextView)findViewById(R.id.clkn);
		final TextView di=(TextView)findViewById(R.id.checkedTextView1);
		
		howl=(ImageView)findViewById(R.id.imageView3);
		howl.setVisibility(View.INVISIBLE);
		ys.setVisibility(View.INVISIBLE);
		no.setVisibility(View.INVISIBLE);
		owl.setVisibility(View.INVISIBLE);
		bt1.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View v) {//click button no
			// TODO Auto-generated method stub
			wowl.setVisibility(View.INVISIBLE);
			owl.setVisibility(View.VISIBLE);
			no.setVisibility(View.VISIBLE);
			bt1.setVisibility(View.INVISIBLE);
			bt2.setVisibility(View.INVISIBLE);
			di.setVisibility(View.INVISIBLE);
		
				mpool.play(mDook, 1, 1, 0, -1, 1);
				mv.vibrate(new long[] {0,100, 0,1000},0);
				
		}
		
		});
		
		bt2.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mpool.play(mDook, 1, 1, 0, 1, 1);
			wowl.setVisibility(View.INVISIBLE);
			howl.setVisibility(View.VISIBLE);
			ys.setVisibility(View.VISIBLE);
			bt1.setVisibility(View.INVISIBLE);
			bt2.setVisibility(View.INVISIBLE);
			di.setVisibility(View.INVISIBLE);

			mv.vibrate(1000);
		}
		
	});
	
	}
}
