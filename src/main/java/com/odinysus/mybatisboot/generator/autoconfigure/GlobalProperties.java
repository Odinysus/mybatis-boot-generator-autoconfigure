/**
 * Copyright (c) 2011-2020, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.odinysus.mybatisboot.generator.autoconfigure;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 * 全局配置
 * </p>
 *
 * @author hubin
 * @since 2016-12-02
 */
@ConfigurationProperties(
        prefix = "mybatis.gen.global"
)
public class GlobalProperties {

    /**
     * 生成文件的输出目录【默认 D 盘根目录】
     */
    private String outputDir = "D://";

    /**
     * 是否覆盖已有文件
     */
    private boolean fileOverride = false;

    /**
     * 是否打开输出目录
     */
    private boolean open = true;

    /**
     * 是否在xml中添加二级缓存配置
     */
    private boolean enableCache = true;

    /**
     * 开发人员
     */
    private String author;

    /**
     * 开启 Kotlin 模式
     */
    private boolean kotlin = false;

    /**
     * 开启 ActiveRecord 模式
     */
    private boolean activeRecord = true;

    /**
     * 开启 BaseResultMap
     */
    private boolean baseResultMap = false;

    /**
     * 开启 baseColumnList
     */
    private boolean baseColumnList = false;
    /**
     * 各层文件名称方式，例如： %Action 生成 UserAction
     */
    private String mapperName = "%sMapper";
    private String xmlName = "%sMapper";
    private String serviceName = "%sService";
    private String serviceImplName = "%sServiceImp";
    private String controllerName = "%sController";
    /**
     * 指定生成的主键的ID类型
     */
    private IdType idType;

    public void setIdType(IdType idType) {
        this.idType = idType;
    }

    public IdType getIdType() {
        return idType;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public boolean isFileOverride() {
        return fileOverride;
    }

    public void setFileOverride(boolean fileOverride) {
        this.fileOverride = fileOverride;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isEnableCache() {
        return enableCache;
    }

    public void setEnableCache(boolean enableCache) {
        this.enableCache = enableCache;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isKotlin() {
        return kotlin;
    }

    public void setKotlin(boolean kotlin) {
        this.kotlin = kotlin;
    }

    public boolean isActiveRecord() {
        return activeRecord;
    }

    public void setActiveRecord(boolean activeRecord) {
        this.activeRecord = activeRecord;
    }

    public boolean isBaseResultMap() {
        return baseResultMap;
    }

    public void setBaseResultMap(boolean baseResultMap) {
        this.baseResultMap = baseResultMap;
    }

    public boolean isBaseColumnList() {
        return baseColumnList;
    }

    public void setBaseColumnList(boolean baseColumnList) {
        this.baseColumnList = baseColumnList;
    }

    public String getMapperName() {
        return mapperName;
    }

    public void setMapperName(String mapperName) {
        this.mapperName = mapperName;
    }

    public String getXmlName() {
        return xmlName;
    }

    public void setXmlName(String xmlName) {
        this.xmlName = xmlName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceImplName() {
        return serviceImplName;
    }

    public void setServiceImplName(String serviceImplName) {
        this.serviceImplName = serviceImplName;
    }

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public GlobalConfig createBuilder() {
        return new GlobalConfig()
                .setActiveRecord(isActiveRecord())
                .setAuthor(getAuthor())
                .setBaseColumnList(isBaseColumnList())
                .setBaseResultMap(isBaseResultMap())
                .setControllerName(getControllerName())
                .setEnableCache(isEnableCache())
                .setFileOverride(isEnableCache())
                .setKotlin(isKotlin())
                .setMapperName(getMapperName())
                .setOpen(isOpen())
                .setOutputDir(getOutputDir())
                .setServiceImplName(getServiceImplName())
                .setServiceName(getServiceName())
                .setXmlName(getXmlName());
    }
}
