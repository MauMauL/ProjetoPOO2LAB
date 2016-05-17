package sistema.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sistema.modelos.Professor;
import sistema.service.ProfessorService;

@ManagedBean
@ViewScoped
public class ProfessorManagedBean 
{
	
	private Professor professor = new Professor();
	private List<Professor> professores;
	private ProfessorService service = new ProfessorService();
	
	
	public void salvar() {
		service.salvar(professor);

		if (professores != null)
			professores.add(professor);

		professor = new Professor();
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public List<Professor> getProfessores() {
		if (professores == null)
			professores = service.getProfessores();

		return professores;
	}

	public void remover(Professor professor) {
		service.remover(professor);
		professores.remove(professor);
	}
}
