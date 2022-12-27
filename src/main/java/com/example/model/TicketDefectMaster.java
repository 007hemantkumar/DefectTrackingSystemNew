package com.example.model;

public class TicketDefectMaster {
	private long ticketId;
	private String summary;
	private String description;
	private String status;
	private String assignedTo;
	private String category;
	private long version;
	private String ticketLifeStatus;
	public TicketDefectMaster() {
		super();
	}
	public TicketDefectMaster(long ticketId, String summary, String description, String status, String assignedTo,
			String category, long version, String ticketLifeStatus) {
		super();
		this.ticketId = ticketId;
		this.summary = summary;
		this.description = description;
		this.status = status;
		this.assignedTo = assignedTo;
		this.category = category;
		this.version = version;
		this.ticketLifeStatus = ticketLifeStatus;
	}
	public long getTicketId() {
		return ticketId;
	}
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public String getTicketLifeStatus() {
		return ticketLifeStatus;
	}
	public void setTicketLifeStatus(String ticketLifeStatus) {
		this.ticketLifeStatus = ticketLifeStatus;
	}
	@Override
	public String toString() {
		return "TicketDefectMaster [ticketId=" + ticketId + ", summary=" + summary + ", description=" + description
				+ ", status=" + status + ", assignedTo=" + assignedTo + ", category=" + category + ", version="
				+ version + ", ticketLifeStatus=" + ticketLifeStatus + "]";
	}

}
