package com.zou.system.service.impl;

import com.alibaba.fastjson2.JSON;
import com.zou.system.domain.Caseinfo;
import com.zou.system.mapper.CaseinfoMapper;
import com.zou.system.service.ICaseinfoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用例管理Service业务层处理
 *
 * @author zou
 * @date 2024-01-28
 */
@Service
public class CaseinfoServiceImpl implements ICaseinfoService {
  @Autowired private CaseinfoMapper caseinfoMapper;

  /**
   * 查询用例管理
   *
   * @param caseId 用例管理主键
   * @return 用例管理
   */
  @Override
  public Caseinfo selectCaseinfoByCaseId(Long caseId) {
    Caseinfo caseinfo = caseinfoMapper.selectCaseinfoByCaseId(caseId);
    // 设置请求头、请求参数列表
    caseinfo.setHeaderList(JSON.parseObject(caseinfo.getHeader(), List.class));
    caseinfo.setParamList(JSON.parseObject(caseinfo.getParam(), List.class));
    return caseinfo;
  }

  /**
   * 查询用例管理列表
   *
   * @param caseinfo 用例管理
   * @return 用例管理
   */
  @Override
  public List<Caseinfo> selectCaseinfoList(Caseinfo caseinfo) {
    return caseinfoMapper.selectCaseinfoList(caseinfo);
  }

  /**
   * 新增用例管理
   *
   * @param caseinfo 用例管理
   * @return 结果
   */
  @Override
  public int insertCaseinfo(Caseinfo caseinfo) {
    // 请求头、参数转json
    caseinfo.setHeader(JSON.toJSONString(caseinfo.getHeaderList()));
    caseinfo.setParam(JSON.toJSONString(caseinfo.getParamList()));

    int row = caseinfoMapper.insertCaseinfo(caseinfo);
    //        insertHeaderAndParam(caseinfo);
    return row;
  }

  /**
   * 插入
   *
   * @param caseinfo
   */
  private void insertHeaderAndParam(Caseinfo caseinfo) {}

  /**
   * 修改用例管理
   *
   * @param caseinfo 用例管理
   * @return 结果
   */
  @Override
  public int updateCaseinfo(Caseinfo caseinfo) {
    // 请求头、参数转json
    caseinfo.setHeader(JSON.toJSONString(caseinfo.getHeaderList()));
    caseinfo.setParam(JSON.toJSONString(caseinfo.getParamList()));
    return caseinfoMapper.updateCaseinfo(caseinfo);
  }

  /**
   * 批量删除用例管理
   *
   * @param caseIds 需要删除的用例管理主键
   * @return 结果
   */
  @Override
  public int deleteCaseinfoByCaseIds(Long[] caseIds) {
    return caseinfoMapper.deleteCaseinfoByCaseIds(caseIds);
  }

  /**
   * 删除用例管理信息
   *
   * @param caseId 用例管理主键
   * @return 结果
   */
  @Override
  public int deleteCaseinfoByCaseId(Long caseId) {
    return caseinfoMapper.deleteCaseinfoByCaseId(caseId);
  }
}
