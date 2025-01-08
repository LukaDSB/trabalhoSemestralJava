import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import biblioteca.Aluno;
import biblioteca.Livro;
import biblioteca.Reserva;
import acesso.Usuario;

public class Principal {

    private static final List<Aluno> consumidores = new ArrayList<>();

    private static final List<Livro> livrosDisponiveis = new ArrayList<>();

    public static void main(String[] args) {
        if (autenticarUsuario()) {
            livrosDisponiveis.addAll(Livro.listar(Livro.class)); 
            exibirTelaPrincipal();
        } else {
            JOptionPane.showMessageDialog(null, "Acesso negado. O programa será encerrado.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    private static boolean autenticarUsuario() {
        String usuarioLogin = JOptionPane.showInputDialog(null,
                "Informe o seu login:",
                "Entrada de Dados",
                JOptionPane.QUESTION_MESSAGE);

        String usuarioSenha = JOptionPane.showInputDialog(null,
                "Informe a sua senha:",
                "Entrada de Dados",
                JOptionPane.QUESTION_MESSAGE);

        if (usuarioLogin != null && usuarioSenha != null) {
            if (Usuario.autenticarAluno(usuarioLogin, usuarioSenha)) {
                JOptionPane.showMessageDialog(null,
                        "Login bem-sucedido! Bem-vindo, " + usuarioLogin + "!",
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Usuário ou senha inválidos.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        JOptionPane.showMessageDialog(null,
                "Nenhum login foi inserido. O programa será encerrado.",
                "Aviso", JOptionPane.WARNING_MESSAGE);
        return false;
    }

    private static void exibirTelaPrincipal() {
        JFrame frame = new JFrame("Sistema Bibliotecário | v1.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 80);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 4, 10, 10));

        JLabel label = new JLabel("  Selecione a opção desejada:");
        frame.add(label, BorderLayout.NORTH);

        JButton btnCadastrarConsumidor = new JButton("Cadastrar Consumidor");
        btnCadastrarConsumidor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Aluno> alunos = Usuario.listar(Aluno.class);

                alunos.removeAll(consumidores);

                if (alunos.isEmpty()) {
                    JOptionPane.showMessageDialog(frame,
                            "Nenhum aluno disponível para cadastrar.",
                            "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String[] nomesAlunos = alunos.stream().map(Aluno::getNome).toArray(String[]::new);

                JComboBox<String> comboBox = new JComboBox<>(nomesAlunos);

                JPanel panel = new JPanel(new BorderLayout());
                panel.add(new JLabel("Selecione um aluno para cadastrar como consumidor:"), BorderLayout.NORTH);
                panel.add(comboBox, BorderLayout.CENTER);

                int resultado = JOptionPane.showConfirmDialog(frame, panel, "Cadastrar Consumidor",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (resultado == JOptionPane.OK_OPTION) {
                    int indexSelecionado = comboBox.getSelectedIndex();
                    Aluno alunoSelecionado = alunos.get(indexSelecionado);

                    consumidores.add(alunoSelecionado);
                    JOptionPane.showMessageDialog(frame,
                            "Aluno " + alunoSelecionado.getNome() + " foi cadastrado como consumidor com sucesso.",
                            "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        JButton btnRemoverConsumidor = new JButton("Remover Consumidor");
        btnRemoverConsumidor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (consumidores.isEmpty()) {
                    JOptionPane.showMessageDialog(frame,
                            "Nenhum consumidor cadastrado para remover.",
                            "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String[] nomesConsumidores = consumidores.stream().map(Aluno::getNome).toArray(String[]::new);

                JComboBox<String> comboBox = new JComboBox<>(nomesConsumidores);

                JPanel panel = new JPanel(new BorderLayout());
                panel.add(new JLabel("Selecione um consumidor para remover:"), BorderLayout.NORTH);
                panel.add(comboBox, BorderLayout.CENTER);

                int resultado = JOptionPane.showConfirmDialog(frame, panel, "Remover Consumidor",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (resultado == JOptionPane.OK_OPTION) {
                    int indexSelecionado = comboBox.getSelectedIndex();
                    Aluno consumidorSelecionado = consumidores.get(indexSelecionado);
                    consumidores.remove(consumidorSelecionado);

                    JOptionPane.showMessageDialog(frame,
                            "Consumidor " + consumidorSelecionado.getNome() + " foi removido com sucesso.",
                            "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

          JButton btnCadastrarReserva = new JButton("Cadastrar Reserva");
        btnCadastrarReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (consumidores.isEmpty()) {
                    JOptionPane.showMessageDialog(frame,
                            "Nenhum consumidor cadastrado disponível para reservar um livro.",
                            "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (livrosDisponiveis.isEmpty()) {
                    JOptionPane.showMessageDialog(frame,
                            "Nenhum livro disponível para reserva.",
                            "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String[] nomesConsumidores = consumidores.stream().map(Aluno::getNome).toArray(String[]::new);
                JComboBox<String> dropdownConsumidores = new JComboBox<>(nomesConsumidores);

                String[] titulosLivros = livrosDisponiveis.stream().map(Livro::getTitulo).toArray(String[]::new);
                JComboBox<String> dropdownLivros = new JComboBox<>(titulosLivros);

                JPanel panel = new JPanel(new GridLayout(3, 1));
                panel.add(new JLabel("Selecione o consumidor:"));
                panel.add(dropdownConsumidores);
                panel.add(new JLabel("Selecione o livro:"));
                panel.add(dropdownLivros);

                int resultado = JOptionPane.showConfirmDialog(frame, panel, "Cadastrar Reserva",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (resultado == JOptionPane.OK_OPTION) {
                    int consumidorIndex = dropdownConsumidores.getSelectedIndex();
                    int livroIndex = dropdownLivros.getSelectedIndex();

                    if (consumidorIndex < 0 || livroIndex < 0) {
                        JOptionPane.showMessageDialog(frame,
                                "É necessário selecionar um consumidor e um livro para prosseguir.",
                                "Erro",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Aluno consumidorSelecionado = consumidores.get(consumidorIndex);
                    Livro livroSelecionado = livrosDisponiveis.get(livroIndex);

                    String dataAtual = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    Reserva novaReserva = new Reserva(dataAtual, List.of(livroSelecionado.getTitulo()));
                    consumidorSelecionado.cadastrarReserva(List.of(livroSelecionado.getTitulo()), dataAtual);

                    livrosDisponiveis.remove(livroSelecionado);

                    String mensagem = "Reserva cadastrada com sucesso!\n" +
                            "Livro reservado: " + livroSelecionado.getTitulo() + "\n" +
                            "Autor: " + livroSelecionado.getAutor() + "\n" +
                            "Consumidor: " + consumidorSelecionado.getNome() + "\n" +
                            "Classe: " + consumidorSelecionado.getClass().getSimpleName() + "\n" +
                            "Data: " + dataAtual;

                    JOptionPane.showMessageDialog(frame,
                            mensagem,
                            "Reserva Cadastrada",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(frame,
                    "Tem certeza de que deseja sair?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (confirm == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(frame, "Sistema encerrado. Até logo!", "Adeus", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });

        panel.add(btnCadastrarConsumidor);
        panel.add(btnRemoverConsumidor);
        panel.add(btnCadastrarReserva);
        panel.add(btnSair);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

