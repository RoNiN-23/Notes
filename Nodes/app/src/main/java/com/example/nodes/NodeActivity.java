package com.example.nodes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 @brief Класс, отвечающий за окно интерфейса для создании заметки

 */

public class NodeActivity extends AppCompatActivity {

    private MyDbManager myDbManager;
    private EditText edTitle, edDescription;
    private TextView testView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_node);
        myDbManager = new MyDbManager(this);
        edTitle = findViewById(R.id.edTitle);
        edDescription = findViewById(R.id.edDescription);
        testView = findViewById(R.id.testView);
    }
    /**
	@details Метод включения баззы данных
	Т.к. база данных является довольно энергозатратной, то её работа нужна лишь тогда, когда мы с ней взаимодействуем, поэтому был написан метод её включения и аналогичный метод выключения

*/
    @Override
    protected void onResume() {
        super.onResume();
        myDbManager.openDb();
    }

    /**
	@brief Метод для назначении кнопки функции возврата на главную страницу
*/
    public void goBack(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
	@brief Метод, с помощью которого сохранение заметки

	Заметка сначала сохраняется в баху данных, а затем появляется на главной странице в ввиде её заголовка
*/
    public void saveNode(View view){
        myDbManager.insertToDb(edTitle.getText().toString(),edDescription.getText().toString());
        for(String title : myDbManager.getFromDb()){
            testView.append(title);
            testView.append("\n");
        }
    }
}