package com.kishan_shathi.jwt;

import java.io.IOException;

import org.apache.coyote.BadRequestException;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.kishan_shathi.serviceImpl.MyUserDetailasService;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtService jwtService;
	private final MyUserDetailasService myUserDetailasService;
	
	public JwtAuthenticationFilter(JwtService jwtService,MyUserDetailasService myUserDetailasService) {
		this.jwtService = jwtService;
		this.myUserDetailasService = myUserDetailasService;
		
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		  log.info("jwtauthentication filter entered");
		  
		  try {
		  String header = request.getHeader("Authorization");
		if(header == null|| header.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			log.info("header is null !!");
		}
		
		String token =header.substring(7);
		 String userName = jwtService.getSubjectFromToken(token);

         if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
             UserDetails userInfo = myUserDetailasService.loadUserByUsername(userName);

             if (userInfo != null && jwtService.isTokenValid(token)) {

                 UsernamePasswordAuthenticationToken authenticationToken =
                         new UsernamePasswordAuthenticationToken(
                                 userInfo,
                                 null,
                                 userInfo.getAuthorities());

                 authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                 SecurityContextHolder.getContext().setAuthentication(authenticationToken);


             }


         }
         filterChain.doFilter(request, response);
     }
    catch (JwtException e) {
         log.error("JWT token is invalid: " + e.getMessage());
         response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
         response.getWriter().write("Invalid JWT token");
     } catch (Exception e) {
         log.info("Error in JwtAuthenticationFilter: " + e.toString());

         throw new BadRequestException("BadRequest !!");
     }

 }

}
