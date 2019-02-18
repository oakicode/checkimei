/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.code.oaki.view;

import com.code.oaki.model.AlgorithmLuhn;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Mario
 */
public class IMEIFormController implements Initializable {
    //
    @FXML
    private TextField textIMEI;
    
    @FXML
    private Button btnCheckIMEI;
    
    @FXML
    private Label lErrorIMEI;
    
    private boolean r = false;
    
    @FXML
    public void checkIMEI(ActionEvent event) {
        //
        //System.out.println("Check IMEI!");
        if(!textIMEI.getText().isEmpty()) {
            // System.out.println("Check IMEI - Algorithm");
            r = AlgorithmLuhn.validateIMEI(textIMEI.getText());
            // System.out.println("Check IMEI - Algorithm: " + r);
            if(r){
                lErrorIMEI.setText("IMEI Correcto!!!");
                lErrorIMEI.setTextFill(Color.GREEN);
                lErrorIMEI.setVisible(true);
            } else {
                lErrorIMEI.setText("Error en IMEI");
                lErrorIMEI.setTextFill(Color.RED);
                lErrorIMEI.setVisible(true);
            }
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Code
        
        btnCheckIMEI.disableProperty().bind(textIMEI.textProperty().isEmpty()
                .or(textIMEI.lengthProperty().lessThan(15)));
        
        lErrorIMEI.setVisible(false);
        //lErrorIMEI.visibleProperty().bind(textIMEI.focusedProperty().not());
    }    
    
}
