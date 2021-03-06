package sistema.service;

import java.util.List;

import sistema.generic.ConteudoDAO;
import sistema.modelos.Conteudo;


public class ConteudoService 
{

	private ConteudoDAO conteudoDAO = new ConteudoDAO();

	public Conteudo salvar(Conteudo conteudo)
	{

		conteudo = conteudoDAO.save(conteudo);
		conteudoDAO.closeEntityManager();
		return conteudo;
	}

	public List<Conteudo> getConteudos() 
	{
		List<Conteudo> list = conteudoDAO.getAll(Conteudo.class);
		conteudoDAO.closeEntityManager();
		return list;
	}

	public void alterar(Conteudo conteudo) 
	{
		conteudoDAO.save(conteudo);
		conteudoDAO.closeEntityManager();

	}

	public void remover(Conteudo conteudo) 
	{
		conteudo = conteudoDAO.getById(Conteudo.class, conteudo.getCodigoCont());
		conteudoDAO.remove(conteudo);
		conteudoDAO.closeEntityManager();
	}

}
