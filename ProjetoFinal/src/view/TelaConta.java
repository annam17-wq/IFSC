package view;

import model.Atleta;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TelaConta extends JFrame {

    public TelaConta() {
        setTitle("Minha Conta - Detalhes do Atleta");
        setSize(650, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Alterado de EXIT_ON_CLOSE para evitar derrubar a tela de fundo

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setBackground(new Color(240, 240, 240));
        painelPrincipal.setLayout(new GridBagLayout());
        painelPrincipal.setBorder(new EmptyBorder(20, 30, 20, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        gbc.insets = new Insets(0, 0, 15, 0);

        // Formatação correta para dados numéricos
        String cpfFormatado = (Atleta.cpf != 0) ? String.format("%011d", Atleta.cpf) : "";
        String telefoneFormatado = (Atleta.telefone != 0) ? String.valueOf(Atleta.telefone) : "";
        String cepFormatado = (Atleta.cep != 0) ? String.format("%08d", Atleta.cep) : "";
        String matriculaFormatada = (Atleta.matricula != 0) ? String.valueOf(Atleta.matricula) : "";

        // Secção 1: Dados Pessoais
        painelPrincipal.add(criarDivisoriaSecao("Dados Pessoais"), gbc);
        gbc.gridy++;
        painelPrincipal.add(criarPainelDados(new String[][]{
            {"Nome:", Atleta.nome},
            {"Data de Nascimento:", Atleta.dataNascimento},
            {"CPF:", cpfFormatado},
            {"Telefone:", telefoneFormatado},
            {"Modalidade:", Atleta.modalidade},
            {"Sexo:", Atleta.sexo}
        }), gbc);
        gbc.gridy++;

        // Secção 2: Endereço
        painelPrincipal.add(criarDivisoriaSecao("Endereço"), gbc);
        gbc.gridy++;
        painelPrincipal.add(criarPainelDados(new String[][]{
            {"País:", Atleta.pais},
            {"Estado:", Atleta.estado},
            {"Cidade:", Atleta.cidade},
            {"Bairro:", Atleta.bairro},
            {"Rua:", Atleta.rua + (Atleta.numero != 0 ? ", Nº " + Atleta.numero : "")},
            {"CEP:", cepFormatado}
        }), gbc);
        gbc.gridy++;

        // Secção 3: Informações Técnicas
        painelPrincipal.add(criarDivisoriaSecao("Informações Técnicas de Atleta"), gbc);
        gbc.gridy++;
        painelPrincipal.add(criarPainelDados(new String[][]{
            {"Categoria:", Atleta.categoria},
            {"Peso:", Atleta.peso != 0.0 ? Atleta.peso + " kg" : ""},
            {"Altura:", Atleta.altura != 0.0 ? Atleta.altura + " m" : ""},
            {"Data Associação:", Atleta.associacao},
            {"Matrícula:", matriculaFormatada},
            {"Posição/Função:", Atleta.posicao},
            {"Equipe:", Atleta.equipe},
            {"Observações:", Atleta.observacoes}
        }), gbc);
        gbc.gridy++;

        // --- Painel de Botões Ações do Usuário ---
        JPanel painelBotao = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        painelBotao.setOpaque(false);
        
        JButton btnEditar = new JButton("Editar Informações");
        btnEditar.setPreferredSize(new Dimension(180, 35));
        btnEditar.setFont(new Font("Tahoma", Font.BOLD, 12));
        painelBotao.add(btnEditar);

        JButton btnExcluir = new JButton("Excluir Cadastro");
        btnExcluir.setPreferredSize(new Dimension(180, 35));
        btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnExcluir.setBackground(new Color(220, 50, 50)); // Vermelho Alerta
        btnExcluir.setForeground(Color.WHITE);
        painelBotao.add(btnExcluir);
        
        painelPrincipal.add(painelBotao, gbc);

        // Ação editar dados existentes
        btnEditar.addActionListener(e -> {
            JPasswordField pf = new JPasswordField();
            int okCancell = JOptionPane.showConfirmDialog(
                this, pf, "Digite sua senha atual para editar:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE
            );

            if (okCancell == JOptionPane.OK_OPTION) {
                String senhaDigitada = new String(pf.getPassword());
                if (senhaDigitada.equals(Atleta.senha)) {
                    Atleta.isEdicao = true; 
                    TelaCadastro telaCadastro = new TelaCadastro();
                    telaCadastro.mostrarTela();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Senha incorreta!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Ação de Excluir o cadastro permanentemente
        btnExcluir.addActionListener(e -> {
            int resposta = JOptionPane.showConfirmDialog(
                this, 
                "Tem certeza de que deseja excluir permanentemente o seu cadastro?", 
                "Confirmar Exclusão", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.WARNING_MESSAGE
            );

            if (resposta == JOptionPane.YES_OPTION) {
                Atleta.resgatarPadrao(); // Reseta os atributos para null/0
                JOptionPane.showMessageDialog(this, "Cadastro excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                
                // Retorna à classe inicial
                pf.main(null);
                dispose();
            }
        });

        JScrollPane scrollPane = new JScrollPane(painelPrincipal);
        scrollPane.setBorder(null);
        getContentPane().add(scrollPane);
    }

    private JPanel criarDivisoriaSecao(String titulo) {
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setOpaque(false);
        JLabel label = new JLabel(titulo.toUpperCase());
        label.setFont(new Font("Tahoma", Font.BOLD, 12));
        label.setForeground(new Color(80, 90, 100));
        JSeparator linha = new JSeparator();
        linha.setForeground(new Color(180, 185, 190));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0; c.insets = new Insets(0, 0, 0, 10); painel.add(label, c);
        c.gridx = 1; c.fill = GridBagConstraints.HORIZONTAL; c.weightx = 1.0; c.insets = new Insets(4, 0, 0, 0); painel.add(linha, c);
        return painel;
    }

    private JPanel criarPainelDados(String[][] dados) {
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setOpaque(false);
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(4, 15, 4, 15);

        for (int i = 0; i < dados.length; i++) {
            String campo = dados[i][0];
            String valor = (dados[i][1] != null) ? dados[i][1] : "";

            c.gridx = 0; c.gridy = i; c.weightx = 0.0;
            JLabel lblCampo = new JLabel(campo);
            lblCampo.setFont(new Font("Tahoma", Font.BOLD, 13));
            painel.add(lblCampo, c);

            c.gridx = 1; c.weightx = 1.0;
            JLabel lblValor = new JLabel(valor.isEmpty() || valor.equals("0") || valor.equals("0.0") ? "Não informado" : valor);
            lblValor.setFont(new Font("Tahoma", Font.PLAIN, 13));
            painel.add(lblValor, c);
        }
        return painel;
    }
}