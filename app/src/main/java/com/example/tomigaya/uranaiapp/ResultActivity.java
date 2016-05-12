package com.example.tomigaya.uranaiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //レイアウト(activity_result.xml)より、名前のテキストビューを取得
        TextView txvName = (TextView)findViewById(R.id.result_txv_name);
        TextView txvDivine = (TextView)findViewById(R.id.result_txv_divine);
        TextView txvDivine2 =(TextView)findViewById(R.id.result_txv_divine2);
        TextView txvBirth = (TextView)findViewById(R.id.result_txv_birth);

        //遷移元(MainActivity)から送られてきたインテントを取得
        Intent intent = getIntent();

        //遷移元でセットした氏名を取得し、TextViewに設定する
        String name = intent.getStringExtra(MainActivity.INPUT_NAME);
        txvName.setText(name);

        String birth = intent.getStringExtra(MainActivity.INPUT_BIRTH);
        txvBirth.setText(birth);

        //遷移先でセットした結果番号を取得する
        //defaultValue:キーに対応するデータが見つからなかった時、返す値
        int resultNumber = intent.getIntExtra(MainActivity.RESULT_NUMBER,0);

        int itemNumber = intent.getIntExtra(MainActivity.ITEM_NUMBER,0);

        //Resource(string.xml)より、string型の配列データを取得
        String[] divineData = getResources().getStringArray(R.array.result_txv_divine_data);
        txvDivine.setText(divineData[resultNumber]);

        String[] divineData2 = getResources().getStringArray(R.array.result_txv_divine_data2);
        txvDivine2.setText(divineData2[itemNumber]);

        Button back = (Button)findViewById(R.id.result_btn_back);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,MainActivity.class);

        startActivity(intent);
    }
}

