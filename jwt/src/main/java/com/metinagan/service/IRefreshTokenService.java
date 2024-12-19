package com.metinagan.service;

import com.metinagan.jwt.AuthResponse;
import com.metinagan.jwt.RefreshTokenRequest;

public interface IRefreshTokenService {

	public AuthResponse refreshToken(RefreshTokenRequest request);
	
}
