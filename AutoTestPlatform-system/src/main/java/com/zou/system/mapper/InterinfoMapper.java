package com.zou.system.mapper;

import java.util.List;
import com.zou.system.domain.Interinfo;
import com.zou.system.domain.Caseinfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 接口管理Mapper接口
 *
 * @author zou
 * @date 2024-01-28
 */
public interface InterinfoMapper
{
    /**
     * 检查接口下是否有用例
     * @return
     */
    @Select({
            "<script>",
            "SELECT COUNT(1) from caseinfo where interId IN",
            "<foreach item='id' collection='ids' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"
    })
    int verifyDelete(@Param("ids") Long[] interIds);
    /**
     * 查询接口管理
     *
     * @param interId 接口管理主键
     * @return 接口管理
     */
    public Interinfo selectInterinfoByInterId(Long interId);

    /**
     * 查询接口管理列表
     *
     * @param interinfo 接口管理
     * @return 接口管理集合
     */
    public List<Interinfo> selectInterinfoList(Interinfo interinfo);

    /**
     * 新增接口管理
     *
     * @param interinfo 接口管理
     * @return 结果
     */
    public int insertInterinfo(Interinfo interinfo);

    /**
     * 修改接口管理
     *
     * @param interinfo 接口管理
     * @return 结果
     */
    public int updateInterinfo(Interinfo interinfo);

    /**
     * 删除接口管理
     *
     * @param interId 接口管理主键
     * @return 结果
     */
    public int deleteInterinfoByInterId(Long interId);

    /**
     * 批量删除接口管理
     *
     * @param interIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteInterinfoByInterIds(Long[] interIds);

    /**
     * 批量删除用例管理
     *
     * @param interIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCaseinfoByInterIds(Long[] interIds);

    /**
     * 批量新增用例管理
     *
     * @param caseinfoList 用例管理列表
     * @return 结果
     */
    public int batchCaseinfo(List<Caseinfo> caseinfoList);


    /**
     * 通过接口管理主键删除用例管理信息
     *
     * @param interId 接口管理ID
     * @return 结果
     */
    public int deleteCaseinfoByInterId(Long interId);
}
