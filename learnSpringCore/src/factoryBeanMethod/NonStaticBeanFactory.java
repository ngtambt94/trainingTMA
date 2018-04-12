package factoryBeanMethod;

public class NonStaticBeanFactory {
    public Message createContent(String content) {
        return new Message(content);
    }
}
