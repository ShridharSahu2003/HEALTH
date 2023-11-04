package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 = {
            {"Doctor Name: Ajit Saste", "Hospital Address: Pimpri", "Exp: 5 yrs", "Mobile No:9898989898", "600"},
            {"Doctor Name: Prasad Pawan", "Hospital Address: Nigdi", "Exp: 15yrs", "Mobile No:7898989898", "98"},
            {"Doctor Name: Swapnil Kale", "Hospital Address: Pune", "Exp: 10 yrs", "Mobile No:8898989898", "388"},
            {"Doctor Name: Deepak Deshmukh", "Hospital Address: Chinchwad", "Exp: 10 yes", "Mobile No:9898888080", "500"},
            {"Doctor Name: Ashok Panda", "Hospital Address: Katrai", "Exp: 7yrs", "Mobile No:7798989898", "800"}
    };
    private String[][] doctor_details2 = {
            {"Doctor Name: Ajit Saste", "Hospital Address: Pimpri", "Exp: 2yrs", "Mobile No:9898989898", "600"},
            {"Doctor Name: Prasad Pawan", "Hospital Address: Nigdi", "Exp: 15yrs", "Mobile No:7898989898", "98"},
            {"Doctor Name: Swapnil Kale", "Hospital Address: Pune", "Exp: 9yrs", "Mobile No:8898989898", "388"},
            {"Doctor Name: Deepak Deshmukh", "Hospital Address: Chinchwad", "Exp: 9yes"," Mobile No:9898888080", "500"},
            {"Doctor Name: Ashok Panda", "Hospital Address: Katrai", "Exp: 7yrs", "Hobile No:7798989898", "800"}
    };
    private String[][] doctor_details3 = {
            {"Doctor Name: Ajit Saste", "Hospital Address: Pimpri", "Exp: 5yrs", "Mobile No:9898989898", "600"},
            {"Doctor Name: Prasad Pawan", "Hospital Address: Nigdi", "Exp: 15yrs", "Mobile No:7898989898", "98"},
            {"Doctor Name: Swapnil Kale", "Hospital Address: Pune", "Exp: 6yrs", "Mobile No:8898989898", "388"},
            {"Doctor Name: Deepak Deshmukh", "Hospital Address: Chinchwad", "Exp: 34yrs", "Mobile No:9898888080", "500"},
            {"Doctor Name: Ashok Panda", "Hospital Address: Katrai", "Exp: 7yrs", "Hobile No:7798989898", "800"}
    };
    private String[][] doctor_details4 = {
            {"Doctor Name: Ajit Saste", "Hospital Address: Pimpri", "Exp: Syrs", "Mobile No:9898989898", "600"},
            {"Doctor Name: Prasad Pawan", "Hospital Address: Nigdi", "Exp: 15yrs", "Mobile No:7898989898", "98"},
            {"Doctor Name: Swapnil Kale", "Hospital Address: Pune", "Exp: Byrs", "Mobile No:8898989898", "388"},
            {"Doctor Name: Deepak Deshmukh", "Hospital Address: Chinchwad", "Exp: oyes", "Mobile No:9898888080", "500"},
            {"Doctor Name: Ashok Panda", "Hospital Address: Katrai", "Exp: 7yrs", "Hobile No:7798989898", "800"}
    };
    private String[][] doctor_details5 = {
            {"Doctor Name: Ajit Saste", "Hospital Address: Pimpri", "Exp: 6yrs", "Mobile No:9898989898", "600"},
            {"Doctor Name: Prasad Pawan", "Hospital Address: Nigdi", "Exp: 15yrs", "Mobile No:7898989898", "98"},
            {"Doctor Name: Swapnil Kale", "Hospital Address: Pune", "Exp: 12yrs", "Mobile No:8898989898", "388"},
            {"Doctor Name: Deepak Deshmukh", "Hospital Address: Chinchwad", "Exp: 32yes"," Mobile No:9898888080", "500"},
            {"Doctor Name: Ashok Panda", "Hospital Address: Katrai", "Exp: 7yrs", "Hobile No:7798989898", "800"}
    };
    TextView tv;
    Button btn;
    HashMap<String, String> item;
    String[][] doctor_details = {};
    ArrayList list;
    SimpleAdapter sa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textviewHATitle);
        btn = findViewById(R.id.buttonHABack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);
        if (title.compareTo("Family_Physicians") == 0) {
            doctor_details = doctor_details1;
        } else if (title.compareTo("Dietician") == 0) {
            doctor_details = doctor_details2;
        } else if (title.compareTo("Dentist") == 0) {
            doctor_details = doctor_details3;
        } else if (title.compareTo("Surgeon") == 0) {
            doctor_details = doctor_details4;
        } else if (title.compareTo("Cardiologists") == 0) {
            doctor_details = doctor_details5;
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));

            }
        });
        list = new ArrayList();
        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "consult Fees" + doctor_details[i][4] + "/-");
            list.add(item);

        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        ListView lst=findViewById(R.id.listViewHA);

        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}