package model;



public class Atleta {
public static String nome;
public static String dataNascimento;
public static long cpf;
public static long telefone;
public static String modalidade;
public static String sexo;



public static String pais;
public static String estado;
public static String cidade;
public static String bairro;
public static String rua;
public static int numero;
public static long cep;



public static String categoria;
public static double peso;
public static double altura;
public static String associacao;
public static long matricula;
public static String posicao;
public static String equipe;
public static String observacoes;



public static String usuario;
public static String senha;
public static boolean isEdicao = false;


public static void resgatarPadrao() {
nome = null; dataNascimento = null; cpf = 0; telefone = 0; modalidade = null; sexo = null;
pais = null; estado = null; cidade = null; bairro = null; rua = null; numero = 0; cep = 0;
categoria = null; peso = 0.0; altura = 0.0; associacao = null; matricula = 0; posicao = null; equipe = null; observacoes = null;
usuario = null; senha = null; isEdicao = false;

}

}
