package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    private JLabel husyLabel;
    private JLabel kraliciLabel;
    private JButton vypocitatButton;
    private JLabel pocetHlavLabel;
    private JLabel pocetNohouLabel;


    private JTextField husyField;
    private JTextField kraliciField;
    private JTextField pocetHlavField;
    private JTextField pocetNohouField;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        husyField = new JTextField();
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husyField);
        husyField.setHorizontalAlignment(JTextField.TRAILING);
        add(husyLabel);
        add(husyField);

        kraliciField = new JTextField();
        kraliciLabel = new JLabel("Kralici");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciField);
        kraliciField.setHorizontalAlignment(JTextField.TRAILING);
        add(kraliciLabel);
        add(kraliciField);

        vypocitatButton = new JButton("Vypočítat");
        vypocitatButton.setMnemonic('V');
        add(vypocitatButton, "right, span");

        pocetHlavField = new JTextField();
        pocetHlavLabel = new JLabel("Počet hlav");
        pocetHlavLabel.setDisplayedMnemonic('P');
        pocetHlavLabel.setLabelFor(pocetHlavField);
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        add(pocetHlavLabel);
        add(pocetHlavField);

        pocetNohouField = new JTextField();
        pocetNohouLabel = new JLabel("Počet nohou");
        pocetNohouLabel.setDisplayedMnemonic('P');
        pocetNohouLabel.setLabelFor(pocetNohouField);
        pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);
        add(pocetNohouLabel);
        add(pocetNohouField);

        pack();

        getRootPane().setDefaultButton(vypocitatButton);

        vypocitatButton.addActionListener(this::handleVypocitat);
    }


//METODA NA VÝPOČET HLAV A NOHOU
    private void handleVypocitat(ActionEvent actionEvent) {

            int pocetHus = Integer.parseInt(husyField.getText());
            int pocetKraliku = Integer.parseInt(kraliciField.getText());

            int pocetHlav = (pocetHus + pocetKraliku);
            int pocetNohou = (pocetHus * 2) + (pocetKraliku * 4);

            pocetHlavField.setText(Integer.toString(pocetHlav));
            pocetNohouField.setText(Integer.toString(pocetNohou));
    }
}
