package sistema.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;
import sistema.modelos.Conteudo;
import sistema.modelos.Disciplina;
import sistema.modelos.Pergunta;
import sistema.service.ConteudoService;
import sistema.service.DisciplinaService;
import sistema.service.PerguntaService;


@ManagedBean
@ViewScoped
public class ConteudoManagedBean 
{
	private Conteudo conteudo = new Conteudo();
	private List<Pergunta> perguntasSelecionadas;
	private List<Conteudo> conteudos;
	private List<Pergunta> perguntas;
	private Disciplina disciplina;
	private ConteudoService contService = new ConteudoService();
	private DisciplinaService discService = new DisciplinaService();
	private PerguntaService perguntaService = new PerguntaService();
	

	public void salvar() 
	{
		disciplina.addConteudo(conteudo);
		conteudo.setDisciplina(disciplina);
		
		adicionaPerguntas();
		
		conteudo = contService.salvar(conteudo);

		if (conteudos != null)
			conteudos.add(conteudo);

		conteudo = new Conteudo();
		disciplina = null;

	}
	

	public List<Pergunta> getPerguntas() {
		if(perguntas == null)
		perguntas = perguntaService.getPerguntas();
			
		return perguntas;
	}


	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}


	public List<Pergunta> getPerguntasSelecionadas() {
		return perguntasSelecionadas;
	}

	public void setPerguntasSelecionadas(List<Pergunta> perguntasSelecionadas) {
		this.perguntasSelecionadas = perguntasSelecionadas;
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
	
	public void setConteudos(List<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}


	public void adicionaPerguntas()
	{
		for(int i = 0; i < perguntasSelecionadas.size(); i++)
		{
			conteudo.addPergunta(perguntasSelecionadas.get(i));
		}
	}
	public void onRowEdit(RowEditEvent event) {

		Conteudo c = ((Conteudo) event.getObject());
		contService.alterar(c);
	}
}
