package com.example.christmasapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.christmasapp.data.DataStorage;
import com.example.christmasapp.models.Child;

public class ViewChildInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_child_info);

        EditText etChildUsername = findViewById(R.id.et_child_username);
        Button btnViewInfo = findViewById(R.id.btn_view_info);
        TextView tvChildInfo = findViewById(R.id.tv_child_info);

        btnViewInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etChildUsername.getText().toString();
                Child child = DataStorage.findChildByUsername(username);

                if (child != null) {
                    String info = "Nom : " + child.getFirstName() + " " + child.getLastName() + "\n"
                            + "Âge : " + child.getAge() + "\n"
                            + "Pays/Ville : " + child.getCountry() + "/" + child.getCity();
                    tvChildInfo.setText(info);
                } else {
                    Toast.makeText(ViewChildInfoActivity.this, "Enfant non trouvé", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
