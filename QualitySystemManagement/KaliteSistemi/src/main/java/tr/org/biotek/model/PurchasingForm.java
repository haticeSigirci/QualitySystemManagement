package tr.org.biotek.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "PurchasingForm")
@Entity
public class PurchasingForm implements Serializable {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "BölümAdı")
	private String DepartmentName; // changed

	//@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "Tarih")
	private java.util.Date Date; // calendar time ?

	// add if it not exist private Time time;

	//Id
	@Column(name = "RequestNo")
	private int RequestNo ;

	@Column(name = "StokSayısı")
	private int AmountOfStock; // changed

	//@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "İstenilenTarih")
	private java.util.Date DateRequested;

	@Column(name = "GenelAçıklama")
	private String GeneralExplanation;

	@Column(name = "İstenilenMiktar")
	private int QuantityRequested;

	@Column(name = "İstekSebebininAçıklanması")
	private String ExplanationOfRequestedReason;

	@Column(name = "İstenilenÜrününTanımı") // changed
	private String RequestedProductDefinition;

	@Column(name = "VerilenSiparişMiktarı")
	private int AmountOfOrder;

	@Column(name = "İhaleNo") // ihale no changed
	private int TenderCode;

	@Column(name = "İsteğiYapan")
	private String Requestor;

	@Column(name = "BölümSorumlusuOnayı")
	private String DepartmentHeadApproval;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.util.Date getDate() {
		return Date;
	}

	public void setDate(java.util.Date date) {
		Date = date;
	}

	public int getRequestNo() {
		return RequestNo;
	}

	public void setRequestNo(int requestNo) {
		RequestNo = requestNo;
	}

	public java.util.Date getDateRequested() {
		return DateRequested;
	}

	public void setDateRequested(java.util.Date dateRequested) {
		DateRequested = dateRequested;
	}

	public String getGeneralExplanation() {
		return GeneralExplanation;
	}

	public void setGeneralExplanation(String generalExplanation) {
		GeneralExplanation = generalExplanation;
	}

	public String getExplanationOfRequestedReason() {
		return ExplanationOfRequestedReason;
	}

	public void setExplanationOfRequestedReason(String explanationOfRequestedReason) {
		ExplanationOfRequestedReason = explanationOfRequestedReason;
	}

	public String getDepartmentName() {
		return DepartmentName;
	}

	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}

	public int getAmountOfStock() {
		return AmountOfStock;
	}

	public void setAmountOfStock(int amountOfStock) {
		AmountOfStock = amountOfStock;
	}

	public int getQuantityRequested() {
		return QuantityRequested;
	}

	public void setQuantityRequested(int quantityRequested) {
		QuantityRequested = quantityRequested;
	}

	public String getRequestedProductDefinition() {
		return RequestedProductDefinition;
	}

	public void setRequestedProductDefinition(String requestedProductDefinition) {
		RequestedProductDefinition = requestedProductDefinition;
	}

	public int getAmountOfOrder() {
		return AmountOfOrder;
	}

	public void setAmountOfOrder(int amountOfOrder) {
		AmountOfOrder = amountOfOrder;
	}

	public int getTenderCode() {
		return TenderCode;
	}

	public void setTenderCode(int tenderCode) {
		TenderCode = tenderCode;
	}

	public String getDepartmentHeadApproval() {
		return DepartmentHeadApproval;
	}

	public void setDepartmentHeadApproval(String departmentHeadApproval) {
		DepartmentHeadApproval = departmentHeadApproval;
	}

	public String getRequestor() {
		return Requestor;
	}

	public void setRequestor(String requestor) {
		Requestor = requestor;
	}

}
