package processing;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javax.imageio.ImageIO;
import static java.lang.Integer.max;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene; 
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage; 

public class HomeController implements Initializable {
    
    private Label label;
    @FXML
    private AnchorPane pane;
    @FXML
    private ImageView view1;
    @FXML
    private ImageView view2;
    @FXML
    private Button detalles;
    @FXML
    private Button histograma;
    @FXML
    private VBox VOp;
    

    public BufferedImage im;
    public BufferedImage Kim;
    
    @FXML
    private ImageView negativoButtom;
    @FXML
    private ImageView grisesButtom;
    @FXML
    private ImageView blanco_negroButtom;
    @FXML
    private ImageView rotacionLButtom;
    @FXML
    private ImageView rotacionRButtom;
    @FXML
    private ImageView medianaButtom;
    @FXML
    private ImageView LaplaceGaussButtom;
    @FXML
    private ImageView prewittButtom;
    @FXML
    private ImageView sobelButtom;
    @FXML
    private ImageView robertsButtom;
    
    @FXML
    private Slider sliderBrillo;
    @FXML
    private Slider sliderContraste;
    @FXML
    private Slider sliderUmbral;
    @FXML
    private ImageView originalButtom;
    @FXML
    private TextField ipath;
    @FXML
    private Button cargarPBM;
    @FXML
    private Button cargarPGM;
    @FXML
    private Button cargarPPM;
    @FXML
    private Button cargar1;
    @FXML
    private Button cargarOtros;
    @FXML
    private Button cargarNetpbm;

    int esNetpbm;
    @FXML
    private Slider sliderInterpolacion;
    @FXML
    private ImageView promedioButtom;
    private Slider KSize;
    @FXML
    private Slider nrowPro;
    @FXML
    private Slider ncolPro;
    @FXML
    private Slider nrowMe;
    @FXML
    private Slider ncolMe;
    @FXML
    private Slider nrowLa;
    @FXML
    private Slider ncolLa;
    @FXML
    private Slider KSizePre;
    @FXML
    private Slider KSizeSo;
    @FXML
    private Slider KSizeRo;
    @FXML
    private RadioButton HPre;
    @FXML
    private ToggleGroup Prewitt;
    @FXML
    private RadioButton VPre;
    @FXML
    private RadioButton HSo;
    @FXML
    private ToggleGroup Sobel;
    @FXML
    private RadioButton VSo;
    @FXML
    private RadioButton HRo;
    @FXML
    private ToggleGroup Roberts;
    @FXML
    private RadioButton VRo;
    @FXML
    private Slider sliderVecinos;
    @FXML
    private Slider nrowKer;
    @FXML
    private Slider ncolKer;
    @FXML
    private Button GO;
    @FXML
    private TextField outpath;


    public HomeController() {
        try{

        }catch(Exception e) {  }
        
    }
        
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            //TODO
        }catch(Exception e) { 
        
    }}  


    @FXML
    private void BnegativoAction(MouseEvent event) throws IOException {
 view2.setImage(SwingFXUtils.toFXImage(im,null)); 
        
        for(int i = 0; i<im.getHeight(); i++){
            for(int j = 0; j<im.getWidth(); j++){
                Color imColor = new Color(im.getRGB(j,i));  
                    int pixr = (int) (255-imColor.getRed()); 
                    int pixb = (int) (255-imColor.getGreen()); 
                    int pixg = (int) (255-imColor.getBlue()); 
                    Color newColor = new Color(pixr,pixb,pixg); 
                im.setRGB(j,i,newColor.getRGB());  
            }
        }
        
        view1.setImage(SwingFXUtils.toFXImage(im,null));
    }

    @FXML
    private void grisesButtomAction(MouseEvent event) throws IOException {
        view2.setImage(SwingFXUtils.toFXImage(im,null)); 
        for(int i = 0; i<im.getHeight(); i++){
            for(int j = 0; j<im.getWidth(); j++){
                Color imColor = new Color(im.getRGB(j,i));
                int pix = (int) (imColor.getRed()* 0.299)+ (int) (imColor.getGreen()* 0.587)+ (int) (imColor.getBlue()* 0.114);
                Color newColor = new Color(pix,pix,pix);
                im.setRGB(j,i,newColor.getRGB());
            }
         } 
        view1.setImage(SwingFXUtils.toFXImage(im,null));
    }

    @FXML
    private void blanco_negroButtomAction(MouseEvent event) throws IOException {
        view2.setImage(SwingFXUtils.toFXImage(im,null)); 
        for(int i = 0; i<im.getHeight(); i++){
            for(int j = 0; j<im.getWidth(); j++){
                Color imColor = new Color(im.getRGB(j,i));
                int pix = (int)(imColor.getRed()+imColor.getGreen()+imColor.getBlue())/3;
                if (pix>=128){pix = 255;}
                else{pix = 0;}
                Color newColor = new Color(pix,pix,pix);
                im.setRGB(j,i,newColor.getRGB());
            }
         } 
        view1.setImage(SwingFXUtils.toFXImage(im,null));
    }

    @FXML
    private void rotacionRButtomAction(MouseEvent event) throws IOException {
                
        view2.setImage(SwingFXUtils.toFXImage(im,null)); 
        BufferedImage im2 = new BufferedImage(im.getHeight(), im.getWidth(), BufferedImage.TYPE_INT_RGB);      
        for (int y = 0; y < im.getHeight(); y++) {
            for (int x = 0; x < im.getWidth(); x++) {  
                im2.setRGB(y,im.getWidth()-1-x,im.getRGB(x,y));   
            }
        }
        im = im2;
        view1.setImage(SwingFXUtils.toFXImage(im,null)); 

    }
    
        @FXML
    private void rotacionLButtomAction(MouseEvent event) throws IOException {
                
        view2.setImage(SwingFXUtils.toFXImage(im,null)); 
        BufferedImage im2 = new BufferedImage(im.getHeight(), im.getWidth(), BufferedImage.TYPE_INT_RGB);      
        for (int y = 0; y < im.getHeight(); y++) {
            for (int x = 0; x < im.getWidth(); x++) {  
                im2.setRGB(im.getHeight()-1-y,x,im.getRGB(x,y));   
            }
        }
        im = im2;
        view1.setImage(SwingFXUtils.toFXImage(im,null)); 
    }

 
    @FXML
    private void promedioButtomAction(MouseEvent event) throws IOException {
        view2.setImage(SwingFXUtils.toFXImage(im,null)); 

        int dim_row = (int) nrowPro.getValue();
        int dim_col = (int) ncolPro.getValue();
      
        int pi = (int) dim_row/2;
        int pj = (int) dim_col/2;
        
        
//        double op1[][] =   {{ 1, 1, 1, 1, 1, 1, 1},
//                            { 1, 1, 1, 1, 1, 1, 1},
//                            { 1, 1, 1, 1, 1, 1, 1},
//                            { 1, 1, 1, 1, 1, 1, 1},
//                            { 1, 1, 1, 1, 1, 1, 1},
//                            { 1, 1, 1, 1, 1, 1, 1},
//                            { 1, 1, 1, 1, 1, 1, 1}};

        int n = dim_row*dim_col;
        double ker[][] = new double[dim_row][dim_col];
        
        for(int o=0; o < dim_row; o++){
            for(int u=0; u < dim_col; u++){
                ker[o][u] = 1;
            }
        }

        int der = dim_col - 1 - pj;
        int izq = dim_col - 1 - (der); 
        int down = dim_row - 1 - pi;
        int up = dim_row - 1 - (down);

        Kim = new BufferedImage(im.getWidth(), im.getHeight(), BufferedImage.TYPE_INT_RGB);
        int h = dim_row;
        int w = dim_col;

        for(int i = 0; i < (int) im.getHeight(); i++){
            for(int j = 0; j < (int) im.getWidth(); j++){  

                double pixr = 0;
                double pixg = 0;
                double pixb = 0;

                for(int a = (int) max(0,up - i); a < h; a++){

                    if (((im.getHeight() - 1 - i) - (a - pi)) < 0) continue;

                    for(int e = (int)  max(0, izq - j); e <  w; e++){ 

                        if (((im.getWidth() - 1 - j) - (e - pj)) < 0)continue;

                        Color imColor = new Color(im.getRGB(j+ (e-pj), i+ (a-pi)));

                        pixr +=  imColor.getRed() * ker[a][e];
                        pixg +=  imColor.getGreen() * ker[a][e];
                        pixb +=  imColor.getBlue() * ker[a][e];

                    }   
                }

                Color newColor = new Color((int) pixr/n,(int) pixg/n,(int) pixb/n);
                Kim.setRGB(j,i, newColor.getRGB());
            }
         } 
        view1.setImage(SwingFXUtils.toFXImage(Kim,null));
    }

    @FXML
    private void medianaButtomAction(MouseEvent event) throws IOException {
        view2.setImage(SwingFXUtils.toFXImage(im,null)); 

        int dim_row = (int) nrowMe.getValue();
        int dim_col = (int) ncolMe.getValue();
      
        int pi = (int) dim_row/2;
        int pj = (int) dim_col/2;

  
        double ker[][] = new double[dim_row][dim_col];
        int der = 0;
        int izq = 0;
        int down = 0;
        int up = 0;
        int h = 1;
        int w = 1;
        if (dim_col > 1){ 
            der = dim_col - 1 - pj;
            izq = dim_col - 1 - (der); 
            w = dim_col;
        }

        if (dim_row > 1){
                down = dim_row - 1 - pi;
                up = dim_row - 1 - (down);
                h = dim_row;
        }
        
        Kim = new BufferedImage(im.getWidth(), im.getHeight(), BufferedImage.TYPE_INT_RGB);


        for(int i = 0; i < (int) im.getHeight(); i++){
            for(int j = 0; j < (int) im.getWidth(); j++){  
                int colors_red[] = new int[dim_row*dim_col];
                int colors_green[] = new int[dim_row*dim_col];
                int colors_blue[] = new int[dim_row*dim_col];
                int cont = 0;
                for(int a = (int) max(0,up - i); a < h; a++){

                    if (((im.getHeight() - 1 - i) - (a - pi)) < 0) continue;

                    for(int e = (int)  max(0, izq - j); e <  w; e++){ 

                        if (((im.getWidth() - 1 - j) - (e - pj)) < 0)continue;
                        Color imColor = new Color(im.getRGB(j+ (e-pj), i+ (a-pi)));
                        colors_red[cont] = imColor.getRed();
                        colors_green[cont]=  imColor.getGreen();
                        colors_blue[cont] =  imColor.getBlue();
                        cont++;
                    }   
                }
                Arrays.sort(colors_red,0,cont);
                Arrays.sort(colors_green,0,cont);
                Arrays.sort(colors_blue,0,cont);
                
                int pixr = colors_red[cont/2];
                int pixg = colors_green[cont/2];
                int pixb = colors_blue[cont/2];

                Color newColor = new Color(pixr,pixg,pixb);
                Kim.setRGB(j,i, newColor.getRGB());
            }
         } 
        view1.setImage(SwingFXUtils.toFXImage(Kim,null));
    }  

    @FXML
    private void LaplaceGaussButtomAction(MouseEvent event) throws IOException {
       view2.setImage(SwingFXUtils.toFXImage(im,null));

        int dim_row = (int) nrowLa.getValue();
        int dim_col = (int) ncolLa.getValue();        
        int start_row;
        int start_col;
        int dif = 0;
  
        if (dim_row == 3) start_row = 2;
        else if ((dim_row == 1) & ((dim_col == 3)|(dim_col == 5)|(dim_col == 7))) start_row = 3;
        else if (dim_row == 5) start_row = 1;
        else if (dim_row == 7) start_row = 0;
        else return;     
                
        if (dim_col == 3) start_col = 2;
        else if ((dim_col == 1) & ((dim_row == 3)|(dim_row == 5)|(dim_row == 7))) start_col = 3;
        else if (dim_col == 5) start_col = 1;
        else if (dim_col == 7) start_col = 0;
        else return;   
         
        int pi = (int) dim_row/2;
        int pj = (int) dim_col/2;
        
        double op1[][] =   {{1, 1, 2, 2, 2, 1, 1},
                            {1, 2, 2, 4, 2, 2, 1},
                            {2, 2, 4, 8, 4, 2, 2},
                            {2, 4, 8,16, 8, 4, 2},
                            {2, 2, 4, 8, 4, 2, 2},
                            {1, 2, 2, 4, 2, 2, 1},
                            {1, 1, 2, 2, 2, 1, 1}};
        

        double ker[][] = new double[dim_row][dim_col];
                
        for(int o=start_row; o<7-start_row; o++){
            for(int u=start_col; u<7-start_col; u++){
                dif += op1[o][u];
                ker[o-start_row][u-start_col] = op1[o][u];
            }
        }
        
        int der = 0;
        int izq = 0;
        int down = 0;
        int up = 0;
        int h = 1;
        int w = 1;
        
        if (dim_col > 1){ 
            der = dim_col - 1 - pj;
            izq = dim_col - 1 - (der); 
            w = dim_col;
        }

        if (dim_row > 1){
                down = dim_row - 1 - pi;
                up = dim_row - 1 - (down);
                h = dim_row;
        }

        BufferedImage im4 = new BufferedImage(im.getWidth(), im.getHeight(), BufferedImage.TYPE_INT_RGB);

        for(int i = 0; i < (int) im.getHeight(); i++){
            for(int j = 0; j < (int) im.getWidth(); j++){  

                double pixr = 0;
                double pixg = 0;
                double pixb = 0;

                for(int a = (int) max(0,up - i); a < h; a++){

                    if (((im.getHeight() - 1 - i) - (a - pi)) < 0) continue;

                    for(int e = (int)  max(0, izq - j); e <  w; e++){ 

                        if (((im.getWidth() - 1 - j) - (e - pj)) < 0)continue;

                        Color imColor = new Color(im.getRGB(j+ (e-pj), i+ (a-pi)));

                        pixr +=  imColor.getRed() * ker[a][e];
                        pixg +=  imColor.getGreen() * ker[a][e];
                        pixb +=  imColor.getBlue() * ker[a][e];
                    }   
                }

                pixr = pixr/dif;
                pixg = pixg/dif;
                pixb = pixb/dif;         
                
                if (pixr < 0) pixr = 0;
                else if (pixr > 255) pixr = 255;
                
                if (pixg < 0) pixg = 0;
                else if (pixg > 255) pixg = 255;
                                
                if (pixb < 0) pixb = 0;
                else if (pixb > 255) pixb = 255;
                
                Color newColor = new Color((int) pixr,(int) pixg,(int) pixb);
                im4.setRGB(j,i, newColor.getRGB());
            }
         }
////double kernel[][] =     {-1,-1,-1,-1,-1,-1,-1},
////                        {-1,-1,-1,-1,-1,-1,-1},
////                        {-1,-1,-1,8,-1,-1,-1},
////                        {-1,-1,8,12,8,-1,-1},
////                        {-1,-1,-1,8,-1,-1,-1},
////                        {-1,-1,-1,-1,-1,-1,-1},
////                        {-1,-1,-1,-1,-1,-1,-1}};
//
//
       double kernel[][] = {{-1,-1 , -1},
                            {-1, 8 ,-1},
                            { -1,-1 , -1}};
        
       pi = 1;
       pj = 1;

       der = kernel[1].length - 1 - pj;
       izq = kernel[1].length - 1 - (der); 
       w = kernel[1].length;


       down = kernel.length - 1 - pi;
       up = kernel.length - 1 - (down);
       h = kernel.length;

       Kim = new BufferedImage(im4.getWidth(), im4.getHeight(), BufferedImage.TYPE_INT_RGB);

        for(int i = 0; i < (int) im4.getHeight(); i++){
            for(int j = 0; j < (int) im4.getWidth(); j++){  

                double pixr = 0;
                double pixg = 0;
                double pixb = 0;

                for(int a = (int) max(0,up - i); a < h; a++){

                    if (((im4.getHeight() - 1 - i) - (a - 1)) < 0) continue;

                    for(int e = (int)  max(0, izq - j); e <  w; e++){ 

                        if (((im4.getWidth() - 1 - j) - (e - 1)) < 0)continue;

                        Color imColor = new Color(im4.getRGB(j+ (e-1), i+ (a-1)));

                        pixr +=  imColor.getRed() * kernel[a][e];
                        pixg +=  imColor.getGreen() * kernel[a][e];
                        pixb +=  imColor.getBlue() * kernel[a][e];

                    }   
                }      
                
                int pix = (int) (pixr + pixg + pixb)/3 + 128 ;
                
                if (pix < 0) pix = 0;
                else if (pix > 255) pix = 255;
                
                Color newColor = new Color((int) pix,(int) pix,(int) pix);
                Kim.setRGB(j,i, newColor.getRGB());
            }
         }
  
        view1.setImage(SwingFXUtils.toFXImage(Kim,null));

    }

    
    @FXML
    private void prewittButtomAction(MouseEvent event) throws IOException {
        view2.setImage(SwingFXUtils.toFXImage(im,null));

        int dim = (int) KSizePre.getValue();
        int start;
        
        if (dim == 3) start = 2;
        else if (dim == 5) start = 1;
        else if (dim == 7) start = 0;
        else return;        
        
        int pi = (int) dim/2;
        int pj = (int) dim/2;

        double op1[][] =   {{-1,-1,-1, 0, 1, 1, 1},
                            {-1,-1,-1, 0, 1, 1, 1},
                            {-1,-1,-1, 0, 1, 1, 1},
                            {-1,-1,-1, 0, 1, 1, 1},
                            {-1,-1,-1, 0, 1, 1, 1},
                            {-1,-1,-1, 0, 1, 1, 1},
                            {-1,-1,-1, 0, 1, 1, 1}};


        double ker[][] = new double[dim][dim];
        
        for(int o=start; o<7-start; o++){
            for(int u=start; u<7-start; u++){
                if (HPre.isSelected()) {
                    ker[o-start][u-start] = op1[o][u];
                }
                else if (VPre.isSelected()) {
                    ker[o-start][u-start] = op1[u][o];
                }
            }
        }
        
        int der = dim - 1 - pj;
        int izq = dim - 1 - (der); 
        int down = dim - 1 - pi;
        int up = dim - 1 - (down);

        Kim = new BufferedImage(im.getWidth(), im.getHeight(), BufferedImage.TYPE_INT_RGB);
        int h = dim;
        int w = dim;

        for(int i = 0; i < (int) im.getHeight(); i++){
            for(int j = 0; j < (int) im.getWidth(); j++){  

                double pixr = 0;
                double pixg = 0;
                double pixb = 0;

                for(int a = (int) max(0,up - i); a < h; a++){

                    if (((im.getHeight() - 1 - i) - (a - pi)) < 0) continue;

                    for(int e = (int)  max(0, izq - j); e <  w; e++){ 

                        if (((im.getWidth() - 1 - j) - (e - pj)) < 0)continue;

                        Color imColor = new Color(im.getRGB(j+ (e-pj), i+ (a-pi)));

                        pixr +=  imColor.getRed() * ker[a][e];
                        pixg +=  imColor.getGreen() * ker[a][e];
                        pixb +=  imColor.getBlue() * ker[a][e];

                    }   
                }
                
                
                int pix = (int) (pixr + pixg + pixb)/3 + 128 ;
//                pixg += 128 ;
//                pixb += 128 ;         
                
                if (pix < 0) pix = 0;
                else if (pix > 255) pix = 255;
                
                Color newColor = new Color((int) pix,(int) pix,(int) pix);
                Kim.setRGB(j,i, newColor.getRGB());
            }
         }
        view1.setImage(SwingFXUtils.toFXImage(Kim,null));
    }
    
           
    @FXML
    private void sobelButtomAction(MouseEvent event) throws IOException {
        view2.setImage(SwingFXUtils.toFXImage(im,null));

        int dim = (int) KSizeSo.getValue();
        int start;
        
        if (dim == 3) start = 2;
        else if (dim == 5) start = 1;
        else if (dim == 7) start = 0;
        else return;
      
        int pi = (int) dim/2;
        int pj = (int) dim/2;
        
        double op1[][] =   {{-1,-1, -1, 0, 1, 1, 1},
                            {-1,-1, -1, 0, 1, 1, 1},
                            {-1,-1, -1, 0, 1, 1, 1},
                            {-2,-2, -4, 0, 4, 2, 2},
                            {-1,-1, -1, 0, 1, 1, 1},
                            {-1,-1, -1, 0, 1, 1, 1},
                            {-1,-1, -1, 0, 1, 1, 1},};


        double ker[][] = new double[dim][dim];
        
        for(int o=start; o<7-start; o++){
            for(int u=start; u<7-start; u++){
                if (HSo.isSelected()) {
                    ker[o-start][u-start] = op1[o][u];
                }
                else if (VSo.isSelected()) {
                    ker[o-start][u-start] = op1[u][o];
                }
            }
        }
        
        int der = dim - 1 - pj;
        int izq = dim - 1 - (der); 
        int down = dim - 1 - pi;
        int up = dim - 1 - (down);
        int h = dim;
        int w = dim;
        
        Kim = new BufferedImage(im.getWidth(), im.getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < (int) im.getHeight(); i++){
            for(int j = 0; j < (int) im.getWidth(); j++){  

                double pixr = 0;
                double pixg = 0;
                double pixb = 0;

                for(int a = (int) max(0,up - i); a < h; a++){

                    if (((im.getHeight() - 1 - i) - (a - pi)) < 0) continue;

                    for(int e = (int)  max(0, izq - j); e <  w; e++){ 

                        if (((im.getWidth() - 1 - j) - (e - pj)) < 0)continue;

                        Color imColor = new Color(im.getRGB(j+ (e-pj), i+ (a-pi)));

                        pixr +=  imColor.getRed() * ker[a][e];
                        pixg +=  imColor.getGreen() * ker[a][e];
                        pixb +=  imColor.getBlue() * ker[a][e];
                    }   
                }
 
                int pix = (int) (pixr + pixg + pixb)/3 + 128 ;   
                
                if (pix < 0) pix = 0;
                else if (pix > 255) pix = 255;
                
                Color newColor = new Color(pix, pix, pix);
                Kim.setRGB(j,i, newColor.getRGB());
            }
         }
        //im = im4;
        view1.setImage(SwingFXUtils.toFXImage(Kim,null));
    }

    @FXML
    private void robertsButtomAction(MouseEvent event) throws IOException {
        view2.setImage(SwingFXUtils.toFXImage(im,null));
  
        int pivotei;
        int pivotej;
        int dim = (int) KSizeRo.getValue();
//        System.out.println("dim:");
//        System.out.println(dim);
        
        int start;
        int pivote;
        
        if (dim == 2) { start = 2; pivote= 0; }
        else if (dim == 4) { start = 1; pivote= 1; }
        else if (dim == 6) { start = 0; pivote= 2; }
        else return;

        int pi = pivote;
        int pj = pivote;
        
        double op1[][] =   {{0,1,  1, 1, 1, 1},
                            {-1,0,  1, 1, 1, 1},
                            {-1,-1, 0, 1, 1, 1},
                            {-1,-1,-1, 0, 1, 1},
                            {-1,-1,-1,-1, 0, 1},
                            {-1,-1,-1,-1,-1, 0}};  

//        double op1[][] =   {{1,0,  0, 0, 0, 0},
//                            {0,1,  0, 0, 0, 0},
//                            {0,0, 1, 0, 0, 0},
//                            {0,0,0, -1, 0, 0},
//                            {0,0,0,0, -1, 0},
//                            {0,0,0,0,0, -1}};  

        double ker[][] = new double[dim][dim];
        
        for(int o=start; o<6-start; o++){
            for(int u=start; u<6-start; u++){
                if (HRo.isSelected()) {
                    ker[o-start][u-start] = op1[o][u];
                }
                else if (VRo.isSelected()) {
                    ker[o-start][u-start] = op1[u][o];
                }
            }
        }

        int der = dim - 1 - pj;
        int izq = dim - 1 - (der); 
        int down = dim - 1 - pi;
        int up = dim - 1 - (down);
        int h = dim;
        int w = dim;
        
        Kim = new BufferedImage(im.getWidth(), im.getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < (int) im.getHeight(); i++){
            for(int j = 0; j < (int) im.getWidth(); j++){  

                double pixr = 0;
                double pixg = 0;
                double pixb = 0;

                for(int a = (int) max(0,up - i); a < h; a++){

                    if (((im.getHeight() - 1 - i) - (a - pi)) < 0) continue;

                    for(int e = (int)  max(0, izq - j); e <  w; e++){ 

                        if (((im.getWidth() - 1 - j) - (e - pj)) < 0)continue;

                        Color imColor = new Color(im.getRGB(j+ (e-pj), i+ (a-pi)));

                        pixr +=  imColor.getRed() * ker[a][e];
                        pixg +=  imColor.getGreen() * ker[a][e];
                        pixb +=  imColor.getBlue() * ker[a][e];

                    }   
                }
                
                
                int pix = (int) (pixr + pixg + pixb)/3 + 128 ;
//                pixg += 128 ;
//                pixb += 128 ;         
                
                if (pix < 0) pix = 0;
                else if (pix > 255) pix = 255;
                
                Color newColor = new Color(pix,pix,pix);
                Kim.setRGB(j,i, newColor.getRGB());
            }
         }
        view1.setImage(SwingFXUtils.toFXImage(Kim,null));
    }

    @FXML
    private void sliderBrilloAction(MouseEvent event) throws IOException {
        BufferedImage im2 = new BufferedImage(im.getWidth(),im.getHeight(), BufferedImage.TYPE_INT_RGB);      
        view2.setImage(SwingFXUtils.toFXImage(im,null));
        int a = (int) sliderBrillo.getValue();

        for(int i = 0; i<im.getHeight(); i++){
            for(int j = 0; j<im.getWidth(); j++){
                Color imColor = new Color(im.getRGB(j,i));
                
                int pixr = (int) imColor.getRed() + a;
                int pixg = (int) imColor.getGreen() + a; 
                int pixb = (int) imColor.getBlue() + a;
                
                if (pixr < 0) pixr = 0;
                else if (pixr > 255) pixr = 255;
                
                if (pixg < 0) pixg = 0;
                else if (pixg > 255) pixg = 255;
                                
                if (pixb < 0) pixb = 0;
                else if (pixb > 255) pixb = 255;  
                
                Color newColor = new Color(pixr,pixg,pixb);
                im2.setRGB(j,i,newColor.getRGB());
            }
        }
        view1.setImage(SwingFXUtils.toFXImage(im2,null));
    }

    @FXML
    private void sliderContrasteAction(MouseEvent event)throws IOException {
        BufferedImage im2 = new BufferedImage(im.getWidth(),im.getHeight(), BufferedImage.TYPE_INT_RGB);      
        view2.setImage(SwingFXUtils.toFXImage(im,null));
        double a = sliderContraste.getValue();
        //System.out.println(a);
        
        for(int i = 0; i<im.getHeight(); i++){
            for(int j = 0; j<im.getWidth(); j++){
                Color imColor = new Color(im.getRGB(j,i));
                double pixr = imColor.getRed();
                double pixg = imColor.getGreen(); 
                double pixb = imColor.getBlue();       
                
                if(a<0){
                    a = a * (-1);
                    pixr = pixr/a;
                    pixg = pixg/a; 
                    pixb = pixb/a;                
                }
                else if (a>0){
                    pixr = pixr*a;
                    pixg = pixg*a; 
                    pixb = pixb*a;   
                }
            
                if (pixr < 0) pixr = 0;
                else if (pixr > 255) pixr = 255;
                
                if (pixg < 0) pixg = 0;
                else if (pixg > 255) pixg = 255;
                                
                if (pixb < 0) pixb = 0;
                else if (pixb > 255) pixb = 255;  
                
                Color newColor = new Color((int)pixr,(int)pixg,(int)pixb);
                im2.setRGB(j,i,newColor.getRGB());
            }
        }
        
        
        view1.setImage(SwingFXUtils.toFXImage(im2,null));
    }

    @FXML
    private void sliderUmbralAction(MouseEvent event) {
                
        double um = sliderUmbral.getValue();
        BufferedImage im2 = new BufferedImage(im.getWidth(),im.getHeight(), BufferedImage.TYPE_INT_RGB);      
        view2.setImage(SwingFXUtils.toFXImage(im,null));
        //int um = 200;
        for(int i = 0; i<im.getHeight(); i++){
            for(int j = 0; j<im.getWidth(); j++){
                Color imColor = new Color(im.getRGB(j,i));
                int pix = (int)(imColor.getRed()+imColor.getGreen()+imColor.getBlue())/3;  
                if (pix>=um){pix = 255;}
                else{pix = 0;}

                Color newColor = new Color(pix,pix,pix);
                im2.setRGB(j,i,newColor.getRGB());
            }
         } 
         view1.setImage(SwingFXUtils.toFXImage(im2,null));
    }

    int may = 255;
    
    @FXML
    private void CargarAction() throws IOException {
        esNetpbm = 1;
        String path = ipath.getText();
        
        FileInputStream fileInputStream = new FileInputStream(path);

        Scanner scan = new Scanner(fileInputStream);

        String magic = scan.nextLine();
        
        scan.nextLine();
        int w = scan.nextInt();
        int h = scan.nextInt();

        im = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        if ( magic.equals("P1")){       

           
            fileInputStream.close();
            FileInputStream fileInputStream2 = new FileInputStream(path);
            DataInputStream dis = new DataInputStream(fileInputStream2);

            for(int a = 0; a<3; a++){
                char c = (char)(dis.readUnsignedByte()); 
                while(c != '\n'){
                    c = (char)(dis.readUnsignedByte());
                }
             }
            
             int pix;
             for (int i = 0; i < h; i++) {
                 for (int j = 0; j < w; j++) {
                     char b = (char) dis.readUnsignedByte();
                     if (b=='0'){pix = 255;}
                     else{pix = 0;}
                     
                     Color newColor = new Color(pix,pix,pix);
                     im.setRGB(j,i,newColor.getRGB());
                 }  
             }
             fileInputStream2.close();
        }
        else if (magic.equals("P2")){
            may = scan.nextInt();
            
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    int pix = scan.nextInt() * 255/may;
                    Color newColor = new Color(pix,pix,pix);
                    im.setRGB(j,i,newColor.getRGB());  
                }
             } 
            fileInputStream.close();
        }
        else if (magic.equals("P3")){
            may = scan.nextInt();

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {

                    int pixr = scan.nextInt() * 255/may;
                    int pixg = scan.nextInt() * 255/may;
                    int pixb = scan.nextInt() * 255/may;

                    Color newColor = new Color(pixr,pixg,pixb);
                    im.setRGB(j,i,newColor.getRGB());  
                }
             } 
            fileInputStream.close();
        }
       
        view1.setImage(SwingFXUtils.toFXImage(im,null));
        view2.setImage(SwingFXUtils.toFXImage(im,null));
    }

    public int check_format(int n) throws IOException {
        int [][] count = new int[256][4];
        int c = 0;
        for(int i = 0; i<im.getHeight(); i++){
            for(int j = 0; j<im.getWidth(); j++){ 
                Color imColor = new Color(im.getRGB(j,i));         
                count[(int) imColor.getRed()][0] ++;
                count[(int) imColor.getGreen()][1] ++;
                count[(int) imColor.getBlue()][2] ++;  
                count[(int) (imColor.getBlue()+imColor.getGreen()+imColor.getRed())/3][3] ++;  
            }
        }
        int same = 0;
        for(int i = 0; i<256; i++){
            if (abs(count[i][0]-count[i][3])<5)same++;
        }
        if (same > n){
            c = 1;
            System.out.println("GRISES");
        }
        return c;
    }
    
    @FXML
    private void CargarPBMAction(ActionEvent event) throws IOException {
        
        System.out.println("pbm");
        
        File myFile = new File("src/processing/Output/GetPath.txt");
        String absolute_path = myFile.getAbsolutePath();
        StringBuilder str = new StringBuilder(absolute_path.substring(0, absolute_path.length() - 11));
        //System.out.println(str);
        str.append(outpath.getText());
        str.append(".pbm");
        
        //System.out.println(str.toString());
        String ruta = str.toString();
        
        String contenido = "P1\n";
        StringBuilder sb = new StringBuilder(contenido);
        
        sb.append("#COMENTARIO ");
        sb.append("\n");
        
        sb.append(Integer.toString(im.getWidth()));
        sb.append(" ");
        sb.append(Integer.toString(im.getHeight()));
        sb.append("\n");
        for(int i = 0; i<im.getHeight(); i++){
            for(int j = 0; j<im.getWidth(); j++){ 
                Color imColor = new Color(im.getRGB(j,i));
                int pix = (int) (imColor.getRed() + imColor.getGreen() + imColor.getBlue())/3;
                if (pix >= 128){sb.append('0');}
                else{ sb.append('1');}
            }     
        }
        //sb.append("\n");
        String singleString = sb.toString();
        
        File file = new File(ruta);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(singleString);
        bw.close(); 

    }

    @FXML
    private void CargarPGMAction() throws IOException {   
        System.out.println("pgm");
        
        File myFile = new File("src/processing/Output/GetPath.txt");
        String absolute_path = myFile.getAbsolutePath();
        StringBuilder str = new StringBuilder(absolute_path.substring(0, absolute_path.length() - 11));
        //System.out.println(str);
        str.append(outpath.getText());
        str.append(".pgm");
        
        //System.out.println(str.toString());
        String ruta = str.toString();
        
        String contenido = "P2\n";
        StringBuilder sb = new StringBuilder(contenido);
        
        sb.append("#COMENTARIO ");
        sb.append("\n");
        
        sb.append(Integer.toString(im.getWidth()));
        sb.append(" ");
        sb.append(Integer.toString(im.getHeight()));
        sb.append("\n");

        int [] chain = new int[(im.getHeight()*im.getWidth())+im.getWidth()];
        int c = 0;
        int max_value = 0;
        for(int i = 0; i<im.getHeight(); i++){
            for(int j = 0; j<im.getWidth(); j++){         
                Color imColor = new Color(im.getRGB(j,i));         
                chain[c] = (int) (imColor.getRed() + imColor.getGreen() + imColor.getBlue())/3;
                c++;          
            }
            chain[c] = -1;
            c++;
        }
        max_value = may;
        sb.append(Integer.toString(max_value));
        sb.append("\n");
        
        for (int a : chain) {
            if (a == -1){
                sb.append("\n");
                continue;
            }
            sb.append(a*max_value/255);
            sb.append(" ");
        }
        sb.append("\n");
        
        String singleString = sb.toString();
        
        File file = new File(ruta);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(singleString);
        bw.close();

    }

    @FXML
    private void CargarPPMAction(ActionEvent event) throws IOException {
        System.out.println("ppm");
        
        File myFile = new File("src/processing/Output/GetPath.txt");
        String absolute_path = myFile.getAbsolutePath();
        StringBuilder str = new StringBuilder(absolute_path.substring(0, absolute_path.length() - 11));
        //System.out.println(str);
        str.append(outpath.getText());
        str.append(".ppm");
        
        //System.out.println(str.toString());
        String ruta = str.toString();
        
        if (check_format(240) == 1){
            CargarPGMAction();
            return;
        }

        String contenido = "P3\n";
        StringBuilder sb = new StringBuilder(contenido);
        
        sb.append("#COMENTARIO ");
        sb.append("\n");
        
        sb.append(Integer.toString(im.getWidth()));
        sb.append(" ");
        sb.append(Integer.toString(im.getHeight()));
        sb.append("\n");

        //System.out.println(sb);
        int [] chain = new int[(im.getHeight()*im.getWidth()*3)+im.getWidth()];
        int c = 0;
        int max_value = 0;
        for(int i = 0; i<im.getHeight(); i++){
            for(int j = 0; j<im.getWidth(); j++){ 
                
                Color imColor = new Color(im.getRGB(j,i));           
                chain[c] = imColor.getRed();
                c++;         
                chain[c] = imColor.getGreen();
                c++;              
                chain[c] = imColor.getBlue();
                c++;
               
            }
            chain[c] = -1;
            c++;
        }
        max_value = may;
        sb.append(Integer.toString(max_value));
        sb.append("\n");
        
        for (int a : chain) {
            if (a == -1){
                sb.append("\n");
                continue;
            }
            sb.append(a*max_value/255);
            sb.append(" ");
        }
        sb.append("\n");
        
        String singleString = sb.toString();
        
        File file = new File(ruta);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(singleString);
        bw.close();

    }

    @FXML
    private void CargarOtrosAction() throws IOException {
        esNetpbm = 0;
        String path = ipath.getText();
        im = ImageIO.read(new File(path)); 
        view1.setImage(SwingFXUtils.toFXImage(im,null));
        view2.setImage(SwingFXUtils.toFXImage(im,null));
    }
    
    @FXML
    private void originalButtomAction(MouseEvent event)  throws IOException {
        String path = ipath.getText();
        
        if (esNetpbm == 1){
            CargarOtrosAction();
        }
        else{
            CargarAction();
        }
        
    }

    @FXML
    private int DetallesButton() throws IOException {
        
        List<String> l = new ArrayList<String>();
        for(int i = 0; i<im.getHeight(); i++){
            for(int j = 0; j<im.getWidth(); j++){
                String color = Integer.toString(im.getRGB(j,i));
                l.add(color);
            }
         }
        Set<String> uniquec = new HashSet<String>(l);
        int nro = uniquec.size();
        int dpi = 0;

        if (check_format(230) == 1) nro = 8;
        else if (nro == 2) nro = 1;
        else nro = 24;
                
        Pane layout_imagen = new Pane(); 
        Stage mostrar = new Stage();
        
        mostrar.setTitle("Histogramas");
        mostrar.setScene(new Scene(layout_imagen));
        
        layout_imagen.setPrefSize(300,130);
        layout_imagen.setStyle("-fx-background-color: #222222;" +
                                "-fx-text-fill: #8d8888");
        
        Label label_dim = new Label("Height: "+ im.getHeight() + "  Width: " +im.getWidth());
        label_dim.setLayoutX(20);
        label_dim.setLayoutY(20); 
        label_dim.setStyle("-fx-text-fill: #8d8888");   
        
        Label label_num = new Label("Bits per pixel: " + nro); 
        label_num.setLayoutX(20);
        label_num.setLayoutY(50); 
        label_num.setStyle("-fx-text-fill: #8d8888");  
        
        Label label_dpi = new Label("Dots per inch: -/-"); 
        label_dpi.setLayoutX(20);
        label_dpi.setLayoutY(80); 
        label_dpi.setStyle("-fx-text-fill: #8d8888");   

        
        layout_imagen.getChildren().add(label_dim);  
        layout_imagen.getChildren().add(label_num); 
        layout_imagen.getChildren().add(label_dpi);
        
        mostrar.show();
        return nro;
    }

    @FXML
    private void HistogramaButton(ActionEvent event) throws IOException {
 
        int [][] count = new int[256][4];
        int c = 0;
        int iguales = 0;
        int max_red = 0;
        int max_green = 0;
        int max_blue = 0;
        int max_grey = 0;
        
        for(int i = 0; i<im.getHeight(); i++){
            for(int j = 0; j<im.getWidth(); j++){ 
                Color imColor = new Color(im.getRGB(j,i));         
                count[(int) imColor.getRed()][0] ++;
                count[(int) imColor.getGreen()][1] ++;
                count[(int) imColor.getBlue()][2] ++;  
                count[(int) (imColor.getBlue()+imColor.getGreen()+imColor.getRed())/3][3] ++;  
                
                if ((int) imColor.getRed() == (int) imColor.getGreen()){
                    if ((int) imColor.getRed() == (int) imColor.getBlue()) 
                        iguales++;
                }             
                max_red =  max(max_red,count[(int) imColor.getRed()][0]);
                max_green =  max(max_green,count[(int) imColor.getGreen()][1]);
                max_blue =  max(max_blue,count[(int) imColor.getBlue()][2]);
                max_grey = max(max_grey,count[(int) (imColor.getBlue()+imColor.getGreen()+imColor.getRed())/3][3]);   
            }
        }
        int max_value = max(max_red,max(max_green,max(max_blue,max_grey)));
        BufferedImage imred = new BufferedImage(256, 151, BufferedImage.TYPE_INT_RGB);
        BufferedImage imgreen = new BufferedImage(256, 151, BufferedImage.TYPE_INT_RGB);
        BufferedImage imblue = new BufferedImage(256, 151, BufferedImage.TYPE_INT_RGB);   
        BufferedImage imgrey = new BufferedImage(256, 151, BufferedImage.TYPE_INT_RGB);   

        //int max_frec = max();
        
        int same = 0;
        for(int i = 0; i<256; i++){
            if (abs(count[i][0]-count[i][3])<5)same++;
        }

        
        for(int i = 0; i<imred.getHeight(); i++){
            for(int j = 0; j<imred.getWidth(); j++){ 
                Color newColor;
                if (count[j][0]<=i){newColor = new Color(242,116,116);}
                else{newColor = new Color(162,162,162);}
                imred.setRGB(j,i,newColor.getRGB());
                
                if (count[j][1]<=i){newColor = new Color(127,191,127);}
                else{newColor = new Color(162,162,162);}
                imgreen.setRGB(j,i,newColor.getRGB());
                
                if (count[j][2]<=i){newColor = new Color(121,171,205);}
                else{newColor = new Color(162,162,162);}
                imblue.setRGB(j,i,newColor.getRGB());
               
                if (count[j][3]<=i){newColor = new Color(76,76,76);}
                else{newColor = new Color(162,162,162);}
                imgrey.setRGB(j,i,newColor.getRGB());
            }
        }
        
        Pane layout_imagen = new Pane(); 
        Stage mostrar = new Stage();
        
        mostrar.setTitle("Histogramas");
        mostrar.setScene(new Scene(layout_imagen));
        
        layout_imagen.setPrefSize(580,370);
        layout_imagen.setStyle("-fx-background-color: #222222;");
        
        ImageView igreen = new ImageView();
        igreen.setImage(SwingFXUtils.toFXImage(imgreen,null));
        igreen.setLayoutX(20);
        igreen.setLayoutY(200);
        
        ImageView iblue = new ImageView();
        iblue.setImage(SwingFXUtils.toFXImage(imblue,null));
        iblue.setLayoutX(300);
        iblue.setLayoutY(200);
        
        ImageView igrey = new ImageView();
        igrey.setImage(SwingFXUtils.toFXImage(imgrey,null));
        igrey.setLayoutX(20);
        igrey.setLayoutY(20); 
        
        ImageView ired = new ImageView();
        ired.setImage(SwingFXUtils.toFXImage(imred,null)); 
        ired.setLayoutX(300);
        ired.setLayoutY(20); 
        
        Label label1 = new Label("Canal gris");
        label1.setLayoutX(20);
        label1.setLayoutY(170); 
        label1.setStyle("-fx-text-fill: #8d8888");   
        
        Label label2 = new Label("Canal verde"); 
        label2.setLayoutX(20);
        label2.setLayoutY(350); 
        label2.setStyle("-fx-text-fill: #8d8888");  
        
        Label label3 = new Label("Canal rojo"); 
        label3.setLayoutX(300);
        label3.setLayoutY(170); 
        label3.setStyle("-fx-text-fill: #8d8888");   
        
        Label label4 = new Label("Canal azul"); 
        label4.setLayoutX(300);
        label4.setLayoutY(350); 
        label4.setStyle("-fx-text-fill: #8d8888");   
        
        layout_imagen.getChildren().add(igreen);       
        layout_imagen.getChildren().add(ired);
        layout_imagen.getChildren().add(iblue);  
        layout_imagen.getChildren().add(igrey); 

        layout_imagen.getChildren().add(label1);       
        layout_imagen.getChildren().add(label2);  
        layout_imagen.getChildren().add(label3);   
        layout_imagen.getChildren().add(label4);   
        
        mostrar.show();

    }

    
    @FXML
    private void zoomVecinos(MouseEvent event)  throws IOException {
        double n = (double) sliderVecinos.getValue();
        int dim_col = (int) (n*im.getWidth());
        int dim_row = (int) (n*im.getHeight());  
 
        Kim = new BufferedImage(dim_col,dim_row, BufferedImage.TYPE_INT_RGB);      

        for(int i = 0; i<Kim.getHeight(); i++){
            for(int j = 0; j<Kim.getWidth(); j++){
                Kim.setRGB(j,i,im.getRGB((int) (j/n),(int) (i/n)));
            }
         }   
        view1.setImage(SwingFXUtils.toFXImage(Kim,null));  
    }

    @FXML
    private void zoomInterpolacion(MouseEvent event)  throws IOException {
        double n = (double) sliderInterpolacion.getValue();     
               
        int dim_col = (int) (n*im.getWidth());
        int dim_row = (int) (n*im.getHeight());  
        
        Kim = new BufferedImage(dim_col,dim_row, BufferedImage.TYPE_INT_RGB);


        int ker[][] = { {1,3},
                        {2,4}};
        
        int pi = 0;
        int pj = 0;
        int der = 1;
        int izq = 0; 
        int down = 1;
        int up = 0;       
        
        for(int i = 0; i < (int) Kim.getHeight()-1; i++){
            for(int j = 0; j < (int) Kim.getWidth()-1; j++){ 
                
                double pixr = 0.0;
                double pixg = 0.0;
                double pixb = 0.0;
                for(int a = 0; a < 2; a++){ //kernel filas

                    if (((Kim.getHeight() - 1 - i) - (a - pi)) < 0) continue;

                    for(int e = 0; e <  2; e++){  //kernel columnas

                        if (((Kim.getWidth() - 1 - j) - (e - pj)) < 0)continue;
                        
                        int intj =  (int) Math.floor(j/n);
                        int inti = (int) Math.floor(i/n);

                        Color imColor = new Color(im.getRGB(intj+e-pj,inti+a-pi));               

                        double aa =  (double) i/n - inti;
                        double bb =  (double) j/n - intj;
                        

                        if (ker[a][e] == 1){
//                            System.out.println("is");
                            pixr +=  (double) imColor.getRed() * (1-aa) * (1-bb);
                            pixg +=  (double) imColor.getGreen() * (1-aa) * (1-bb);
                            pixb +=  (double) imColor.getBlue() * (1-aa) * (1-bb);
                        }
                        else if (ker[a][e] == 2){
//                            System.out.println("sd");
                            pixr +=  (double) imColor.getRed() * aa * (1-bb);
                            pixg +=  (double) imColor.getGreen() * aa * (1-bb);
                            pixb +=  (double) imColor.getBlue() * aa * (1-bb);
                        }
                        else if (ker[a][e] == 3){
//                            System.out.println("ir");               
                            pixr +=  (double) imColor.getRed() * (1-aa) * bb;
                            pixg +=  (double) imColor.getGreen() * (1-aa) * bb;
                            pixb +=  (double) imColor.getBlue() * (1-aa) * bb;
                        }
                        else if (ker[a][e] == 4){
//                            System.out.println("dr"); 
                            pixr +=  (double) imColor.getRed() * aa * bb;  
                            pixg +=  (double) imColor.getGreen() * aa * bb;  
                            pixb +=  (double) imColor.getBlue()  * aa * bb;  
                        }
                    } 
                }
                  
                if (pixr < 0)  pixr = 0;
                else if (pixr > 255) pixr = 255;
                
                if (pixg < 0)  pixg = 0;
                else if (pixg > 255) pixg = 255;                
                 
                if (pixb < 0)  pixb = 0;
                else if (pixb > 255) pixb = 255;               

                

                Color newColor = new Color((int)pixr,(int)pixg,(int)pixb);
                Kim.setRGB(j,i, newColor.getRGB());
            }
         }    
        view1.setImage(SwingFXUtils.toFXImage(Kim,null));           

    }
    

    @FXML
    private void CargarBMPAction(ActionEvent event) throws IOException {
        
        System.out.println("otros");
        
        File myFile = new File("src/processing/Output/GetPath.txt");
        String absolute_path = myFile.getAbsolutePath();
        StringBuilder str = new StringBuilder(absolute_path.substring(0, absolute_path.length() - 11));
        //System.out.println(str);
        str.append(outpath.getText());
        
        //System.out.println(str.toString());
        String ruta = str.toString();
        
        File file = new File(ruta);
        if (!file.exists()) {
            file.createNewFile();
        }
        ImageIO.write(im, "png", file);
    }

    @FXML
    private void anyKernelActionButton(ActionEvent event) throws IOException {
        
        int dim_row = (int) nrowKer.getValue();
        int dim_col = (int) ncolKer.getValue();
      
        int pi = (int) dim_row/2;
        int pj = (int) dim_col/2;

        int n = dim_row*dim_col;
        double ker[][] = new double[dim_row][dim_col];
                
        
        GridPane gridpane = new GridPane();
        TextField[] cell = new TextField[n];
        int c = 0;
        for(int o=0; o < dim_row; o++){
            for(int u=0; u < dim_col; u++){
                cell[c] = new TextField("1");
                gridpane.add(cell[c], o, u);
                c++;
            }
        }
        
        Button sendKernel = new Button();
        sendKernel.setText("Enviar Kernel");
        sendKernel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int c = 0;
                int div = 0;
                for(int o=0; o<dim_row; o++){
                    for(int u=0; u<dim_col; u++){
                        ker[u][o] = Double.parseDouble(cell[c].getText());
                        System.out.println(ker[u][o]);
                        div += abs(ker[u][o]);
                        c++;
                    }
                }
                
                int der = dim_col - 1 - pj;
                int izq = dim_col - 1 - (der); 
                int down = dim_row - 1 - pi;
                int up = dim_row - 1 - (down);

                Kim = new BufferedImage(im.getWidth(), im.getHeight(), BufferedImage.TYPE_INT_RGB);
                int h = dim_row;
                int w = dim_col;

                for(int i = 0; i < (int) im.getHeight(); i++){
                    for(int j = 0; j < (int) im.getWidth(); j++){  

                        double pixr = 0;
                        double pixg = 0;
                        double pixb = 0;

                        for(int a = (int) max(0,up - i); a < h; a++){

                            if (((im.getHeight() - 1 - i) - (a - pi)) < 0) continue;

                            for(int e = (int)  max(0, izq - j); e <  w; e++){ 

                                if (((im.getWidth() - 1 - j) - (e - pj)) < 0)continue;

                                Color imColor = new Color(im.getRGB(j+ (e-pj), i+ (a-pi)));

                                pixr +=  imColor.getRed() * ker[a][e];
                                pixg +=  imColor.getGreen() * ker[a][e];
                                pixb +=  imColor.getBlue() * ker[a][e];

                            }   
                        }
                        if (pixr < 0) pixr = 0;
                        else if (pixr > 255) pixr = 255;

                        if (pixg < 0) pixg = 0;
                        else if (pixg > 255) pixg = 255;

                        if (pixb < 0) pixb = 0;
                        else if (pixb > 255) pixb = 255;  

                        Color newColor = new Color((int) pixr/div,(int) pixg/div,(int) pixb/div);
                        Kim.setRGB(j,i, newColor.getRGB());
                    }
                 } 
                view1.setImage(SwingFXUtils.toFXImage(Kim,null));
            }
        });
        

        StackPane layout_imagen = new StackPane(); 
        Stage mostrar = new Stage();

        mostrar.setTitle("Kernel Personalizado");
        mostrar.setScene(new Scene(layout_imagen, 450, 450));

        layout_imagen.getChildren().add(gridpane);
        layout_imagen.getChildren().add(sendKernel); 
        mostrar.show(); 
    }

    @FXML
    private void OptionBMP(ActionEvent event)  throws IOException {
        File myFile = new File("src/processing/Test/doggie.bmp");
        String absolute_path = myFile.getAbsolutePath();
        //System.out.println(absolute_path);
        ipath.setText(absolute_path);
        im = ImageIO.read(new File(absolute_path));
        view1.setImage(SwingFXUtils.toFXImage(im,null)); 
    }

    @FXML
    private void OptionPBM(ActionEvent event)  throws IOException {
        File myFile = new File("src/processing/Test/NewImage.pbm");
        String absolute_path = myFile.getAbsolutePath();
        //System.out.println(absolute_path);
        ipath.setText(absolute_path);
        CargarAction();     
    }

    @FXML
    private void OptionPGM(ActionEvent event)  throws IOException {
        File myFile = new File("src/processing/Test/NewImage.pgm");
        String absolute_path = myFile.getAbsolutePath();
        //System.out.println(absolute_path);
        ipath.setText(absolute_path);
        CargarAction();
    }

    @FXML
    private void OptionPPM(ActionEvent event)  throws IOException {
        File myFile = new File("src/processing/Test/NewImage.ppm");
        String absolute_path = myFile.getAbsolutePath();
        //System.out.println(absolute_path);
        ipath.setText(absolute_path);
        CargarAction();       
    }

    @FXML
    private void FijarFiltro(MouseEvent event) throws IOException {
        im = Kim;
    }

    
}
