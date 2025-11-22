package src.nim;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.lang.Thread;

import java.io.FileInputStream;
import java.util.Random;

public class NimApp extends Application {
    Random rand = new Random();
  private  Commande commande =  new Commande();
    private int nombreAllumettes = 0;
    private char [] allumetttes;
    String nomJoueur1;
    String nomJoueur2;
    @Override
    public void start(Stage primarystage) throws Exception {

        // SCENE 0 =====================================================================================================
        // titre0
        FileInputStream file = new FileInputStream("nim.jpg"); //entrez une image
        Image image = new Image(file); //mettre le fichier iamge dans un objet image
        ImageView imageView = new ImageView(image); // puis l'objet image dands ImageView
        Label titre0 = new Label("Bienvenue dans le jeux de Nim"); // titre
        //parametrer la taille du titre0
        titre0.setStyle("-fx-font-size: 20"); // taille de la police
        // Radio button1 pour le choix , jouer avec l'ia ou jouer avec un duexieme joueur
        RadioButton button1 = new RadioButton("Jouer avec l'IA ?"); // radiobutton
        // deucieme radio button
        RadioButton button2 = new RadioButton("Jouer avec un deuxieme joueur ?");  // radiobutton 2
        //bouton pour jouer
        Button button0 = new Button("Jouer"); // bouton pour cliquer


        VBox vbox0 = new VBox(5);
        vbox0.setAlignment(Pos.CENTER);
        vbox0.getChildren().addAll(titre0,button1,button2, button0,imageView);

        Scene scene0 = new Scene(vbox0,600,500);

        // Scene 1 ================================================================
        Label titre1 = new Label("INSCRIVEZ VOUS !"); // titre 1 de la scence 1
        titre1.setStyle("-fx-font-size: 20");
        //feedback
        Label feedback = new Label();
        //nom du joueur 1
        Label nomJ = new Label("Nom joueur 1 :");
        // field pour le joueur 1
        TextField nomJInput = new TextField();
        // max taille largeur
        nomJInput.setMaxWidth(150);


        //nom du joueur 2
        Label nomJ2 = new Label("Nom joueur 2 :");
        // field pour le joueur 2
        TextField nomJInput2 = new TextField();
        // max taille largeur
        nomJInput2.setMaxWidth(150);
        // label
        Label label = new Label("\nEntrez un nombre d'allumettes (minimum 10) : ");
        // field pour le nombre d'allumettes
        TextField nombre = new TextField();
        // max taille largeur du field nombre
        nombre.setMaxWidth(100);
    // bouton ok
        Button ok = new Button("Ok");
        // vbox
        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(titre1,nomJ,nomJInput,nomJ2,nomJInput2, label, nombre,ok,feedback);
        vbox.setAlignment(Pos.CENTER);
        // scene 1
        Scene scene = new Scene(vbox,600,500);


        //SCENE 2

        //feedback pour le nombre d'allumettes
        Label allumettes = new Label(); // nombre allumettes pour le jeu avec 2 joueurs
        Label feedback2 = new Label(); // feedback
        Label joueur = new Label(); // text
        TextField joueur1Input = new TextField();
        joueur1Input.setMaxWidth(100); // parametre la lartgeur maximum

        Label joueur2 = new Label("Tu veux enlever combien d'allumettes joueurs 2"+nomJoueur2+" ? (entre 1 et 3) : ");
        TextField joueur2Input = new TextField();
        joueur2Input.setMaxWidth(100); // parametre la lartgeur maximum

        Button  joueurButton = new Button("Ok"); //bouton pour le joueur 1
        Button  joueur2Button = new Button("Ok"); // bouton pour le joueur 2

        Label feedback3 = new Label(); // feedback
        VBox vbox2 = new VBox(5); //vbox
        vbox2.getChildren().addAll(allumettes,joueur,joueur1Input,joueurButton,joueur2,joueur2Input, joueur2Button,feedback2,feedback3); //add les nodes dans la vbox
        vbox2.setAlignment(Pos.CENTER); // centrer les elements de la vbox
        Scene scene2 = new Scene(vbox2,600,500); // instancier la scene 2 puis mettre en parametre la vbox2

        //SCENE AVEC IA ==========================================================

        //feedback pour le nombre d'allumettes
        Label feedback22 = new Label(); // feed back
        Label allumettesVIA = new Label("Tu veux combien d'allumettes"); // label nombre allumettes pour le jeu version ia
        TextField allumettes1VIA = new TextField(); //  field back
        allumettes1VIA.setMaxWidth(100); // parametre la largeur max
        Label joueur11 = new Label("Nom du joueur 1 :  "); // label
        joueur1Input.setMaxWidth(100); //parametrage de la largeur max du field
        TextField nomJoueur1VIA = new TextField(); // field pour que le joueur entre son nom
        nomJoueur1VIA.setMaxWidth(100); //parametrage de la largeur max du field


        Button  boutonOkVIA = new Button("Ok"); // bouton ok pour la version avec IA

        Label feedback33 = new Label();//fedback
        VBox vbox22 = new VBox(5); // vbox
        vbox22.getChildren().addAll(feedback22,joueur11,nomJoueur1VIA,allumettesVIA,allumettes1VIA,boutonOkVIA,feedback33); // add les nodes dans la vbox
        vbox22.setAlignment(Pos.CENTER); // parametre pour centrer les elements de la vbox
        Scene scene22 = new Scene(vbox22,600,500); // scene pour la version avec ia

        //SCENE 2 VERSION AVEC IA

        Label noombreallumettesVIA = new Label(""); // label pour afficher le nombre d'allumettes
        Label feedbackVIA = new Label(); // feedback
        Label joueurVIA = new Label("Tu veux enlever combien d'allumettes : ?\n(minimum 10)"); // text
        TextField joueurVIAInput = new TextField(); // field pour que le jooueur entree le nombre d'allumetes qu'il veut
        joueurVIAInput.setMaxWidth(100); //  parametre la largeur maximum
        joueurVIAInput.setMaxWidth(100); // parametre la largeur maximum
        Label ia = new Label(); // label pour direquand l'ia enleve une allumettes

        Button joueurButtonVIA = new Button("Jouer"); // bouton pour jouer

        VBox vbox22VIA = new VBox(5);
        vbox22VIA.setAlignment(Pos.CENTER);
        vbox22VIA.getChildren().addAll(noombreallumettesVIA,joueurVIA,joueurVIAInput,ia,joueurButtonVIA,feedbackVIA);
        Scene scene22VIA = new Scene(vbox22VIA,600,500);
   //=================================================================================================================
        // SCENE FIN DE JEUX | RECOMMENCER
        Label titre3 = new Label("FIN DU JEUX !!"); // label
        Label gagnant = new Label(); // label pour dire qui est le gagnant
        Label sousT = new Label();
        gagnant.setStyle("-fx-font-size: 20"); // set la taille de la font du label gagnant
        Button recommencer = new Button("Recommencer"); // bouton si le joueur veut recommencer
        Button quitter = new Button("Quitter"); // bouton si le joueur veut quitter

        VBox vbox3 = new VBox(5); // vbox
        vbox3.setAlignment(Pos.CENTER); // centre les nodes de la vbox
        vbox3.getChildren().addAll(titre3,gagnant,sousT,recommencer,quitter); // puis les ajoutes

        Scene scene3 = new Scene(vbox3,600,500); // creation de la scene en mettant en paramtre la vbox et set la dimension

        quitter.setOnAction(e -> {primarystage.close();}); // action du bouton quitter
        button0.setOnAction(e -> {
             if(button1.isSelected()){
                 primarystage.setScene(scene22);
             }else{primarystage.setScene(scene);}


        }); // action du bouton0
        nombre.setOnAction(e -> {
            ok.fire(); // touche enter = cliquer sur le bouton nombre
        });
        ok.setOnAction(e -> {
            try{
                nombreAllumettes = Integer.parseInt(nombre.getText());
                if(nombreAllumettes >= 10) {
                    commande.afficherAllumettes(nombreAllumettes,allumettes);
                    joueur2.setDisable(true);
                    joueur2Input.setDisable(true);
                    nomJoueur1 = nomJInput.getText();
                    nomJoueur2 = nomJInput2.getText();
                    joueur.setText("Tu veux enlever combien d'allumettes "+nomJoueur1+"  ? (entre 1 et 3) : ");
                    joueur2.setText("Tu veux enlever combien d'allumettes "+nomJoueur2+"  ? (entre 1 et 3) : ");
                    primarystage.setScene(scene2);
                }{
                    feedback.setText("Entrez un nombre correct ! Minimum 10 ! ");
                }
            }catch(NumberFormatException ex){
                feedback.setText("Entrez un nombre ! ");
            }
        });


        // =============action des boutons de la pour la version 2 joueurs==============================
        joueurButton.setOnAction(e -> {
            try {
                int nbjoueur1 = Integer.parseInt(joueur1Input.getText());
                if (1 <= nbjoueur1 && nbjoueur1 <= 3) {
                    if(nombreAllumettes-nbjoueur1<=0){
                        nombreAllumettes += nbjoueur1;
                        feedback2.setVisible(false);
                        feedback3.setText("Tu peux pas");
                    }{
                        nombreAllumettes -=  nbjoueur1;
                        feedback2.setText(nomJoueur1+" a enlevé : "+nbjoueur1);
                    }

                    System.out.println("Nombre joueur 2 : " + nbjoueur1);
                    System.out.println("Nombre enlever allumettes apres que  le joueur 2 a enlever " + nombreAllumettes);
                    commande.afficherAllumettes(nombreAllumettes, allumettes);
                    commande.finduJeuX(nombreAllumettes,nomJoueur1,nomJoueur2,gagnant,joueurButton,joueur2Button,feedback2,primarystage,scene3,nomJoueur1);
                    joueur.setDisable(true);
                    joueur1Input.setDisable(true);
                    joueurButton.setDisable(true);

                    joueur2Input.setDisable(false);
                    joueur2Button.setDisable(false);
                    joueur1Input.clear();

                } else {
                    feedback2.setText("Entrez un nombre entre 1 et 3");
                }
            }catch (Exception ex) {
                feedback2.setText("Entrez un nombre ! ");
            }
             });
        joueur2Button.setOnAction(e -> {
           try {
               int nbjoueur2 = Integer.parseInt(joueur2Input.getText());
               if (1 <= nbjoueur2 && nbjoueur2 <= 3) {
                   if(nombreAllumettes-nbjoueur2<=0){
                       feedback2.setVisible(false);
                       feedback3.setText("Tu peux pas");
                       nombreAllumettes += nbjoueur2;
                   }{
                       nombreAllumettes -=  nbjoueur2;
                       feedback2.setText(nomJoueur2+" a enlevé : "+nbjoueur2);
                   }

                   System.out.println("Nombre joueur 2 : " + nbjoueur2);
                   System.out.println("Nombre enlever allumettes apres que  le joueur 2 a enlever " + nombreAllumettes);
                   commande.afficherAllumettes(nombreAllumettes, allumettes);
                   commande.finduJeuX(nombreAllumettes,nomJoueur1,nomJoueur2,gagnant,joueurButton,joueur2Button,feedback2,primarystage,scene3,nomJoueur2);

                   joueur.setDisable(false);
                   joueur1Input.setDisable(false);
                   joueurButton.setDisable(false);

                   joueur2.setDisable(false);
                   joueur2Input.setDisable(true);
                   joueur2Button.setDisable(true);
                   joueur2Input.clear();


               } else {
                   feedback2.setText("Entrez un nombre entre 1 et 3");
               }
           }catch (Exception ex) {
               feedback2.setText("Entrez un nombre ! ");
           }
        });
        // action du field joueur pour appuyer sur la touche Enter
        joueur1Input.setOnAction(e -> {joueurButton.fire();
        });
        // action du field joueur pour appuyer sur la touche Enter
        joueur2Input.setOnAction(e -> {joueur2Button.fire();});
        // actin du bouton recommencer
        recommencer.setOnAction(e -> {
            nombre.clear();
            feedback.setText("");
            feedback2.setText("");
            joueur1Input.clear();
            joueur2Input.clear();
            nomJInput.clear();
            nomJInput2.clear();
            nomJoueur1VIA.clear();
            allumettes1VIA.clear();
            ia.setText("");
            joueurVIAInput.clear();

            joueur.setDisable(false);
            joueur1Input.setDisable(false);
            joueurButton.setDisable(false);



            primarystage.setScene(scene0);
        });
        //=========================================================


        //ACTION BOUTON VERSION IA
        boutonOkVIA.setOnAction(e -> {
            try{
                nombreAllumettes = Integer.parseInt(allumettes1VIA.getText());
                if(nombreAllumettes >= 10){

                    commande.afficherAllumettes(nombreAllumettes, noombreallumettesVIA);

                    String nomJoueur1 = nomJoueur1VIA.getText();
                    joueurVIA.setText(nomJoueur1+", enlève entre 1 et 3 allumettes");
                    primarystage.setScene(scene22VIA);
                }else{
                    feedback33.setText("Minimum 10 !");
                }
            } catch (NumberFormatException ex) {
                feedback33.setText("Entrez un nombre !");
            }

        });
        joueurButtonVIA.setOnAction(e -> {
            try{
                int rolejoueur = 1;
                String nomJoueur11 = nomJoueur1VIA.getText();
                Random random = new Random();
                int randomNum = random.nextInt(1,4);
                int nAJoueur1 = Integer.parseInt(joueurVIAInput.getText());
                int somme = randomNum + nAJoueur1;
                int reste = 0;
                if(1<= nAJoueur1 && nAJoueur1 <= 3){
                    nombreAllumettes-= nAJoueur1;
                    commande.afficherAllumettes(nombreAllumettes, noombreallumettesVIA);
                    if(nombreAllumettes<=0){
                        nombreAllumettes += nAJoueur1;
                    }
                    rolejoueur = 2;
                    if(nombreAllumettes==1){
                        joueurVIA.setText("Le gagnant est "+nomJoueur11);
                        sousT.setText("");
                        Thread.sleep(2000);
                        gagnant.setText("Le gagnant est "+nomJoueur11);
                        primarystage.setScene(scene3);
                    }else{
                        if(nombreAllumettes==4){
                            reste =4;
                            randomNum = 3;
                            ia.setText("L'ia enlever :"+randomNum);

                        }
                        if(nombreAllumettes==3){
                            reste = 3;
                            randomNum = 2;
                            ia.setText("L'ia enlever :"+randomNum);

                        }
                        if(nombreAllumettes==2){
                            reste = 2;
                            randomNum = 1;
                            ia.setText("L'ia enlever :"+randomNum);
                        }
                        commande.afficherAllumettes(nombreAllumettes, noombreallumettesVIA);
                        nombreAllumettes -= randomNum;
                        commande.afficherAllumettes(nombreAllumettes, noombreallumettesVIA);
                        if(nombreAllumettes<=0){
                            commande.afficherAllumettes(nombreAllumettes, noombreallumettesVIA);
                            nombreAllumettes += randomNum;
                            commande.afficherAllumettes(nombreAllumettes, noombreallumettesVIA);
                        }

                        ia.setText("L'ia enlever :"+randomNum);
                        if(nombreAllumettes==1){
                            ia.setText("L'ia enlever :"+randomNum);
                            commande.afficherAllumettes(nombreAllumettes, noombreallumettesVIA);
                            Thread.sleep(1000); // figer la scene 1 seconde
                            sousT.setText("Il restait "+reste+" allumettes, l'ia en a pris "+randomNum);
                            gagnant.setText("Le gagnant est l'ia");
                            primarystage.setScene(scene3);

                        }
                    }

                }else{
                    ia.setText("Entrez un nombre entre 1 et 3 ");
                }
            }catch(Exception ex){
                ia.setText("Erreur ! ");
            }


        });
        joueurVIAInput.setOnAction(e -> {
            joueurButtonVIA.fire();
        });

        allumettes1VIA.setOnAction(e -> {boutonOkVIA.fire();});

        // Stage
        primarystage.setScene(scene0); //parametrer la scence 0 par defaut
        primarystage.setResizable(false); // parametrer que la taille de le scen est fixe
        primarystage.setTitle("Jeux de Nim"); // mettre un titre à la stage
        primarystage.show(); // afficher la stage



    }
}
