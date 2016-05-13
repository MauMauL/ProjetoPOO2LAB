package sistema.modelos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

abstract class Pergunta {
	
	private int codPer;
	private String dificuldade;
	private int tempoEstimado;
	private Calendar dataCriacao;
	private String enunciado;
	private List<Conteudo> conteudos = new ArrayList<Conteudo>();
	private List<Calendar> datasDeUso = new ArrayList<Calendar>();
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
	public Calendar getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Calendar dataCriacao) {
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
	public List<Calendar> getDatasDeUso() {
		return datasDeUso;
	}
	public void setDatasDeUso(List<Calendar> datasDeUso) {
		this.datasDeUso = datasDeUso;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
}
