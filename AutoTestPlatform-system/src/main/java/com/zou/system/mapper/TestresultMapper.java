package com.zou.system.mapper;

import java.util.List;
import com.zou.system.domain.Testresult;

/**
 * 测试结果Mapper接口
 * 
 * @author zou
 * @date 2024-01-28
 */
public interface TestresultMapper 
{
    /**
     * 查询测试结果
     * 
     * @param resultId 测试结果主键
     * @return 测试结果
     */
    public Testresult selectTestresultByResultId(Integer resultId);

    /**
     * 查询测试结果列表
     * 
     * @param testresult 测试结果
     * @return 测试结果集合
     */
    public List<Testresult> selectTestresultList(Testresult testresult);

    /**
     * 新增测试结果
     * 
     * @param testresult 测试结果
     * @return 结果
     */
    public int insertTestresult(Testresult testresult);

    /**
     * 修改测试结果
     * 
     * @param testresult 测试结果
     * @return 结果
     */
    public int updateTestresult(Testresult testresult);

    /**
     * 删除测试结果
     * 
     * @param resultId 测试结果主键
     * @return 结果
     */
    public int deleteTestresultByResultId(Integer resultId);

    /**
     * 批量删除测试结果
     * 
     * @param resultIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTestresultByResultIds(Integer[] resultIds);
}
