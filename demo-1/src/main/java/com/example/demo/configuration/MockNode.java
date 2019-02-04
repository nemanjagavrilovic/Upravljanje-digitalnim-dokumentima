package com.example.demo.configuration;


import java.util.Collection;
import java.util.List;

import org.elasticsearch.Version;
import org.elasticsearch.env.Environment;
import org.elasticsearch.node.Node;
import org.elasticsearch.plugins.Plugin;
public class MockNode extends Node {

    // these are kept here so a copy of this MockNode can be created, since Node does not store them
    private Collection<Class<? extends Plugin>> plugins;

    public MockNode(Environment settings,  Collection<Class<? extends Plugin>> list) {
        super(settings, list);
        this.plugins = list;
    }

    public Collection<Class<? extends Plugin>> getPlugins() {
    	System.out.println("Size "+plugins.size());
        return plugins;
    }

    
}
