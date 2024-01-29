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
import com.zou.system.domain.Testresult;
import com.zou.system.service.ITestresultService;
import com.zou.common.utils.poi.ExcelUtil;
import com.zou.common.core.page.TableDataInfo;

/**
 * 测试结果Controller
 *
 * @author zou
 * @date 2024-01-28
 */
@RestController
@RequestMapping("/system/testresult")
public class TestresultController extends BaseController
{
    @Autowired
    private ITestresultService testresultService;

    /**
     * 查询测试结果列表
     */
    @PreAuthorize("@ss.hasPermi('system:testresult:list')")
    @GetMapping("/list")
    public TableDataInfo list(Testresult testresult)
    {
//        设置用户id
        testresult.setUserId(SecurityUtils.getUserId());
        startPage();
        List<Testresult> list = testresultService.selectTestresultList(testresult);
        return getDataTable(list);
    }

    /**
     * 导出测试结果列表
     */
    @PreAuthorize("@ss.hasPermi('system:testresult:export')")
    @Log(title = "测试结果", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Testresult testresult)
    {
        List<Testresult> list = testresultService.selectTestresultList(testresult);
        ExcelUtil<Testresult> util = new ExcelUtil<Testresult>(Testresult.class);
        util.exportExcel(response, list, "测试结果数据");
    }

    /**
     * 获取测试结果详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:testresult:query')")
    @GetMapping(value = "/{resultId}")
    public AjaxResult getInfo(@PathVariable("resultId") Integer resultId)
    {
        return success(testresultService.selectTestresultByResultId(resultId));
    }

    /**
     * 新增测试结果
     */
    @PreAuthorize("@ss.hasPermi('system:testresult:add')")
    @Log(title = "测试结果", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Testresult testresult)
    {
        testresult.setUserId(SecurityUtils.getUserId());
        return toAjax(testresultService.insertTestresult(testresult));
    }

    /**
     * 修改测试结果
     */
    @PreAuthorize("@ss.hasPermi('system:testresult:edit')")
    @Log(title = "测试结果", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Testresult testresult)
    {
        return toAjax(testresultService.updateTestresult(testresult));
    }

    /**
     * 删除测试结果
     */
    @PreAuthorize("@ss.hasPermi('system:testresult:remove')")
    @Log(title = "测试结果", businessType = BusinessType.DELETE)
	@DeleteMapping("/{resultIds}")
    public AjaxResult remove(@PathVariable Integer[] resultIds)
    {
        return toAjax(testresultService.deleteTestresultByResultIds(resultIds));
    }
}
