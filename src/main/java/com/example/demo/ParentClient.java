package com.example.demo;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ParentService")
@RibbonClient(name = "ParentService")
public interface ParentClient {
	
	@GetMapping("/get/parent")
	public Parent getParent();

}
