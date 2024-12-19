package com.metinagan.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metinagan.jwt.AuthResponse;
import com.metinagan.jwt.JwtService;
import com.metinagan.jwt.RefreshTokenRequest;
import com.metinagan.model.RefreshToken;
import com.metinagan.repository.RefreshTokenRepository;
import com.metinagan.service.IAuthService;
import com.metinagan.service.IRefreshTokenService;

@Service
public class RefreshTokenServiceImpl implements IRefreshTokenService {
	
	@Autowired
	private RefreshTokenRepository refreshTokenRepository;

	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthServiceImpl authServiceImpl;
	
	
	public boolean isRefreshTokenExpired(Date expiredDate) {
		return new Date().before(expiredDate);
	}
	
	@Override
	public AuthResponse refreshToken(RefreshTokenRequest request) {
		
		Optional<RefreshToken> optional = refreshTokenRepository.findByRefreshToken(request.getRefreshToken());
		
		if(optional.isEmpty()) {
			System.out.println("refreshToken geçersizdir" + optional.get());
		}
		
		RefreshToken refreshToken = optional.get();
		if(!isRefreshTokenExpired(refreshToken.getExpireDate())) {
			System.out.println("RefreshToken expire oldu" + refreshToken);
		}
		String accessToken = jwtService.generatedtoken(refreshToken.getUser());
		RefreshToken newRefreshToken = authServiceImpl.createRefreshToken(refreshToken.getUser());
		refreshTokenRepository.save(newRefreshToken);
		return new AuthResponse(accessToken,newRefreshToken.getRefreshToken());
	}

	
	
}


















