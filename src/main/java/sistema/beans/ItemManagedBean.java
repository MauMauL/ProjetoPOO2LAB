package sistema.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Item;
import sistema.service.ItemService;

@ManagedBean
@ViewScoped
public class ItemManagedBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Item item = new Item();
	private ItemService itemService = new ItemService();
	private List<Item> itens; 

	
	public void salvar()
	{
		item = itemService.salvarItem(item);
		
		if(itens != null)
		{
			itens.add(item);
		}
		
		item = new Item();
	}
	public void remover(Item item)
	{
		itemService.remover(item);
		itens.remove(item);
	}
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
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
	public void onRowEdit(RowEditEvent event) {

		Item i = ((Item) event.getObject());
		itemService.alterar(i);
	}

	
}
