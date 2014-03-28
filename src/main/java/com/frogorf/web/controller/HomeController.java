package com.frogorf.web.controller;

import java.io.File;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.redfin.sitemapgenerator.WebSitemapGenerator;

/** Handles requests for the application home page. */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/** Simply selects the home view to render by returning its name. */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		File outFile = new File("/resources/");
		WebSitemapGenerator wsg;
		try {
			wsg = new WebSitemapGenerator("http://localhost:8080/web/", outFile);
			for (int i = 0; i < 60000; i++)
				wsg.addUrl("http://localhost:8080/web/doc" + i + ".html");
			wsg.write();
			wsg.writeSitemapsWithIndex(); // generate the sitemap_index.xml
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "home";
	}

}
