package com.gxuts.wss.dms.service.process;

import java.util.List;

import com.gxuts.wss.dms.entity.hr.UserInfo;

public interface FlowUserService {
	public List<String> manyByRole(String roleName);
	public String oneByRole(String roleName);
	public String leaderByRole(int departmentId, String roleName);
}
