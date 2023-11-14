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
