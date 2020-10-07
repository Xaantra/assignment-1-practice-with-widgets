package fr.isep.ii3510.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button changeTextButton;
    private Button changeColorButton;
    private Button downFontButton;
    private Button upFontButton;
    private TextView textView;
    private EditText changeText;
    private Spinner colorFontList;
    DisplayMetrics metrics;

    public Editable text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        changeTextButton = findViewById(R.id.change_text_button);
        changeColorButton = findViewById(R.id.change_color_button);
        downFontButton = findViewById(R.id.down_font_button);
        upFontButton = findViewById(R.id.up_font_button);
        textView = findViewById(R.id.text_view);
        changeText = findViewById(R.id.change_text_edit);
        colorFontList = findViewById(R.id.color_list);


// List for font color
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.font_colors_array, android.R.layout.simple_spinner_item); //https://developer.android.com/guide/topics/ui/controls/spinner#java
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorFontList.setAdapter(adapter);

// Pixel density of the device
        metrics = getApplicationContext().getResources().getDisplayMetrics(); // https://stackoverflow.com/questions/29528381/subtract-2-to-the-text-size-of-a-textview-in-java
                                                                              // I didn't know about pixel density and I did textView.setTextSize(textView.getTextSize() - 2); which doesn't work, it keeps getting bigger...

    }


    public void onClick(View view) {
        text = changeText.getText();
        textView.setText(text);

    }

    public void onClickColor(View view) {
        String color = colorFontList.getSelectedItem().toString();
        textView.setTextColor(Color.parseColor(color));
        changeText.setText("");

    }

    public void onClickUpFont(View view) {
        float fTextSize = textView.getTextSize()/metrics.density;
        if (textView.getTextSize() < 100){
            textView.setTextSize(fTextSize+2);
        }


    }

    public void onClickDownFont(View view) {
        float fTextSize = textView.getTextSize()/metrics.density;
        if (textView.getTextSize() > 2){
            textView.setTextSize(fTextSize-2);
        }

    }


}