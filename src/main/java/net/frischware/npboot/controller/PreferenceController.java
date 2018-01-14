package net.frischware.npboot.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.frischware.npboot.bean.Preference;
import net.frischware.npboot.repository.PreferenceRepository;

/**
 * 
 * @author
 *
 */
@RestController
public class PreferenceController {

	private Long cnt = 0l;
	
	@Autowired
	private PreferenceRepository repo;
	
	/**
	 * 
	 * @param preference
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/preference")
	@ResponseStatus(HttpStatus.CREATED)
	public Long createPreference(@RequestBody Preference preference) {
		cnt++;
		repo.create(preference, cnt);
		return cnt;
	}

	/**
	 * 
	 * @param e
	 * @param response
	 * @throws IOException
	 */
	@ExceptionHandler
	void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}
}
