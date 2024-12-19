package com.metinagan.service;

import com.metinagan.Dto.DtoUser;
import com.metinagan.jwt.AuthRequest;
import com.metinagan.jwt.AuthResponse;

public interface IAuthService {

	public DtoUser register(AuthRequest request);
	
	public AuthResponse authanticate(AuthRequest request);
}
