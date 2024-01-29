package com.zou.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.zou.common.utils.SecurityUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zou.common.annotation.Log;
import com.zou.common.core.controller.BaseController;
import com.zou.common.core.domain.AjaxResult;
import com.zou.common.enums.BusinessType;
import com.zou.system.domain.Interinfo;
import com.zou.system.service.IInterinfoService;
import com.zou.common.utils.poi.ExcelUtil;
import com.zou.common.core.page.TableDataInfo;

/**
 * 接口管理Controller
 *
 * @author zou
 * @date 2024-01-28
 */
@RestController
@RequestMapping("/system/interinfo")
public class InterinfoController extends BaseController
{
    @Autowired
    private IInterinfoService interinfoService;

    /**
     * 查询接口管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:interinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(Interinfo interinfo)
    {
        interinfo.setUserId(SecurityUtils.getUserId());
        startPage();
        List<Interinfo> list = interinfoService.selectInterinfoList(interinfo);
        return getDataTable(list);
    }

    /**
     * 导出接口管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:interinfo:export')")
    @Log(title = "接口管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Interinfo interinfo)
    {
        List<Interinfo> list = interinfoService.selectInterinfoList(interinfo);
        ExcelUtil<Interinfo> util = new ExcelUtil<Interinfo>(Interinfo.class);
        util.exportExcel(response, list, "接口管理数据");
    }

    /**
     * 获取接口管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:interinfo:query')")
    @GetMapping(value = "/{interId}")
    public AjaxResult getInfo(@PathVariable("interId") Long interId)
    {
        return success(interinfoService.selectInterinfoByInterId(interId));
    }

    /**
     * 新增接口管理
     */
    @PreAuthorize("@ss.hasPermi('system:interinfo:add')")
    @Log(title = "接口管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Interinfo interinfo)
    {
        interinfo.setUserId(SecurityUtils.getUserId());

        return toAjax(interinfoService.insertInterinfo(interinfo));
    }

    /**
     * 修改接口管理
     */
    @PreAuthorize("@ss.hasPermi('system:interinfo:edit')")
    @Log(title = "接口管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Interinfo interinfo)
    {
        return toAjax(interinfoService.updateInterinfo(interinfo));
    }

    /**
     * 删除接口管理
     */
    @PreAuthorize("@ss.hasPermi('system:interinfo:remove')")
    @Log(title = "接口管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{interIds}")
    public AjaxResult remove(@PathVariable Long[] interIds)
    {
        return toAjax(interinfoService.deleteInterinfoByInterIds(interIds));
    }
}
