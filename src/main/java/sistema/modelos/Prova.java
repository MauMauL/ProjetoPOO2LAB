package sistema.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


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

	private int dificuldade;

	private int dificuldadeP;
	
	private int numeroPergunta;
	
	@Temporal(value = TemporalType.DATE)
	private Date dataAplicacao;
	
	@ManyToOne
	private Disciplina disciplina;
	
	@ManyToMany
	private List<Pergunta> perguntas = new ArrayList<Pergunta>();
	
	
	
	public int getNumeroPergunta() {
		return numeroPergunta;
	}
	public void setNumeroPergunta(int numeroPergunta) {
		this.numeroPergunta = numeroPergunta;
	}
	public int getDificuldade() {
		return dificuldade;
	}
	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}
	public int getDificuldadeP() {
		return dificuldadeP;
	}
	public void setDificuldadeP(int dificuldadeP) {
		this.dificuldadeP = dificuldadeP;
	}
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
	public Date getDataAplicacao() {
		return dataAplicacao;
	}
	public void setDataAplicacao(Date dataAplicacao) {
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
	
	public void addPergunta(Pergunta pergunta)
	{
		perguntas.add(pergunta);
	}
	public void addAlternativa(Alternativa alternativa)
	{
		perguntas.add(alternativa);
	}
	public void addDissertativa(Dissertativa dissertativa)
	{
		perguntas.add(dissertativa);
	}
	public void addMultiplaEscolha(MultiplaEscolha multiplaEscolha)
	{
		perguntas.add(multiplaEscolha);
	}
	public void addVerdadeiroFalso(VerdadeiroFalso verdadeiroFalso)
	{
		perguntas.add(verdadeiroFalso);
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
