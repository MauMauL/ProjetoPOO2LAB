package sistema.beans;


import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;
import sistema.modelos.Alternativa;
import sistema.modelos.Dissertativa;
import sistema.modelos.Item;
import sistema.modelos.MultiplaEscolha;
import sistema.modelos.Pergunta;
import sistema.modelos.VerdadeiroFalso;
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
	private List<Item> itensSelecionados;
	private List<Item> itens;
	//private UploadedFile file;
	//private String nomeFile;
   
	public void salvarAlternativa() 
	{	
		int nPergunta = 0;
		
		nPergunta = perguntas.size();
		nPergunta += 1;
		alternativa.setNumeroPerguntas(nPergunta);
		adicionaItensA();
		
		//pegaUrlA();
		
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
		//pegaUrlD();
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
		
		adicionaItensM();
		//pegaUrlM();
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
		//pegaUrlV();
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
	/*public void pegaUrlA()
	{
		alternativa.setImagem(nomeFile);
	}
	public void pegaUrlD()
	{
		dissertativa.setImagem(nomeFile);
	}
	public void pegaUrlM()
	{
		multiplaEscolha.setImagem(nomeFile);
	}
	public void pegaUrlV()
	{
		verdadeiroFalso.setImagem(nomeFile);
	}
	public void upload()
	{
		if(file != null)
		{
			nomeFile = file.getFileName();
		}
	}
	
	public String getNomeFile() {
		return nomeFile;
	}
	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}
	public UploadedFile getFile() {
		return file;
	}
	public void setFile(UploadedFile file) {
		this.file = file;
	}*/
	public List<Item> getItens() {
		if(itens == null)
		{
			itens = itemService.getItens();
		}
		
		return itens;
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
