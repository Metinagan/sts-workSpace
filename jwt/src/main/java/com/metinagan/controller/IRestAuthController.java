package com.metinagan.controller;

import com.metinagan.Dto.DtoUser;
import com.metinagan.jwt.AuthRequest;
import com.metinagan.jwt.AuthResponse;
import com.metinagan.jwt.RefreshTokenRequest;

public interface IRestAuthController {

	public DtoUser register(AuthRequest request);
	
	public AuthResponse authanticate(AuthRequest request);
	
	public AuthResponse refreshToken(RefreshTokenRequest request);
}
