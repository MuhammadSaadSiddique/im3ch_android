package com.adnan.tech.im3ch;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.adnan.tech.im3ch.Util.Anim;
import com.adnan.tech.im3ch.Util.AppPermission;
import com.adnan.tech.im3ch.Util.ConstVar;
import com.adnan.tech.im3ch.Util.DialogClass;

public class MainActivity extends AppCompatActivity {
    Button btn_signUp_Mechanic, btn_signUp_Customer;
    TextView tv_already_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Init();
            onClick();
        } catch (Exception ex) {
            new DialogClass(this, "Exception", ex.getMessage());
        }
    }

    private void Init() {
        try {
            new Anim().Entry(this);
            btn_signUp_Mechanic = findViewById(R.id.btn_signUp_Mechanic);
            btn_signUp_Customer = findViewById(R.id.btn_signUp_Customer);
            tv_already_account = findViewById(R.id.tv_already_account);
            new AppPermission(getApplicationContext(), this);
        } catch (Exception ex) {
            new DialogClass(this, "Exception", ex.getMessage());
        }
    }


    public void onClick() {
        btn_signUp_Mechanic.setOnClickListener(v -> {
            /*OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://192.168.0.149:8080/Fix/60b1f5590d2e2f3d38ecceff")
                    .method("GET", null).build();
            client.newCall(request).enqueue(
                    new Callback() {
                        @Override
                        public void onFailure(Request request, IOException e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onResponse(Response response) {

                            Log.e("test",  response.body().toString());
                            String jsonData = null;
                            try {
                                jsonData = response.body().string();
                                JSONObject Jobject = new JSONObject(jsonData);

                            } catch (IOException | JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    });
            */
            Intent intent = new Intent(this, SignUpActivity.class);
            intent.putExtra(ConstVar.Type, ConstVar.Mechanic);
            startActivity(intent);
        });
        btn_signUp_Customer.setOnClickListener(v -> {
            Intent intent = new Intent(this, SignUpActivity.class);
            intent.putExtra(ConstVar.Type, ConstVar.Customer);
            startActivity(intent);
        });
        tv_already_account.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        new Anim().Back(this);
    }
}