package com.gxuts.wss.drug.service.hr;

import java.io.Serializable;

import com.gxuts.wss.drug.entity.RoleInfo;

public interface RoleService {
	public Serializable save(RoleInfo role);

	public RoleInfo get(Class<RoleInfo> c, Serializable id);

}
