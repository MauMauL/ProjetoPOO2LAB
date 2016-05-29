package sistema.service;

import java.util.List;

import sistema.generic.ItemDAO;
import sistema.modelos.Item;

public class ItemService 
{
	private ItemDAO itemDAO = new ItemDAO();
	
	public Item salvarItem(Item item) 
	{
		item = itemDAO.save(item);
		itemDAO.closeEntityManager();
		return item;

	}
	public List<Item> getItems() {
		List<Item> list = itemDAO.getAll(Item.class);
		itemDAO.closeEntityManager();
		return list;
	}

	public void alterar(Item item) {
		itemDAO.save(item);
		itemDAO.closeEntityManager();
	}

	public void remover(Item item) {

		item = itemDAO.getById(Item.class,
				item.getCodigoItem());
		itemDAO.remove(item);
		itemDAO.closeEntityManager();
	}
	public Item pesquisar(Item item) 
	{
		item = itemDAO.getById(Item.class, item.getCodigoItem());
		itemDAO.closeEntityManager();
		return item;
	}
}
