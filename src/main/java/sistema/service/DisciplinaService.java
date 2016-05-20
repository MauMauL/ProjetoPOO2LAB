package sistema.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import sistema.generic.DisciplinaDAO;
import sistema.modelos.Conteudo;
import sistema.modelos.Disciplina;


public class DisciplinaService 
{

	private DisciplinaDAO disciplinaDAO = new DisciplinaDAO();

	public Disciplina salvar(Disciplina disciplina) 
	{
		disciplina = disciplinaDAO.save(disciplina);
		disciplinaDAO.closeEntityManager();
		return disciplina;

	}

	public List<Disciplina> getDisciplinas() {
		List<Disciplina> list = disciplinaDAO.getAll(Disciplina.class);
		disciplinaDAO.closeEntityManager();
		return list;
	}

	public void alterar(Disciplina disciplina) {
		disciplinaDAO.save(disciplina);
		disciplinaDAO.closeEntityManager();
	}

	public void remover(Disciplina disciplina) {

		disciplina = disciplinaDAO.getById(Disciplina.class,
				disciplina.getCodigoDisc());
		disciplinaDAO.remove(disciplina);
		disciplinaDAO.closeEntityManager();
	}
	public List<Conteudo> pesquisarConteudosDisciplina(Disciplina disciplina) 
	{

		List<Conteudo> conteudos;

		disciplina = disciplinaDAO.getById(Disciplina.class, disciplina.
				getCodigoDisc());
		conteudos = disciplina.getConteudos();

		return conteudos;
	}
	public Disciplina pesquisar(Disciplina disciplina) 
	{

		disciplina = disciplinaDAO.getById(Disciplina.class, disciplina.getCodigoDisc());
		disciplinaDAO.closeEntityManager();
		return disciplina;
	}
}



