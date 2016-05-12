package com.example.tomigaya.uranaiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //入力された名前に対するキー名(定数)
    public  static  final  String INPUT_NAME = "InputName";
    public  static  final String INPUT_BIRTH = "inputBirth";
    //占い結果の計算値に対応するキー名(定数)
    public static  final  String RESULT_NUMBER ="ResultNumber";

    public  static  final  String ITEM_NUMBER = "itemNumer";

    public EditText nameEditText;
    public EditText yearEditText;
    public EditText monthEditText;
    public EditText dayEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity_main.xml を読み込んでいる→画面が表示
        setContentView(R.layout.activity_main);
        //Log(ログ):履歴を残す
        //System.out.printlnみたいなもの
        Log.d("Lifecycle","onCreate");

        // レイアウト(activity_main.xml)より、「占う」ボタン(IDがmain_btn_divine)を取得
        Button divineBtn=(Button)findViewById(R.id.main_btn_divine);
        Button initBtn=(Button)findViewById(R.id.main_btn_init);

        nameEditText = (EditText)findViewById(R.id.main_etx_name);
        yearEditText =(EditText)findViewById(R.id.main_etx_year);
        monthEditText = (EditText)findViewById(R.id.main_etx_month);
        dayEditText = (EditText)findViewById(R.id.main_etx_day);



        //占うボタンにリスナーを設定
        //this:このクラス(Mainactivity)
        divineBtn.setOnClickListener(this);
        initBtn.setOnClickListener(this);



    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle","onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle","onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle","onStop");
    }

    //view:押されたビュー(テキスト、ボタン等)の情報
    @Override
    public void onClick(View v) {
        //「占う」ボタンが押された時の処理を書く
        switch (v.getId()) {
            case R.id.main_btn_divine:

                //Intentクラスのオブジェクトを生成
                //this:             このクラス(MainActivity)自身
                //ResultActivity.class:遷移先のクラス
                Intent intent = new Intent(this, ResultActivity.class);

                //入力されている名前を文字列(String)として取得
                //toString();Editable→Stringへ変換
                String inputName = nameEditText.getText().toString();
                String calling = "さん";

                String nameComp = inputName + calling;

//
//                String year = yearEditText.getText().toString();
//                String month = monthEditText.getText().toString();
//                String day = dayEditText.getText().toString();
//                String Birth = year + "年" + month + "月" + day + "日" + "生まれの" + seiza + "のあなた";
//


                //遷移先に渡すデータをセット
                //1.取り出す時に指定するキー
                //2.実際のデータ
                intent.putExtra(INPUT_NAME, nameComp);
//                intent.putExtra(INPUT_BIRTH, Birth);

                //0~9までのランンダムな値を生成する
                int resultNumber = new java.util.Random().nextInt(10);
                intent.putExtra(RESULT_NUMBER, resultNumber);

                int itemNumber = new java.util.Random().nextInt(10);
                intent.putExtra(ITEM_NUMBER, itemNumber);


                //星座判定
                if (0321 to 0420){
                String Areis = "牡羊座";

            }else (0420 to 0520){
                String Taurus = "牡牛座";

            }else (0521 to 0621){
                String Gemini = "双子座";

            }else (0622 to 0723){
                String Cancer = "蟹座";

            }else (0724 to 0823){
                String Leo = "獅子座";

            }else (0824 to 0923){
                String Virgo = "乙女座";

            }else (0924 to 1023){
                String Libra = "天秤座";

            }else (1024 to 1122){
                String Scorpio = "蠍座";

            }else (1123 to 1222){
                String Sagitta = "射手座";

            }else (1223 to 0120){
                String Capri = "山羊座";

            }else (0121 to 0219){
                String Aqua = "水瓶座";

            }else (0220 to 0320){
                String Pisces = "魚座";

            }

                //画面遷移開始
                startActivity(intent);

                break;

            case R.id.main_btn_init:

                nameEditText.setText("");
                yearEditText.setText("");
                monthEditText.setText("");
                dayEditText.setText("");
    }
    }
}


