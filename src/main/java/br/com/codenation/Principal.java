package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Principal {

    public static void main(String[] args){

        DesafioMeuTimeApplication desafio = new DesafioMeuTimeApplication();


        //SÃO PAULO
        Time saoPaulo = new Time();
        saoPaulo.setId(new Long(1));
        saoPaulo.setNome("São Paulo");
        saoPaulo.setDataCriacao(LocalDate.of(1900, 2, 10));
        saoPaulo.setCorUniformePrincipal("Branco");
        saoPaulo.setCorUniformePrincipal("Vermelho");

        desafio.incluirTime(saoPaulo.getId(), saoPaulo.getNome(), saoPaulo.getDataCriacao(),
                saoPaulo.getCorUniformePrincipal(), saoPaulo.getCorUniformeSecundario());

        //PALMEIRAS
        Time palmeiras = new Time();
        palmeiras.setId(new Long(2));
        palmeiras.setNome("Palmeiras");
        palmeiras.setDataCriacao(LocalDate.of(1935, 5, 28));
        palmeiras.setCorUniformePrincipal("Branco");
        palmeiras.setCorUniformePrincipal("Verde");

        desafio.incluirTime(palmeiras.getId(), palmeiras.getNome(), palmeiras.getDataCriacao(),
                palmeiras.getCorUniformePrincipal(), palmeiras.getCorUniformeSecundario());


        //FLAVIO
        Jogador flavio = new Jogador();
        flavio.setId(new Long(1));
        flavio.setIdTime(new Long(2));
        flavio.setNome("Flavio Miranda");
        flavio.setDataNascimento(LocalDate.of(1989, 3, 20));
        flavio.setNivelHabilidade(2);
        flavio.setSalario(new BigDecimal(20000.00));

        desafio.incluirJogador(flavio.getId(), flavio.getIdTime(), flavio.getNome(),
                flavio.getDataNascimento(),flavio.getNivelHabilidade(),flavio.getSalario());

        //HENRIQUE
        Jogador henrique = new Jogador();
        henrique.setId(new Long(2));
        henrique.setIdTime(new Long(2));
        henrique.setNome("Henrique Soares");
        henrique.setDataNascimento(LocalDate.of(2000, 1, 15));
        henrique.setNivelHabilidade(9);
        henrique.setSalario(new BigDecimal(100.00));

        desafio.incluirJogador(henrique.getId(), henrique.getIdTime(), henrique.getNome(),
                henrique.getDataNascimento(),henrique.getNivelHabilidade(),henrique.getSalario());




        //desafio.definirCapitao(new Long(1));

        //System.out.println(desafio.buscarNomeJogador(new Long(1)));
       // System.out.println(desafio.buscarCapitaoDoTime(new Long(1)));
        //System.out.println(desafio.buscarNomeTime(new Long(2)));
       // System.out.println(desafio.buscarSalarioDoJogador(new Long(2)));
        //System.out.println(desafio.buscarJogadoresDoTime((new Long(2))));
        //System.out.println(desafio.buscarJogadorMaisVelho((new Long(2)))); //erro

       //System.out.println(desafio.buscarTimes());
        //System.out.println(desafio.buscarTopJogadores(9));

        System.out.println(desafio.buscarCorCamisaTimeDeFora(new Long(1), new Long(2)));






    }
}
