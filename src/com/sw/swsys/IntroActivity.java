package com.sw.swsys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class IntroActivity extends Activity {

	Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

/*	  // 배경화면 그리기 - 이미지 뷰를 읽어 기기 사이즈에 맞춘다.
		ImageView imgview = (ImageView)findViewById(R.id.main); // xml 이미지가 들어갈 이미지뷰를 가져온다.
		Bitmap bmp=BitmapFactory.decodeResource(getResources(), R.drawable.app_title); // 비트맵 이미지를 만든다.
		int width=(int)(getWindowManager().getDefaultDisplay().getWidth()); // 가로 사이즈 지정
		int height=(int)(getWindowManager().getDefaultDisplay().getHeight()); // 세로 사이즈 지정
		Bitmap resizedbitmap=Bitmap.createScaledBitmap(bmp, width, height, true); // 이미지 사이즈 조정
		imgview.setImageBitmap(resizedbitmap); // 이미지뷰에 조정한 이미지 넣기
	*/
		
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_intro);
		handler = new Handler();
		handler.postDelayed(irun, 2000);

	}

	Runnable irun = new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			Intent iIntent = new Intent(IntroActivity.this, MainActivity.class);
			startActivity(iIntent);
			overridePendingTransition(android.R.anim.fade_in,
					android.R.anim.fade_out);

		}
	};
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		handler.removeCallbacksAndMessages(irun);
	}
	@Override
	protected void onNewIntent(Intent intent)
	{
		super.onNewIntent(intent);
		
		boolean killFlag = intent.getBooleanExtra("KILL_APP", false);
		if(killFlag == true)
		{
			finish();
		}
	}

}






