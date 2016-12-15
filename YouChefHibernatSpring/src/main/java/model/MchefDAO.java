package model;

public interface MchefDAO {
	MchefBean select (MchefBean mc_id);

	int insert(MchefBean bean);
}
