package com.jobsubmit.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.jobsubmit.conversion.Conversion;

/*This is a controller class, which maps the url path.
 * and returns the Model and View Object as a response.
 * this calls internally two other methods from the conversion class
 * from com.jobsubmit.conversion.Conversion.java
 * 
 * @Controller annotation allows this class to act as a controller.
 * @RequestMapping maps the url pattern
 * @RequestParam gets all the parameters submitted through POST method.similar to the
 * request.getParam. 
*/

@Controller
public class SubmitController {

	Conversion conversion = new Conversion();
	
	@RequestMapping("/")
	public ModelAndView indexPage() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/onsubmit", method = RequestMethod.POST)
	public ModelAndView onsubmit(@RequestParam Map<String, String> parameters) {
		String positionName = parameters.get("positionName");
		String companyName = parameters.get("companyName");
		String sourceUrl = parameters.get("sourceUrl");
		String hrName = parameters.get("hrName");
		String path = parameters.get("path");
		
		// int checkedValue = Integer.parseInt(checked);
		if (hrName.isEmpty())
			hrName = "Recruiter";
		String s = "Congrats! You applied for " + positionName + " in " + companyName + " from the source " + sourceUrl
				+ ",whose HR is " + hrName;		
		String generatedText = conversion.generateFile(positionName, companyName, sourceUrl, hrName);
		/*if(checked != null){
			String emailId = parameters.get("emailId");
			String sent = sendEmail.sendMail(emailId);
			s += "\n"+ sent;
		}
		*/
		conversion.generatePdf(generatedText,path);
		String successText = "Your File has been created at this "+path+" location.";
		//return new ModelAndView("submission").addObject("s", s);
		return new ModelAndView("submission").addObject("s", successText);
	}
	
}
