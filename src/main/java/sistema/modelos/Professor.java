package sistema.modelos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Professor implements Serializable 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigoProf;
	private String nomeProf; 
	private String cursoMinistra;

	@OneToMany(mappedBy="professor")
	private List<Disciplina> disciplinas;
	
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
	public int getCodigoProf() {
		return codigoProf;
	}
	public void setCodigoProf(int codigoProf) {
		this.codigoProf = codigoProf;
	}
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	public void addDisciplinas(Disciplina disciplina)
	{
		disciplinas.add(disciplina);
	}
	
	
	
}
