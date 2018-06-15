
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

import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.Resource;

/**
 * <p>
 * 模板路径配置项
 * </p>
 *
 * @author tzg hubin
 * @since 2017-06-17
 */
@ConfigurationProperties(
		prefix = "mybatis.gen.template"
)
@AutoConfigureAfter({GlobalProperties.class})
public class TemplateProperties {

    @Resource
    private GlobalProperties globalProperties;

	private String entity = "/templates/entity.java.vm";

	private String service = "/templates/service.java.vm";

	private String serviceImpl = "/templates/serviceImpl.java.vm";

	private String mapper = "/templates/mapper.java.vm";

	private String xml = "/templates/mapper.xml.vm";

	private String controller = "/templates/controller.java";

	public String getEntity(boolean kotlin) {
		return kotlin ? "/templates/entity.kt.ftl" : entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getServiceImpl() {
		return serviceImpl;
	}

	public void setServiceImpl(String serviceImpl) {
		this.serviceImpl = serviceImpl;
	}

	public String getMapper() {
		return mapper;
	}

	public void setMapper(String mapper) {
		this.mapper = mapper;
	}

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public TemplateConfig createBuilder() {
		return new TemplateConfig()
                .setController(getController())
				.setEntity(getEntity(globalProperties.isKotlin()))
                .setMapper(getMapper())
                .setService(getService())
                .setServiceImpl(getServiceImpl());
	}
}
