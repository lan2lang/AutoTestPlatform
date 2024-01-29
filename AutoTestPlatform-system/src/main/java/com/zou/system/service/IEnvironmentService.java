package com.zou.system.service;

import java.util.List;
import com.zou.system.domain.Environment;

/**
 * 环境Service接口
 *
 * @author zou
 * @date 2024-01-28
 */
public interface IEnvironmentService
{
    /**
     * 查询环境
     *
     * @param envirId 环境主键
     * @return 环境
     */
    public Environment selectEnvironmentByEnvirId(Long envirId);

    /**
     * 查询环境列表
     *
     * @param environment 环境
     * @return 环境集合
     */
    public List<Environment> selectEnvironmentList(Environment environment);

    /**
     * 新增环境
     *
     * @param environment 环境
     * @return 结果
     */
    public int insertEnvironment(Environment environment);

    /**
     * 修改环境
     *
     * @param environment 环境
     * @return 结果
     */
    public int updateEnvironment(Environment environment);

    /**
     * 批量删除环境
     *
     * @param envirIds 需要删除的环境主键集合
     * @return 结果
     */
    public int deleteEnvironmentByEnvirIds(Long[] envirIds) throws Exception;

    /**
     * 删除环境信息
     *
     * @param envirId 环境主键
     * @return 结果
     */
    public int deleteEnvironmentByEnvirId(Long envirId);
}
