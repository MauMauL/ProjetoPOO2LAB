package sistema.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Disciplina;
import sistema.modelos.Professor;
import sistema.service.DisciplinaService;
import sistema.service.ProfessorService;

@ManagedBean
@ViewScoped
public class DisciplinaManagedBean 
{
	private Disciplina disciplina = new Disciplina();
	private Professor professor;
	private List<Disciplina> disciplinas;
	private DisciplinaService DiscService = new DisciplinaService();
	private ProfessorService ProfService = new ProfessorService();
	
	public void salvar() {
		
		professor.addDisciplina(disciplina);
		disciplina.setProfessor(professor);
		
		disciplina = DiscService.salvar(disciplina);
		if(disciplinas == null)
		{
			disciplinas.add(disciplina);
		}
		disciplina = new Disciplina();
		professor = null;
		

		if (disciplinas != null)
			disciplinas.add(disciplina);

		disciplina = new Disciplina();
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Professor getProfessor() {
		return professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	} 
	public List<Disciplina> getDisciplinas() {
		if (disciplinas == null)
			disciplinas = DiscService.getDisciplinas();

		return disciplinas;
	}
	public List<Professor> getProfessores() {
		return ProfService.getProfessores();

	}
	public void remover(Disciplina disciplina) {
		DiscService.remover(disciplina);
		disciplinas.remove(disciplina);
	}
	
	public void onRowEdit(RowEditEvent event) {

		Disciplina d = ((Disciplina) event.getObject());
		DiscService.alterar(d);
	}
}
