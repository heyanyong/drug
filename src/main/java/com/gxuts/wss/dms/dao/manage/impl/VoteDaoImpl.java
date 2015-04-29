package com.gxuts.wss.dms.dao.manage.impl;

import org.springframework.stereotype.Repository;

import com.gxuts.wss.dms.dao.BaseDao;
import com.gxuts.wss.dms.dao.manage.VoteDao;
import com.gxuts.wss.dms.entity.manage.VoteInfo;
@Repository("voteDao")
public class VoteDaoImpl extends BaseDao<VoteInfo> implements VoteDao{

}
