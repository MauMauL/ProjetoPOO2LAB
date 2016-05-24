package sistema.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Conteudo implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigoCont;
	
	private String nomeCont;
	
	@ManyToOne
	private Disciplina disciplina;
	
	@ManyToMany
	private List<Pergunta> perguntas = new ArrayList<Pergunta>();
	
	public long getCodigoCont() {
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
	public void addPergunta(Pergunta pergunta)
	{
		perguntas.add(pergunta);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigoCont ^ (codigoCont >>> 32));
		result = prime * result + ((nomeCont == null) ? 0 : nomeCont.hashCode());
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
		Conteudo other = (Conteudo) obj;
		if (codigoCont != other.codigoCont)
			return false;
		if (nomeCont == null) {
			if (other.nomeCont != null)
				return false;
		} else if (!nomeCont.equals(other.nomeCont))
			return false;
		return true;
	}
}
