package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



//@JsonIgnoreProperties
@Entity
@Table (name = "T_PUBLICITY")
public class Publicity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idPublicity ;
	private String namePublicity ;
	@Temporal (TemporalType.DATE)
	private Date startDatePublicity ;
	@Temporal (TemporalType.DATE)
	private Date endDatePublicity ;
	@Enumerated (EnumType.STRING)
	private TargetPublicity targetPublicity ;
	@Enumerated (EnumType.STRING)
	private ChannelPublicity channelPublicity ;
	private float costPublicity ;
	private boolean statusPublicity ;
	private String mailOwnerPublicity ;
	private int phoneOwnerPublicity ;
	private String typePublicity ;
	private String descriptionPublicity ;
	private int InitialViewNumber ;
	private int finalViewNumber ;
	
	public Publicity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Publicity(int idPublicity, String namePublicity, Date startDatePublicity, Date endDatePublicity,
			TargetPublicity targetPublicity, ChannelPublicity channelPublicity, float costPublicity,
			boolean statusPublicity, String mailOwnerPublicity, int phoneOwnerPublicity, String typePublicity,
			String descriptionPublicity, int initialViewNumber, int finalViewNumber) {
		super();
		this.idPublicity = idPublicity;
		this.namePublicity = namePublicity;
		this.startDatePublicity = startDatePublicity;
		this.endDatePublicity = endDatePublicity;
		this.targetPublicity = targetPublicity;
		this.channelPublicity = channelPublicity;
		this.costPublicity = costPublicity;
		this.statusPublicity = statusPublicity;
		this.mailOwnerPublicity = mailOwnerPublicity;
		this.phoneOwnerPublicity = phoneOwnerPublicity;
		this.typePublicity = typePublicity;
		this.descriptionPublicity = descriptionPublicity;
		InitialViewNumber = initialViewNumber;
		this.finalViewNumber = finalViewNumber;
	}

	//@JsonIgnore
	@ManyToOne
	Administrator Administrator;
	@JsonIgnore
	@ManyToOne
	Event event;
	
	
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		event = event;
	}

	public void setStartDatePublicity(Date startDatePublicity) {
		this.startDatePublicity = startDatePublicity;
	}
	public void setEndDatePublicity(Date endDatePublicity) {
		this.endDatePublicity = endDatePublicity;
	}
	public int getIdPublicity() {
		return idPublicity;
	}
	public void setIdPublicity(int idPublicity) {
		this.idPublicity = idPublicity;
	}
	public String getNamePublicity() {
		return namePublicity;
	}
	public void setNamePublicity(String namePublicity) {
		this.namePublicity = namePublicity;
	}
	public float getCostPublicity() {
		return costPublicity;
	}
	public void setCostPublicity(float costPublicity) {
		this.costPublicity = costPublicity;
	}
	public String getMailOwnerPublicity() {
		return mailOwnerPublicity;
	}
	public void setMailOwnerPublicity(String mailOwnerPublicity) {
		this.mailOwnerPublicity = mailOwnerPublicity;
	}
	public int getPhoneOwnerPublicity() {
		return phoneOwnerPublicity;
	}
	public void setPhoneOwnerPublicity(int phoneOwnerPublicity) {
		this.phoneOwnerPublicity = phoneOwnerPublicity;
	}
	public String getTypePublicity() {
		return typePublicity;
	}
	public void setTypePublicity(String typePublicity) {
		this.typePublicity = typePublicity;
	}
	public String getDescriptionPublicity() {
		return descriptionPublicity;
	}
	public void setDescriptionPublicity(String descriptionPublicity) {
		this.descriptionPublicity = descriptionPublicity;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	//@Enumerated (EnumType.STRING)
	public ChannelPublicity getChannelPublicity() {
		return channelPublicity;
	}
	public void setChannelPublicity(ChannelPublicity channelPublicity) {
		this.channelPublicity = channelPublicity;
	}
	public TargetPublicity getTargetPublicity() {
		return targetPublicity;
	}
	public void setTargetPublicity(TargetPublicity targetPublicity) {
		this.targetPublicity = targetPublicity;
	}
	public boolean isStatusPublicity() {
		return statusPublicity;
	}
	public void setStatusPublicity(boolean statusPublicity) {
		this.statusPublicity = statusPublicity;
	}
	public int getInitialViewNumber() {
		return InitialViewNumber;
	}
	public void setInitialViewNumber(int initialViewNumber) {
		InitialViewNumber = initialViewNumber;
	}
	public int getFinalViewNumber() {
		return finalViewNumber;
	}
	public void setFinalViewNumber(int finalViewNumber) {
		this.finalViewNumber = finalViewNumber;
	}
	public Administrator getAdministrator() {
		return Administrator;
	}
	public void setAdministrator(Administrator administrator) {
		Administrator = administrator;
	}
	public Date getStartDatePublicity() {
		return startDatePublicity;
	}
	public Date getEndDatePublicity() {
		return endDatePublicity;
	}
	
	
}
