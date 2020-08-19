package com.dzp.clevergarlic.web.common;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.dzp.clevergarlic.config.annotation.PassToken;
import com.dzp.clevergarlic.dao.RegionRepository;
import com.dzp.clevergarlic.dto.common.ExecuteSqlRequest;
import com.dzp.clevergarlic.dto.excel.EasyExportDTO;
import com.dzp.clevergarlic.entity.Region;
import com.dzp.clevergarlic.enums.CommonEnum;
import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.result.Result;
import com.dzp.clevergarlic.service.admin.CommonService;
import com.dzp.clevergarlic.util.FileUtil;
import com.dzp.clevergarlic.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 基础数据
 * @Auther ck
 * @Date 2020/7/3 17:43
 * @Desc
 */
@Api(value = "BasicData", description = "公共数据模块接口")
@RestController
@RequestMapping(value = "/basic", produces = "application/json;charset=utf-8")
public class BasicDataController {

    @Autowired
    CommonService commonService;

    @Autowired
    RegionRepository regionRepository;

    @ApiOperation(value = "execute SQL script")
    @PostMapping(value = "/executeSql")
    @PassToken
    public Object executeSql(@RequestBody ExecuteSqlRequest request) {
        String langType = CommonEnum.LANGUAGE_CN.getMessage();
        try {
            List<String> msg = new ArrayList<>();
            msg.add("execute sql success !");
            return Result.success(commonService.executeSql(request), msg, langType);
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED, langType, e);
        }
    }

    @ApiOperation(value = "generate code")
    @PostMapping(value = "/generateCode")
    @PassToken
    public Object generateCode() {
        try {
            return commonService.generateCode();
        } catch (Exception e) {
            return null;
        }
    }

    @ApiOperation(value = "setRegion")
    @PostMapping("/setRegion")
    @PassToken
    public String setRegion(@ApiParam(value = "Region文件") @RequestParam("file") MultipartFile file) {
        try {
            File file1 = FileUtil.multipartFileToFile(file);
            ExcelReader reader = ExcelUtil.getReader(file1);
            List<List<Object>> list = reader.read();

            List<Region> regionList = new ArrayList<>();
            for (List<Object> objects : list) {
                Region region = new Region();
                if (objects.get(0) != null) {
                    region.setId((Integer) objects.get(0));
                }
                if (objects.get(1) != null) {
                    region.setAreaName((String) objects.get(1));
                }
                if (objects.get(2) != null) {
                    region.setParentId((Integer) objects.get(2));
                }
                if (objects.get(3) != null) {
                    region.setShortName((String) objects.get(3));
                }
                regionList.add(region);
            }

            regionRepository.saveAll(regionList);
            return "success";
        } catch (Exception e) {
            return null;
        }
    }


}
