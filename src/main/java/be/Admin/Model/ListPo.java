package be.Admin.Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "listpo")
public class ListPo {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private Date tglord;
	private Date tglexp;
	private String deschead;
	private int jumlah;
	private int  vol;
	private String satuan;
	private float itmprice;
	private float itemsell;
	
	public Date getTglord() {
		return tglord;
	}
	public void setTglord(Date tglord) {
		this.tglord = tglord;
	}
	public Date getTglexp() {
		return tglexp;
	}
	public void setTglexp(Date tglexp) {
		this.tglexp = tglexp;
	}
	public String getDeschead() {
		return deschead;
	}
	public void setDeschead(String deschead) {
		this.deschead = deschead;
	}
	public int getJumlah() {
		return jumlah;
	}
	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}
	public int getVol() {
		return vol;
	}
	public void setVol(int vol) {
		this.vol = vol;
	}
	public String getSatuan() {
		return satuan;
	}
	public void setSatuan(String satuan) {
		this.satuan = satuan;
	}
	public float getItmprice() {
		return itmprice;
	}
	public void setItmprice(float itmprice) {
		this.itmprice = itmprice;
	}
	public float getItemsell() {
		return itemsell;
	}
	public void setItemsell(float itemsell) {
		this.itemsell = itemsell;
	}
	
}
