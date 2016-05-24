package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import sistema.modelos.Disciplina;
import sistema.modelos.Pergunta;
import sistema.modelos.Prova;
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
	private List<Pergunta> perguntasSelecionadas;
	private List<Prova> provas;
	private PerguntaService perguntaService = new PerguntaService();
	private ProvaService provaService = new ProvaService();
	private DisciplinaService discService = new DisciplinaService();
	
	public void salvar() 
	{
		/*for(int i = 0; i < perguntasSelecionadas.size();i++)
		{
			prova.addPergunta(perguntasSelecionadas.get(i));
			perguntasSelecionadas.get(i).addProva(prova);
		}*/
		
		disciplina.addProva(prova);
		prova.setDisciplina(disciplina);
		
		prova = provaService.salvar(prova);

		if (provas != null)
			provas.add(prova);

		prova = new Prova();
		disciplina = null;
	}
	
	
	public List<Pergunta> getPerguntasSelecionadas() {
		return perguntasSelecionadas;
	}

	public void setPerguntasSelecionadas(List<Pergunta> perguntasSelecionadas) {
		this.perguntasSelecionadas = perguntasSelecionadas;
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
	public List<Pergunta> getPerguntas() {
		return perguntaService.getPerguntas();
	}

	public void remover(Prova prova) {
		provaService.remover(prova);
		provas.remove(prova);
	}
	public void onRowEdit(RowEditEvent event) {

		Prova p = ((Prova) event.getObject());
		provaService.alterar(p);
	}
}
