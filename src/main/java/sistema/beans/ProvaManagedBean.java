package sistema.beans;

import java.util.List;

import sistema.modelos.Prova;
import sistema.service.DefaultService;

public class ProvaManagedBean {
	private Prova prova = new Prova();
	private List<Prova> provas;
	private DefaultService service = new DefaultService();
	
	public void salvar() {
		service.salvar(prova);

		if (provas != null)
			provas.add(prova);

		prova = new Prova();
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	} 
	public List<Prova> getProvas() {
		if (provas == null)
			provas = service.getAs();

		return provas;
	}

	public void remover(Prova prova) {
		service.remover(prova);
		provas.remove(prova);
	}
}
