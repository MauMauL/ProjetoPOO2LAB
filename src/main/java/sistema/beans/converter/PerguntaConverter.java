package sistema.beans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.modelos.Pergunta;
import sistema.service.PerguntaService;

@FacesConverter("converterPergunta")
public class PerguntaConverter implements Converter 
{
private PerguntaService servico = new PerguntaService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) 
	{

		
		if (value != null && !value.isEmpty()) {
			
			  for(Pergunta p : servico.getPerguntas())
				 if(p.getEnunciado().equals(value))
				  	return p;
					
		}

		return null;

	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic,
			Object pergunta) {
		if (pergunta == null || pergunta.equals("")) {
			return null;
		} else {
			return ((Pergunta) pergunta).getEnunciado();

		}
	}
}
