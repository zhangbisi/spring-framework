package com.zhuri.annotation.upms.interceptor;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author :
 * @create : 2019-01-01 13:12
 * @description :
 *切面类：
 *      1、类上添加   @Aspect 注解
 *      2、定义一个切点  @Pointcut注解 + pointCut()方法
 *      3、JoinPoint joinPoint 获取传入的参数
 *      4、
 *
 *
 *      Aspect 切面
 *      join Point 连接点
 *      advice  通知
 *      pointcut 切点
 *      target 目标对象
 *      proxy 代理对象
 *      weaving 织入
 *
 *
 */

@Aspect
public class UpmsLogAspects {

    /**
     * 抽取公共的切入点表达式
     *
     * 语法结构：   execution(   方法修饰符  方法返回值  方法所属类 匹配方法名 (  方法中的形参表 )  方法申明抛出的异常  )
     *          "*"：代表一个任意类型的参数；
     *          “..”：代表零个或多个任意类型的参数。
     *          （）匹配一个无参方法
     *
     * 　　　（..）匹配一个可接受任意数量参数和类型的方法
     *
     * 　　　（*）匹配一个接受一个任意类型参数的方法
     *
     * 　　　（*，Integer）匹配一个接受两个参数的方法，第一个可以为任意类型，第二个必须为Integer。
     */
    //定义切点
    @Pointcut("execution(*  com.zhuri.annotation.upms.service.*.*(..))")
    public void aspect(){}

    @Pointcut("args(java.lang.String)")
    public void pointcutArgs(){
    	System.out.println("Pointcut  args");
	}

	@Pointcut("within(java.lang.String)")
	public void pointcutWithin(){
		System.out.println("Pointcut  within");
	}

    //前置通知(
    @Before("aspect()")
    public void logStart(JoinPoint joinPoint){
        System.out.println("前置方法 = [" + joinPoint.getSignature().getName()+ "] 方法参数={}"+joinPoint.getArgs().toString());
    }

    //后置通知
    @After("aspect()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println("后置方法 = [" + joinPoint.getSignature().getName()+ "] 方法参数={}"+joinPoint.getArgs().toString());
    }

    //环绕通知。注意要有ProceedingJoinPoint参数传入。
    //JoinPoint 必须放在参数的第一位   捕获目标方法的传入参数 返回的参数
    @AfterReturning(value = "aspect()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println("捕获目标方法的传入参数 返回的参数 joinPoint = [" + joinPoint.getArgs() + "], result = [" + result + "]");
		Object[] parames = joinPoint.getArgs();//获取目标方法体参数
		for (int i = 0; i < parames.length; i++) {
			System.out.println(parames[i]);
		}
		System.out.println(joinPoint.getSignature().getName());
		//获取目标类名
		String className = joinPoint.getTarget().getClass().toString();
		System.out.println("className:" + className);
		className = className.substring(className.indexOf("com"));
		//获取目标方法签名
		String signature = joinPoint.getSignature().toString();
		System.out.println("signature:" + signature);
    }

    //捕获目标方法的传入参数 返回的异常
    @AfterThrowing(value = "aspect()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        System.out.println("异常信息,joinPoint = [" + joinPoint.getArgs() + "], exception = [" + exception + "]");
    }

}
