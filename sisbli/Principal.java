import javax.swing.*;
import java.awt.*;
import biblioteca.LivroReservado;
import biblioteca.Aluno;
import acesso.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main(String[] args) {
        if (autenticarUsuario()) {
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

            List<LivroReservado> consumidores = new ArrayList<>();
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
                JOptionPane.showMessageDialog(frame, "Funcionalidade de Remoção de Consumidor em desenvolvimento!");
            }
        });

        JButton btnCadastrarReserva = new JButton("Cadastrar Reserva");
        btnCadastrarReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Funcionalidade de Cadastro de Reserva em desenvolvimento!");
            }
        });

        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resposta = JOptionPane.showConfirmDialog(frame, "Deseja realmente sair?", "Confirmação",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resposta == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
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
