package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mChef")
public class MchefBean {
	@Id
	private int mc_id;
	private int years;
	private String venue;
	private int quota;
	private String background;
	private int v_id;
	private int hasPlace;

	@Override
	public String toString() {
		return "MchefBean[mc_id = " + mc_id + ", years = " + years + ", venue = " 
				+ venue + ", quota = " + quota + ", background = " + background 
				+ ", v_id = " + v_id + ", hasPlace = " + hasPlace + "]";
	}

	public int getMc_id() {
		return mc_id;
	}

	public void setMc_id(int mc_id) {
		this.mc_id = mc_id;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public int getQuota() {
		return quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public int getV_id() {
		return v_id;
	}

	public void setV_id(int v_id) {
		this.v_id = v_id;
	}

	public int getHasPlace() {
		return hasPlace;
	}

	public void setHasPlace(int hasPlace) {
		this.hasPlace = hasPlace;
	}
}
