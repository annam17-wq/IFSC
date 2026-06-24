package Controller;

import model.Atleta;
import view.TelaCadastro;
import view.TelaConta;
import view.pf;

import javax.swing.JOptionPane;

public class AtletaController {

    // Método para validar e salvar os dados iniciais (TelaCadastro)
    public static boolean salvarDadosIniciais(String nome, String nascimento, String cpfStr, String telefone, String modalidade, String sexo) {
        // Validações que antes ficavam na TelaCadastro
        if (nome.isEmpty() || nascimento.isEmpty() || cpfStr.isEmpty() || telefone.isEmpty() || modalidade.isEmpty() || sexo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Erro de Validação", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!cpfStr.matches("^\\d{11}$")) {
            JOptionPane.showMessageDialog(null, "O CPF deve conter exatamente 11 números!", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!telefone.matches("^\\d{10,11}$")) {
            JOptionPane.showMessageDialog(null, "O telefone deve conter entre 10 e 11 números com DDD!", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!sexo.matches("^[MF]$")) {
            JOptionPane.showMessageDialog(null, "No campo Sexo, digite apenas M ou F!", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Se passou nas validações, o Controller salva no Model
        Atleta.nome = nome;
        Atleta.dataNascimento = nascimento;
        Atleta.cpf = Long.parseLong(cpfStr);
        Atleta.telefone = Long.parseLong(telefone);
        Atleta.modalidade = modalidade;
        Atleta.sexo = sexo.toUpperCase();

        return true;
    }

    // Método para excluir o cadastro de forma segura
    public static void excluirCadastro(javax.swing.JFrame telaAtual) {
        int resposta = JOptionPane.showConfirmDialog(
            telaAtual, 
            "Tem certeza de que deseja excluir permanentemente o seu cadastro?", 
            "Confirmar Exclusão", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.WARNING_MESSAGE
        );

        if (resposta == JOptionPane.YES_OPTION) {
            Atleta.resgatarPadrao(); // Limpa o Model
            JOptionPane.showMessageDialog(telaAtual, "Cadastro apagado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
            pf.main(null); // Abre a tela inicial
            telaAtual.dispose(); // Fecha a tela da conta
        }
    }
}