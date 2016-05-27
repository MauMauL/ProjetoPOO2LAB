package sistema.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sistema.modelos.Conteudo;
import sistema.modelos.Disciplina;
import sistema.modelos.Pergunta;
import sistema.modelos.Prova;
import sistema.service.ConteudoService;
import sistema.service.DisciplinaService;
import sistema.service.PerguntaService;
import sistema.service.ProvaService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;


@ManagedBean
@ViewScoped
public class ProvaManagedBean 
{
	
	private Prova prova = new Prova();
	private Disciplina disciplina;
	private List<Prova> provas;
	private List<Conteudo> conteudos;
	private List<Conteudo> conteudosSelecionados;
	private List<Pergunta> perguntas;
	private PerguntaService perguntaService = new PerguntaService();
	private ProvaService provaService = new ProvaService();
	private DisciplinaService discService = new DisciplinaService();
	private ConteudoService conteudoService = new ConteudoService();
	
	
	public void salvar() 
	{
		
		geraPerguntas();
		//adicionaConteudos();
	
		disciplina.addProva(prova);
		prova.setDisciplina(disciplina);
		
	
		prova = provaService.salvar(prova);
	
		if (provas != null)
			provas.add(prova);

		prova = new Prova();
		disciplina = null;
	}
	
	
	public List<Conteudo> getConteudosSelecionados() {
		return conteudosSelecionados;
	}
	public void setConteudosSelecionados(List<Conteudo> conteudosSelecionados) {
		this.conteudosSelecionados = conteudosSelecionados;
	}

	public List<Conteudo> getConteudos() 
	{
		if(conteudos == null)
			conteudos = conteudoService.getConteudos();
			
		return conteudos;
	}

	public List<Pergunta> getPerguntas()
	{if(perguntas == null)
		perguntas = perguntaService.getPerguntas();
		return perguntas;
	}
	public void setConteudos(List<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}


	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}


	public Disciplina getDisciplina() {
		return disciplina;
	}


	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}


	public List<Disciplina> getDisciplinas() {
		return discService.getDisciplinas();

	}

	public Disciplina getFornecedor() {
		return disciplina;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	} 
	public List<Prova> getProvas() {
		if (provas == null)
			provas = provaService.getProvas();

		return provas;
	}
	public void remover(Prova prova) {
		provaService.remover(prova);
		provas.remove(prova);
	}
	public void onRowEdit(RowEditEvent event) {

		Prova p = ((Prova) event.getObject());
		provaService.alterar(p);
	}
	public void geraPerguntas()
	{
		int aux = 0;
		List<Pergunta> l = perguntaService.getPerguntas();
		
		Collections.sort(l);
		
		for(int i = 0; i < l.size(); i++)
		{
			if(l.get(i).getDificuldade() <=  prova.getDificuldadeP() || aux < prova.getNumeroPergunta())
			{
				prova.addPergunta(l.get(i));
				aux++;
			}
		}
		if(prova.getPerguntas().size() < prova.getNumeroPergunta() && l.size() >= prova.getNumeroPergunta() )
		{
			int a = 0;
			
			a = prova.getNumeroPergunta() - prova.getPerguntas().size();
			
			for(int i = 0; i < a; i++)
			{
				if(l.get(i).getDificuldade() > prova.getDificuldadeP())
				{
					prova.addPergunta(l.get(i));
				}
			}
		}
	}
	public void adicionaConteudos()
	{
		for(int i = 0; i < conteudosSelecionados.size(); i++)
		{
			
		}
	}
}

	