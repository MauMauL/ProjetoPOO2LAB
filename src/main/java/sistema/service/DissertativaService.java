package sistema.service;

import java.util.List;

import sistema.generic.DissertativaDAO;
import sistema.modelos.Dissertativa;


public class DissertativaService 
{
	private DissertativaDAO dissertativaDAO = new DissertativaDAO();
	
	public List<Dissertativa> getDissertativas() {
		List<Dissertativa> list = dissertativaDAO.getAll(Dissertativa.class);
		dissertativaDAO.closeEntityManager();
		return list;
	}
}
