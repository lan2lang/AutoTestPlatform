package com.zou.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.zou.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.zou.system.domain.Interinfo;
import com.zou.system.mapper.EnvironmentMapper;
import com.zou.system.domain.Environment;
import com.zou.system.service.IEnvironmentService;

/**
 * 环境Service业务层处理
 *
 * @author zou
 * @date 2024-01-28
 */
@Service
public class EnvironmentServiceImpl implements IEnvironmentService
{
    @Autowired
    private EnvironmentMapper environmentMapper;

    /**
     * 查询环境
     *
     * @param envirId 环境主键
     * @return 环境
     */
    @Override
    public Environment selectEnvironmentByEnvirId(Long envirId)
    {
        return environmentMapper.selectEnvironmentByEnvirId(envirId);
    }

    /**
     * 查询环境列表
     *
     * @param environment 环境
     * @return 环境
     */
    @Override
    public List<Environment> selectEnvironmentList(Environment environment)
    {
        return environmentMapper.selectEnvironmentList(environment);
    }

    /**
     * 新增环境
     *
     * @param environment 环境
     * @return 结果
     */
    @Transactional
    @Override
    public int insertEnvironment(Environment environment)
    {
        int rows = environmentMapper.insertEnvironment(environment);
        insertInterinfo(environment);
        return rows;
    }

    /**
     * 修改环境
     *
     * @param environment 环境
     * @return 结果
     */
    @Transactional
    @Override
    public int updateEnvironment(Environment environment)
    {
//        environmentMapper.deleteInterinfoByEnvirId(environment.getEnvirId());
//        insertInterinfo(environment);
        return environmentMapper.updateEnvironment(environment);
    }

    /**
     * 批量删除环境
     *
     * @param envirIds 需要删除的环境主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteEnvironmentByEnvirIds(Long[] envirIds) throws Exception {
        //检查有无依赖这些环境的接口
        if (environmentMapper.verifyDelete(envirIds)>0){
            throw new RuntimeException("环境下有接口，不能删除");
        }
        return environmentMapper.deleteEnvironmentByEnvirIds(envirIds);
    }

    /**
     * 删除环境信息
     *
     * @param envirId 环境主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteEnvironmentByEnvirId(Long envirId)
    {
//        environmentMapper.deleteInterinfoByEnvirId(envirId);
        return environmentMapper.deleteEnvironmentByEnvirId(envirId);
    }

    /**
     * 新增接口管理信息
     *
     * @param environment 环境对象
     */
    public void insertInterinfo(Environment environment)
    {
        List<Interinfo> interinfoList = environment.getInterinfoList();
        Long envirId = environment.getEnvirId();
        if (StringUtils.isNotNull(interinfoList))
        {
            List<Interinfo> list = new ArrayList<Interinfo>();
            for (Interinfo interinfo : interinfoList)
            {
                interinfo.setEnvirId(envirId);
                list.add(interinfo);
            }
            if (list.size() > 0)
            {
                environmentMapper.batchInterinfo(list);
            }
        }
    }
}
