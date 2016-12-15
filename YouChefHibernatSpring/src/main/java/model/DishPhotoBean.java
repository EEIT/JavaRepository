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
	private Integer dp_id;
	private Integer md_id;
	private Byte[] d_photo;
	private Integer d_id;
	
	@Override
	public String toString() {
		return "DishPhotoBean[dp_id = " + dp_id + ", md_id = " + md_id + ", d_photo = " 
				+ d_photo + ", d_id = " + d_id + "]";
	}
	public Integer getDp_id() {
		return dp_id;
	}
	public void setDp_id(Integer dp_id) {
		this.dp_id = dp_id;
	}
	public Integer getMd_id() {
		return md_id;
	}
	public void setMd_id(Integer md_id) {
		this.md_id = md_id;
	}
	public Byte[] getD_photo() {
		return d_photo;
	}
	public void setD_photo(Byte[] d_photo) {
		this.d_photo = d_photo;
	}
	public Integer getD_id() {
		return d_id;
	}
	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}
	
}
