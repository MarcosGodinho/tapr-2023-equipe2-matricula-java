package br.edu.univille.microservmatricula.entity;
import java.util.Date;

import com.azure.spring.data.cosmos.core.mapping.Container;
import org.springframework.data.annotation.Id;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName = "matricula")
public class Matricula {

    @Id
    @PartitionKey
    @GeneratedValue
    public String id;
    public String cpf;
    public Date dataIngresso;
    public int periodoCursando;
    public Aluno aluno;
    public Curso curso;

    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    public String getID() {
        return id;
    }
    public void setID(String id) {
        this.id = id;
    }
    public String getCPF() {
        return cpf;
    }
    public void setCPF(String cPF) {
        cpf = cPF;
    }
    public Date getDataIngresso() {
        return dataIngresso;
    }
    public void setDataIngresso(Date dataIngresso) {
        this.dataIngresso = dataIngresso;
    }
    public int getPeriodoCursando() {
        return periodoCursando;
    }
    public void setPeriodoCursando(int periodoCursando) {
        this.periodoCursando = periodoCursando;
    }
    
}
