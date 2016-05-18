package sistema.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;

import org.primefaces.event.RowEditEvent;

import sistema.beans.datamodel.ProfessorDataModel;
import sistema.modelos.Disciplina;
import sistema.modelos.Professor;
import sistema.service.ProfessorService;

@ManagedBean
@ViewScoped
public class ProfessorManagedBean 
{
	
	private Professor professor = new Professor();
	private List<Professor> professores;
	private ProfessorService service = new ProfessorService();
	private Professor professorSelecionado;
	
	
	public void salvar() {
		professor = service.salvar(professor);

		if (professores != null)
			professores.add(professor);

		professor = new Professor();
	}

	public Professor getProfessorSelecionado() {
		return professorSelecionado;
	}

	public void setProfessorSelecionado(Professor professorSelecionado) {
		this.professorSelecionado = professorSelecionado;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public DataModel<Professor> getProfessores() {
		if (professores == null)
			professores = service.getProfessores();

		return new ProfessorDataModel(professores);
	}

	public List<Disciplina> getDisciplinasProfessor() {
		if (professorSelecionado != null) {
			return service.pesquisarDisciplinasProfessor(professorSelecionado);
		} else
			return null;
	}
	public void remover(Professor professor) {
		service.remover(professor);
		professores.remove(professor);
	}
	public void onRowEdit(RowEditEvent event) {

		Professor p = ((Professor) event.getObject());
		service.alterar(p);
	}
}
