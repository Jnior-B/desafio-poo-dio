import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Curso curso1 = new Curso();

        curso1.setTitulo("Curso Java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);


        Curso curso2 = new Curso();

        curso2.setTitulo("Curso Java");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de Java");
        mentoria.setDescricao("descricao mentoria java");
        mentoria.setData(LocalDate.now());

        /*
        System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);
        */
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.getDataInicial();
        bootcamp.setNome("Bootcamp Java Developper");
        bootcamp.setDescricao("Descrição Bootcamp Java Developper");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devJunior =new Dev();
        devJunior.setNome("Junior");

        devJunior.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos Inscritos Junior" + devJunior.getConteudosInscritos());
        devJunior.progredir(bootcamp);
        devJunior.progredir(bootcamp);
        //devJunior.progredir();
        System.out.println("-");
        System.out.println("Conteudos Inscritos Junior" + devJunior.getConteudosInscritos());
        System.out.println("Conteudos Concluidos Junior" + devJunior.getConteudosConcluidos());
        System.out.println("XP:" + devJunior.calcularTotalXp());


        System.out.println("-------------");


        Dev devBamba = new Dev();
        devBamba.setNome("Bamba");
        devBamba.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos Inscritos Bamba" + devBamba.getConteudosInscritos());
        devBamba.progredir(bootcamp);
        devBamba.progredir(bootcamp);
        //devBamba.progredir();
        System.out.println("-");
        System.out.println("Conteudos Inscritos Bamba" + devBamba.getConteudosInscritos());
        System.out.println("Conteudos Concluidos Bamba" + devBamba.getConteudosConcluidos());
        System.out.println("XP:" + devBamba.calcularTotalXp());

    }
}
