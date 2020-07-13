package com.dzp.clevergarlic.web.admin;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.excel.EasyExcel;
import com.dzp.clevergarlic.config.annotation.Log;
import com.dzp.clevergarlic.dto.admin.demoDto.DemoListResponse;
import com.dzp.clevergarlic.dto.admin.demoDto.ListToPageRequest;
import com.dzp.clevergarlic.dto.excel.EasyExportDto;
import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.listener.DemoListener;
import com.dzp.clevergarlic.result.Result;
import com.dzp.clevergarlic.result.ResultVo;
import com.dzp.clevergarlic.service.DemoService;
import com.dzp.clevergarlic.util.FileUtil;
import com.dzp.clevergarlic.util.PageUtil;
import com.dzp.clevergarlic.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * this is a little demo
 * @Auther ck
 * @Date 2020/7/1 16:13
 * @Desc
 */

@Api(value = "demo", description = "this is demo's description")
@RestController
@RequestMapping(value = "/demo", produces = "application/json;charset=utf-8")
public class DemoController {

    @Autowired
    DemoService demoService;

    @ApiOperation(value = "test")
    @PostMapping(value = "/test")
    public ResultVo<String> getDemo(String id) {
        if (ObjectUtils.isEmpty(id)) {
            return Result.error(ExceptionMsg.ParamError,"id必传");
        }
        return Result.success(demoService.getUrlById(id));
    }

    @ApiOperation("列表分页")
    @Log("demo")
    @PostMapping("/list")
    public ResultVo<PageUtil<DemoListResponse>> getList(ListToPageRequest request) {
        return Result.success(demoService.getList(request));
    }

    @ApiOperation(value = "hutool导入")
    @PostMapping(value = "/htImport")
    public ResultVo htImport(@ApiParam(value = "导入Excel文件") @RequestParam("file") MultipartFile file) {

        try {
            File file1 = FileUtil.multipartFileToFile(file);
            ExcelReader reader = ExcelUtil.getReader(file1);
            List<List<Object>> list = reader.read();
            return Result.success(list.toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "hutool导出")
    @PostMapping(value = "/htExport")
    public void htExport(HttpServletResponse response) {
        try {
            List<EasyExportDto> list = new ArrayList<>();
            list.add(new EasyExportDto("1","jack",13,"男","teacher"));
            list.add(new EasyExportDto("2","lucy",24,"女","boss"));
            list.add(new EasyExportDto("3","bob",18,"男","doctor"));

            ExcelWriter writer = ExcelUtil.getWriter();
            // 添加表头信息
            addExcelHeader(writer);
            writer.write(list,true);

            //response为HttpServletResponse对象
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            //test.xls是弹出下载对话框的文件名，不能为中文，中文自行编码
            //String name = new String("哒大".getBytes("UTF-8"), "ISO-8859-1");
            String name = StringUtil.StringToUTF8("demo");

            response.setHeader("Content-Disposition","attachment;filename=" + name + ".xls");

            ServletOutputStream out= response.getOutputStream();
            writer.flush(out,true);

            // 关闭,释放内存
            writer.close();

            // 关闭输出Servlet流
            IoUtil.close(out);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addExcelHeader(ExcelWriter writer) {
        writer.addHeaderAlias("name","姓名");
        writer.addHeaderAlias("age","年龄");
        writer.addHeaderAlias("sex","性别");
        writer.addHeaderAlias("work","职业");
        // 大标题
        writer.merge(3, "人员信息");
    }

    @ApiOperation(value = "easyExcel导入")
    @PostMapping(value = "/easyImport")
    public ResultVo easyImport(@ApiParam(value = "导入Excel文件") @RequestParam("file") MultipartFile file) {

        try {
            EasyExcel.read(file.getInputStream(), EasyExportDto.class, new DemoListener(demoService)).sheet().doRead();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "easyExcel导出")
    @PostMapping(value = "/easyExport")
    public void easyExport() {
        try {
            List<EasyExportDto> list = new ArrayList<>();
            /*list.add(new EasyExportDTO("1","jack",13,"男","teacher"));
            list.add(new EasyExportDTO("2","lucy",24,"女","boss"));
            list.add(new EasyExportDTO("3","bob",18,"男","doctor"));*/

            String fileName = "demo.xls";
            EasyExcel.write(fileName, EasyExportDto.class).sheet(1).doWrite(list);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


}
