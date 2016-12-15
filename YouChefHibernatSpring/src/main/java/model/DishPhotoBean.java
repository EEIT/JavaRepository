package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dishPhoto")
public class DishPhotoBean implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int dp_id;
	private int md_id;
	private byte[] d_photo;
	private int d_id;
	
	@Override
	public String toString() {
		return "DishPhotoBean[dp_id = " + dp_id + ", md_id = " + md_id + ", d_photo = " 
				+ d_photo + ", d_id = " + d_id + "]";
	}
	public int getDp_id() {
		return dp_id;
	}
	public void setDp_id(int dp_id) {
		this.dp_id = dp_id;
	}
	public int getMd_id() {
		return md_id;
	}
	public void setMd_id(int md_id) {
		this.md_id = md_id;
	}
	public byte[] getD_photo() {
		return d_photo;
	}
	public void setD_photo(byte[] d_photo) {
		this.d_photo = d_photo;
	}
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	
}
