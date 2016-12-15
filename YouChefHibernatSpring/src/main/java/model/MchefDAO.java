package model;

import java.util.List;

public interface MchefDAO {
	MchefBean select (MchefBean mc_id);

	int insert(MchefBean bean);
	
	List<MchefBean> selectAll();
}
