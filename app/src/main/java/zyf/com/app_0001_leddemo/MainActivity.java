package zyf.com.app_0001_leddemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import zyf.com.hardlibrary.HardControl;

public class MainActivity extends Activity implements View.OnClickListener {

    private boolean ledon = false;

    private CheckBox checkBoxLed1;
    private CheckBox checkBoxLed2;
    private CheckBox checkBoxLed3;
    private CheckBox checkBoxLed4;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HardControl.ledOpen();
        initView();
    }


    private void initView() {

        checkBoxLed1 = (CheckBox) findViewById(R.id.LED1);
        checkBoxLed2 = (CheckBox) findViewById(R.id.LED2);
        checkBoxLed3 = (CheckBox) findViewById(R.id.LED3);
        checkBoxLed4 = (CheckBox) findViewById(R.id.LED4);

        button = (Button) findViewById(R.id.BUTTON);
        button.setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View v) {
        ledon = !ledon;
        if (ledon) {
            button.setText("ALL OFF");
            checkBoxLed1.setChecked(true);
            checkBoxLed2.setChecked(true);
            checkBoxLed3.setChecked(true);
            checkBoxLed4.setChecked(true);

            for (int i = 0; i < 4; i++) {
                HardControl.ledCtrl(i, 1);
            }
        }
        else {
            button.setText("ALL ON");
            checkBoxLed1.setChecked(false);
            checkBoxLed2.setChecked(false);
            checkBoxLed3.setChecked(false);
            checkBoxLed4.setChecked(false);

            for (int i = 0; i < 4; i++){
                HardControl.ledCtrl(i, 0);
            }
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.LED1:
                if (checked) {
                    Toast.makeText(getApplicationContext(), "LED1 on", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(0, 1);
                }
                else {
                    Toast.makeText(getApplicationContext(), "LED1 off", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(0, 0);
                }
                break;
            case R.id.LED2:
                if (checked) {
                    Toast.makeText(getApplicationContext(), "LED2 on", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(1, 1);
                }
                else {
                    Toast.makeText(getApplicationContext(), "LED2 off", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(1, 0);
                }
                break;

            case R.id.LED3:
                if (checked) {
                    Toast.makeText(getApplicationContext(), "LED3 on", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(2, 1);
                }
                else {
                    Toast.makeText(getApplicationContext(), "LED3 off", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(2, 0);
                }
                break;

            case R.id.LED4:
                if (checked) {
                    Toast.makeText(getApplicationContext(), "LED4 on", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(3, 1);
                }
                else {
                    Toast.makeText(getApplicationContext(), "LED4 off", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(3, 0);
                }
                break;
        }
    }
}
