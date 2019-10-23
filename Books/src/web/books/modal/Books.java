package web.books.modal;

import org.bson.types.ObjectId;

public class Books {

	private ObjectId id;
	private String name;
	private String price;
	private String authorname;

	public Books() {

	}

	public Books( String name, String price, String authorname) {
		super();
		this.name = name;
		this.price = price;
		this.authorname = authorname;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setState(String authorname) {
		this.authorname = authorname;
	}

}
