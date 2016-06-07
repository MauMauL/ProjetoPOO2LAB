package sistema.modelos;

import java.io.Serializable;
import java.util.ArrayList;
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
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Pergunta implements Serializable, Comparable<Pergunta>
{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codPer;
	
	private int dificuldade;
	private int tempoEstimado;
	
	@Temporal(value = TemporalType.DATE)
	private Date dataCriacao;
	
	private String enunciado;
	
	@ManyToMany(mappedBy="perguntas")
	@JoinTable( name="TblPerguntaProva",joinColumns = {@JoinColumn(name ="c_codPergunta")},
	inverseJoinColumns = {@JoinColumn(name ="c_codProva")})
	private List<Prova> provas = new ArrayList<Prova>();
	
	@ManyToMany(mappedBy="perguntas")
	@JoinTable( name="TblPerguntaConteudo",joinColumns = {@JoinColumn(name ="c_codPergunta")},
	inverseJoinColumns = {@JoinColumn(name ="c_codCont")})
	private List<Conteudo> conteudos = new ArrayList<Conteudo>();

	public long getCodPer() {
		return codPer;
	}
	public void setCodPer(long codPer) {
		this.codPer = codPer;
	}
	public int getDificuldade() {
		return dificuldade;
	}
	public void setDificuldade(int dificuldade) {
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
	public void addConteudo(Conteudo conteudo)
	{
		conteudos.add(conteudo);
	}
	@Override
	public int compareTo(Pergunta p) 
	{	
		if(this.dificuldade > p.getDificuldade())
		{
			return 1;
		}
		else if(this.dificuldade < p.getDificuldade())
		{
			return -1;
		}
		return 0;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codPer ^ (codPer >>> 32));
		result = prime * result + ((enunciado == null) ? 0 : enunciado.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pergunta other = (Pergunta) obj;
		if (codPer != other.codPer)
			return false;
		if (enunciado == null) {
			if (other.enunciado != null)
				return false;
		} else if (!enunciado.equals(other.enunciado))
			return false;
		return true;
	}
	
		
}
