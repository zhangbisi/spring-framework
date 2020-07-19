package com.zhuri.annotation.upms.interceptor;

import com.zhuri.annotation.upms.customannotation.RedisCache;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author :
 * @create : 2020-07-01 16:53
 * @description :
 */
@Aspect
@Component
public class RedisCacheAdvice {
	private static final ExpressionParser parser = new SpelExpressionParser();
	private static final LocalVariableTableParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();

	/**
	 * 定义切点
	 */
	@Pointcut("@annotation(com.zhuri.annotation.upms.customannotation.RedisCache")
	public void redisCachePointcut(){}

	@Around(value = "redisCachePointcut()")
    public Object round(final ProceedingJoinPoint point){
		try {
			return point.proceed();
		} catch (Throwable throwable) {
			System.out.println("环绕通知异常");
			throwable.printStackTrace();
			return null;
		}
	}

	public Method getMethod(ProceedingJoinPoint point){
		Method method = null;
		try {
			Object[] args = point.getArgs();
			// 获取参数的类型
			Class[] argTypes = new Class[point.getArgs().length];
			for (int i = 0; i < args.length; i++) {
				argTypes[i] = args[i].getClass();
			}
			method = point.getTarget().getClass().getMethod(point.getSignature().getName(), argTypes);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		return method;
	}

	private RedisCache getAnnotation(final ProceedingJoinPoint pJointPoint) throws NoSuchMethodException {
		final Signature sig = pJointPoint.getSignature();
		if (!(sig instanceof MethodSignature)) {
			throw new NoSuchMethodException("This annotation is only valid on a method.");
		}
		final MethodSignature msig = (MethodSignature) sig;
		final Object target = pJointPoint.getTarget();
		Method method = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
		return method.getAnnotation(RedisCache.class);
	}

	private String parseSpel(String key, Method method, Object[] args){
		String[] paraNameArr = parameterNameDiscoverer.getParameterNames(method);
		// 无入参情况直接返回原始key
		if (paraNameArr == null || paraNameArr.length == 0) {
			return key;
		}
		StandardEvaluationContext context = new StandardEvaluationContext();
		for (int i = 0; i < paraNameArr.length; i++) {
			// 判断目标方法参数
			if (args[i] == null) {
				System.out.println("缓存目标方法对应参数值:" + paraNameArr[i] + "=null");
				continue;
			}
			context.setVariable(paraNameArr[i], args[i]);
		}
		return parser.parseExpression(key).getValue(context, String.class);
	}

}
