package data;

public class Candidates {
	private int id;
	private String firstname;
	private String surname;
	public Candidates(String id, String firstname, String surname) {
		setId(id);
		this.firstname=firstname;
		this.surname=surname;
		
	}
	public Candidates() {

		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
		
	}
	public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	public String getfirstname() {
		return firstname;
	}
	public void setfirstname(String firstname) {
		this.firstname = firstname;
		
	}
	public String getsurname() {
		
		return surname;
	}
	public void setsurname(String surname) {
		this.surname = surname;
		
	}
	
	
}