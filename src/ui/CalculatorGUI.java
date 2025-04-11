package ui;

import calculadora.*;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class CalculatorGUI extends JFrame {
    private JComboBox<String> operacoesCombo;
    private JPanel camposPainel;
    private JButton calcularBtn;
    private JLabel resultadoLabel;

    private JCheckBox maiusculasBox, minusculasBox, numerosBox, simbolosBox;
    private HashMap<String, JTextField> campos = new HashMap<>();

    public CalculatorGUI() {
        setTitle("Calculadora de Porcentagens e Utilidades");
        setSize(600, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        String[] operacoes = {
            "Aplicar Desconto (% de A)",
            "Incrementar Valor (% de A)",
            "Amostragem 1 (X% de Y)",
            "Amostragem 2 (X é quantos % de Y)",
            "Valor era e paguei (quanto foi o desconto)",
            "Delta % (variação entre valores)",
            "Valor Original (antes do desconto)",
            "Regra de Três",
            "Gerador de Senhas"
        };

        operacoesCombo = new JComboBox<>(operacoes);
        operacoesCombo.addActionListener(e -> atualizarCampos());

        calcularBtn = new JButton("Calcular");
        calcularBtn.addActionListener(e -> realizarCalculo());

        resultadoLabel = new JLabel("Resultado: ");

        JPanel topo = new JPanel(new FlowLayout());
        topo.add(new JLabel("Operação:"));
        topo.add(operacoesCombo);

        camposPainel = new JPanel(new GridLayout(6, 2, 10, 10));
        camposPainel.setBorder(BorderFactory.createTitledBorder("Parâmetros"));

        JPanel rodape = new JPanel(new FlowLayout());
        rodape.add(calcularBtn);
        rodape.add(resultadoLabel);

        add(topo, BorderLayout.NORTH);
        add(camposPainel, BorderLayout.CENTER);
        add(rodape, BorderLayout.SOUTH);

        atualizarCampos();
    }

    private void atualizarCampos() {
        camposPainel.removeAll();
        campos.clear();

        String operacao = (String) operacoesCombo.getSelectedItem();

        switch (operacao) {
            case "Aplicar Desconto (% de A)" -> criarCampos("Valor", "Desconto (%)");
            case "Incrementar Valor (% de A)" -> criarCampos("Valor", "Acréscimo (%)");
            case "Amostragem 1 (X% de Y)" -> criarCampos("Porcentagem", "Total");
            case "Amostragem 2 (X é quantos % de Y)" -> criarCampos("Parte", "Total");
            case "Valor era e paguei (quanto foi o desconto)" -> criarCampos("Valor Original", "Valor Pago");
            case "Delta % (variação entre valores)" -> criarCampos("Valor Antigo", "Valor Novo");
            case "Valor Original (antes do desconto)" -> criarCampos("Valor com Desconto", "Desconto (%)");
            case "Regra de Três" -> criarCampos("A", "B", "C");
            case "Gerador de Senhas" -> criarCamposSenha();
        }

        camposPainel.revalidate();
        camposPainel.repaint();
    }

    private void criarCampos(String... nomes) {
        for (String nome : nomes) {
            JLabel label = new JLabel(nome + ":");
            JTextField campo = new JTextField(10);
            campos.put(nome, campo);
            camposPainel.add(label);
            camposPainel.add(campo);
        }
    }

    private void criarCamposSenha() {
        JLabel tamanhoLabel = new JLabel("Tamanho da Senha:");
        JTextField tamanhoField = new JTextField(10);
        campos.put("Tamanho", tamanhoField);

        maiusculasBox = new JCheckBox("Letras Maiúsculas");
        minusculasBox = new JCheckBox("Letras Minúsculas");
        numerosBox = new JCheckBox("Números");
        simbolosBox = new JCheckBox("Símbolos");

        camposPainel.add(tamanhoLabel);
        camposPainel.add(tamanhoField);
        camposPainel.add(maiusculasBox);
        camposPainel.add(minusculasBox);
        camposPainel.add(numerosBox);
        camposPainel.add(simbolosBox);
    }

    private void realizarCalculo() {
        try {
            String operacao = (String) operacoesCombo.getSelectedItem();
            Calcule calculo;
            double resultado;

            switch (operacao) {
                case "Aplicar Desconto (% de A)" -> {
                    calculo = new DiscountAply();
                    resultado = calculo.calcular(parseCampo("Valor"), parseCampo("Desconto (%)"));
                    resultadoLabel.setText("Resultado: " + String.format("%.2f", resultado));
                }
                case "Incrementar Valor (% de A)" -> {
                    calculo = new IncrementValue();
                    resultado = calculo.calcular(parseCampo("Valor"), parseCampo("Acréscimo (%)"));
                    resultadoLabel.setText("Resultado: " + String.format("%.2f", resultado));
                }
                case "Amostragem 1 (X% de Y)" -> {
                    calculo = new SamplingOne();
                    resultado = calculo.calcular(parseCampo("Porcentagem"), parseCampo("Total"));
                    resultadoLabel.setText("Resultado: " + String.format("%.2f", resultado));
                }
                case "Amostragem 2 (X é quantos % de Y)" -> {
                    calculo = new SamplingTwo();
                    resultado = calculo.calcular(parseCampo("Parte"), parseCampo("Total"));
                    resultadoLabel.setText("Resultado: " + String.format("%.2f", resultado));
                }
                case "Valor era e paguei (quanto foi o desconto)" -> {
                    calculo = new DiscountValue();
                    resultado = calculo.calcular(parseCampo("Valor Original"), parseCampo("Valor Pago"));
                    resultadoLabel.setText("Resultado: " + String.format("%.2f", resultado) + "%");
                }
                case "Delta % (variação entre valores)" -> {
                    calculo = new PercentageDelta();
                    resultado = calculo.calcular(parseCampo("Valor Antigo"), parseCampo("Valor Novo"));
                    resultadoLabel.setText("Resultado: " + String.format("%.2f", resultado) + "%");
                }
                case "Valor Original (antes do desconto)" -> {
                    calculo = new OriginalValue();
                    resultado = calculo.calcular(parseCampo("Valor com Desconto"), parseCampo("Desconto (%)"));
                    resultadoLabel.setText("Resultado: " + String.format("%.2f", resultado));
                }
                case "Regra de Três" -> {
                    calculo = new RuleOfThree();
                    resultado = calculo.calcular(parseCampo("A"), parseCampo("B"), parseCampo("C"));
                    resultadoLabel.setText("Resultado: " + String.format("%.2f", resultado));
                }
                case "Gerador de Senhas" -> {
                    int tamanho = (int) parseCampo("Tamanho");
                    PasswordGenerator generator = new PasswordGenerator(
                        maiusculasBox.isSelected(),
                        minusculasBox.isSelected(),
                        numerosBox.isSelected(),
                        simbolosBox.isSelected()
                    );
                    String senha = generator.gerar(tamanho);
                    resultadoLabel.setText("Senha: " + senha);
                }
                default -> throw new IllegalArgumentException("Operação inválida");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Preencha os campos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double parseCampo(String nome) {
        return Double.parseDouble(campos.get(nome).getText());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorGUI().setVisible(true));
    }
}
