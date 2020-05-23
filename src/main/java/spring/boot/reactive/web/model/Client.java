package spring.boot.reactive.web.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("client")
public class Client {

	@Id
	private String id;
	private String name;
	private String domian;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDomian() {
		return domian;
	}
	public void setDomian(String domian) {
		this.domian = domian;
	}
	
}
