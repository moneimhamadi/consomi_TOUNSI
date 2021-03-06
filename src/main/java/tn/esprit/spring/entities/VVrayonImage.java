package tn.esprit.spring.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;





@Entity
@Table(name = "images")
public class VVrayonImage {
	
	private static final long SerialVersionUID=1L;
	
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public int idImage ;
	public String NameImage ;
	public String type ;
	
	
	@Lob
	private byte[] data;

	
	
	
	
	
	
	

	public VVrayonImage() {
		super();
		// TODO Auto-generated constructor stub
	}


	public VVrayonImage(int idImage, String nameImage, String type, byte[] data) {
		super();
		this.idImage = idImage;
		NameImage = nameImage;
		this.type = type;
		this.data = data;
	}

	
	
	
	

	public Department getDepartment() {
		return Department;
	}


	public void setDepartment(Department department) {
		Department = department;
	}


	public int getIdImage() {
		return idImage;
	}


	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}


	public String getNameImage() {
		return NameImage;
	}


	public void setNameImage(String nameImage) {
		NameImage = nameImage;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public VVrayonImage(String nameImage, String type, byte[] data) {
		super();
		NameImage = nameImage;
		this.type = type;
		this.data = data;
	}
	
	
	
	
	//@JsonIgnore
		@ManyToOne
		Department Department ;
	
	
	

}
