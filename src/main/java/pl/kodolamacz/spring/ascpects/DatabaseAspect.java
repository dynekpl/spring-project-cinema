package pl.kodolamacz.spring.ascpects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Controller;

import java.util.Arrays;

public class DatabaseAspect {

  public void before(JoinPoint joinPoint) {
    System.out.println("Before save");
  }

  public void after(JoinPoint joinPoint) {
  }
}

