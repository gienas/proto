package pl.ene;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import pl.ene.model.Item;

@ManagedBean
@SessionScoped
public class Bean implements Serializable {

    private List<Item> list = new ArrayList<Item>();
    private Item item = new Item();
    private boolean edit = true;

    
    public Bean()
    {

    }
    
    @PostConstruct
    public void init() {
        // list = dao.list();
        // Actually, you should retrieve the list from DAO. This is just for demo.
   
        list = new ArrayList<Item>();
        list.add(new Item(1L, "Ala ma kota, ala ma kota, ala ma kota"));
        list.add(new Item(2L, "Ala ma psa, ala ma psa, ala ma psa"));
        list.add(new Item(3L, "Ala ma myszkê, ala ma myszkê, ala ma myszkê ...."));
        System.out.println("Default contructor call");
    }

    public void add() {
         //dao.create(item);
        // Actually, the DAO should already have set the ID from DB. This is just for demo.
        item.setId(list.isEmpty() ? 1 : list.get(list.size() - 1).getId() + 1);
        list.add(item);
        item = new Item(); // Reset placeholder.
    }

    public void edit(Item item) {
        this.item = item;
        edit = true;
    }
    public void save() {
        // dao.update(item);
        item = new Item(); // Reset placeholder.
        edit = false;
    }

    public void delete(Item item) {
        // dao.delete(item);
        list.remove(item);
    }

    public List<Item> getList() {
    	System.out.println("getList");
        return list;
    }

    public Item getItem() {
        return item;
    }

    public boolean isEdit() {
        return edit;
    }

	public void setList(List<Item> list) {
		this.list = list;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

    
    
    // Other getters/setters are actually unnecessary. Feel free to add them though.

}