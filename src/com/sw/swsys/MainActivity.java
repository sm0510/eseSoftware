package com.sw.swsys;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {	
	final Activity activity = this;
	boolean btBackState = false; // �ڷΰ��� ��ư�� ���°��� ���� ����
	Timer timer = new Timer(); // Ÿ�̸� ����
	private Toast toast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public void onClick(View v) {

		int sel = v.getId();
		switch (sel) {
		}
	}

	@Override
	public void onBackPressed() {
		// super.onBackPressed();
		if (btBackState == false) {
			timer.schedule(new TimerTask() {
				public void run() {
					btBackState = false;
				}
			}, 2000);
			btBackState = true;
			showGuide();
		} else {
			finish();
			Intent intent = new Intent(MainActivity.this, IntroActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
					| Intent.FLAG_ACTIVITY_SINGLE_TOP);
			intent.putExtra("KILL_APP", true);
			startActivity(intent);
			toast.cancel();
		}
	}

	private void showGuide() {
		toast = Toast.makeText(getApplicationContext(),
				"\'�ڷ�\'��ư�� �ѹ� �� �����ø� ����˴ϴ�.", Toast.LENGTH_SHORT);
		toast.show();
	}

}
