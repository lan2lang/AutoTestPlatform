package com.zou.system.mapper;

import java.util.List;
import com.zou.system.domain.Caseinfo;

/**
 * 用例管理Mapper接口
 * 
 * @author zou
 * @date 2024-01-28
 */
public interface CaseinfoMapper 
{
    /**
     * 查询用例管理
     * 
     * @param caseId 用例管理主键
     * @return 用例管理
     */
    public Caseinfo selectCaseinfoByCaseId(Long caseId);

    /**
     * 查询用例管理列表
     * 
     * @param caseinfo 用例管理
     * @return 用例管理集合
     */
    public List<Caseinfo> selectCaseinfoList(Caseinfo caseinfo);

    /**
     * 新增用例管理
     * 
     * @param caseinfo 用例管理
     * @return 结果
     */
    public int insertCaseinfo(Caseinfo caseinfo);

    /**
     * 修改用例管理
     * 
     * @param caseinfo 用例管理
     * @return 结果
     */
    public int updateCaseinfo(Caseinfo caseinfo);

    /**
     * 删除用例管理
     * 
     * @param caseId 用例管理主键
     * @return 结果
     */
    public int deleteCaseinfoByCaseId(Long caseId);

    /**
     * 批量删除用例管理
     * 
     * @param caseIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCaseinfoByCaseIds(Long[] caseIds);
}
