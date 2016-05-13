package sistema.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prova implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codProva;
	private String turma;
	private String curso;
	private String dataAplicacao;
	private Disciplina disciplina;
	private List<Pergunta> perguntas = new ArrayList<Pergunta>();
	
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getDataAplicacao() {
		return dataAplicacao;
	}
	public void setDataAplicacao(String dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public List<Pergunta> getPerguntas() {
		return perguntas;
	}
	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}
}
