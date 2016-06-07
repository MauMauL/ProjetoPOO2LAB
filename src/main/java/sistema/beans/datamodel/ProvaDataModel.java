package sistema.beans.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;
import sistema.modelos.Prova;
import sistema.service.ProvaService;

public class ProvaDataModel extends ListDataModel<Prova> implements SelectableDataModel<Prova> 
{
private ProvaService servico = new ProvaService();
	
	public ProvaDataModel()
	{
		
	}

	public ProvaDataModel(List <Prova> list)
	{
	   super(list);	
	}

	
	@Override
	public Prova getRowData(String rowKey) {
		
		for(Prova p: servico.getProvas())
		   if(Integer.parseInt(rowKey) ==  p.getCodProva())
			   return servico.pesquisar(p);
		
		return null;
	}

	@Override
	public Object getRowKey(Prova prova) {
		return prova.getCodProva();
	}

}
