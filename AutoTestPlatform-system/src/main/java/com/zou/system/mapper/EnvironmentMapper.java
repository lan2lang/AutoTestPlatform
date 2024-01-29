package com.zou.system.mapper;

import java.util.List;
import com.zou.system.domain.Environment;
import com.zou.system.domain.Interinfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 环境Mapper接口
 *
 * @author zou
 * @date 2024-01-28
 */
public interface EnvironmentMapper
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
     * 删除环境
     *
     * @param envirId 环境主键
     * @return 结果
     */
    public int deleteEnvironmentByEnvirId(Long envirId);

    /**
     * 批量删除环境
     *
     * @param envirIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEnvironmentByEnvirIds(Long[] envirIds);

    /**
     * 批量删除接口管理
     *
     * @param envirIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteInterinfoByEnvirIds(Long[] envirIds);

    /**
     * 批量新增接口管理
     *
     * @param interinfoList 接口管理列表
     * @return 结果
     */
    public int batchInterinfo(List<Interinfo> interinfoList);


    /**
     * 通过环境主键删除接口管理信息
     *
     * @param envirId 环境ID
     * @return 结果
     */
    public int deleteInterinfoByEnvirId(Long envirId);

    /**
     * 检查环境下是否有接口
     * @return
     */
    @Select({
            "<script>",
            "SELECT COUNT(1) from interinfo where envirId IN",
            "<foreach item='id' collection='ids' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"
    })
    int verifyDelete(@Param("ids") Long[] envirIds);
}
