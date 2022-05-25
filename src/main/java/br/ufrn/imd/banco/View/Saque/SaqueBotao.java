package br.ufrn.imd.banco.View.Saque;

import java.math.BigDecimal;

import br.ufrn.imd.banco.View.EscolherConta;
import br.ufrn.imd.banco.View.OuvinteBotao;
import br.ufrn.imd.banco.conta.ContaController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class SaqueBotao {
    private static final Button singleton = setBotao();
    public static Button getInstance(){return singleton;}
    private static Button setBotao(){
        Button botao = new Button("Efetuar saque");
        OuvinteBotao.setHandlers(botao);
        botao.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                ContaController.getInstance();
                SaqueText.setTexto(
                    ContaController.saque(
                        EscolherConta.getInstance().getValue(),
                        new BigDecimal(SaqueValor.getInstance().getText())
                    )
                );
            }
        });
        return botao;
    }
}
