package com.hana7.springdemo.jpa.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hana7.springdemo.security.JwtUtil;
import com.hana7.springdemo.security.exception.CustomJwtException;

public class JwtRefreshController {
	@RequestMapping("/api/subscriber/refresh")
	public Map<String, Object> refresh(@RequestHeader("Authorization")String authHeader,
		String refreshToken) {
		if (refreshToken == null) {
			throw new CustomJwtException("NULL_REFRESH_TOKEN");
		}
		if (authHeader == null || authHeader.length() < 7) {
			throw new CustomJwtException("INVALID_TOKEN_TOKEN");
		}
		String accessToken = authHeader.substring(7);
		if(!didExpiredToken(accessToken)) {
			return Map.of("accessToken", accessToken, "refreshToken", refreshToken);
		}
		
		Map<String, Object> claim = JwtUtil.validateToken(refreshToken);
		String newAccessToken = JwtUtil.generateToken(claim, 10);
		String newRefreshToken = isSomeLeftTime((long)claim.get("exp")) ? JwtUtil.generateToken(claim, 60 * 24) : refreshToken;
		return Map.of("accessToken", newAccessToken, "refreshToken", newRefreshToken);
	}

	private boolean isSomeLeftTime(long exp) {
		long nowSec = System.currentTimeMillis() / 1000;
		return (exp - nowSec) < 60 * 60; //60초 * 60 = 60분
	}

	private boolean didExpiredToken(String accessToken) {
		try {
			JwtUtil.validateToken(accessToken);
		} catch (CustomJwtException e) {
			return true;
		}
		return false;
	}
}