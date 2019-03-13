package com.bid.emanager.status.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/status")
public class StatusController {
	
	@GetMapping
	public ResponseEntity ping() {
		return ResponseEntity.ok().build();
	}
}
