package com.siemens.tracker.web.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.siemens.tracker.backend.service.TrackerService;

@Controller
public class ConsoleController{
	
	/** The login status. */
	private String loginStatus = "loginStatus";
	
	/** The login. */
	private String login = "login";
	
	private String errorPage = "errorPage";
		
	@Resource
	protected TrackerService trackerService;
	
	/**
	 * Load login page.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value="/login")
	public ModelAndView loadLoginPage() {
		return new ModelAndView(login);
	}
	
	/**
	 * Login error.
	 *
	 * @return the model and view
	 */
	@RequestMapping("/loginError")
	public ModelAndView loginError() {
		Map<String, String> map = new HashMap<>();
		map.put("error", "true");
		return new ModelAndView(login, map);

	}
	
	@RequestMapping("/errorPage")
	public ModelAndView errorPage() {
		Map<String, String> map = new HashMap<>();
		map.put("error", "true");
		return new ModelAndView(errorPage, map);

	}

	/**
	 * Logout.
	 *
	 * @return the model and view
	 */
	@RequestMapping("/logout")
	public ModelAndView logout() {
		Map<String, String> map = new HashMap<>();
		map.put("logout", "true");
		return new ModelAndView(login, map);

	}
	
	/**
	 * Recon.
	 *
	 * @return the model and view
	 */
	@RequestMapping("/recon")
	public ModelAndView recon() {
		Map<String, Object> map = new HashMap<>();
		/*map.put("reconTypesList",trackerService.getReconTypesList());*/
		map.put("userList",trackerService.getUserRolesList());
		map.put("loginStatus", "true");
		return new ModelAndView("recon", map);

	}
	
//	@ModelAttribute("ReconTypesList")
//	public Map<String,String> getReconTypesList() {
//		Map<String,String> reconTypesList = new LinkedHashMap<String,String>();
//		reconTypesList.put("es","Estimation");
//		reconTypesList.put("mr","Missing Read Recon");
//		reconTypesList.put("ctpt","CTPT");
//		reconTypesList.put("sc","Spike Correction");
//		reconTypesList.put("tc","Tariff Correction");
//		reconTypesList.put("dd","Demand");
//	return reconTypesList;	
//}
	/**
	 * Load Admin page.
	 *
	 * @return the model and view
	 */
	@RequestMapping("/admin")
	public ModelAndView loadAdminPage() {
		Map<String, Object> map = new HashMap<>();
		map.put("userList",trackerService.getUserRolesList());
		map.put(loginStatus, "true");
		return new ModelAndView("admin", map);
	}
	
	/**
	 * Load Add new user page.
	 *
	 * @return the model and view
	 */
	@RequestMapping("/addUser")
	public ModelAndView loadAddUserPage() {
		Map<String, Object> map = new HashMap<>();
	/*	map.put("userList",trackerService.getUserRolesList());*/
		map.put(loginStatus, "true");
		return new ModelAndView("addUser", map);
	}
	
	/**
	 * Load default pwd change page.
	 *
	 * @return the model and view
	 */
	@RequestMapping("/resetPassword")
		public ModelAndView loadDefaultPwdChangePage(){
			Map<String,Object> map = new HashMap<>();
			map.put("userList",trackerService.getUserRolesList());
			map.put(loginStatus, true);
			return new ModelAndView("resetPassword",map);
		}
	
	/**
	 * Load the page for BCO File upload.
	 *
	 * @return the model and view
	 */
	@RequestMapping("/BCOupload")
		public ModelAndView loadBCOFileUploadPage(){
			Map<String,Object> map = new HashMap<>();
			map.put(loginStatus, true);
			return new ModelAndView("BCOupload",map);
		}
}
