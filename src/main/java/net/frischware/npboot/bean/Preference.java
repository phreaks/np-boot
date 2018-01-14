package net.frischware.npboot.bean;

import java.sql.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author 
 *
 */
public class Preference {

	private Long id;
	private String functionalId;
	private Long customerNr;
	private Long partnerNr;
	private Long accountNr;
	private String channel;
	private Boolean enabled;
	private String address;
	private String channelName;
	private String channelType;
	private Date created;
	private Date updated;
	private Date deleted;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the functionalId
	 */
	public String getFunctionalId() {
		return functionalId;
	}
	/**
	 * @param functionalId the functionalId to set
	 */
	public void setFunctionalId(String functionalId) {
		this.functionalId = functionalId;
	}
	/**
	 * @return the customerNr
	 */
	public Long getCustomerNr() {
		return customerNr;
	}
	/**
	 * @param customerNr the customerNr to set
	 */
	public void setCustomerNr(Long customerNr) {
		this.customerNr = customerNr;
	}
	/**
	 * @return the partnerNr
	 */
	public Long getPartnerNr() {
		return partnerNr;
	}
	/**
	 * @param partnerNr the partnerNr to set
	 */
	public void setPartnerNr(Long partnerNr) {
		this.partnerNr = partnerNr;
	}
	/**
	 * @return the accountNr
	 */
	public Long getAccountNr() {
		return accountNr;
	}
	/**
	 * @param accountNr the accountNr to set
	 */
	public void setAccountNr(Long accountNr) {
		this.accountNr = accountNr;
	}
	/**
	 * @return the channel
	 */
	public String getChannel() {
		return channel;
	}
	/**
	 * @param channel the channel to set
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}
	/**
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}
	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the channelName
	 */
	public String getChannelName() {
		return channelName;
	}
	/**
	 * @param channelName the channelName to set
	 */
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	/**
	 * @return the channelType
	 */
	public String getChannelType() {
		return channelType;
	}
	/**
	 * @param channelType the channelType to set
	 */
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}
	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	/**
	 * @return the updated
	 */
	public Date getUpdated() {
		return updated;
	}
	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	/**
	 * @return the deleted
	 */
	public Date getDeleted() {
		return deleted;
	}
	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(Date deleted) {
		this.deleted = deleted;
	}

	public String toJsonString() {
		ObjectMapper converter = new ObjectMapper();
		try {
			return converter.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "could not convert to json";
	}
	
	
}
