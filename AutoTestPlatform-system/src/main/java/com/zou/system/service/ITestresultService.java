package com.zou.system.service;

import java.io.IOException;
import java.util.List;
import com.zou.system.domain.Testresult;
import com.zou.system.domain.vo.TestReportVo;

/**
 * 测试结果Service接口
 *
 * @author zou
 * @date 2024-01-30
 */
public interface ITestresultService
{
    /**
     * 查询测试结果
     *
     * @param resultId 测试结果主键
     * @return 测试结果
     */
    public Testresult selectTestresultByResultId(Long resultId);

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
     * 批量删除测试结果
     *
     * @param resultIds 需要删除的测试结果主键集合
     * @return 结果
     */
    public int deleteTestresultByResultIds(Long[] resultIds);

    /**
     * 删除测试结果信息
     *
     * @param resultId 测试结果主键
     * @return 结果
     */
    public int deleteTestresultByResultId(Long resultId);

    /**
     * 执行测试用例
     * @param testresult
     * @return
     */
    int executeCase(Testresult testresult) throws IOException, InterruptedException;

    /**
     * 生成测试报告
     * @param testresult
     * @return
     */
    TestReportVo selectTestReport(Testresult testresult);
}
