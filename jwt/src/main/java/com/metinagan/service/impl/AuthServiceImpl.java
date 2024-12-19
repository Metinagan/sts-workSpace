package com.metinagan.service.impl;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.metinagan.Dto.DtoUser;
import com.metinagan.jwt.AuthRequest;
import com.metinagan.jwt.AuthResponse;
import com.metinagan.jwt.JwtService;
import com.metinagan.model.RefreshToken;
import com.metinagan.model.User;
import com.metinagan.repository.RefreshTokenRepository;
import com.metinagan.repository.UserRepository;
import com.metinagan.service.IAuthService;

@Service
public class AuthServiceImpl implements IAuthService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder beCryptPasswordEncoder;
	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private RefreshTokenRepository refreshTokenRepository;
	
	public RefreshToken createRefreshToken(User user){
		RefreshToken refreshToken =new RefreshToken();
		
		refreshToken.setRefreshToken(UUID.randomUUID().toString());
		refreshToken.setExpireDate(new Date(System.currentTimeMillis()+1000*60*60*4));
		refreshToken.setUser(user);
		
		return refreshToken;
	}
	
	@Override
	public AuthResponse authanticate(AuthRequest request) {
		try {
			UsernamePasswordAuthenticationToken auth = 
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
			authenticationProvider.authenticate(auth);
			
			Optional<User> optional = userRepository.findByUsername(request.getUsername());
			String accessToken = jwtService.generatedtoken(optional.get());
			
			RefreshToken refreshToken = createRefreshToken(optional.get());
			refreshTokenRepository.save(refreshToken);
			
			return new AuthResponse(accessToken,refreshToken.getRefreshToken()); 
			
		} catch (Exception e) {
			System.out.println("kullanıcı adı veya şifre hatalı");
		}
		return null;
	}
	
	 
	@Override
	public DtoUser register(AuthRequest request) {
		
		User user = new User();
		
		user.setUsername(request.getUsername());
		user.setPassword(beCryptPasswordEncoder.encode(request.getPassword()));
		
		User savedUser = userRepository.save(user);
		
		DtoUser dtoUser = new DtoUser();
		BeanUtils.copyProperties(savedUser, dtoUser);
		
		return dtoUser;
	}



}





