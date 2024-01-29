package com.zou.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zou.system.mapper.CaseinfoMapper;
import com.zou.system.domain.Caseinfo;
import com.zou.system.service.ICaseinfoService;

/**
 * 用例管理Service业务层处理
 * 
 * @author zou
 * @date 2024-01-28
 */
@Service
public class CaseinfoServiceImpl implements ICaseinfoService 
{
    @Autowired
    private CaseinfoMapper caseinfoMapper;

    /**
     * 查询用例管理
     * 
     * @param caseId 用例管理主键
     * @return 用例管理
     */
    @Override
    public Caseinfo selectCaseinfoByCaseId(Long caseId)
    {
        return caseinfoMapper.selectCaseinfoByCaseId(caseId);
    }

    /**
     * 查询用例管理列表
     * 
     * @param caseinfo 用例管理
     * @return 用例管理
     */
    @Override
    public List<Caseinfo> selectCaseinfoList(Caseinfo caseinfo)
    {
        return caseinfoMapper.selectCaseinfoList(caseinfo);
    }

    /**
     * 新增用例管理
     * 
     * @param caseinfo 用例管理
     * @return 结果
     */
    @Override
    public int insertCaseinfo(Caseinfo caseinfo)
    {
        return caseinfoMapper.insertCaseinfo(caseinfo);
    }

    /**
     * 修改用例管理
     * 
     * @param caseinfo 用例管理
     * @return 结果
     */
    @Override
    public int updateCaseinfo(Caseinfo caseinfo)
    {
        return caseinfoMapper.updateCaseinfo(caseinfo);
    }

    /**
     * 批量删除用例管理
     * 
     * @param caseIds 需要删除的用例管理主键
     * @return 结果
     */
    @Override
    public int deleteCaseinfoByCaseIds(Long[] caseIds)
    {
        return caseinfoMapper.deleteCaseinfoByCaseIds(caseIds);
    }

    /**
     * 删除用例管理信息
     * 
     * @param caseId 用例管理主键
     * @return 结果
     */
    @Override
    public int deleteCaseinfoByCaseId(Long caseId)
    {
        return caseinfoMapper.deleteCaseinfoByCaseId(caseId);
    }
}
