package model;

public interface MchefDAO {
	MchefBean select (int mc_id);

	boolean insert(MchefBean bean);
}
