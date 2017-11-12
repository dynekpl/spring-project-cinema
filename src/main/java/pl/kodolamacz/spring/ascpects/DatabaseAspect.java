package pl.kodolamacz.spring.ascpects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Controller;

import java.util.Arrays;

@Controller
@Aspect
public class DatabaseAspect {

  @Before("execution(* pl.kodolamacz.spring.dao.repository.AbstractDao.save(..))")
  public void before(JoinPoint joinPoint) {
    System.out.println("Before save");
  }

  @After("execution(* pl.kodolamacz.spring.dao.repository.AbstractDao.save(..))")
  public void after(JoinPoint joinPoint) {
    System.out.println("After save");
    System.out.println(joinPoint.getSignature().getName());
    System.out.println(Arrays.toString(joinPoint.getArgs()));
  }

  @Around("execution(* pl.kodolamacz.spring.dao.repository.AbstractDao.findById(..))")
  public void around(ProceedingJoinPoint joinPoint)  throws Throwable {
    System.out.println("Around start");

    Object proceed = joinPoint.proceed();// wykonuje macierzystą metodę

    System.out.println("Around stop");
  }
}

