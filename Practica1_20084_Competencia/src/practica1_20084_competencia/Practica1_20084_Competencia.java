package practica1_20084_competencia;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Practica1_20084_Competencia extends JFrame {
           Hilo1 hilo1;
           Hilo2 hilo2 ;
        public Practica1_20084_Competencia(){
                setSize(400,400);
                setTitle("Condiciones de competencias");
                MisComponentes();
        }
        private void MisComponentes(){
                JButton  JBRun = new JButton("Run");
                JButton JBPausa = new JButton("Pausa");
                JButton JBDetener = new JButton("Detener");
                JLabel JLHilo1 = new JLabel("Hilo1");
                JLabel JLHilo2 = new JLabel("Hilo 2");
                JTextArea JTHilo1 = new JTextArea();
                JTextArea JTHilo2 = new JTextArea();
                JScrollPane JPHilo1 = new JScrollPane(JTHilo1);
                JScrollPane JPHilo2 = new JScrollPane(JTHilo2);
                setLayout(null);
                
                JBRun.setBounds(10, 100, 100, 25);
                JBPausa.setBounds(10, 150, 100, 25);
                JBDetener.setBounds(10,200,100,25);
                
                JLHilo1.setBounds(180,10,100,50);
                JLHilo2.setBounds(280,10,100,50);
                JPHilo1.setBounds(140,50,100,300);
                JPHilo2.setBounds(250,50,100,300);
                add(JBRun);
                add(JBPausa);
                add(JBDetener);
                add(JLHilo1);
                add(JLHilo2);
                add(JPHilo1);
                add(JPHilo2);
                JBRun.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                                hilo1 = new Hilo1(JTHilo1);
                                hilo2 = new Hilo2(JTHilo2);
                                hilo1.start();
                                hilo2.start();
                        }
                 });
                 JBPausa.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                               if(JBPausa.getText().equals("Reanudar")){
                                        hilo1.reanudarhilo();
                                        hilo2.reanudarhilo();
                                        JBPausa.setText("Pausar");
                                }else{
                                        hilo1.pausarrhilo();
                                        hilo2.pausarrhilo();
                                        JBPausa.setText("Reanudar");
                                }     
                        }
                 });
                  JBDetener.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                                hilo1.detenerhilo();
                                hilo2.detenerhilo();
                                JTHilo1.setText("");
                                JTHilo2.setText("");
                        }
                 });
                
        }
        public static void main(String[] args) {
                Practica1_20084_Competencia miVentana = new Practica1_20084_Competencia();
                miVentana.setVisible(true);
                miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }      
        
}
