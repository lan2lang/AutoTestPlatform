package com.zou.system.controller;

import com.zou.common.annotation.Log;
import com.zou.common.core.controller.BaseController;
import com.zou.common.core.domain.AjaxResult;
import com.zou.common.core.page.TableDataInfo;
import com.zou.common.enums.BusinessType;
import com.zou.common.utils.SecurityUtils;
import com.zou.common.utils.poi.ExcelUtil;
import com.zou.system.domain.Caseinfo;
import com.zou.system.service.ICaseinfoService;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用例管理Controller
 *
 * @author zou
 * @date 2024-01-28
 */
@RestController
@RequestMapping("/system/case")
public class CaseinfoController extends BaseController {
  @Autowired private ICaseinfoService caseinfoService;

  /** 查询用例管理列表 */
  @PreAuthorize("@ss.hasPermi('system:case:list')")
  @GetMapping("/list")
  public TableDataInfo list(Caseinfo caseinfo) {
    caseinfo.setUserId(SecurityUtils.getUserId());
    startPage();
    List<Caseinfo> list = caseinfoService.selectCaseinfoList(caseinfo);
    return getDataTable(list);
  }

  /** 导出用例管理列表 */
  @PreAuthorize("@ss.hasPermi('system:case:export')")
  @Log(title = "用例管理", businessType = BusinessType.EXPORT)
  @PostMapping("/export")
  public void export(HttpServletResponse response, Caseinfo caseinfo) {
    List<Caseinfo> list = caseinfoService.selectCaseinfoList(caseinfo);
    ExcelUtil<Caseinfo> util = new ExcelUtil<Caseinfo>(Caseinfo.class);
    util.exportExcel(response, list, "用例管理数据");
  }

  /** 获取用例管理详细信息 */
  @PreAuthorize("@ss.hasPermi('system:case:query')")
  @GetMapping(value = "/{caseId}")
  public AjaxResult getInfo(@PathVariable("caseId") Long caseId) {
    return success(caseinfoService.selectCaseinfoByCaseId(caseId));
  }

  /** 新增用例管理 */
  @PreAuthorize("@ss.hasPermi('system:case:add')")
  @Log(title = "用例管理", businessType = BusinessType.INSERT)
  @PostMapping
  public AjaxResult add(@RequestBody Caseinfo caseinfo) {
    caseinfo.setUserId(SecurityUtils.getUserId());
    return toAjax(caseinfoService.insertCaseinfo(caseinfo));
  }

  /** 修改用例管理 */
  @PreAuthorize("@ss.hasPermi('system:case:edit')")
  @Log(title = "用例管理", businessType = BusinessType.UPDATE)
  @PutMapping
  public AjaxResult edit(@RequestBody Caseinfo caseinfo) {
    return toAjax(caseinfoService.updateCaseinfo(caseinfo));
  }

  /** 删除用例管理 */
  @PreAuthorize("@ss.hasPermi('system:case:remove')")
  @Log(title = "用例管理", businessType = BusinessType.DELETE)
  @DeleteMapping("/{caseIds}")
  public AjaxResult remove(@PathVariable Long[] caseIds) {
    return toAjax(caseinfoService.deleteCaseinfoByCaseIds(caseIds));
  }
}
