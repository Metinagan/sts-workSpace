package com.metinagan.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.metinagan.Dto.DtoUser;
import com.metinagan.controller.IRestAuthController;
import com.metinagan.jwt.AuthRequest;
import com.metinagan.jwt.AuthResponse;
import com.metinagan.jwt.RefreshTokenRequest;
import com.metinagan.service.IAuthService;
import com.metinagan.service.IRefreshTokenService;

import jakarta.validation.Valid;

@RestController
public class RestAuthControllerImpl implements IRestAuthController{

	@Autowired
	private IAuthService authService;
	
	@Autowired
	private IRefreshTokenService refreshTokenService;
	
	
	
	@PostMapping("/register")
	@Override
	public DtoUser register(@Valid @RequestBody AuthRequest request) {
		
		return authService.register(request);
	}

	@PostMapping("/authenticate")
	@Override
	public AuthResponse authanticate(@RequestBody AuthRequest request) {
		return authService.authanticate(request);
	}

	@PostMapping("/refreshToken")
	@Override
	public AuthResponse refreshToken(@RequestBody RefreshTokenRequest request) {
		return refreshTokenService.refreshToken(request);
	}
	
	
	
	
}















