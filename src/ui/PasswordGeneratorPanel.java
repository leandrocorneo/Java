package ui;

import calculadora.PasswordGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PasswordGeneratorPanel extends JPanel {
    private JCheckBox maiusculas, minusculas, numeros, simbolos;
    private JSpinner tamanhoSpinner;
    private JButton gerarBtn;
    private JTextField senhaField;

    public PasswordGeneratorPanel() {
        setBorder(BorderFactory.createTitledBorder("Gerador de Senha"));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        maiusculas = new JCheckBox("Maiúsculas", true);
        minusculas = new JCheckBox("Minúsculas", true);
        numeros = new JCheckBox("Números", true);
        simbolos = new JCheckBox("Símbolos", true);

        gbc.gridx = 0; gbc.gridy = 0;
        add(maiusculas, gbc);
        gbc.gridx = 1;
        add(minusculas, gbc);
        gbc.gridx = 0; gbc.gridy = 1;
        add(numeros, gbc);
        gbc.gridx = 1;
        add(simbolos, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Tamanho"), gbc);

        tamanhoSpinner = new JSpinner(new SpinnerNumberModel(8, 4, 50, 1));
        gbc.gridx = 1;
        add(tamanhoSpinner, gbc);

        gerarBtn = new JButton("Gerar");
        gerarBtn.addActionListener(this::gerarSenha);
        gbc.gridx = 2;
        add(gerarBtn, gbc);

        senhaField = new JTextField(20);
        senhaField.setEditable(false);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 3;
        add(senhaField, gbc);
    }

    private void gerarSenha(ActionEvent e) {
        try {
            boolean upper = maiusculas.isSelected();
            boolean lower = minusculas.isSelected();
            boolean digits = numeros.isSelected();
            boolean special = simbolos.isSelected();
            int tamanho = (int) tamanhoSpinner.getValue();

            PasswordGenerator generator = new PasswordGenerator(upper, lower, digits, special);
            String senha = generator.gerar(tamanho);
            senhaField.setText(senha);

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
