package com.dzp.clevergarlic.dto.excel;

import com.alibaba.excel.annotation.ExcelProperty;

import java.lang.reflect.Field;

/**
 * @Auther ck
 * @Date 2020/7/3 13:58
 * @Desc
 */
public class EasyExportDTO {

    @ExcelProperty(value = "姓名", index = 0)
    private String name;
    @ExcelProperty(value = "年龄", index = 1)
    private Integer age;
    @ExcelProperty(value = "性别", index = 2)
    private String sex;
    @ExcelProperty(value = "职业", index = 3)
    private String work;


    public static final String[] getTitles(){
        Field[] fields = EasyExportDTO.class.getDeclaredFields();
        int length = fields.length;
        String[] titles = new String[length];
        for (int i = 0; i < length; i++) {
            ExcelProperty annotation = fields[i].getAnnotation(ExcelProperty.class);
            titles[i] = annotation.value()[0];
        }
        return titles;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public EasyExportDTO(String id, String name, Integer age, String sex, String work) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.work = work;
    }
}
