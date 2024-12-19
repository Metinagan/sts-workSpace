package com.metinagan.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override //Her gelen HTTP isteğinde bu metod çağrılır.
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//Bearer sadasdasdasdas
		String header;
		String token;
		String userName;
		
		header = request.getHeader("Authorization");
		
		if(header==null) {
			filterChain.doFilter(request, response);
		}else {
			token = header.substring(7);
			try {
				userName= jwtService.getUserNameByToken(token);
				if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
					UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
					if (userDetails!=null && jwtService.isTokenExpired(token)) {
						//kişiyi scurity context'e koyabiliriz
						UsernamePasswordAuthenticationToken authentication =
					new UsernamePasswordAuthenticationToken(userName, null, userDetails.getAuthorities());
						
						authentication.setDetails(userDetails);
						SecurityContextHolder.getContext().setAuthentication(authentication);
					}
				}
				
			} catch (ExpiredJwtException e) {
				System.out.println("Token süresi dolmuştur : "+ e.getMessage());
			}
			catch (Exception e) {
				System.out.println("Genel bir hata oluştu : " + e.getMessage());
			}
			filterChain.doFilter(request, response);
		}
	}
}





















