package br.com.ilussencio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Aluno> list = new ArrayList<>();
        int opcao;
        int indice;
        String nome, matricula, dataNascimento;

        do{
            System.out.println("===== MENU =====");
            System.out.println("(1) Cadastrar");
            System.out.println("(2) Listar Todos");
            System.out.println("(3) Pesquisar");
            System.out.println("(4) Remover");
            System.out.println("(5) Sair");
            System.out.printf("Opção: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao){
                case 1:
                    System.out.printf("Entre com o nome: ");
                    nome = scan.nextLine();
                    System.out.printf("Entre com a matricula: ");
                    matricula = scan.nextLine();
                    System.out.printf("Entre com a data de nascimento: ");
                    dataNascimento = scan.nextLine();
                    Aluno aluno = new Aluno(nome,matricula,dataNascimento);
                    list.add(aluno);
                    break;
                case 2:
                    if(list.isEmpty()){
                        System.out.println("Lista Vazia!");
                    }else{
                        for (Aluno p : list) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 3:
                    if(list.isEmpty()){
                        System.out.println("Lista Vazia!");
                    }else{
                        System.out.printf("Entre com um nome para pesquisar: ");
                        nome = scan.nextLine();
                        for(Aluno p :  list){
                            if(p.getNome().equalsIgnoreCase(nome)){
                                System.out.println(p);
                            }
                        }
                    }
                    break;
                case 4:
                    if(list.isEmpty()){
                        System.out.println("Lista Vazia!");
                    }else{
                        for(int i = 0; i < list.size(); i ++){
                            System.out.println("Indice(" + i + ") - " + list.get(i));
                        }
                        System.out.printf("Qual indice deseja remover: ");
                        indice = scan.nextInt();
                        scan.nextLine();
                        list.remove(indice);
                    }
                    break;
                case 5:
                    System.out.println("Obrigado pela visita! volte sempre S2");
                    break;
                default:
                    System.out.println("Opção invalida!");
            }
        }while ( opcao != 5 );

    }
}