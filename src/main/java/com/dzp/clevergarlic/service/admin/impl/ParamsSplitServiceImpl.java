package com.dzp.clevergarlic.service.admin.impl;

import com.dzp.clevergarlic.dto.admin.businessDTO.BusinessInfoResponse;
import com.dzp.clevergarlic.dto.admin.businessDTO.response.BusinessForm;
import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.response.BuildingUnit;
import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.response.LeaseFeeInfoResponse;
import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.response.ParamsUnit;
import com.dzp.clevergarlic.enums.BudgetParamEnum;
import com.dzp.clevergarlic.service.admin.BusinessService;
import com.dzp.clevergarlic.service.admin.LeaseFeeService;
import com.dzp.clevergarlic.service.admin.ParamsSplitService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 参数拆份服务
 * @Auther ck
 * @Date 2020/8/20 18:40
 * @Desc
 */
@Service
public class ParamsSplitServiceImpl implements ParamsSplitService {

    @Autowired
    LeaseFeeService leaseFeeService;

    @Autowired
    BusinessService businessService;

    /**
     * 租金参数拆分（按单楼）
     * @param planId
     * @param buildingId
     * @return
     */
    @Override
    public List<ParamsUnit> leaseSplit(String planId, String buildingId) {

        // 拆分后的参数集合
        List<ParamsUnit> splitList = new ArrayList<>();

        List<LeaseFeeInfoResponse> leaseFeeInfo = leaseFeeService.getLeaseFeeInfo(buildingId);
        leaseFeeInfo.sort(Comparator.comparingDouble(LeaseFeeInfoResponse::getInstallType));// 按参数类型排倒序

        List<BuildingUnit> buildingUnits = leaseFeeService.getUnitByBuilding(buildingId);// 整楼单元集合

        for (LeaseFeeInfoResponse leaseFeeForm : leaseFeeInfo) {

            ParamsUnit leaseFeeUnit = new ParamsUnit();
            if (BudgetParamEnum.PARAMS_TYPE_ZD.getCode().equals(leaseFeeForm.getInstallType())) {

                for (BuildingUnit buildingUnit : buildingUnits) {
                    BeanUtils.copyProperties(leaseFeeForm, leaseFeeUnit);
                    leaseFeeUnit.setUnit(buildingUnit.getUnit());
                    splitList.add(leaseFeeUnit);
                }
            } else if (BudgetParamEnum.PARAMS_TYPE_LC.getCode().equals(leaseFeeForm.getInstallType())) {

                String[] splitStr = leaseFeeForm.getInstallValue().split("-");
                for (int floor=Integer.parseInt(splitStr[0]);floor<=Integer.parseInt(splitStr[1]);floor++) {
                    int finalFloor = floor;
                    // 该楼层下的单元集合
                    List<BuildingUnit> collect = buildingUnits.stream().filter(BuildingUnit -> BuildingUnit.getFloorCode() == finalFloor).collect(Collectors.toList());
                    for (BuildingUnit buildingUnit : collect) {
                        BeanUtils.copyProperties(leaseFeeForm, leaseFeeUnit);
                        leaseFeeUnit.setUnit(buildingUnit.getUnit());
                        splitList.add(leaseFeeUnit);
                    }
                }
            } else {
                BeanUtils.copyProperties(leaseFeeForm, leaseFeeUnit);
                splitList.add(leaseFeeUnit);
            }
        }

        // 去重
        List<ParamsUnit> finalList = splitList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(ParamsUnit :: getUnit))), ArrayList::new));
        return finalList;
    }

    /**
     * 招商参数拆分（按单楼）
     * @param planId
     * @param buildingId
     * @return
     */
    @Override
    public List<ParamsUnit> businessSplit(String planId, String buildingId) {

        // 拆分后的参数集合
        List<ParamsUnit> splitList = new ArrayList<>();

        BusinessInfoResponse businessInfo = businessService.getBusinessInfo(buildingId).getData();
        List<BusinessForm> businessForms = businessInfo.getBusinessForms();
        businessForms.sort(Comparator.comparingDouble(BusinessForm::getInstallType));// 按参数类型排倒序

        List<BuildingUnit> buildingUnits = leaseFeeService.getUnitByBuilding(buildingId);// 整楼单元集合
        for (BusinessForm businessForm : businessForms) {

            ParamsUnit leaseFeeUnit = new ParamsUnit();
            if (BudgetParamEnum.PARAMS_TYPE_ZD.getCode().equals(businessForm.getInstallType())) {

                for (BuildingUnit buildingUnit : buildingUnits) {
                    BeanUtils.copyProperties(businessForm, leaseFeeUnit);
                    leaseFeeUnit.setUnit(buildingUnit.getUnit());
                    splitList.add(leaseFeeUnit);
                }
            } else if (BudgetParamEnum.PARAMS_TYPE_LC.getCode().equals(businessForm.getInstallType())) {

                String[] splitStr = businessForm.getInstallValue().split("-");
                for (int floor=Integer.parseInt(splitStr[0]);floor<=Integer.parseInt(splitStr[1]);floor++) {
                    int finalFloor = floor;
                    // 该楼层下的单元集合
                    List<BuildingUnit> collect = buildingUnits.stream().filter(BuildingUnit -> BuildingUnit.getFloorCode() == finalFloor).collect(Collectors.toList());
                    for (BuildingUnit buildingUnit : collect) {
                        BeanUtils.copyProperties(businessForm, leaseFeeUnit);
                        leaseFeeUnit.setUnit(buildingUnit.getUnit());
                        splitList.add(leaseFeeUnit);
                    }
                }
            } else {
                BeanUtils.copyProperties(businessForm, leaseFeeUnit);
                splitList.add(leaseFeeUnit);
            }
        }

        // 去重
        List<ParamsUnit> finalList = splitList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(ParamsUnit :: getUnit))), ArrayList::new));
        return finalList;
    }
}
