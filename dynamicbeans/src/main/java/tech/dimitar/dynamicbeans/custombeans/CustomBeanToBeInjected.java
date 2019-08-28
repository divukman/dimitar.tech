package tech.dimitar.dynamicbeans.custombeans;


public class CustomBeanToBeInjected {
    private String text;

    public CustomBeanToBeInjected(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "CustomBeanToBeInjected{" +
                "text='" + text + '\'' +
                '}';
    }
}
