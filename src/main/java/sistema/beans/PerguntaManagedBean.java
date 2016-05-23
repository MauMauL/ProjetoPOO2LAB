package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import org.primefaces.event.RowEditEvent;
import sistema.beans.datamodel.DisciplinaDataModel;
import sistema.modelos.Alternativa;
import sistema.modelos.Dissertativa;
import sistema.modelos.MultiplaEscolha;
import sistema.modelos.Pergunta;
import sistema.modelos.Prova;
import sistema.modelos.VerdadeiroFalso;
import sistema.service.PerguntaService;


@ManagedBean
@ViewScoped
public class PerguntaManagedBean 
{
	private static final long serialVersionUID = 1L;
	
	private Alternativa alternativa = new Alternativa();
	private Dissertativa dissertativa = new Dissertativa();
	private MultiplaEscolha multiplaEscolha = new MultiplaEscolha();
	private VerdadeiroFalso verdadeiroFalso = new VerdadeiroFalso();
	private List<Pergunta> perguntas;
	private PerguntaService perguntaService = new PerguntaService();

	public void salvarAlternativa() 
	{
		int nPergunta = 0;
		
		nPergunta = perguntas.size();
		nPergunta += 1;
		alternativa.setNumeroPerguntas(nPergunta);
		
		perguntaService.salvarAlternativa(alternativa);
	
		if(perguntas != null)
		{
			perguntas.add(alternativa);
		}
	
		alternativa = new Alternativa();

	}
	public void salvarDissertativa() 
	{
		int nPergunta;
		
		nPergunta = perguntas.size();
		nPergunta += 1;
		
		dissertativa.setNumeroPerguntas(nPergunta);
		
		perguntaService.salvarDissertativa(dissertativa);
		
		if(perguntas != null)
		{
			perguntas.add(dissertativa);
		}
		
		dissertativa = new Dissertativa();

	}
	public void salvarMultiplaEscolha() 
	{
		int nPergunta;
	
		nPergunta = perguntas.size();
		nPergunta += 1;
		
		multiplaEscolha.setNumeroPerguntas(nPergunta);
		
		perguntaService.salvarMultiplaEscolha(multiplaEscolha);
		
		if(perguntas != null)
		{
			perguntas.add(multiplaEscolha);
		}
		
		multiplaEscolha = new MultiplaEscolha();
	}
	public void salvarVerdadeiroFalso() 
	{
		int nPergunta;
		
		nPergunta = perguntas.size();
		nPergunta += 1;
		
		verdadeiroFalso.setNumeroPerguntas(nPergunta);
		
		perguntaService.salvarVerdadeiroFalso(verdadeiroFalso);
		
		if(perguntas != null)
		{
			perguntas.add(verdadeiroFalso);
		}
		
		verdadeiroFalso = new VerdadeiroFalso();
	}

	public Alternativa getAlternativa() {
		return alternativa;
	}
	public void setAlternativa(Alternativa alternativa) {
		this.alternativa = alternativa;
	}
	public Dissertativa getDissertativa() {
		return dissertativa;
	}
	public void setDissertativa(Dissertativa dissertativa) {
		this.dissertativa = dissertativa;
	}
	public MultiplaEscolha getMultiplaEscolha() {
		return multiplaEscolha;
	}
	public void setMultiplaEscolha(MultiplaEscolha multiplaEscolha) {
		this.multiplaEscolha = multiplaEscolha;
	}
	public VerdadeiroFalso getVerdadeiroFalso() {
		return verdadeiroFalso;
	}
	public void setVerdadeiroFalso(VerdadeiroFalso verdadeiroFalso) {
		this.verdadeiroFalso = verdadeiroFalso;
	}
	public List<Pergunta> getPerguntas() {
		if(perguntas == null)
		{
			perguntas = perguntaService.getPerguntas();
		}
		return perguntas;
	}
	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}
	public void removeAlternativa(Alternativa alternativa) {
		perguntaService.remover(alternativa);
		perguntas.remove(alternativa);
	}
	public void removeDissertativa(Dissertativa dissertativa) {
		perguntaService.remover(dissertativa);
		perguntas.remove(dissertativa);
	}
	public void removeMultiplaEscolha(MultiplaEscolha multiplaEscolha) {
		perguntaService.remover(multiplaEscolha);
		perguntas.remove(multiplaEscolha);
	}
	public void removeVerdadeiroFalso(VerdadeiroFalso verdadeiroFalso) {
		perguntaService.remover(verdadeiroFalso);
		perguntas.remove(verdadeiroFalso);
	}
	public void removePergunta(Pergunta pergunta) {
		perguntaService.remover(pergunta);
		perguntas.remove(pergunta);
	}
	
}
