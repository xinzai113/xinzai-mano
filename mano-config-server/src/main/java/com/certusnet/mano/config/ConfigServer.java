package com.certusnet.mano.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient

@Configuration  
@ComponentScan  
@EnableAutoConfiguration
public class ConfigServer 
{
	
	
	
	@Autowired
	private EurekaClient discoveryClient;
	
	public String printEurekaServiceInfo()
	{
		InstanceInfo instance = discoveryClient.getNextServerFromEureka("STORES", false);
		return instance.toString();
	}
	
    public static void main( String[] args )
    { 
    	SpringApplication.run(ConfigServer.class, args);
    }
}
