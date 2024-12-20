package com.kishan_shathi.jwt;

import java.io.IOException;

import org.apache.coyote.BadRequestException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.kishan_shathi.serviceImpl.MyUserDetailasService;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtService jwtService;
	private final MyUserDetailasService myUserDetailasService;

	public JwtAuthenticationFilter(JwtService jwtService, MyUserDetailasService myUserDetailasService) {
		this.jwtService = jwtService;
		this.myUserDetailasService = myUserDetailasService;

	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		log.info("jwtauthentication filter entered");

		try {
			String header = request.getHeader("Authorization");
			if (header == null || !header.startsWith("Bearer ")) {
				filterChain.doFilter(request, response);
				log.info("header is null !!");
				return;
			}

			String token = header.substring(7);
			String userName = jwtService.getSubjectFromToken(token);
			log.info("username from token extraction : {}",userName);

			if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				
				UserDetails userInfo = myUserDetailasService.loadUserByUsername(userName);
				log.info("username loadUserByUsername : {}",userInfo);
				if (userInfo != null && jwtService.isTokenValid(token)) {
					log.info("username loadUserByUsername intered if block :{}",jwtService.isTokenValid(token));
					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
							userInfo, null, userInfo.getAuthorities());
					log.info("username loadUserByUsername intered if block:{} ",authenticationToken);
					authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					log.info("username loadUserByUsername intered if block");
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
					log.info("last line");
				}

			}
			
			filterChain.doFilter(request, response);
			log.info(userName);
			
		} catch (JwtException e) {
			log.error("JWT token is invalid: " + e.getMessage());
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write("Invalid JWT token");
		} catch (Exception e) {
			log.info("Error in JwtAuthenticationFilter: " + e.toString());

			throw new BadRequestException("BadRequest !!");
		}

	}

}
