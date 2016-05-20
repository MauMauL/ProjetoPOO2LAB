package sistema.modelos;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Pergunta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codPer;
	
	private String dificuldade;
	private int tempoEstimado;
	private Date dataCriacao;
	private String enunciado;
	
	private List<Prova> provas = new ArrayList<Prova>();
	private List<Conteudo> conteudos = new ArrayList<Conteudo>();
	private String imagem;
	
	public int getCodPer() {
		return codPer;
	}
	public void setCodPer(int codPer) {
		this.codPer = codPer;
	}
	public String getDificuldade() {
		return dificuldade;
	}
	public void setDificuldade(String dificuldade) {
		this.dificuldade = dificuldade;
	}
	public int getTempoEstimado() {
		return tempoEstimado;
	}
	public void setTempoEstimado(int tempoEstimado) {
		this.tempoEstimado = tempoEstimado;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public List<Conteudo> getConteudos() {
		return conteudos;
	}
	public void setConteudos(List<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public List<Prova> getProvas() {
		return provas;
	}
	public void setProvas(List<Prova> provas) {
		this.provas = provas;
	}
		
}
