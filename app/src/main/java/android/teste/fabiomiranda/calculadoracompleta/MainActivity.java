
package android.teste.fabiomiranda.calculadoracompleta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private int soma = 0;
    private int subtracao = 0;
    private int multiplicacao = 0;
    private int divisao = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickButton1(View view) {
        EditText edt = (EditText) findViewById(R.id.editext);
        String tag = view.getTag().toString();
        String expressao;

        if (tag.equals("1")) {
            expressao = edt.getText().toString();
            edt.setText(expressao.concat("7"));
        } else if (tag.equals("2")) {
            expressao = edt.getText().toString();
            edt.setText(expressao.concat("8"));
        } else if (tag.equals("3")) {
            expressao = edt.getText().toString();
            edt.setText(expressao.concat("9"));
        } else if (tag.equals("4")) {
            divisao++;
            expressao = edt.getText().toString();
            edt.setText(expressao.concat("/"));
        } else if (tag.equals("5")) {
            expressao = edt.getText().toString();
            if(expressao.length()!=0) {
                if (expressao.charAt(expressao.length() - 1) == 'x')
                    multiplicacao--;
                else if (expressao.charAt(expressao.length() - 1) == '/')
                    divisao--;
                else if (expressao.charAt(expressao.length() - 1) == '+')
                    soma--;
                else if (expressao.charAt(expressao.length() - 1) == '-')
                    subtracao--;
                expressao = expressao.substring(0, expressao.length() - 1);
                edt.setText(expressao);
            }
        } else if (tag.equals("6")) {
            expressao = edt.getText().toString();
            edt.setText(expressao.concat("4"));
        } else if (tag.equals("7")) {
            expressao = edt.getText().toString();
            edt.setText(expressao.concat("5"));
        } else if (tag.equals("8")) {
            expressao = edt.getText().toString();
            edt.setText(expressao.concat("6"));
        } else if (tag.equals("9")) {
            multiplicacao++;
            expressao = edt.getText().toString();
            edt.setText(expressao.concat("x"));
        } else if (tag.equals("10")) {
            expressao = "";
            multiplicacao = divisao = subtracao = soma = 0;
            edt.setText(expressao);
        } else if (tag.equals("11")) {
            expressao = edt.getText().toString();
            edt.setText(expressao.concat("1"));
        } else if (tag.equals("12")) {
            expressao = edt.getText().toString();
            edt.setText(expressao.concat("2"));
        } else if (tag.equals("13")) {
            expressao = edt.getText().toString();
            edt.setText(expressao.concat("3"));
        } else if (tag.equals("14")) {
            subtracao++;
            expressao = edt.getText().toString();
            edt.setText(expressao.concat("-"));
        } else if (tag.equals("15")) {
            expressao = edt.getText().toString();
            edt.setText(expressao.concat("0"));
        } else if (tag.equals("16")) {
            expressao = edt.getText().toString();
            edt.setText(expressao.concat("."));
        } else if (tag.equals("17")) {
            soma++;
            expressao = edt.getText().toString();
            edt.setText(expressao.concat("+"));
        } else if (tag.equals("18")) {
            expressao = edt.getText().toString();
            String[] array = new String[2];
            int operador, anterior, posterior;
            double conta;
            String atualizada, s1, s2;

            while (divisao != 0 || multiplicacao != 0) {
                int mult = expressao.indexOf("x");
                int div = expressao.indexOf("/");
                if (mult == -1 || (div != -1 && div < mult)) {
                    while (divisao != 0) {
                        operador = anterior = posterior = 0;
                        conta = 0;
                        operador = expressao.indexOf("/");

                        for (int i = operador - 1; i >= 0; i--) {
                            if (expressao.charAt(i) == '+' || expressao.charAt(i) == '-' || expressao.charAt(i) == '/' || expressao.charAt(i) == 'x') {
                                anterior = i;
                                break;
                            }
                        }
                        for (int j = operador + 1; j < expressao.length(); j++) {
                            if (expressao.charAt(j) == '+' || expressao.charAt(j) == '-' || expressao.charAt(j) == '/' || expressao.charAt(j) == 'x') {
                                posterior = j;
                                break;
                            }
                        }

                        if (anterior == 0 && posterior == 0) {
                            array = expressao.split("/");
                            conta =  Double.parseDouble(array[0]) / Double.parseDouble(array[1]);
                            edt.setText("");
                            if(Double.parseDouble(array[0]) % Double.parseDouble(array[1]) == 0) {
                                int aux = (int) conta;
                                edt.setText(Integer.toString(aux));
                            }
                            else
                                edt.setText(Double.toString(conta));
                            divisao--;
                        }
                        else {
                            String s = expressao.substring(anterior, posterior);
                            array = s.split("/");
                            conta = Double.parseDouble(array[0]) / Double.parseDouble(array[1]);

                            if (anterior == 0) {
                                s2 = expressao.substring(posterior, expressao.length());
                                atualizada = Double.toString(conta).concat(s2);
                            } else if (posterior == 0) {
                                s1 = expressao.substring(0, anterior + 1);
                                s2 = expressao.substring(posterior, expressao.length());
                                atualizada = s1.concat(Double.toString(conta)).concat(s2);

                            } else {
                                s1 = expressao.substring(0, anterior + 1);
                                atualizada = s1.concat(Double.toString(conta));
                            }
                            expressao = atualizada;
                            divisao--;
                        }
                    }
                } else {
                    while (multiplicacao != 0) {
                        operador = anterior = posterior = 0;
                        conta = 0;
                        operador = expressao.indexOf("x");

                        for (int i = operador - 1; i >= 0; i--) {
                            if (expressao.charAt(i) == '+' || expressao.charAt(i) == '-' || expressao.charAt(i) == '/' || expressao.charAt(i) == 'x') {
                                anterior = i;
                                break;
                            }
                        }
                        for (int j = operador + 1; j < expressao.length(); j++) {
                            if (expressao.charAt(j) == '+' || expressao.charAt(j) == '-' || expressao.charAt(j) == '/' || expressao.charAt(j) == 'x') {
                                posterior = j;
                                break;
                            }
                        }

                        if (anterior == 0 && posterior == 0) {
                            array = expressao.split("x");
                            conta = Double.parseDouble(array[0]) * Double.parseDouble(array[1]);

                            edt.setText("");
                            String c;
                            c = Double.toString(conta);
                            int a = c.indexOf(".");
                            String decimal = c.substring(a+1,c.length());
                            if(Integer.parseInt(decimal) == 0){
                                int aux = (int) conta;
                                edt.setText(Integer.toString(aux));
                            }
                            else
                                edt.setText(Double.toString(conta));
                           multiplicacao--;
                        }
                        else {
                            String s = expressao.substring(anterior, posterior);
                            array = s.split("x");
                            conta = Double.parseDouble(array[0]) * Double.parseDouble(array[1]);

                            if (anterior == 0) {
                                s2 = expressao.substring(posterior, expressao.length());
                                atualizada = Double.toString(conta).concat(s2);
                            } else if (posterior == 0) {
                                s1 = expressao.substring(0, anterior + 1);
                                s2 = expressao.substring(posterior, expressao.length());
                                atualizada = s1.concat(Double.toString(conta)).concat(s2);
                            } else {
                                s1 = expressao.substring(0, anterior + 1);
                                atualizada = s1.concat(Double.toString(conta));
                            }
                            expressao = atualizada;
                            multiplicacao--;
                        }
                    }
                }
            }
            while (soma != 0 || subtracao != 0) {
                    while (soma != 0) {
                        operador = anterior = posterior = 0;
                        conta = 0;
                        operador = expressao.indexOf("+");

                        for (int i = operador - 1; i >= 0; i--) {
                            if (expressao.charAt(i) == '+' || expressao.charAt(i) == '-' || expressao.charAt(i) == '/' || expressao.charAt(i) == 'x') {
                                anterior = i;
                                break;
                            }
                        }
                        for (int j = operador + 1; j < expressao.length(); j++) {
                            if (expressao.charAt(j) == '+' || expressao.charAt(j) == '-' || expressao.charAt(j) == '/' || expressao.charAt(j) == 'x') {
                                posterior = j;
                                break;
                            }
                        }

                        if (anterior == 0 && posterior == 0) {
                            array = expressao.split("[+]");
                            conta = Double.parseDouble(array[0]) + Double.parseDouble(array[1]);

                            edt.setText("");
                            String c;
                            c = Double.toString(conta);
                            int a = c.indexOf(".");
                            String decimal = c.substring(a+1,c.length());
                            if(Integer.parseInt(decimal) == 0){
                                int aux = (int) conta;
                                edt.setText(Integer.toString(aux));
                            }
                            else
                                edt.setText(Double.toString(conta));
                            soma--;
                        }
                        else {
                            String s = expressao.substring(anterior, posterior);
                            array = s.split("[+]");
                            conta = Double.parseDouble(array[0]) + Double.parseDouble(array[1]);

                            if (anterior == 0) {
                                s2 = expressao.substring(posterior, expressao.length());
                                atualizada = Double.toString(conta).concat(s2);
                            } else if (posterior == 0) {
                                s1 = expressao.substring(0, anterior + 1);
                                s2 = expressao.substring(posterior, expressao.length());
                                atualizada = s1.concat(Double.toString(conta)).concat(s2);

                            } else {
                                s1 = expressao.substring(0, anterior + 1);
                                atualizada = s1.concat(Double.toString(conta));
                            }
                            expressao = atualizada;
                            soma--;
                        }
                    }
                    while (subtracao != 0) {
                        operador = anterior = posterior = 0;
                        conta = 0;
                        operador = expressao.indexOf("-");

                        for (int i = operador - 1; i >= 0; i--) {
                            if (expressao.charAt(i) == '+' || expressao.charAt(i) == '-' || expressao.charAt(i) == '/' || expressao.charAt(i) == 'x') {
                                anterior = i;
                                break;
                            }
                        }
                        for (int j = operador + 1; j < expressao.length(); j++) {
                            if (expressao.charAt(j) == '+' || expressao.charAt(j) == '-' || expressao.charAt(j) == '/' || expressao.charAt(j) == 'x') {
                                posterior = j;
                                break;
                            }
                        }

                        if (anterior == 0 && posterior == 0) {
                            array = expressao.split("-");
                            conta = Double.parseDouble(array[0]) - Double.parseDouble(array[1]);

                            edt.setText("");
                            String c;
                            c = Double.toString(conta);
                            int a = c.indexOf(".");
                            String decimal = c.substring(a+1,c.length());
                            if(Integer.parseInt(decimal) == 0){
                                int aux = (int) conta;
                                edt.setText(Integer.toString(aux));
                            }
                            else
                                edt.setText(Double.toString(conta));
                            subtracao--;
                        }
                        else {
                            String s = expressao.substring(anterior, posterior);
                            array = s.split("-");
                            conta = Double.parseDouble(array[0]) - Double.parseDouble(array[1]);

                            if (anterior == 0) {
                                s2 = expressao.substring(posterior, expressao.length());
                                atualizada = Double.toString(conta).concat(s2);
                            } else if (posterior == 0) {
                                s1 = expressao.substring(0, anterior + 1);
                                s2 = expressao.substring(posterior, expressao.length());
                                atualizada = s1.concat(Double.toString(conta)).concat(s2);
                            } else {
                                s1 = expressao.substring(0, anterior + 1);
                                atualizada = s1.concat(Double.toString(conta));
                            }
                            expressao = atualizada;
                            subtracao--;
                        }
                    }
            }
        }
    }
}
