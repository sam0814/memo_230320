package com.memo.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.memo.post.dao.postMapper;

@Controller
public class TestController {
	
	@Autowired
	private	postMapper postmapper;
	
	
  @ResponseBody
    @RequestMapping("/test1")
    public String helloWorld() {
        return "Hello world!";
    }
  
  @ResponseBody
	@RequestMapping("/test2")
	public Map<String, Object> test2() {
		Map<String, Object> map = new HashMap<>();
		map.put("a", 111);
		map.put("b", 222);
		map.put("b", 333);
		return map;
	}
  
  @RequestMapping("/test3")
  public String test3() {
	  return"test/test3";
  }
  
  @ResponseBody
  @RequestMapping("/test4")
  public List<Map<String,Object>> test4() {
	  return postmapper.selectPostList();
  }
}