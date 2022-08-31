package uniftec.davi.com.exercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private EditText grauAEditText, grauBEditText, grauCEditText;
    private Button calcularButton, limparButton;
    private TextView resultText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        grauAEditText = findViewById(R.id.grauaEditText);
        grauBEditText = findViewById(R.id.graubEditText);
        grauCEditText = findViewById(R.id.graucEditText);
        calcularButton = findViewById(R.id.calcular_button);
        limparButton = findViewById(R.id.limpar_button);
        resultText = findViewById(R.id.result_text);

        calcularButton.setOnClickListener(this);
        limparButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){


       if(view == calcularButton){
           calcularMedia();
       }else{
           limparValores();
       }
    }

    private void calcularMedia(){
        float notaGrauA, notaGrauB, notaGrauC, media1, media2;

        try {
            notaGrauA = Float.parseFloat(grauAEditText.getText().toString());
            notaGrauB = Float.parseFloat(grauBEditText.getText().toString());
            notaGrauC = Float.parseFloat(grauCEditText.getText().toString());
            media1 = (notaGrauA + notaGrauB) / 2;

            if(media1 >= 7){
                resultText.setText("Aluno foi Aprovado com Média: " + media1);
            }else{
                media2 =( notaGrauA + notaGrauB + notaGrauC)/3;
                if(media2 >= 5){
                    resultText.setText("Aluno foi Aprovado com Média: " + media2);
                }else{
                    resultText.setText("Aluno foi Reprovado com Média: " + media2);
                }

            }


        }catch(Exception error){
            Toast.makeText(this, "Informe as Notas de Todos os Graus!", Toast.LENGTH_LONG).show();
        }




    }

    private void limparValores(){
        grauAEditText.requestFocus();
        grauAEditText.setText("");
        grauBEditText.setText("");
        grauCEditText.setText("");
        resultText.setText("Digite o valor de todas as notas!");
        Toast.makeText(this, "Valores foram Limpos!", Toast.LENGTH_LONG).show();
    }
}