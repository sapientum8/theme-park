package com.gradlehero.themepark;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class ThemeParkApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThemeParkApplication.class);
    }
    @Bean
    static MyBeanFactoryPostProcessor myBeanFactoryPostProcessor() {
        return new MyBeanFactoryPostProcessor();
    }
    /*
    @Bean
    static MyBeanPostProcessor myBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }

*/
    static class MyBeanPostProcessor implements BeanPostProcessor {
        @Override
        public Object postProcessBeforeInitialization(@NotNull Object bean,@NotNull String beanName) throws BeansException {
            log.info("bean[{}]:before",beanName);
            return BeanPostProcessor.super.postProcessBeforeInitialization(bean,beanName);
        }

        @Override
        public Object postProcessAfterInitialization(@NotNull Object bean,@NotNull String beanName) throws BeansException {
            log.info("bean[{}]:after",beanName);
            return BeanPostProcessor.super.postProcessAfterInitialization(bean,beanName);
        }
    }

    static class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
            for (String name:beanFactory.getBeanDefinitionNames()) {
                var bean = beanFactory.getBeanDefinition(name);
                if (bean.getRole() != 0)
                    log.info("bean[{}]:definition",bean);
            }
        }
    }
}
