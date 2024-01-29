package com.zou.system.service;

import java.util.List;
import com.zou.system.domain.Interinfo;

/**
 * 接口管理Service接口
 * 
 * @author zou
 * @date 2024-01-28
 */
public interface IInterinfoService 
{
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
     * 批量删除接口管理
     * 
     * @param interIds 需要删除的接口管理主键集合
     * @return 结果
     */
    public int deleteInterinfoByInterIds(Long[] interIds);

    /**
     * 删除接口管理信息
     * 
     * @param interId 接口管理主键
     * @return 结果
     */
    public int deleteInterinfoByInterId(Long interId);
}
