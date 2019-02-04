package com.example.demo.configuration;

import java.util.Collection;
import java.util.Collections;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.InternalSettingsPreparer;
import org.elasticsearch.node.Node;
import org.elasticsearch.plugin.serbianplugin.analyzer.SerbianAnalyzer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
@Configuration
@EnableElasticsearchRepositories
public class ElasticsearchConfig {


    @Value("${spring.data.elasticsearch.cluster-name:elasticsearch}")
    private String clusterName;

    @Bean
    public Client elasticsearchClient() {
        Settings.Builder settings = Settings.builder();
        settings.put("node.local", true);
        settings.put("cluster.name", "elasticsearch");
        settings.put("http.enabled", false);
        Settings s = settings.build();
        Collection plugins = Collections.singletonList(SerbianAnalyzer.class);
        MockNode node = new MockNode(InternalSettingsPreparer.prepareEnvironment(s, null),plugins);
        System.out.println(node.getPlugins().size());
        return node.client();
    }

    
}