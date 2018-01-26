package com.tx.saveWorld;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目的启动入口
 */
@Controller
@SpringBootApplication
public class SaveWorldApplication {
	private static final Logger LOGGER = LogManager.getLogger(SaveWorldApplication.class);

	@RequestMapping("/")
	public String index(Model model){
		Person single = new Person("aa",11);

		List<Person> people = new ArrayList<Person>();
		Person p1 = new Person("xx",11);
		Person p2 = new Person("yy",22);
		Person p3 = new Person("zz",33);
		people.add(p1);
		people.add(p2);
		people.add(p3);

		model.addAttribute("singlePerson", single);
		model.addAttribute("people", people);

		LOGGER.info("person={}",p2.getName());
		return "index";
	}

	@RequestMapping("/iview")
	public String ivewTest(Model model){
		LOGGER.info("ivewTest");
		return "iview";
	}

	@RequestMapping("/bootstrap")
	public String bootstrapTest(Model model){
		LOGGER.info("bootstrapTest");
		return "bootstrap";
	}
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SaveWorldApplication.class);
		app.run(args);
	}
}
