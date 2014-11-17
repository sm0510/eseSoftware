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

/*	  // ���ȭ�� �׸��� - �̹��� �並 �о� ��� ����� �����.
		ImageView imgview = (ImageView)findViewById(R.id.main); // xml �̹����� �� �̹����並 �����´�.
		Bitmap bmp=BitmapFactory.decodeResource(getResources(), R.drawable.app_title); // ��Ʈ�� �̹����� �����.
		int width=(int)(getWindowManager().getDefaultDisplay().getWidth()); // ���� ������ ����
		int height=(int)(getWindowManager().getDefaultDisplay().getHeight()); // ���� ������ ����
		Bitmap resizedbitmap=Bitmap.createScaledBitmap(bmp, width, height, true); // �̹��� ������ ����
		imgview.setImageBitmap(resizedbitmap); // �̹����信 ������ �̹��� �ֱ�
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






