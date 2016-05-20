package sistema.modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class VerdadeiroFalso extends Pergunta
{
	
	private List<Item> itens = new ArrayList<Item>(); 
	
	public List<Item> getItens() 
	{
		return itens;
	}
	public void setItens(List<Item> itens) 
	{
		this.itens = itens;
	}
	public void addItens(Item item)
	{
		itens.add(item);
	}
}
