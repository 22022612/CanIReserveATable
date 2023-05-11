package sg.edu.rp.c346.id22022612.canireserveatable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    EditText name;
    EditText number;
    EditText pax;
    RadioGroup smoke;
    TextView displayText;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.dp);
        tp = findViewById(R.id.tp);
        name = findViewById(R.id.name);
        number = findViewById(R.id.number);
        pax = findViewById(R.id.pax);
        smoke = findViewById(R.id.smoke);
        displayText = findViewById(R.id.display);
        reset = findViewById(R.id.reset);

        int day = dp.getDayOfMonth();
        int month = dp.getMonth()+1;
        int year = dp.getYear();
        String date = String.format("%d / %d / %d",day,month,year);
        String nameStr = name.getText().toString();
        String numberStr = number.getText().toString();
        String grp = pax.getText().toString();
        int hour = tp.getHour();
        int minute = tp.getMinute();
        String time = "";
        if (hour<10){
            if (minute<10){
                time = String.format("0%d:0%d",hour,minute);
            } else {
                time = String.format("0%d:%d",hour,minute);
            }
        } else {
            time = String.format("%d:%d",hour,minute);
        }
        int checkedRadioId = smoke.getCheckedRadioButtonId();
        String smokearea = "";
        if (checkedRadioId == R.id.radioSmoking){
            smokearea = "Non-Smoking Area";
        } else {
            smokearea = "Smoking Area";
        }
        String message = "Reservation confirmed!";
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
        String displayStr = String.format("Name: %s \nMobile Number: %s \nGroup Size: %s \nDate: %s \nTime: %s \nArea: %s",
                nameStr, numberStr, grp, date, time, smokearea);
        Toast.makeText(MainActivity.this,displayStr,Toast.LENGTH_LONG).show();

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                number.setText("");
                pax.setText("");
                dp.updateDate(2020,5,1);
                tp.setHour(19);
                tp.setMinute(30);
                smoke.check(R.id.radioNonSmoking);
                displayText.setText("Display");
            }
        });

    }
}
