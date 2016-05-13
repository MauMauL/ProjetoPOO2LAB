package sistema.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conteudo implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigoCont;
	private String nomeCont;
	private Disciplina disciplina;
	private List<Pergunta> perguntas = new ArrayList<Pergunta>();
	
	public int getCodigoCont() {
		return codigoCont;
	}
	public void setCodigoCont(int codigoCont) {
		this.codigoCont = codigoCont;
	}
	public String getNomeCont() {
		return nomeCont;
	}
	public void setNomeCont(String nomeCont) {
		this.nomeCont = nomeCont;
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
