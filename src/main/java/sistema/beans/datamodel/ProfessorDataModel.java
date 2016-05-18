package sistema.beans.datamodel;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;
import sistema.modelos.Professor;
import sistema.service.ProfessorService;

public class ProfessorDataModel extends ListDataModel<Professor> implements SelectableDataModel<Professor>
{

private ProfessorService servico = new ProfessorService();
	
	public ProfessorDataModel()
	{
		
	}

	public ProfessorDataModel(List <Professor> list)
	{
	   super(list);	
	}

	
	@Override
	public Professor getRowData(String rowKey) {
		
		for(Professor p: servico.getProfessores())
		   if(Integer.parseInt(rowKey) ==  p.getCodigoProf())
			   return p;
		
		return null;
	}

	@Override
	public Object getRowKey(Professor professor) {
		return professor.getCodigoProf();
	}

}
