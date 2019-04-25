package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMI extends JFrame {

    private JTextField Weight= new JTextField();
    private JTextField Height = new JTextField();
    private JLabel BMI = new JLabel();

    private JLabel W= new JLabel();
    private JLabel H= new JLabel();

    private JRadioButton M= new JRadioButton("Metric");
    private JRadioButton I= new JRadioButton("Imperial");

    public BMI(){
        this.setTitle("BMI Calculator");
        this.setSize(500,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JButton CheckBMI = new JButton("Check Metric BMI");
        CheckBMI.addActionListener(new BMIListener());
        JButton CheckIMBMI = new JButton("Check Imperial BMI");
        CheckIMBMI.addActionListener(new BMIListener2());
        JButton Clear= new JButton("Clear");
        Clear.addActionListener(new clearscreen());

        ButtonGroup unitsgroup = new ButtonGroup();

        M.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                W.setText("Weight (kg)");
                H.setText("Height (m)");

            }
        });
        I.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                W.setText("Weight (lb)");
                H.setText("Height (in)");

            }
        });
        unitsgroup.add(M);
        unitsgroup.add(I);


        JLabel result = new JLabel("Your BMI is: ");


        JPanel panel1= new JPanel();
        panel1.setLayout(new GridLayout(3,3));
        JPanel panel2= new JPanel();
        panel2.setLayout(new GridLayout(3,1));
        JPanel panel3= new JPanel();
        panel3.setLayout(new GridLayout(1,2));


        panel1.add(W);
        panel1.add(Weight);
        panel1.add(H);
        panel1.add(Height);
        panel1.add(result);
        panel1.add(BMI);



        panel2.add(CheckBMI);
        panel2.add(CheckIMBMI);
        panel2.add(Clear);

        panel3.add(M);
        panel3.add(I);

        this.add(panel1,BorderLayout.CENTER);
        this.add(panel2,BorderLayout.SOUTH);
        this.add(panel3,BorderLayout.NORTH);

        this.setVisible(true);
    }
    private class BMIListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double kilograms= Double.parseDouble(Weight.getText());
            double meters = Double.parseDouble(Height.getText());
            double bmi= (double)computeBMI(kilograms,meters);


            if(bmi<18.5){
                BMI.setText(""+ bmi + " Underweight");
            }else if(bmi>=18.5&&bmi<25){
                BMI.setText(""+ bmi + " Normal");
            }else if(bmi>=25&&bmi<30){
                BMI.setText(""+ bmi + " Overweight");
            }else if(bmi>=30){
                BMI.setText(""+ bmi + " Obese");
            }

    }
    }
    public static double computeBMI(double weight, double height){
        return weight/(height*height);
    }
    private class clearscreen implements ActionListener{
       public void actionPerformed(ActionEvent e){
            Weight.setText("");
            Height.setText("");
            BMI.setText("");
        }
    }

    private class BMIListener2 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double pounds= Double.parseDouble(Weight.getText());
            double inches= Double.parseDouble(Height.getText());
            double bmi=(double)computeBMI2(pounds,inches);

            if(bmi<18.5){
                BMI.setText(""+ bmi + " Underweight");
            }else if(bmi>=18.5&&bmi<25){
                BMI.setText(""+ bmi + " Normal");
            }else if(bmi>=25&&bmi<30){
                BMI.setText(""+ bmi + " Overweight");
            }else if(bmi>=30){
                BMI.setText(""+ bmi + " Obese");
            }
        }
    }
public static double computeBMI2(double weight, double height){
        return weight/(height*height) * 703;
}
}
