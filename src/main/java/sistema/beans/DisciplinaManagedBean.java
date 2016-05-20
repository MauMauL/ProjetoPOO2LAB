package sistema.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import org.primefaces.event.RowEditEvent;

import sistema.beans.datamodel.DisciplinaDataModel;
import sistema.modelos.Conteudo;
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
	private DisciplinaService discService = new DisciplinaService();
	private ProfessorService profService = new ProfessorService();
	private Disciplina disciplinaSelecionada;
	
	public void salvar() {
		
		professor.addDisciplina(disciplina);
		disciplina.setProfessor(professor);
		
		disciplina = discService.salvar(disciplina);
		
		if(disciplinas != null)
		{
			disciplinas.add(disciplina);
		}
		disciplina = new Disciplina();
		professor = null;

	}

	public Disciplina getDisciplinaSelecionada() {
		return disciplinaSelecionada;
	}

	public void setDisciplinaSelecionada(Disciplina disciplinaSelecionada) {
		this.disciplinaSelecionada = disciplinaSelecionada;
	}
	public DataModel<Disciplina> getDisciplinasDataModel() {
		if (disciplinas == null)
			disciplinas = discService.getDisciplinas();

		return new DisciplinaDataModel(disciplinas);
	}
	public List<Conteudo> getConteudosDisciplina() {
		if (disciplinaSelecionada != null) {
			return discService.pesquisarConteudosDisciplina(disciplinaSelecionada);
		} else
			return null;
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
			disciplinas = discService.getDisciplinas();

		return disciplinas;
	}
	public List<Professor> getProfessores() {
		return profService.getProfessores();

	}
	public void remove(Disciplina disciplina) {
		discService.remover(disciplina);
		disciplinas.remove(disciplina);
	}
	public void remover(Disciplina disciplina) 
	{
		if (discService.pesquisarConteudosDisciplina(disciplina).size() > 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, 
			new FacesMessage(FacesMessage.SEVERITY_INFO, 
					"Não é possível remover disciplina",
					"Disciplina possui conteudos!"));
		}
		else
		{
			discService.remover(disciplina);
			disciplinas.remove(disciplina);
		}
	}
	
	public void onRowEdit(RowEditEvent event) {

		Disciplina d = ((Disciplina) event.getObject());
		discService.alterar(d);
	}
}
