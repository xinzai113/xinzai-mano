package com.certusnet.mano.config;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;


@RestController  
@RequestMapping("/")  
public class UserController { 

	@RequestMapping("/")
	String home() {
	    return "Hello World!";
	}

	@RequestMapping("/now")
	String hehe() {
	    return "现在时间：" + (new Date()).toLocaleString();
	}
	
	@Autowired  
    private Git git;
	
	@RequestMapping (value= "/v1/catalogs/vnfds", method = RequestMethod.POST)  
	public void testMethod( @RequestBody String myjson) {  
//		 String myjson = (String) request.getAttribute("json2");
		//System.out.println("myProps="+git.getUri());
		// System.out.println("myjson="+myjson);
		 JSONObject obj = (JSONObject) JSONObject.parse(myjson);
		 String uuid = (String) obj.get("id");
		 System.out.println("myuuid="+uuid);
		try{
			   
				/*FileInputStream input=new FileInputStream("C:\\Users\\admin\\Desktop\\xinWork\\vnfd-uuid.json");
				String dir =  this.getClass().getClassLoader().getResource("").getPath();
				FileOutputStream output=new FileOutputStream(dir +"/vnfd/vnfd-"+uuid+".json");
				int in=input.read();
				while(in!=-1){
				output.write(in);
				in=input.read();*/
			//String dir =  this.getClass().getClassLoader().getResource("").getPath();
			String dir = git.getUri();
			FileOutputStream output=new FileOutputStream(dir +"/vnfd/vnfd-"+uuid+".json");
			output.write(myjson.getBytes());
			output.close();
			
				
			}catch (IOException e){
				System.out.println(e.toString());
			}
	}
}
