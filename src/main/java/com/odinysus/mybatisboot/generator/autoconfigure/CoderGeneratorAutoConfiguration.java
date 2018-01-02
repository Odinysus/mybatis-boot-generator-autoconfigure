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

import com.baomidou.mybatisplus.generator.AutoGenerator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * 配置汇总 传递给文件生成工具
 * </p>
 *
 * @author odinysus
 * @since 2018-1-1
 */
@Configuration
@ConditionalOnClass(AutoGenerator.class)
@EnableConfigurationProperties({PackageProperties.class, GlobalProperties.class, StrategyProperties.class, DataSourceProperties.class, TemplateProperties.class})
public class CoderGeneratorAutoConfiguration {

	private static Log log = LogFactory.getLog(CoderGeneratorAutoConfiguration.class);

	@Autowired
	private  GlobalProperties globalProperties;
	@Autowired
	private PackageProperties packageProperties;
	@Autowired
	private StrategyProperties strategyProperties;
	@Autowired
	private DataSourceProperties dataSourceProperties;
	@Autowired
	private TemplateProperties templateProperties;



	@Bean(value = "autoGenerator")
	@ConditionalOnMissingBean(AutoGenerator.class)
	public AutoGenerator getAutoGenerator() {
		return new AutoGenerator()
				.setDataSource(dataSourceProperties.createBulider())
				.setGlobalConfig(globalProperties.createBuilder())
				.setPackageInfo(packageProperties.createBuilder())
				.setStrategy(strategyProperties.crateBuilder())
				.setTemplate(templateProperties.createBuilder());
	}

}
