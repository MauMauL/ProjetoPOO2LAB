package sistema.modelos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Pergunta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codPer;
	
	private String dificuldade;
	private int tempoEstimado;
	
	@Temporal(value = TemporalType.DATE)
	private Date dataCriacao;
	
	private String enunciado;
	private int numeroPerguntas;
	
	@ManyToMany(mappedBy="perguntas")
	@JoinTable( name="TblPerguntaProva",joinColumns = {@JoinColumn(name ="c_codPergunta")},
    		inverseJoinColumns = {@JoinColumn(name ="c_codProva")})
	private List<Prova> provas = new ArrayList<Prova>();
	
	@ManyToMany(mappedBy="perguntas")
	@JoinTable( name="TblPerguntaProva",joinColumns = {@JoinColumn(name ="c_codPergunta")},
	inverseJoinColumns = {@JoinColumn(name ="c_codCont")})
	private List<Conteudo> conteudos = new ArrayList<Conteudo>();
	
	private String imagem;
	
	public long getCodPer() {
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
	/*public String getDataCriacao() {
		
		String dataCriacao = "";
		
		try {	 
			SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yy");
			dataCriacao = formatoData.format(this.dataCriacao.getTime());
			 
			return dataCriacao;
			 
			} catch (Exception e) 
			{
				System.out.println("Erro ao converter de Calendar para String");
			}
		return "";
	}
	public void setDataCriacao(String dataCriacao) {
		
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yy");
		
		this.dataCriacao = Calendar.getInstance();
		
		try{
		this.dataCriacao.setTime(formatoData.parse(dataCriacao));
		}catch(Exception e)
		{
			System.out.println("Erro ao converter de String para Calendar");
		}
	}*/
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	
	public int getNumeroPerguntas() {
		return numeroPerguntas;
	}
	public void setNumeroPerguntas(int numeroPerguntas) {
		this.numeroPerguntas = numeroPerguntas;
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
	public void addProva(Prova prova)
	{
		provas.add(prova);
	}
		
}
