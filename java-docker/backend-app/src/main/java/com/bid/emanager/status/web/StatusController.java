package com.bid.emanager.status.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/status")
public class StatusController {
	
	@Value("${test.xyz}")
	private String env;
	
	@GetMapping
	public ResponseEntity ping(HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		log.info(env);
		log.info("Locale:", LocaleContextHolder.getLocale());
		return ResponseEntity.ok().build();
	}
}