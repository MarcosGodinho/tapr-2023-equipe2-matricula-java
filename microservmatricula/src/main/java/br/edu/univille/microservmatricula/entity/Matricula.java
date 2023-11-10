package br.edu.univille.microservmatricula.entity;
import java.util.Date;

import com.azure.spring.data.cosmos.core.mapping.Container;
import org.springframework.data.annotation.Id;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName = "matricula")
public class Matricula {

    @Id
    @GeneratedValue
    public String idMatricula;

    @PartitionKey
    public String cpfAluno;

    public Date dataIngresso;
    
    public int periodoCursando;

    public String getIdMatricula() {
        return idMatricula;
    }
    public void setIdMatricula(String idMatricula) {
        this.idMatricula = idMatricula;
    }
    public String getCPF() {
        return cpfAluno;
    }
    public void setCPF(String cPF) {
        cpfAluno = cPF;
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
