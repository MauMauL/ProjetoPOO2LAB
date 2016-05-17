package sistema.beans;

import java.util.List;

import sistema.modelos.Alternativa;
import sistema.service.DefaultService;

public class AlternativaManagedBean {
	
	private Alternativa alternativa = new Alternativa();
	private List<Alternativa> alternativas;
	private DefaultService service = new DefaultService();
	
	public void salvar() {
		service.salvar(alternativa);

		if (alternativas != null)
			alternativas.add(alternativa);

		alternativa = new Alternativa();
	}

	public Alternativa getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(Alternativa alternativa) {
		this.alternativa = alternativa;
	} 
	public List<Alternativa> getAlternativas() {
		if (alternativas == null)
			alternativas = service.getAs();

		return alternativas;
	}

	public void remover(Alternativa alternativa) {
		service.remover(alternativa);
		alternativas.remove(alternativa);
	}
}