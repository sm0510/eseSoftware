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

import com.sw.swsys.graph.LineGraphActivity;

public class MainActivity extends Activity implements OnClickListener {
	final Activity activity = this;
	boolean btBackState = false; // �ڷΰ��� ��ư�� ���°��� ���� ����
	Timer timer = new Timer(); // Ÿ�̸� ����
	private Toast toast;
	private ImageButton estimate = null;
	private ImageButton graph = null;
	private ImageButton upup = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		estimate = (ImageButton) this.findViewById(R.id.estimate1);
		graph = (ImageButton) this.findViewById(R.id.graph2);
		upup = (ImageButton) this.findViewById(R.id.upup3);
		estimate.setOnClickListener(this);
		graph.setOnClickListener(this);
		upup.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		int sel = v.getId();
		switch (sel) {
		case R.id.estimate1:
			Intent l = new Intent(MainActivity.this, BluetoothChat.class);
			startActivity(l);
			overridePendingTransition(android.R.anim.fade_in,
					android.R.anim.fade_out);
			break;
		case R.id.upup3:
			Intent k = new Intent(MainActivity.this, DatabaseActivity.class);
			startActivity(k);
			overridePendingTransition(android.R.anim.fade_in,
					android.R.anim.fade_out);
			break;
		case R.id.graph2:
			Intent j = new Intent(MainActivity.this, LineGraphActivity.class);
			startActivity(j);
			overridePendingTransition(android.R.anim.fade_in,
					android.R.anim.fade_out);
			break;

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
