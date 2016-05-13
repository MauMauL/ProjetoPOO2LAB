package sistema.modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Disciplina 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigoDisc;
	private String nomeDisc;
	private List<Conteudo> conteudos = new ArrayList<Conteudo>();
	@ManyToOne
	private Professor professor;
	private List<Prova> provas = new ArrayList<Prova>();
	
	public int getCodigoDisc() {
		return codigoDisc;
	}
	public void setCodigoDisc(int codigoDisc) {
		this.codigoDisc = codigoDisc;
	}
	public String getNomeDisc() {
		return nomeDisc;
	}
	public void setNomeDisc(String nomeDisc) {
		this.nomeDisc = nomeDisc;
	}
	public List<Conteudo> getConteudos() {
		return conteudos;
	}
	public void setConteudos(ArrayList<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public List<Prova> getProvas() {
		return provas;
	}
	public void setProvas(ArrayList<Prova> provas) {
		this.provas = provas;
	}
}
