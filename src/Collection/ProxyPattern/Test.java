package Collection.ProxyPattern;

public class Test {
    public static void main(String[] args) {
//        IHello hello = new ProxyHello(new Hello());
//        hello.sayHello("tomorrow");
        IHello hello = (IHello) new DynaProxyHello().bind(new Hello(), new LoggerImpl());
        hello.sayHello("tomorrow");
    }
}
