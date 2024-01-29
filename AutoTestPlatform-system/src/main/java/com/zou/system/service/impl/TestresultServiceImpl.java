package com.zou.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zou.system.mapper.TestresultMapper;
import com.zou.system.domain.Testresult;
import com.zou.system.service.ITestresultService;

/**
 * 测试结果Service业务层处理
 * 
 * @author zou
 * @date 2024-01-28
 */
@Service
public class TestresultServiceImpl implements ITestresultService 
{
    @Autowired
    private TestresultMapper testresultMapper;

    /**
     * 查询测试结果
     * 
     * @param resultId 测试结果主键
     * @return 测试结果
     */
    @Override
    public Testresult selectTestresultByResultId(Integer resultId)
    {
        return testresultMapper.selectTestresultByResultId(resultId);
    }

    /**
     * 查询测试结果列表
     * 
     * @param testresult 测试结果
     * @return 测试结果
     */
    @Override
    public List<Testresult> selectTestresultList(Testresult testresult)
    {
        return testresultMapper.selectTestresultList(testresult);
    }

    /**
     * 新增测试结果
     * 
     * @param testresult 测试结果
     * @return 结果
     */
    @Override
    public int insertTestresult(Testresult testresult)
    {
        return testresultMapper.insertTestresult(testresult);
    }

    /**
     * 修改测试结果
     * 
     * @param testresult 测试结果
     * @return 结果
     */
    @Override
    public int updateTestresult(Testresult testresult)
    {
        return testresultMapper.updateTestresult(testresult);
    }

    /**
     * 批量删除测试结果
     * 
     * @param resultIds 需要删除的测试结果主键
     * @return 结果
     */
    @Override
    public int deleteTestresultByResultIds(Integer[] resultIds)
    {
        return testresultMapper.deleteTestresultByResultIds(resultIds);
    }

    /**
     * 删除测试结果信息
     * 
     * @param resultId 测试结果主键
     * @return 结果
     */
    @Override
    public int deleteTestresultByResultId(Integer resultId)
    {
        return testresultMapper.deleteTestresultByResultId(resultId);
    }
}
