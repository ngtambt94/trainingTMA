package factoryBeanMethod;

public class StaticBeanFactory {
    public static Message createContent(String content) {
        return new Message(content);
    }
}
