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
public class Prova implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codProva;
	
	private String nomeProva;
	
	private String turma;
	
	private String curso;
	
	private String dataAplicacao;
	
	@ManyToOne
	private Disciplina disciplina;
	

	private List<Pergunta> perguntas = new ArrayList<Pergunta>();
	
	
	public long getCodProva() {
		return codProva;
	}
	public void setCodProva(long codProva) {
		this.codProva = codProva;
	}
	
	public String getNomeProva() {
		return nomeProva;
	}
	public void setNomeProva(String nomeProva) {
		this.nomeProva = nomeProva;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getDataAplicacao() {
		return dataAplicacao;
	}
	public void setDataAplicacao(String dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codProva ^ (codProva >>> 32));
		result = prime * result + ((nomeProva == null) ? 0 : nomeProva.hashCode());
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
		Prova other = (Prova) obj;
		if (codProva != other.codProva)
			return false;
		if (nomeProva == null) {
			if (other.nomeProva != null)
				return false;
		} else if (!nomeProva.equals(other.nomeProva))
			return false;
		return true;
	}

}
