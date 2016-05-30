package sistema.beans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sistema.modelos.Item;
import sistema.service.ItemService;

@FacesConverter("converterItem")
public class ItemConverter implements Converter 
{
	
	private ItemService servico = new ItemService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) 
	{

		
		if (value != null && !value.isEmpty()) {
			
			  for(Item i : servico.getItens())
				 if(i.getAlternativa().equals(value))
				  	return i;
					
		}

		return null;

	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic,
			Object item) {
		if (item == null || item.equals("")) {
			return null;
		} else {
			return ((Item) item).getAlternativa();

		}
	}
}
