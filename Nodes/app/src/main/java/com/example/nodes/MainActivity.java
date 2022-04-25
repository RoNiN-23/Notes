package com.example.nodes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 @brief Класс, отвечающий за окно главного интерфейса

 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
	*\brief Метод активации кнопки добаления новой заметки
	*После нажатия на кнопку, срабатывает данный метод и пользователь переносится на новое окно, где имеет возможность написать новую заметку
    */
    public void addNode(View view){                                             //Переход на страницу добавление новой заметки
        Intent intent = new Intent(this, NodeActivity.class);
        startActivity(intent);
    }
}