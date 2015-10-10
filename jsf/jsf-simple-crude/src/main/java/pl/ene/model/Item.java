package pl.ene.model;

public class Item {
	
	private Long id;
	private String value;

	public Item()
	{
		id = 0L;
		value = "empty";
	}
	
	public Item(Long id, String value) {
		super();
		this.id = id;
		this.value = value;
	}

	
	public void setValue(String value) {
		this.value = value;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

}
