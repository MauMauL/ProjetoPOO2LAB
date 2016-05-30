package sistema.service;

import java.util.List;

import sistema.generic.AlternativaDAO;
import sistema.generic.DissertativaDAO;
import sistema.generic.MultiplaEscolhaDAO;
import sistema.generic.PerguntaDAO;
import sistema.generic.VerdadeiroFalsoDAO;
import sistema.modelos.Alternativa;
import sistema.modelos.Dissertativa;
import sistema.modelos.MultiplaEscolha;
import sistema.modelos.Pergunta;
import sistema.modelos.VerdadeiroFalso;

public class PerguntaService 
{
	private PerguntaDAO perguntaDAO = new PerguntaDAO();
	private AlternativaDAO alternativaDAO = new AlternativaDAO();
	private DissertativaDAO dissertativaDAO = new DissertativaDAO();
	private MultiplaEscolhaDAO multiplaEscolhaDAO = new MultiplaEscolhaDAO();
	private VerdadeiroFalsoDAO verdadeiroFalsoDAO = new VerdadeiroFalsoDAO();

	public Pergunta salvarAlternativa(Alternativa alternativa) 
	{
		alternativa = alternativaDAO.save(alternativa);
		alternativaDAO.closeEntityManager();
		return alternativa;

	}
	public Pergunta salvarDissertativa(Dissertativa dissertativa) 
	{
		dissertativa = dissertativaDAO.save(dissertativa);
		dissertativaDAO.closeEntityManager();
		return dissertativa;

	}
	public Pergunta salvarMultiplaEscolha(MultiplaEscolha multiplaEscolha) 
	{
		multiplaEscolha = multiplaEscolhaDAO.save(multiplaEscolha);
		multiplaEscolhaDAO.closeEntityManager();
		return multiplaEscolha;

	}
	public Pergunta salvarVerdadeiroFalso(VerdadeiroFalso verdadeiroFalso) 
	{
		verdadeiroFalso = verdadeiroFalsoDAO.save(verdadeiroFalso);
		verdadeiroFalsoDAO.closeEntityManager();
		return verdadeiroFalso;

	}
	public List<Pergunta> getPerguntas() {
		List<Pergunta> list = perguntaDAO.getAll(Pergunta.class);
		perguntaDAO.closeEntityManager();
		return list;
	}

	public void alterar(Pergunta pergunta) {
		perguntaDAO.save(pergunta);
		perguntaDAO.closeEntityManager();
	}

	public void remover(Pergunta pergunta) {

		pergunta = perguntaDAO.getById(Pergunta.class,
				pergunta.getCodPer());
		perguntaDAO.remove(pergunta);
		perguntaDAO.closeEntityManager();
	}
	public Pergunta pesquisar(Pergunta pergunta) 
	{
		pergunta = perguntaDAO.getById(Pergunta.class, pergunta.getCodPer());
		perguntaDAO.closeEntityManager();
		return pergunta;
	}
	
}
