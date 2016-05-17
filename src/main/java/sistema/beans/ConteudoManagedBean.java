package sistema.beans;

import java.util.List;

import sistema.modelos.Conteudo;
import sistema.service.DefaultService;

public class ConteudoManagedBean {
	private Conteudo conteudo = new Conteudo();
	private List<Conteudo> conteudos;
	private DefaultService service = new DefaultService();
	
	public void salvar() {
		service.salvar(conteudo);

		if (conteudos != null)
			conteudos.add(conteudo);

		conteudo = new Conteudo();
	}

	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	} 
	public List<Conteudo> getConteudos() {
		if (conteudos == null)
			conteudos = service.getAs();

		return conteudos;
	}

	public void remover(Conteudo conteudo) {
		service.remover(conteudo);
		conteudos.remove(conteudo);
	}
}
