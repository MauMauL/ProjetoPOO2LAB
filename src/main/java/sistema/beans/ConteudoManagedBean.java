package sistema.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;

import sistema.modelos.Conteudo;
import sistema.modelos.Disciplina;
import sistema.service.ConteudoService;
import sistema.service.DisciplinaService;


@ManagedBean
@ViewScoped
public class ConteudoManagedBean 
{
	private Conteudo conteudo = new Conteudo();
	private List<Conteudo> conteudos;
	private Disciplina disciplina;
	private ConteudoService contService = new ConteudoService();
	private DisciplinaService discService = new DisciplinaService();
	
	
	public void salvar() 
	{
		disciplina.addConteudo(conteudo);
		conteudo.setDisciplina(disciplina);

		conteudo = contService.salvar(conteudo);

		if (conteudos != null)
			conteudos.add(conteudo);

		conteudo = new Conteudo();
		disciplina = null;

	}

	public List<Disciplina> getDisciplinas() 
	{
		return discService.getDisciplinas();

	}

	public Disciplina getDisciplina() 
	{
		return disciplina;
	}

	public void remover(Conteudo conteudo) 
	{
		contService.remover(conteudo);
		conteudos.remove(conteudo);
	}

	public void setDisciplina(Disciplina disciplina) 
	{
		this.disciplina = disciplina;
	}

	public Conteudo getConteudo() 
	{
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) 
	{
		this.conteudo = conteudo;
	}

	public List<Conteudo> getConteudos() {
		if (conteudos == null)
			conteudos = contService.getConteudos();

		return conteudos;
	}

	public void onRowEdit(RowEditEvent event) {

		Conteudo c = ((Conteudo) event.getObject());
		contService.alterar(c);
	}

}
