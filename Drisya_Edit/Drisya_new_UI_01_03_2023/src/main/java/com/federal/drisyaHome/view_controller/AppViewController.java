package com.federal.drisyaHome.view_controller;

import org.springframework.stereotype.Controller;
import static com.federal.drisyaHome.Constants.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.dao.RedisDao;
import com.federal.drisyaHome.dao.home.HomeDao;
import com.federal.drisyaHome.model.*;
import com.federal.drisyaHome.service.home.RetirementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@Controller
public class AppViewController {
	@Autowired
	RetirementService retirementService;

	@Autowired
	HomeDao homeDao;

	@GetMapping("/")
	public String start() {
		return "login_ActionSSO.jsp";
	}

	@GetMapping("/home")
	public String index() {
		return "/index.jsp";
	}

	@GetMapping("/applications")
	public String applications() {
		return "/applications.jsp";
	}

	@GetMapping("/reference")
	public String reference() {
		return "/reference.jsp";
	}

	@GetMapping("/support")
	public String support() {
		return "/support.jsp";
	}

	@GetMapping("/footer")
	public String footer() {
		return "/footermenu.jsp";
	}

	@GetMapping("/retirement")
	public String retirement() {
		return "/retirement.jsp";
	}

	@GetMapping("/signout")
	public String logoutWebpage() {
		return "/logout.jsp";
	}

	@GetMapping("/retirementActivation")
	public String retirementActivatn(Model m) {
	/*	ArrayList<RetirementData> retList = retirementService.getRetirementView();
		m.addAttribute("retirementList", retList);
		ArrayList<VrsData> vrsLists = retirementService.getVrsView();
		m.addAttribute("vrsList", vrsLists);*/
		return "/retirementpreview.jsp";
	}


	@GetMapping("/access")
	public String accessPage() {
		return "/access_denied.jsp";
	}

}
