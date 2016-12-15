package model;

public interface MchefDAO {
	MchefBean select (Integer mc_id);

	boolean insert(MchefBean bean);
}
