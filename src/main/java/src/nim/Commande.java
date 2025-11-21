package src.nim;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.concurrent.Callable;

public class Commande {
    public void afficherAllumettes(int nbA,Label label){
        char [] tabA =  new char[nbA];
        for (int i = 0; i < nbA; i++) {
            tabA[i] = '|';
        }
        String allumettes =  new String(tabA);
        label.setText("Nombres d'allumettes "+nbA+"\n"+allumettes);
        label.setStyle("-fx-background-color: #FF0000;");
        label.setStyle("-fx-font-size: 20");

    }


}
