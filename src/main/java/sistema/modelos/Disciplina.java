package sistema.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Disciplina implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigoDisc;
	
	private String nomeDisc;
	
	@OneToMany(mappedBy="disciplina")
	private List<Conteudo> conteudos = new ArrayList<Conteudo>();
	
	@ManyToOne
	private Professor professor;
	
	@OneToMany(mappedBy="disciplina")
	private List<Prova> provas = new ArrayList<Prova>();
	
	public long getCodigoDisc() {
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
	public void addConteudo(Conteudo conteudo)
	{
		conteudos.add(conteudo);
	}
	public void addProva(Prova prova)
	{
		provas.add(prova);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigoDisc ^ (codigoDisc >>> 32));
		result = prime * result + ((nomeDisc == null) ? 0 : nomeDisc.hashCode());
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
		Disciplina other = (Disciplina) obj;
		if (codigoDisc != other.codigoDisc)
			return false;
		if (nomeDisc == null) {
			if (other.nomeDisc != null)
				return false;
		} else if (!nomeDisc.equals(other.nomeDisc))
			return false;
		return true;
	}
	

}
