package com.zhuri.annotation.upms.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author :
 * @create : 2019-01-09 10:55
 * @description :
                           监听容器中发布的一些事件，事件驱动模型开发
                            监听 ApplicationEvent 及其下面的事件
                  步骤
                        1）、写一个监听器来监某个事件
                        2）、把监听器放到容器中
                        3）、只要容器中有相关事件的发布，我们就能监听到这个事件
                            ContextRefreshedEvent：容器刷新完成
                            ContextClosedEvent：容器关闭

                        4）、发布一个事件，
                            context.publishEvent(new ApplicationEvent(new String("我发布的自定义事件"))

                原理：
                    ContextRefreshedEvent、ContextClosedEvent
                         1）、ContextRefreshedEvent事件：
                            1）、容器创建对象：refresh();
                            2)、finishRefresh();容器刷新完成
                            3)、publishEvent(event, null);
                                【事件发布流程】：
                                    1）、获得事件的多播器；getApplicationEventMulticaster()
                                    2）、multicastEvent 派发事件
                                    3）、获得所有的getApplicationListeners
                                        for (final ApplicationListener<?> listener : getApplicationListeners(event, type))
                                         1）、如果有Executor，可以使用Executor进行异步派发
                                                Executor executor = getTaskExecutor();
                                         2）、否则，同步方式直接执行invokeListener(listener, event);拿到listener回调onApplicationEvent方法

 【事件派发器获取】

 */
@Component
public class MyApplicationListener implements ApplicationListener {

    //当容器中发布此事件以后 改方法得到触发
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println( );
        System.out.println("收到的事件event = [" + event + "]");
        System.out.println( );
    }
}
