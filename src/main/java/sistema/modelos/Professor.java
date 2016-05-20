package sistema.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Professor implements Serializable 
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigoProf;
	
	private String nomeProf; 
	private String cursoMinistra;

	@OneToMany(mappedBy="professor")
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public Professor()
	{
		
	}
	public Professor(long codigoProf, String nomeProf) {
		super();
		this.codigoProf = codigoProf;
		this.nomeProf = nomeProf;
	}
	public String getNomeProf() {
		return nomeProf;
	}
	public void setNomeProf(String nomeProf) {
		this.nomeProf = nomeProf;
	}
	public String getCursoMinistra() {
		return cursoMinistra;
	}
	public void setCursoMinistra(String cursoMinistra) {
		this.cursoMinistra = cursoMinistra;
	}
	public long getCodigoProf() {
		return codigoProf;
	}
	public void setCodigoProf(long codigoProf) {
		this.codigoProf = codigoProf;
	}
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	public void addDisciplina(Disciplina disciplina)
	{
		disciplinas.add(disciplina);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeProf == null) ? 0 : nomeProf.hashCode());
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
		Professor other = (Professor) obj;
		if (nomeProf == null) {
			if (other.nomeProf != null)
				return false;
		} else if (!nomeProf.equals(other.nomeProf))
			return false;
		return true;
	}
	
}
