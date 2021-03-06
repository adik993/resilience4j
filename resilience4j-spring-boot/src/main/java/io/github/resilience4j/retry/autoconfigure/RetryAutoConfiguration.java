/*
 * Copyright 2019 Mahmoud Romeh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.resilience4j.retry.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import io.github.resilience4j.retry.AsyncRetryRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import io.github.resilience4j.retry.monitoring.endpoint.RetryEndpoint;


/**
 * {@link org.springframework.boot.autoconfigure.EnableAutoConfiguration
 * Auto-configuration} for resilience4j-retry.
 */
@Configuration
@ConditionalOnClass(Retry.class)
@EnableConfigurationProperties(RetryProperties.class)
@Import(RetryConfigurationOnMissingBean.class)
public class RetryAutoConfiguration {

	@Bean
	public RetryEndpoint retryEndpoint(RetryRegistry retryRegistry, AsyncRetryRegistry asyncRetryRegistry) {
		return new RetryEndpoint(retryRegistry, asyncRetryRegistry);
	}

}
