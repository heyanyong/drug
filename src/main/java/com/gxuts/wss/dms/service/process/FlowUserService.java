package com.gxuts.wss.dms.service.process;

import java.util.List;

import com.gxuts.wss.dms.entity.hr.UserInfo;

public interface FlowUserService {
	public String departmentOneRole(int departmentId,String roleName);
	public List<UserInfo> manyByRole(String roleName);
	public UserInfo leaderOneRole(int departmentId, String roleName);
}
