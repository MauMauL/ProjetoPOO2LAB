package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.generic.ProfessorDAO;
import sistema.modelos.Disciplina;
import sistema.modelos.Professor;


public class ProfessorService 
{
	
	private ProfessorDAO professorDAO = new ProfessorDAO();

	public Professor salvar(Professor professor) {

		professor = professorDAO.save(professor);
		professorDAO.closeEntityManager();
		return professor;
	}

	public List<Professor> getProfessores() {
		List<Professor> list = professorDAO.getAll(Professor.class);
		professorDAO.closeEntityManager();
		return list;
	}

	public void alterar(Professor professor) {

		professorDAO.save(professor);
		professorDAO.closeEntityManager();

	}

	public void remover(Professor professor) {

		professor = professorDAO.getById(Professor.class, professor.getCodigoProf());
		professorDAO.remove(professor);
		professorDAO.closeEntityManager();
	}

	public Professor pesquisar(Professor professor) {

		professor = professorDAO.getById(Professor.class, professor.getCodigoProf());
		professorDAO.closeEntityManager();
		return professor;
	}

	public List<Disciplina> pesquisarDisciplinasProfessor(Professor professor) {

		List<Disciplina> disciplinas;

		professor = professorDAO.getById(Professor.class, professor.getCodigoProf());
		disciplinas = professor.getDisciplinas();

		return disciplinas;
	}
}
