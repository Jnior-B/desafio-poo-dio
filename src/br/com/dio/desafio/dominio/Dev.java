package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.*;

public class Dev {


    private String nome;
    Bootcamp bootcamp;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();

    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        if(bootcamp.getDataInicial().isAfter(bootcamp.getDateFinal())){
            System.out.println("Matriculas enceradas, não pode se inscrever");
        }else {
            this.conteudosInscritos.addAll(bootcamp.getConteudos());
            bootcamp.getDevsInscritos().add(this);
        }
    }

    public void progredir(Bootcamp bootcamp) {


            Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
            if ((conteudo.isPresent()) && (bootcamp.getDataInicial().isBefore(bootcamp.getDateFinal()))){
                this.conteudosConcluidos.add(conteudo.get());
                this.conteudosInscritos.remove(conteudo.get());
            } else {
                System.err.println("Você não esta matriculado" +
                        " em nenhum conteudo !");
            }

}

    public double calcularTotalXp(){

            return this.conteudosConcluidos
                    .stream()
                    .mapToDouble(Conteudo::calcularXp)
                    .sum();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(getNome(), dev.getNome()) && Objects.equals(getConteudosInscritos(), dev.getConteudosInscritos()) && Objects.equals(getConteudosConcluidos(), dev.getConteudosConcluidos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getConteudosInscritos(), getConteudosConcluidos());
    }
}
