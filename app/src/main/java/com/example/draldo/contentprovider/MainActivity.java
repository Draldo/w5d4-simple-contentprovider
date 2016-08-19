package com.example.draldo.contentprovider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.UserDictionary;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private static final String[] COLUMNS = new String[] {
            UserDictionary.Words.WORD,
            UserDictionary.Words.FREQUENCY
    };

    private static final int[] LAYOUT = new int[] {
            android.R.id.text1,
            android.R.id.text2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView dictionary = (ListView) findViewById(R.id.dictionary_listview);

        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(UserDictionary.Words.CONTENT_URI, null, null, null, null);

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                android.R.layout.two_line_list_item,
                cursor,
                COLUMNS,
                LAYOUT,
                0
        );

        dictionary.setAdapter(adapter);
    }
}
