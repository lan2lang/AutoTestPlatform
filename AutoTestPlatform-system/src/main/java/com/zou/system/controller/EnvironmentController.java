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
import com.zou.system.domain.Environment;
import com.zou.system.service.IEnvironmentService;
import com.zou.common.utils.poi.ExcelUtil;
import com.zou.common.core.page.TableDataInfo;

/**
 * 环境Controller
 *
 * @author zou
 * @date 2024-01-28
 */
@RestController
@RequestMapping("/system/environment")
public class EnvironmentController extends BaseController
{
    @Autowired
    private IEnvironmentService environmentService;

    /**
     * 查询环境列表
     */
    @PreAuthorize("@ss.hasPermi('system:environment:list')")
    @GetMapping("/list")
    public TableDataInfo list(Environment environment)
    {
        //设置用户id
        environment.setUserId(SecurityUtils.getUserId());
        startPage();
        List<Environment> list = environmentService.selectEnvironmentList(environment);
        return getDataTable(list);
    }

    /**
     * 导出环境列表
     */
    @PreAuthorize("@ss.hasPermi('system:environment:export')")
    @Log(title = "环境", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Environment environment)
    {
        List<Environment> list = environmentService.selectEnvironmentList(environment);
        ExcelUtil<Environment> util = new ExcelUtil<Environment>(Environment.class);
        util.exportExcel(response, list, "环境数据");
    }

    /**
     * 获取环境详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:environment:query')")
    @GetMapping(value = "/{envirId}")
    public AjaxResult getInfo(@PathVariable("envirId") Long envirId)
    {
        return success(environmentService.selectEnvironmentByEnvirId(envirId));
    }

    /**
     * 新增环境
     */
    @PreAuthorize("@ss.hasPermi('system:environment:add')")
    @Log(title = "环境", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Environment environment)
    {
        //设置用户id
        environment.setUserId(SecurityUtils.getUserId());
        return toAjax(environmentService.insertEnvironment(environment));
    }

    /**
     * 修改环境
     */
    @PreAuthorize("@ss.hasPermi('system:environment:edit')")
    @Log(title = "环境", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Environment environment)
    {
        return toAjax(environmentService.updateEnvironment(environment));
    }

    /**
     * 删除环境
     */
    @PreAuthorize("@ss.hasPermi('system:environment:remove')")
    @Log(title = "环境", businessType = BusinessType.DELETE)
	@DeleteMapping("/{envirIds}")
    public AjaxResult remove(@PathVariable Long[] envirIds) throws Exception {
        return toAjax(environmentService.deleteEnvironmentByEnvirIds(envirIds));
    }
}
