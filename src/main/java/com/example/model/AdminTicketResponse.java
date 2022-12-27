package com.example.model;

public class AdminTicketResponse {

	private String ticketId;
	private String AssignedTo;
	private String summary;
	private String description;
	private String status;
	private String category;
	private String version;
	private String ticketLifeStatus;
	public AdminTicketResponse() {
		super();
	}
	public AdminTicketResponse(String ticketId, String assignedTo, String summary, String description, String status,
			String category, String version, String ticketLifeStatus) {
		super();
		this.ticketId = ticketId;
		AssignedTo = assignedTo;
		this.summary = summary;
		this.description = description;
		this.status = status;
		this.category = category;
		this.version = version;
		this.ticketLifeStatus = ticketLifeStatus;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getAssignedTo() {
		return AssignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		AssignedTo = assignedTo;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
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
		return "AdminTicketResponse [ticketId=" + ticketId + ", AssignedTo=" + AssignedTo + ", summary=" + summary
				+ ", description=" + description + ", status=" + status + ", category=" + category + ", version="
				+ version + ", ticketLifeStatus=" + ticketLifeStatus + "]";
	}
	
}
