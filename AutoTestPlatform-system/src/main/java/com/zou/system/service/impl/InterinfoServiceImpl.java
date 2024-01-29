package com.zou.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.zou.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.zou.system.domain.Caseinfo;
import com.zou.system.mapper.InterinfoMapper;
import com.zou.system.domain.Interinfo;
import com.zou.system.service.IInterinfoService;

/**
 * 接口管理Service业务层处理
 *
 * @author zou
 * @date 2024-01-28
 */
@Service
public class InterinfoServiceImpl implements IInterinfoService
{
    @Autowired
    private InterinfoMapper interinfoMapper;

    /**
     * 查询接口管理
     *
     * @param interId 接口管理主键
     * @return 接口管理
     */
    @Override
    public Interinfo selectInterinfoByInterId(Long interId)
    {
        return interinfoMapper.selectInterinfoByInterId(interId);
    }

    /**
     * 查询接口管理列表
     *
     * @param interinfo 接口管理
     * @return 接口管理
     */
    @Override
    public List<Interinfo> selectInterinfoList(Interinfo interinfo)
    {
        return interinfoMapper.selectInterinfoList(interinfo);
    }

    /**
     * 新增接口管理
     *
     * @param interinfo 接口管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertInterinfo(Interinfo interinfo)
    {
        int rows = interinfoMapper.insertInterinfo(interinfo);
        insertCaseinfo(interinfo);
        return rows;
    }

    /**
     * 修改接口管理
     *
     * @param interinfo 接口管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateInterinfo(Interinfo interinfo)
    {
//        interinfoMapper.deleteCaseinfoByInterId(interinfo.getInterId());
//        insertCaseinfo(interinfo);
        return interinfoMapper.updateInterinfo(interinfo);
    }

    /**
     * 批量删除接口管理
     *
     * @param interIds 需要删除的接口管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteInterinfoByInterIds(Long[] interIds)
    {
        //检查有无依赖这些接口的用例
        if (interinfoMapper.verifyDelete(interIds)>0){
            throw new RuntimeException("接口下有用例，不能删除");
        }
        return interinfoMapper.deleteInterinfoByInterIds(interIds);
    }

    /**
     * 删除接口管理信息
     *
     * @param interId 接口管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteInterinfoByInterId(Long interId)
    {

        return interinfoMapper.deleteInterinfoByInterId(interId);
    }

    /**
     * 新增用例管理信息
     *
     * @param interinfo 接口管理对象
     */
    public void insertCaseinfo(Interinfo interinfo)
    {
        List<Caseinfo> caseinfoList = interinfo.getCaseinfoList();
        Long interId = interinfo.getInterId();
        if (StringUtils.isNotNull(caseinfoList))
        {
            List<Caseinfo> list = new ArrayList<Caseinfo>();
            for (Caseinfo caseinfo : caseinfoList)
            {
                caseinfo.setInterId(interId);
                list.add(caseinfo);
            }
            if (list.size() > 0)
            {
                interinfoMapper.batchCaseinfo(list);
            }
        }
    }
}
