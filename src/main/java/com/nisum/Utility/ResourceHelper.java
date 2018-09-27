package com.nisum.Utility;

public class ResourceHelper {
	public String getResourcePath(String Resourcename) {
		String path = getBaseResourcePath()  + "/src/main/resource/" + Resourcename;
		return path;
	}
	
	public String getBaseResourcePath() {
		String path = System.getProperty("user.dir");
		return path;
	}
		
}
