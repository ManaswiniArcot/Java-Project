package com.samplejs;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.filetest.FileTest;
import com.sun.xml.internal.org.jvnet.staxex.NamespaceContextEx.Binding;

@Controller
public class AppController {

	@Autowired
	private UserService userService;
	/*This method is called the request matches the pattern the value in the Request mapping.
	This page is loaded after the Login Page*/	
	@RequestMapping("/welcome")
	public ModelAndView mymodel() throws Exception {
		ModelAndView myModel = new ModelAndView("myfirstang");
		return myModel;
	}

	/*
	 * This method adds the same attribute to all the models in he controller
	 * class, that is this can be accessed from any JSP file with the attribute
	 * name mentioned below.@ModelAttribute used on the method level.
	 *
	 */ @ModelAttribute
	public void addCommonObj(Model model1) {
		model1.addAttribute("headerMsg", "This is a Java Challenge");
	}

	/*This method is called when user enters a directory path and clicks on GO button
	@RequestParam gets the parameter from the request,that is the value entered by the user.
	and is directly mapped to a String variable.
	This method checks if the path is empty or not.If empty notifies the user.
	*/
	@RequestMapping(value = "/files", method = RequestMethod.POST)
	public ModelAndView getFiles(@RequestParam("path") String path) {

		ModelAndView fileModel = new ModelAndView("filelist");
		fileModel.addObject("path", path);
		File[] fileList;
		System.out.println("in controller");
		FileTest ftest = new FileTest();
		if (!path.isEmpty()) {
			fileList = ftest.getFiles(path);
			fileModel.addObject(fileList);
		} else {
			System.out.println("No path");
			fileModel.addObject("msg", "No path Entered by the user");
		}
		return fileModel;
	}

	/*This method is called when the request pattern matches the value 'status' and this is called when 
	the user clicks to check the status.
	
		*/
	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public ModelAndView checkStatus(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException {
		ModelAndView serverModel = new ModelAndView("server");
		MainClass main = new MainClass();
		boolean serverStatus = main.serverStatus(request,response);
		String mysqlStatus = "";
		boolean valid = main.connectionStatus();
		if (valid) {
			mysqlStatus = "MySQL is UP";
			// System.out.println("MYSQL is UP");
			serverModel.addObject("mysql", mysqlStatus);
		} else {
			mysqlStatus = "MySQL is DOWN";
			serverModel.addObject("mysql", mysqlStatus);
			// System.out.println("MySQl is DOWN");
		}
		if (serverStatus) {
			String msg = "Server is UP";
			serverModel.addObject("msg", msg);
			// System.out.println(msg);
		} else {
			String msg = "Server is DOWN";
			serverModel.addObject("msg", msg);
			// System.out.println(msg);
		}
		return serverModel;
	}

	@RequestMapping("/")
	public ModelAndView indexpage() {
		return new ModelAndView("loginPage");
	}

	@RequestMapping(value = "/searchUser", method = RequestMethod.GET)
	public ModelAndView search() {
		ModelAndView searchModel = new ModelAndView("searchPage");
		return searchModel;
	}

	@RequestMapping(value = "/searchBy", method = RequestMethod.POST)
	public ModelAndView searchUserBy(@RequestParam("statetype") String type,
			@RequestParam("countrytype") String country, @RequestParam("Proftype") String Prof) {
		ModelAndView searchResultModel = new ModelAndView("searchResults");
		List<Users> userList = userService.listUsers(type, country, Prof);
		searchResultModel.addObject("userList", userList);
		return searchResultModel;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public void post(HttpServletRequest request, HttpServletResponse response)
			throws JsonGenerationException, JsonMappingException, IOException {
		StringBuffer jb = new StringBuffer();
		String line = null;
		boolean showButton = false;
		ModelAndView loginModel = new ModelAndView("loginPage");
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) { /* report an error */
			System.out.println("Reader null");
		}
		JSONArray jsonArray = null;
		try {
			jsonArray = new JSONArray(jb.toString());
			JSONObject userIdJson = (JSONObject) jsonArray.get(0);
			JSONObject passwordJson = (JSONObject) jsonArray.get(1);
			String userEmail = (String) userIdJson.get("value");
			String password = (String) passwordJson.get("value");
			System.out.println(userEmail + " " + password);
			Users verifiedUser = userService.verifyUser(userEmail, password);
			if (verifiedUser != null) {
				showButton = true;
				System.out.println("valid");
				request.setAttribute("showButton", "valid");
				request.getRequestDispatcher("/loginPage.jsp").forward(request, response);
				loginModel.addObject("showButton", showButton);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// throw new IOException("Error parsing JSON request string");
		}
		PrintWriter out = response.getWriter();
		out.println("You have reached login... JSON received : " + jsonArray);
	}

}
