package com.example.trabalhoWhats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout inputLayoutNumero;
    private TextInputLayout inputLayoutMensagem;

    private TextInputEditText inputEditTextNumero;
    private TextInputEditText inputEditTextMensagem;

    private Button buttonMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputLayoutNumero = findViewById(R.id.input_layout_numero);
        inputLayoutMensagem = findViewById(R.id.input_layout_mensagem);


        inputEditTextNumero = findViewById(R.id.input_text_numero);
        inputEditTextMensagem = findViewById(R.id.input_text_mensagem);

        buttonMensagem = findViewById(R.id.button_mensagem);

        buttonMensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numeroTelefone = inputEditTextNumero.getText().toString();
                String mensagem = inputEditTextMensagem.getText().toString();

             String url = formatoUrl(numeroTelefone, mensagem);

                enviarMensagem(url);

            }

            public String formatoUrl(String numeroTelefone, String mensagem){
                mensagem = mensagem.replace(" " ,"%20");

               String link = "https://wa.me/" + numeroTelefone +"?text="+ mensagem;
                return link;
            }

            public void enviarMensagem(String url) {
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                    startActivity(intent);
            }

        });
    }
}