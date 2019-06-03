package collection.ProxyPattern;

import java.lang.reflect.Method;

public interface LoggerInterface {
    void start(Method method);
    void end(Method method);
}
