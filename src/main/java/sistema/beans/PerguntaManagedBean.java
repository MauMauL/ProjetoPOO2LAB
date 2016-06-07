package sistema.beans;


import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;
import sistema.modelos.Alternativa;
import sistema.modelos.Dissertativa;
import sistema.modelos.Item;
import sistema.modelos.MultiplaEscolha;
import sistema.modelos.Pergunta;
import sistema.modelos.VerdadeiroFalso;
import sistema.service.DissertativaService;
import sistema.service.ItemService;
import sistema.service.PerguntaService;


@ManagedBean
@ViewScoped
public class PerguntaManagedBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Alternativa alternativa = new Alternativa();
	private Dissertativa dissertativa = new Dissertativa();
	private MultiplaEscolha multiplaEscolha = new MultiplaEscolha();
	private VerdadeiroFalso verdadeiroFalso = new VerdadeiroFalso();
	private List<Pergunta> perguntas;
	private PerguntaService perguntaService = new PerguntaService();
	private ItemService itemService = new ItemService();
	private DissertativaService dissertativaService = new DissertativaService();
	private List<Item> itensSelecionados;
	private List<Item> itens;
	private List<Dissertativa> dissertativas;
   
	public void salvarAlternativa() 
	{		
		adicionaItensA();
		
		
		perguntaService.salvarAlternativa(alternativa);
	
		if(perguntas != null)
		{
			perguntas.add(alternativa);
		}
		alternativa = new Alternativa();

	}
	public void salvarDissertativa() 
	{
		perguntaService.salvarDissertativa(dissertativa);
		
		if(perguntas != null)
		{
			perguntas.add(dissertativa);
		}
		if(dissertativas != null)
		{
			dissertativas.add(dissertativa);
		}
		
		dissertativa = new Dissertativa();

	}
	public void salvarMultiplaEscolha() 
	{		
		adicionaItensM();
		perguntaService.salvarMultiplaEscolha(multiplaEscolha);
		
		if(perguntas != null)
		{
			perguntas.add(multiplaEscolha);
		}
		
		multiplaEscolha = new MultiplaEscolha();
	}
	public void salvarVerdadeiroFalso() 
	{

		adicionaItensV();
		
		perguntaService.salvarVerdadeiroFalso(verdadeiroFalso);
		
		if(perguntas != null)
		{
			perguntas.add(verdadeiroFalso);
		}
		
		verdadeiroFalso = new VerdadeiroFalso();
	}
	public void adicionaItensA()
	{
		for(int i = 0; i < itensSelecionados.size(); i++)
		{
			alternativa.addItens(itensSelecionados.get(i));
		}
	}
	public void adicionaItensM()
	{
		for(int i = 0; i < itensSelecionados.size(); i++)
		{
			multiplaEscolha.addItens(itensSelecionados.get(i));
		}
	}
	public void adicionaItensV()
	{
		for(int i = 0; i < itensSelecionados.size(); i++)
		{
			verdadeiroFalso.addItens(itensSelecionados.get(i));
		}
	}
	public List<Item> getItens() {
		if(itens == null)
		{
			itens = itemService.getItens();
		}
		
		return itens;
	}
	public List<Dissertativa> getDissertativas() 
	{
		if(dissertativas == null)
		{	
			dissertativas = dissertativaService.getDissertativas();
		}
		return dissertativas;	
	}
	public void setDissertativas(List<Dissertativa> dissertativas) {
		this.dissertativas = dissertativas;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	public List<Item> getItensSelecionados() {
		return itensSelecionados;
	}
	public void setItensSelecionados(List<Item> itensSelecionados) {
		this.itensSelecionados = itensSelecionados;
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
	public void onRowEdit(RowEditEvent event) {

		Pergunta p = ((Pergunta) event.getObject());
		perguntaService.alterar(p);
	}
	
}
